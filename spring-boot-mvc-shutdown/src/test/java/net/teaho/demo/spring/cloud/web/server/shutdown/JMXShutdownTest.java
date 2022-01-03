package net.teaho.demo.spring.cloud.web.server.shutdown;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jmx.support.MBeanServerConnectionFactoryBean;

import javax.management.MBeanServerConnection;
import javax.management.ObjectName;

/**
 *
 *
 * @author hetl@akulaku.com
 * @date 2020-06
 * @since 1.0.0
 */
@Deprecated
@SpringBootApplication
public class JMXShutdownTest {


    public static void main(String[] args) {
        new SpringApplicationBuilder(JMXShutdownTest.class)
            .web(WebApplicationType.NONE)
            .run(args);
    }

    @Bean
    public ApplicationRunner runner(MBeanServerConnection jmxConnector) {
        return args -> {
            jmxConnector.invoke(new ObjectName("org.springframework.boot:type=Endpoint,name=Shutdown"),
                "shutdown", null, null);
        };
    }

    @Bean
    public MBeanServerConnectionFactoryBean jmxConnector() throws Exception {
        MBeanServerConnectionFactoryBean jmx = new MBeanServerConnectionFactoryBean();
        jmx.setServiceUrl("service:jmx:rmi://127.0.0.1/stub/rmi://127.0.0.1:63384/jmxrmi");

        return jmx;
    }


}
