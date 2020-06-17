package net.teaho.demo.spring.boot.startup.none;

import lombok.extern.slf4j.Slf4j;
import net.teaho.demo.spring.boot.startup.none.component.DemoBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class ApplicationMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(ApplicationMain.class, args);
    }

}
