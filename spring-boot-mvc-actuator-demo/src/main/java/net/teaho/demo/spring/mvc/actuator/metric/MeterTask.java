package net.teaho.demo.spring.mvc.actuator.metric;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MeterTask {

    @Autowired
    private SimpleMetricHandler simpleMetricHandler;

    @Scheduled(cron = "0/2 * * * * ? ")
    public void run() {
        simpleMetricHandler.handleMessage("blabla");
    }
}