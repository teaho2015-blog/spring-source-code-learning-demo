package net.teaho.demo.spring.web.client;

import net.teaho.demo.spring.web.client.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableDiscoveryClient
public class Main {

    private final static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext ctx = SpringApplication.run(Main.class, args);
        TestService test = ctx.getBean(TestService.class);
        Object user = test.getOneUser();
        System.out.println(user);
        System.out.println("Done！");


        test.testRestTemplate();
        System.out.println("test RestTemplate end!!");
    }

}
