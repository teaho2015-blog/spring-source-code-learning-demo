package net.teaho.demo.spring.boot.startup.none.spring;

import net.teaho.demo.spring.boot.startup.none.component.DemoBean;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author teaho2015<at>gmail<dot>com
 * @date 2020-06
 * @since 1.0.0
 */
public class SimpleApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        applicationContext.getBeanFactory().registerSingleton("demoBean",
                DemoBean.builder().name("demoBean from SimpleApplicationContextInitializer.").build());
    }
}
