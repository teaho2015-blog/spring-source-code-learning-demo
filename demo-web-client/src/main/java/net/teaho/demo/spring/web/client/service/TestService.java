package net.teaho.demo.spring.web.client.service;

import net.teaho.demo.spring.web.api.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TestService {

    @Autowired
    private UserFeign userController;

    @Autowired
    private RestTemplate restTemplate;

    public Object getOneUser(){

        return userController.getUserById(1L);

    }


    public void testRestTemplate() {
        String s = restTemplate.getForObject("http://web-demo/user/detail", String.class);
        System.out.println(s);
    }

}
