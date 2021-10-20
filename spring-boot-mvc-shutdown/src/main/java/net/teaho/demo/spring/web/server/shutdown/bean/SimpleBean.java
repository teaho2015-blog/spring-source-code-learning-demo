package net.teaho.demo.spring.web.server.shutdown.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * @author teaho2015<at>gmail.com
 * @date 2020-06
 * @since 1.0.0
 */
@Slf4j
public class SimpleBean implements DisposableBean {
    @Override
    public void destroy() throws Exception {
        log.info("DisposableBean is destroying!");
    }


    public void selfDestroy() {

        log.info("On my way to destroy!");
    }

    @PreDestroy
    public void preDestroy() {

        log.info("@PreDestroy!");

    }
}
