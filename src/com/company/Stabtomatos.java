package com.company;

public class Stabtomatos extends TomatoPlant{
    private final int numberplantspersection = 6;
    public Stabtomatos(String id, String row, int sectionnumber, boolean isPlanted, boolean isTodayWatered, boolean isReadyForHarvest, double harvest) {
        super(id, row, sectionnumber, isPlanted, isTodayWatered, isReadyForHarvest, harvest);
    }

    @Override
    public String toString() {
        return "Stabtomato{" +
                super.toString();
    }

    public String output() {
        return super.output()+"Stabtomato";
    }
}
