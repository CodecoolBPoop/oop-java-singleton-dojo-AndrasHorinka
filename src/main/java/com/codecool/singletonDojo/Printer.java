package com.codecool.singletonDojo;

import java.time.LocalTime;

public class Printer {
    private int id;
    private LocalTime busyEndTime = LocalTime.now();

    public Printer(int id) {
        this.id = id;
    }

    public void print(String toPrint) {
        // Its not needed to actually print with a printer in this exercise
        System.out.println("Printer " + id + " is printing: " + toPrint );
        busyEndTime = LocalTime.now().plusSeconds(5);
    }

    public boolean isAvailable() {
        return LocalTime.now().isAfter(busyEndTime);
    }
}
