package net.teaho.demo.spring.boot.external.configuration.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * @author teaho2015@gmail.com
 * @date 2020-07
 * @since 1.0.0
 */
@Data
@ConfigurationProperties(prefix = "simple.config.bean")
@Validated
public class SimpleConfigProperties {

    private Boolean enabled;

    @NotNull(message = "host must not null")
    private String host;

    @NotNull(message = "ip must not null")
    private String ip;
}
