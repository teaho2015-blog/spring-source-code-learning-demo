package net.teaho.demo.java.spi;

public class Piano implements MusicalInstrument {
    
    @Override
    public void play() {
        System.out.println("Piano is playing.");
    }
}