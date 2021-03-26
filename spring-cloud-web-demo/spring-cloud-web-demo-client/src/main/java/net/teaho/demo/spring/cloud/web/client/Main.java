package net.teaho.demo.spring.cloud.web.client;

import lombok.extern.slf4j.Slf4j;
import net.teaho.demo.spring.cloud.web.client.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@Slf4j
//@EnableDiscoveryClient
public class Main {

    private final static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext ctx = SpringApplication.run(Main.class, args);
        TestService test = ctx.getBean(TestService.class);
        Object user = test.getOneUser();
        log.info(user.toString());
        log.info("Done！");

//        test.testRestTemplate();
//        log.info("test RestTemplate end!!");
//        int exitCode = SpringApplication.exit(ctx);
//        log.info("exitCode is {}!", exitCode);
//        System.exit(exitCode);
    }

}
