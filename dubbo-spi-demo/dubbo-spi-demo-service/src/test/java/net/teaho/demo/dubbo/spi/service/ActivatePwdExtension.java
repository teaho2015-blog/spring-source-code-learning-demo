package net.teaho.demo.dubbo.spi.service;

import org.apache.dubbo.common.extension.SPI;

@SPI("passwordExtension")
public interface ActivatePwdExtension {
    String encode(String pwd);
}
