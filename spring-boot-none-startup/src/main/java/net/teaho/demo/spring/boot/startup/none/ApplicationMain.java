package net.teaho.demo.spring.boot.startup.none;

import net.teaho.demo.spring.boot.startup.none.component.DemoBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ApplicationMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(ApplicationMain.class, args);
        //for test ContextInitializer
        DemoBean db = ctx.getBean(DemoBean.class);
        System.out.println(db.getName());
    }

}
