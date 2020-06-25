package net.teaho.demo.spring.web.server.shutdown;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author teaho2015
 * @date 2020-06
 * @since 1.0.0
 */
@Slf4j
@SpringBootApplication
public class ApplicationMainShutDownByActuactor {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(ApplicationMainShutDownByActuactor.class, args);

        try {
            TimeUnit.SECONDS.sleep(10L);
        } catch (InterruptedException e) {
            log.error("error", e);
        }
        String myServerPort = ctx.getEnvironment().getProperty("management.server.port");
        RestTemplate restTemplate = ctx.getBean("restTemplate", RestTemplate.class);
        String result = restTemplate.postForObject("http://localhost:" + myServerPort + "/actuator/shutdown", new HttpEntity<String>(CollectionUtils.toMultiValueMap(Collections.singletonMap("Content-Type", Collections.singletonList(MediaType.APPLICATION_JSON_UTF8_VALUE)))), String.class);
        //print result
        log.info("Actuator shutdown result: {}", result);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
