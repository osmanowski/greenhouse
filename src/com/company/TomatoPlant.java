package com.company;

public abstract class TomatoPlant {

    private String id;
    private String row;
    private int sectionnumber;
    private boolean isPlanted = false;
    private boolean isTodayWatered = false;
    private boolean isReadyForHarvest = false;
    private double harvest = 0;

    public boolean isPlanted() {
        return isPlanted;
    }

    public void setPlanted(boolean planted) {
        isPlanted = planted;
    }

    public boolean isTodayWatered() {
        return isTodayWatered;
    }

    public void setTodayWatered(boolean todayWatered) {
        isTodayWatered = todayWatered;
    }

    public boolean isReadyForHarvest() {
        return isReadyForHarvest;
    }

    public void setReadyForHarvest(boolean readyForHarvest) {
        isReadyForHarvest = readyForHarvest;
    }

    public double getHarvest() {
        return harvest;
    }

    public void setHarvest(double harvest) {
        this.harvest = harvest;
    }

    public TomatoPlant(String id, String row, int sectionnumber, boolean isPlanted, boolean isTodayWatered, boolean isReadyForHarvest, double harvest) {

        this.id=id;
        this.row=row;
        this.sectionnumber=sectionnumber;
        this.isPlanted = isPlanted;
        this.isTodayWatered = isTodayWatered;
        this.isReadyForHarvest = isReadyForHarvest;
        this.harvest = harvest;
    }


    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public int getSectionnumber() {
        return sectionnumber;
    }

    public void setSectionnumber(int sectionnumber) {
        this.sectionnumber = sectionnumber;
    }

    @Override
    public String toString() {
        return
                "id='" + id + '\'' +
                ", row='" + row + '\'' +
                ", sectionnumber=" + sectionnumber +
                ", isPlanted=" + isPlanted +
                ", isTodayWatered=" + isTodayWatered +
                ", isReadyForHarvest=" + isReadyForHarvest +
                ", harvest=" + harvest +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String output(){
        return "Plant";
    }

    }
