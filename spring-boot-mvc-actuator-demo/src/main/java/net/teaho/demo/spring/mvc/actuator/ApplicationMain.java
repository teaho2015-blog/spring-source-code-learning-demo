package net.teaho.demo.spring.mvc.actuator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;

/**
 * @author teaho2015
 * @date 2020-06
 * @since 1.0.0
 */
@Slf4j
@SpringBootApplication
@RestController
@EnableScheduling
public class ApplicationMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(ApplicationMain.class, args);

    }

    @PostMapping("/demo/time")
    public Map<String, String> demo() {
        return Collections.singletonMap("time", LocalDateTime.now().toString());
    }




}
