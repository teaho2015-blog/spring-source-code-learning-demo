package net.teaho.demo.dubbo.spi.service.impl;

import net.teaho.demo.dubbo.spi.service.ActivatePwdExtension;
import org.apache.dubbo.common.extension.Activate;
import org.springframework.util.DigestUtils;

@Activate(group = {"default_group"})
public class ActivatePwdExtensionDefaultImpl implements ActivatePwdExtension {
    @Override
    public String encode(String pwd) {
        return DigestUtils.md5DigestAsHex(pwd.getBytes());
    }
}
