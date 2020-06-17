package net.teaho.demo.spring.boot.startup.none.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author teaho2015<at>gmail<dot>com
 * @date 2020-06
 * @since 1.0.0
 */
public class SimpleAppEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public SimpleAppEvent(Object source) {
        super(source);
    }


}
