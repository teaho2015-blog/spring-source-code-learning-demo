package net.teaho.demo.java.spi;

public class Guitar implements MusicalInstrument {

    @Override
    public void play() {
        System.out.println("Guitar is playing.");
    }
}