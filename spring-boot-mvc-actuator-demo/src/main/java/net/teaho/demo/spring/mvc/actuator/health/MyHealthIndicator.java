package net.teaho.demo.spring.mvc.actuator.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


/**
 *
 * @author teaho2015<at>gmail.com
 */
@Component
public class MyHealthIndicator implements HealthIndicator {

	@Value("${demo.health.status:true}")
	private Boolean status;

	@Override
	public Health health() {
		// perform some specific health check
		int errorCode = check();
		if (errorCode != 0) {
			return Health.down()
				.withDetail("Error Code", errorCode)
				.withDetail("hello", "world")
				.build();
		}
		return Health.up().build();
	}

	private int check() {
		if (status == null || !status) {
			return -1;
		}
		return 0;
	}


}