package xyz.javista.devicemenager;


import xyz.javista.event.EventSender;

/**
 * Created by Luke on 2017-02-28.
 * PoC input reader/event generator
 */
public class Application {

    public static void main(String[] args) {
        EventSender eventSender = new EventSender();
        Reader reader = new Reader(eventSender);
        eventSender.start();
        reader.start();
    }
}

