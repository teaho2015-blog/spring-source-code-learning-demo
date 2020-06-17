package net.teaho.demo.spring.boot.startup.none.spring.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;

/**
 * @author teaho2015<at>gmail<dot>com
 * @date 2020-06
 * @since 1.0.0
 */
@Slf4j
public class SimpleEventListener implements ApplicationListener<SimpleAppEvent> {

    @Override
    public void onApplicationEvent(SimpleAppEvent event) {
        log.info("event: {}, source: {}", event, event.getSource());
    }
}
