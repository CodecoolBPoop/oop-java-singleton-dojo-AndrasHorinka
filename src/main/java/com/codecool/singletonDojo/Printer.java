package com.codecool.singletonDojo;

import java.time.LocalTime;

public class Printer {

    private int id = 1;
    private LocalTime busyEndTime;
    private static Printer instance = null;

    private Printer() {
    }

    public static Printer getInstance() {
        if (instance == null) {
            instance = new Printer();
        }
        return instance;
    }

    // Prints out the given String
    public void print(String toPrint) {
        // Its not needed to actually print with a printer in this exercise
        System.out.println("Printer " + id + " is printing.");
        busyEndTime = LocalTime.now().plusSeconds(5);
    }

    // Returns true if the printer is ready to print now.
    public boolean isAvailable() {
        return LocalTime.now().isAfter(busyEndTime);
    }
}
