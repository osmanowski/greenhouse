package com.company;

public class Fleischtomatos extends TomatoPlant {
    private final  int numberPlantsPerSection= 4;

    public Fleischtomatos(String id, String row, int sectionnumber, boolean isPlanted, boolean isTodayWatered, boolean isReadyForHarvest, double harvest) {
        super(id, row, sectionnumber, isPlanted, isTodayWatered, isReadyForHarvest, harvest);
    }

    @Override
    public String toString() {
        return "Fleischtomatos{" +
                super.toString();
    }

    @Override
    public String output() {
        return super.output() + "Fleischtomato";
    }
}
