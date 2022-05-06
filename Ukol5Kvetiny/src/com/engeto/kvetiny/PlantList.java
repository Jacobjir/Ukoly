package com.engeto.kvetiny;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlantList {

    List<Plant> plants = new ArrayList<>();

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
