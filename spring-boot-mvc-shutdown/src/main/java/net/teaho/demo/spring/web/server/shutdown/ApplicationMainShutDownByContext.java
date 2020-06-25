package net.teaho.demo.spring.web.server.shutdown;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


/**
 * @author teaho2015
 * @date 2020-06
 * @since 1.0.0
 */
@SpringBootApplication
public class ApplicationMainShutDownByContext {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(ApplicationMainShutDownByContext.class, args);
        ctx.close();
    }

}
