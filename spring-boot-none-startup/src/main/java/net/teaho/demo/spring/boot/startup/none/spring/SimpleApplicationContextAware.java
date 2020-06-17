package net.teaho.demo.spring.boot.startup.none.spring;

import lombok.extern.slf4j.Slf4j;
import net.teaho.demo.spring.boot.startup.none.spring.event.SimpleAppEvent;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author teaho2015<at>gmail<dot>com
 * @date 2020-06
 * @since 1.0.0
 */
@Component
@Slf4j
public class SimpleApplicationContextAware implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        log.info("SimpleApplicationContextAware and send SimpleAppEvent");
        applicationContext.publishEvent(new SimpleAppEvent("event source"));
    }
}
