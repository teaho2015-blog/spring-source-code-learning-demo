package net.teaho.demo.spring.cloud.context.named.app;

import net.teaho.demo.spring.cloud.context.named.SimpleNamedContextFactory;
import net.teaho.demo.spring.cloud.context.named.SimpleNamedSpecification;
import net.teaho.demo.spring.cloud.context.named.config.DefaultSimpleConfiguration;
import net.teaho.demo.spring.cloud.context.named.config.SimpleClientBConfiguration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.context.named.NamedContextFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 该demo模拟了Feign和Ribbon的子Context维护bean的机制，
 *
 * @author teaho2015<at>gmail.com
 * @date 2020-07
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
    NamedConfiguration.class
})
public class TestNamedContextFactory {

    @Autowired
    private SimpleNamedContextFactory simpleNamedContextFactory;

    @Before
    public void init() {
        List<SimpleNamedSpecification> spec = Arrays.asList(
            new SimpleNamedSpecification("default.simple", new Class[]{DefaultSimpleConfiguration.class}),
            new SimpleNamedSpecification("clientA", new Class[]{}),
            new SimpleNamedSpecification("clientB", new Class[]{SimpleClientBConfiguration.class})
        );
        simpleNamedContextFactory.setConfigurations(spec);
    }

    @Test
    public void testGetSimpleNamedContextFactory() {
        Rule clientARule = simpleNamedContextFactory.getInstance("clientA", Rule.class);
        Rule clientBRule = simpleNamedContextFactory.getInstance("clientB", Rule.class);
        Assert.assertTrue(clientARule instanceof RuleImplA);
        Assert.assertTrue(clientBRule instanceof RuleImplB);
    }


}
