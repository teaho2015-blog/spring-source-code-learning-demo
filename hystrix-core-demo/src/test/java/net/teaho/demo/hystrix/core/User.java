package net.teaho.demo.hystrix.core;

import lombok.Builder;
import lombok.Data;

/**
 * @author teaho2015@gmail.com
 * @date 2020-07
 * @since 1.0.0
 */
@Data
@Builder
public class User {

    private String name;
    private String height;
    private String email;
}
