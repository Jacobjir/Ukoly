package com.engeto.kvetiny;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlantList {

    List<Plant> plants = new ArrayList<>();

    private static final String DELIMITER = "\t";

    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    public Plant getPlant(int index) {
        return plants.get(index);
    }

    public void removePlant(int index) {
        plants.remove(index);
    }

    public int size() {
        return plants.size();
    }

    public void importFromFile(String fileName)
        throws PlantException {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)))) {
            int lineNumber = 0;
            while (scanner.hasNextLine()) {
                String record = scanner.nextLine();
                lineNumber++;
                try {
                    this.addPlant(Plant.parse(record,DELIMITER));
                }
                catch (PlantException e) {
                    throw new PlantException("Špatný vstupní soubor " + fileName + " na řádku: " +lineNumber + ":\n\t" +e.getLocalizedMessage());
                }
            }
        } catch (FileNotFoundException e) {
            throw new PlantException("Vstupní soubor " +fileName +" nebyl nalezen: " +e.getLocalizedMessage());
        }
    }

    public void exportToFile(String fileName)
        throws PlantException {

        int lineNumber = 0;
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
            for (Plant plant : plants) {
                String plantsAsFileLine = plant.prepareOutputString(DELIMITER);
                writer.println(fileName);
                lineNumber++;
            }
        } catch (IOException e) {
            throw new PlantException("Chyba při zapisování do: " + fileName + " řádek č." + lineNumber + ": " + e.getLocalizedMessage());
        }
    }

    @Override
    public String toString() {
        return "PlantList{" +
                "plants=" + plants +
                '}';
    }
}
