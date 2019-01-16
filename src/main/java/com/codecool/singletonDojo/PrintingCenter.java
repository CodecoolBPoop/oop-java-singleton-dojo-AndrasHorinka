package com.codecool.singletonDojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class PrintingCenter {
    private static PrintingCenter instance = null;
    private static List<Printer> printers = new ArrayList<>();
    private static final int NR_OF_PRINTERS = 10;
    private static boolean printed = false;
    private static Random rand = new Random();

    private PrintingCenter() {
    }

    public static PrintingCenter getInstance() {
        if (instance == null) {
            instance = new PrintingCenter();
        }

        for (int i = 0; i < NR_OF_PRINTERS; i++) {
            printers.add(new Printer(i));
        }
        return instance;
    }

    public static void print(String toPrint) {
        for (Printer printer: printers) {
            if (printer.isAvailable()) {
                printer.print(toPrint);
                printed = true;
            }
        }
        if (!printed) {
            printers.get(rand.nextInt(NR_OF_PRINTERS)).print(toPrint);
        }
    }
}
