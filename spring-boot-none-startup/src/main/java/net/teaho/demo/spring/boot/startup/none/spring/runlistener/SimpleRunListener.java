package net.teaho.demo.spring.boot.startup.none.spring.runlistener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author teaho2015<at>gmail<dot>com
 * @date 2020-06
 * @since 1.0.0
 */
@Slf4j
public class SimpleRunListener implements SpringApplicationRunListener, Ordered {


    private final SpringApplication application;

    private final String[] args;


    public SimpleRunListener(SpringApplication application, String[] args) {
        this.application = application;
        this.args = args;
    }

    @Override
    public void starting() {
        log.info("starting");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        log.info("environmentPrepared, env:{}", environment);

    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        log.info("contextPrepared, ctx:{}", context);
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        log.info("contextLoaded, context: {}", context);
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        log.info("started, context: {}", context);

    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        log.info("running, context: {}", context);

    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        log.error("failed, context: {}", context, exception);

    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
