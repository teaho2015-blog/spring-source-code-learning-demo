package net.teaho.demo.dubbo.spi.service;


import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * @author teaho2015@gmail.com
 * @date 2020-07
 * @since 1.0.0
 */
@SpringBootApplication
@Slf4j
@EnableDubbo
public class ApplicationMain {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext ctx = SpringApplication.run(ApplicationMain.class, args);

        CountDownLatch cdl = new CountDownLatch(1);
        cdl.await();
    }
}
