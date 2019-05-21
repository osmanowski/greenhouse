package com.company;

public class Cocktailtomatos extends TomatoPlant {
    private final int numberPlantsPerSection=10;



    public Cocktailtomatos(String id, String row, int sectionnumber, boolean isPlanted, boolean isTodayWatered, boolean isReadyForHarvest, double harvest) {
        super(id, row, sectionnumber, isPlanted, isTodayWatered, isReadyForHarvest, harvest);



    }


    @Override
    public boolean isPlanted() {
        return super.isPlanted();
    }

    @Override
    public void setPlanted(boolean planted) {
        super.setPlanted(planted);
    }

    @Override
    public boolean isTodayWatered() {
        return super.isTodayWatered();
    }

    @Override
    public void setTodayWatered(boolean todayWatered) {
        super.setTodayWatered(todayWatered);
    }

    @Override
    public boolean isReadyForHarvest() {
        return super.isReadyForHarvest();
    }

    @Override
    public void setReadyForHarvest(boolean readyForHarvest) {
        super.setReadyForHarvest(readyForHarvest);
    }

    @Override
    public double getHarvest() {
        return super.getHarvest();
    }

    @Override
    public void setHarvest(double harvest) {
        super.setHarvest(harvest);
    }

    @Override
    public String getRow() {
        return super.getRow();
    }

    @Override
    public void setRow(String row) {
        super.setRow(row);
    }

    @Override
    public int getSectionnumber() {
        return super.getSectionnumber();
    }

    @Override
    public void setSectionnumber(int sectionnumber) {
        super.setSectionnumber(sectionnumber);
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }

    @Override
    public String toString() {
        return "Cocktailtomato" +  super.toString();
    }

    @Override
    public String output() {
        return super.output() + "Cocktailtomato";
    }
}
