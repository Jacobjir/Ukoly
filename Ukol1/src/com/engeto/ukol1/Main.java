package com.engeto.ukol1;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        String nameOfSeller;
        LocalDate dateOfBirth;
        int amountOfContracts;
        double totalSoldWeightInTons;
        String residenceOfSeller;
        String licencePlate;
        double fuelConsumptionInLitres;
        String businessPcIpAddress;

        amountOfContracts = 20;
        totalSoldWeightInTons = 200;

        System.out.println("Průměrné množství prodané mrkve na jednu smlouvu je: " + (totalSoldWeightInTons / amountOfContracts) + " tun.");
    }
}