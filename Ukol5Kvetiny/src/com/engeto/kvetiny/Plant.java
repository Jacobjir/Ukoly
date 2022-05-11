package com.engeto.kvetiny;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Plant {
    private String name;
    private String notes;
    private LocalDate planted;
    private LocalDate watering;
    private int frequencyOfWatering;

    public Plant(String name) {
        this(name, 7, LocalDate.now());
    }

    public Plant(String name, int frequencyOfWateringInDays, LocalDate planted) {
        this(name, "", frequencyOfWateringInDays, LocalDate.now(), planted);
    }

    public Plant(String name, String notes, int frequencyOfWateringInDays, LocalDate lastWatering, LocalDate planted) {
        this.name = name;
        this.notes = notes;
        this.frequencyOfWatering = frequencyOfWateringInDays;
        this.watering = lastWatering;
        this.planted = planted;
    }

    public static Plant parse(String text, String delimiter)
        throws PlantException {
        String[] items = text.split(delimiter);
        int numberOfItems = items.length;
        if (numberOfItems != 5)
            throw new PlantException("Nesprávný počet položek na řádku. Očekáváme jich 5, místo " + numberOfItems + "!");

        String name = items[0];
        String notes = items[1];
        try {
            int frequencyOfWatering = Integer.parseInt(items[2]);
            LocalDate watering = LocalDate.parse(items[3]);
            LocalDate planted = LocalDate.parse(items[4]);

            return new Plant(name,notes,frequencyOfWatering,watering,planted);
        }
        catch (DateTimeParseException ex) {
            throw new PlantException("Špatně zadané datum: \"" + text + "\"\n\t" + ex.getLocalizedMessage());
        }
        catch (NumberFormatException ex) {
            throw new PlantException("Špatně zadané číslo na řádku: \"" + text + "\"\n\t" + ex.getLocalizedMessage());
        }
    }

    public String prepareOutputString(String delimiter) {
        return getName() + delimiter + getNotes() + delimiter + getFrequencyOfWatering() + delimiter + getWatering() + delimiter + getPlanted();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getPlanted() {
        return planted;
    }

    public void setPlanted(LocalDate planted) {
        this.planted = planted;
    }

    public LocalDate getWatering() {
        return watering;
    }

    public void setWatering(LocalDate watering)
        throws PlantException{
        LocalDate datePlanted = getPlanted();
        if (watering.isBefore(datePlanted)) {
            throw new PlantException("Datum posledního zalévání " + watering + "nemůže být starší než datum zasazení rostliny " +datePlanted);
        }
    }

    public long getFrequencyOfWatering() {
        return frequencyOfWatering;
    }

    public void setFrequencyOfWatering(int frequencyOfWatering) {
        this.frequencyOfWatering = frequencyOfWatering;
    }

    public String getWateringInfo() {
        return "Název: " + getName() + ". Poslední zalevání: " +watering + ". Doporučené datum dalšího zalévání: " + watering.plusDays(getFrequencyOfWatering()) +".";
    }
}
