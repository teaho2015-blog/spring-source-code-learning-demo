package net.teaho.demo.spring.boot.startup.none.component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author teaho2015<at>gmail<dot>com
 * @date 2020-06
 * @since 1.0.0
 */
@Slf4j
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DemoBean {
    private String name;

}
