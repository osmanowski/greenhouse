package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Section {
    private int number;
    private List<TomatoPlant> plants;



    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    public Section(int number, List<TomatoPlant> plants) {
        this.number = number;
        this.plants = plants;
    }
    public Section(int number){
        this.number=number;

       this.plants= new ArrayList<>();




    }


    public List getPlants() {
        return this.plants;
    }

    public void setPlants(List<TomatoPlant> plants) {
    this.plants = plants;
    }





    @Override
    public String toString() {
        return "\n Section " +
                 number + "\n" +
                "plants=" + plants;
    }

    public void addPlant(String id, String row, int sectionnumber) {
        Cocktailtomatos cocktailtomato = new Cocktailtomatos(id, row, sectionnumber, true, false, false, 0);
        this.plants.add(cocktailtomato);
    }

    public void addPlants(String id, String row, int sectionnumber) {
        Stabtomatos stabtomato = new Stabtomatos(id, row, sectionnumber, true, false, false, 0);
        this.plants.add(stabtomato);

    }

    public void addFleischPlants(String id, String row, int sectionnumber) {
        Fleischtomatos fleischtomato = new Fleischtomatos(id, row, sectionnumber, true, false, false, 0);
        this.plants.add(fleischtomato);
    }

    public TomatoPlant getPlant(String row, int sectionnumber, String id) {
        for(TomatoPlant plant: plants) {
            if(plant.getSectionnumber()==sectionnumber&&plant.getRow().equals(row)&&plant.getId().equals(id)) {
                return plant;
            }
        }
        return null;
    }

    public void removePlant(String row, int sectionnumber, String id) {
        Iterator<TomatoPlant> iterator = plants.iterator();
        while(iterator.hasNext()) {
            TomatoPlant plant = iterator.next();
            if(plant.getRow().equals(row)&&plant.getSectionnumber()==sectionnumber&&plant.getId().equals(id)) {
                iterator.remove();
            }
        }
    }


    public TomatoPlant getPlant() {
        for(TomatoPlant plant: plants) {
            return plant;
        }
    return  null;
    }

    public TomatoPlant getPlantss(int index) {
        return plants.get(index);

    }
}
