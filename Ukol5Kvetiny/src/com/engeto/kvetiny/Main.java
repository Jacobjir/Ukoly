package com.engeto.kvetiny;

import java.io.FileNotFoundException;

public class Main {


    public static final String FILENAME = "kvetiny.txt";
    public static final String DELIMITER = "\t";

    public static void main(String[] args) {


        try {
            System.out.println(PlantList.importFromFile(FILENAME, DELIMITER));
        } catch (PlantException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
