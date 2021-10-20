package net.teaho.demo.java.spi;

import java.util.ServiceLoader;

/**
 * @author teaho2015<at>gmail.com
 * @date 2020-07
 * @since 1.0.0
 */
public class RunMain {

    public static void main(String[] args) {
        ServiceLoader<MusicalInstrument> serviceLoader = ServiceLoader.load(MusicalInstrument.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(MusicalInstrument::play);
    }
}
