package net.teaho.demo.spring.boot.web.server.shutdown.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author hetl@akulaku.com
 * @date 2020-06
 * @since 1.0.0
 */
@Slf4j
@Component
public class LoggingLifeCycle implements SmartLifecycle {


    private final AtomicBoolean running = new AtomicBoolean(false);

    @Override
    public void start() {
        if (running.compareAndSet(false, true)) {
            log.info("In Life cycle bean start().");
        }
    }

    @Override
    public void stop() {
        if (running.compareAndSet(true, false)) {
            log.info("In Life cycle bean stop().");
        }

    }

    @Override
    public boolean isRunning() {
        return running.get();
    }
}
