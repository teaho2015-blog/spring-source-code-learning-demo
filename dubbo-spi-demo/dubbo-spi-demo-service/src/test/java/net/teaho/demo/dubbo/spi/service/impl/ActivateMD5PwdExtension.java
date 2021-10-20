package net.teaho.demo.dubbo.spi.service.impl;

import net.teaho.demo.dubbo.spi.service.ActivatePwdExtension;
import org.apache.dubbo.common.extension.Activate;
import org.springframework.util.DigestUtils;

/**
 * @author teaho2015<at>gmail.com
 * @date 2020-07
 * @since 1.0.0
 */
@Activate(group = {"group"}, order = 1)
public class ActivateMD5PwdExtension implements ActivatePwdExtension {

    @Override
    public String encode(String pwd) {
        return DigestUtils.md5DigestAsHex(pwd.getBytes());
    }
}
