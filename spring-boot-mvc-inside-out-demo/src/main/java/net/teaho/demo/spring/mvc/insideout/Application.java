package net.teaho.demo.spring.mvc.insideout;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;

/**
 * @author teaho2015<at>gmail.com
 * @date 2021-10
 */
@Slf4j
@SpringBootApplication
@RestController
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);

    }

    @PostMapping("/demo/time")
    public Map<String, String> demo() {
        return Collections.singletonMap("time", LocalDateTime.now().toString());
    }




}
