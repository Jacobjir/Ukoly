package com.engeto.kvetiny;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlantList {

    List<Plant> plants = new ArrayList<>();

    public static String importFromFile(String filename, String delimiter)
            throws PlantException, FileNotFoundException {
        String nextLine = "";
        String[] items = new String[1];
        String name;
        String notes;
        BigDecimal frequencyOfWatering;
        LocalDate planted;
        LocalDate watering;
        int lineNumber = 0;

        PlantList result = new PlantList();

        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))) {
            while (scanner.hasNextLine()) {
                lineNumber++;
                nextLine = scanner.nextLine();
                items = nextLine.split("\t");
                name = items[0];
                notes = items[1];
                frequencyOfWatering = new BigDecimal(items[2]);
                planted = LocalDate.parse(items[3]);
                watering = LocalDate.parse(items[4]);
                result.addPlant(new Plant(name,notes,frequencyOfWatering,planted,watering));
            }
            }
        catch (FileNotFoundException e) {
        try {
            throw new PlantException("Soubor nebyl nalezen");
        } catch (PlantException ex) {
            ex.printStackTrace();
        }
    }
        return result;
    }

    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    public Plant getplant(int index){
        return plants.get(index);
    }

    public void removePlant(int index) {
        plants.remove(index);
    }

}
