package net.teaho.demo.dubbo.spi.service;

import net.teaho.demo.dubbo.spi.service.impl.ActivateBase64PwdExtension;
import net.teaho.demo.dubbo.spi.service.impl.ActivateMD5PwdExtension;
import net.teaho.demo.dubbo.spi.service.impl.ActivatePwdExtensionDefaultImpl;
import net.teaho.demo.dubbo.spi.service.impl.ActivateSpecialMD5PwdExtension;
import net.teaho.demo.dubbo.spi.service.simpleext.SimpleExt;
import net.teaho.demo.dubbo.spi.service.simpleext.impl.SimpleExtImpl1;
import net.teaho.demo.dubbo.spi.service.simpleext.impl.SimpleExtImpl2;
import net.teaho.demo.dubbo.spi.service.simpleext.impl.SimpleExtImpl3;
import net.teaho.demo.dubbo.spi.service.simpleext.impl.SimpleExtImpl4;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.rpc.cluster.LoadBalance;
import org.junit.Test;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author hetl@akulaku.com
 * @date 2020-07
 * @since 1.0.0
 */
public class ExtensionLoaderTest {

    @Test
    public void testLoadActivateExtension() {
        {
            // test default
            URL url = URL.valueOf("test://localhost/test");
            List<ActivatePwdExtension> list = ExtensionLoader.getExtensionLoader(ActivatePwdExtension.class)
                .getActivateExtension(url, new String[]{}, "default_group");
            assertEquals(1, list.size());
            assertSame(list.get(0).getClass(), ActivatePwdExtensionDefaultImpl.class);
            assertEquals(list.get(0).encode("abc"), DigestUtils.md5DigestAsHex("abc".getBytes(StandardCharsets.UTF_8)));

        }
        {
            //test group and order
            URL url = URL.valueOf("test://localhost/test");
            url = url.addParameter("group", "group");
            List<ActivatePwdExtension> list = ExtensionLoader.getExtensionLoader(ActivatePwdExtension.class)
                .getActivateExtension(url, new String[]{}, "group");
            assertEquals(2, list.size());
//            assertArrayEquals(list.stream().map(ActivatePwdExtension::getClass).toArray(), new Object[]{ActivateMD5PwdExtension.class, ActivateBase64PwdExtension.class});
            assertSame(list.get(0).getClass(), ActivateMD5PwdExtension.class);
            assertSame(list.get(1).getClass(), ActivateBase64PwdExtension.class);
        }

        {
            // test value
            URL url = URL.valueOf("test://localhost/test");
            url = url.addParameter("group", "group");
            url = url.addParameter("value", "value");
            List<ActivatePwdExtension> list = ExtensionLoader.getExtensionLoader(ActivatePwdExtension.class)
                .getActivateExtension(url, "value", "value");
            assertEquals(1, list.size());
            assertSame(list.get(0).getClass(), ActivateSpecialMD5PwdExtension.class);
            assertEquals(list.get(0).encode("abc"), DigestUtils.md5DigestAsHex("abc".getBytes(StandardCharsets.UTF_8))+"specialValue");

        }


    }

    @Test
    public void testGetExtension() {

        {
            SimpleExt simpleExt = ExtensionLoader.getExtensionLoader(SimpleExt.class).getDefaultExtension();
            assertTrue(simpleExt instanceof SimpleExtImpl1);
        }

        {
            SimpleExt simpleExt = ExtensionLoader.getExtensionLoader(SimpleExt.class).getExtension("impl2");
            assertTrue(simpleExt instanceof SimpleExtImpl2);
        }

    }

    @Test
    public void testGetAdaptiveExtension() {
        {
            SimpleExt simpleExt = ExtensionLoader.getExtensionLoader(SimpleExt.class).getAdaptiveExtension();
            assertFalse(simpleExt instanceof SimpleExtImpl1);
            assertFalse(simpleExt instanceof SimpleExtImpl2);
            assertFalse(simpleExt instanceof SimpleExtImpl3);
            assertFalse(simpleExt instanceof SimpleExtImpl4);
            assertEquals(simpleExt.echo(URL.valueOf("test://localhost:8080/test"), "s"), "Ext1Impl1-echo");
            assertEquals(simpleExt.yell(URL.valueOf("test://localhost:8080/test"), "s"), "Ext1Impl1-yell");
        }


    }

}
