package net.teaho.demo.java.spi;

import java.util.ServiceLoader;

/**
 * @author hetl@akulaku.com
 * @date 2020-07
 * @since 1.0.0
 */
public class RunMain {

    public static void main(String[] args) {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(Robot::sayHello);
    }
}