package net.teaho.demo.spring.boot.external.configuration;


import lombok.extern.slf4j.Slf4j;
import net.teaho.demo.spring.boot.external.configuration.config.SimpleAnnotatedEnableConfigProperties;
import net.teaho.demo.spring.boot.external.configuration.config.SimpleConfigProperties;
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
public class ApplicationMain {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext ctx = SpringApplication.run(ApplicationMain.class, args);

        log.info("===" + ctx.getBean(SimpleConfigProperties.class));
        log.info("===" + ctx.getBean(SimpleAnnotatedEnableConfigProperties.class));
//        CountDownLatch cdl = new CountDownLatch(1);
//        cdl.await();
    }
}
