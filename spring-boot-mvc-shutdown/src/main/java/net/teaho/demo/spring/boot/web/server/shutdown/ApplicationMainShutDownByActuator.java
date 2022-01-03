package net.teaho.demo.spring.boot.web.server.shutdown;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * @author teaho2015
 * @date 2020-06
 * @since 1.0.0
 */
@Slf4j
@SpringBootApplication
public class ApplicationMainShutDownByActuator {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(ApplicationMainShutDownByActuator.class, args);

        try {
            TimeUnit.SECONDS.sleep(10L);
        } catch (InterruptedException e) {
            log.error("error", e);
        }
        if (ctx instanceof AnnotationConfigServletWebServerApplicationContext) {
            String myServerPort = ((AnnotationConfigServletWebServerApplicationContext) ctx).getWebServer().getPort() + "";
            RestTemplate restTemplate = ctx.getBean("restTemplate", RestTemplate.class);
            String result = restTemplate.postForObject("http://localhost:" + myServerPort + "/actuator/shutdown", new HttpEntity<String>(CollectionUtils.toMultiValueMap(Collections.singletonMap("Content-Type", Collections.singletonList(MediaType.APPLICATION_JSON_UTF8_VALUE)))), String.class);
            //print result
            log.info("Actuator shutdown result: {}", result);
        } else {
            log.error("did you change the dependencies? or custom a not servlet web app context?");
        }


    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
