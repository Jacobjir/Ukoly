package com.engeto.kvetiny;

import java.io.FileNotFoundException;
import java.time.LocalDate;

public class Main {


     public static final String INPUT_FILE = "kvetiny.txt";
     public static final String OUTPUT_FILE = "výstup.txt";

    // Pro testování:
    // ================

    // public static final String INPUT_FILE = "kvetiny_spatne_datum.txt";
    // public static final String INPUT_FILE = "kvetiny_spatne_frekvence.txt";

    // ================

    public static void main(String[] args) {
        PlantList list = new PlantList();
        try {
            list.importFromFile(INPUT_FILE);
        } catch (PlantException e) {
            System.err.println(e.getLocalizedMessage());
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.getPlant(i).getWateringInfo());
        }
        list.addPlant(new Plant("Orchidej"));
        list.addPlant(new Plant("Růže",4, LocalDate.now()));
        list.removePlant(2);


        try {
            list.exportToFile(OUTPUT_FILE);
        } catch (PlantException e) {
            System.err.println(e.getLocalizedMessage());
        }
    }
}
