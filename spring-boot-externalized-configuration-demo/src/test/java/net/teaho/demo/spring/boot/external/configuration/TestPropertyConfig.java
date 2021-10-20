package net.teaho.demo.spring.boot.external.configuration;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * @author teaho2015<at>gmail.com
 * @date 2020-07
 * @since 1.0.0
 */
@Data
//@Builder
//@ConfigurationProperties("binder.test")
@Validated
public class TestPropertyConfig {
    private Boolean enabled;
    private String url;
    private String name;
    @NotNull(message = "info must not null")
    private String info;
}
