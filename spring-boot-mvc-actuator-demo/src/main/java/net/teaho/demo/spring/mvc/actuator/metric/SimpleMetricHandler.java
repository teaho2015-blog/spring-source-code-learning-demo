package net.teaho.demo.spring.mvc.actuator.metric;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

/**
 * @author teaho2015
 */
@Component
public class SimpleMetricHandler {

	private final Counter counter;

	public SimpleMetricHandler(MeterRegistry registry) {
		this.counter = registry.counter("received.messages");
	}

	public void handleMessage(String message) {
		this.counter.increment();
		// handle message implementation
	}

}