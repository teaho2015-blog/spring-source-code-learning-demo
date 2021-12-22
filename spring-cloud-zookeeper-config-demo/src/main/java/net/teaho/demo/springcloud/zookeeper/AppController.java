package net.teaho.demo.springcloud.zookeeper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author teaho2015@gmail.com
 * @date 2021-12
 */
@RestController
public class AppController {

    @Autowired
    private Example example;

    @GetMapping("/example")
    public Object getExample() {
        System.out.println(example.getServerEnabled());
        return example.getServerEnabled();
    }
}
