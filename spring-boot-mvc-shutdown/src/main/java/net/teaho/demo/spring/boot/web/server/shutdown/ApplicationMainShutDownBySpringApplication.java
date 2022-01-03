package net.teaho.demo.spring.boot.web.server.shutdown;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author teaho2015
 * @date 2020-06
 * @since 1.0.0
 */
@Slf4j
@SpringBootApplication
public class ApplicationMainShutDownBySpringApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(ApplicationMainShutDownBySpringApplication.class).build().run(args);
        int exitCode = SpringApplication.exit(ctx);
        log.info("exitCode is {}!", exitCode);
        System.exit(exitCode);

    }

    @Bean
    public ExitCodeGenerator exitCodeGenerator() {
        return () -> 10;
    }
}
