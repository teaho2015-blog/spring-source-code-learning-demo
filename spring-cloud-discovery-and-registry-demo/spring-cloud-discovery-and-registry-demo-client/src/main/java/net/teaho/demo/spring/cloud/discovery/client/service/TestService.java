package net.teaho.demo.spring.cloud.discovery.client.service;

import lombok.extern.slf4j.Slf4j;
import net.teaho.demo.spring.cloud.discovery.api.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class TestService {

    @Autowired
    private UserFeign userController;

    @Autowired
    private RestTemplate restTemplate;

    public Object getOneUser(){

        return userController.getUserById(1L);

    }


    public void testRestTemplate() {
        String s = restTemplate.getForObject("http://spring-cloud-web-demo/user/detail", String.class);
        log.info(s);
    }

}
