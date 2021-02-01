package net.teaho.demo.dubbo.spi.api;

import lombok.Builder;
import lombok.Data;

/**
 * @author teaho2015@gmail.com
 * @date 2020-07
 * @since 1.0.0
 */
@Data
@Builder
public class User implements java.io.Serializable {
    private static final long serialVersionUID = -6529508012524243295L;

    private String id;
    private String name;
    private String email;
}
