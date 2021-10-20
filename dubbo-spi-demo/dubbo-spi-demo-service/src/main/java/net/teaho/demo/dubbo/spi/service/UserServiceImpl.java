package net.teaho.demo.dubbo.spi.service;

import net.teaho.demo.dubbo.spi.api.User;
import net.teaho.demo.dubbo.spi.api.UserService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author teaho2015<at>gmail.com
 * @date 2021-01
 * @since 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {


    @Override
    public User getUser(Integer id) {
        return User.builder()
            .id(String.valueOf(id))
            .name("dehua")
            .email("abc@gmail.com")
            .build();
    }
}
