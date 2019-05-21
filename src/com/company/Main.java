package com.company;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        Manager.getInstance().readFromFile();
        UserConsole.menu();
        Manager.getInstance().newDay();

        //Planthouse planthouse = new Planthouse();
        //System.out.println(planthouse.getRow("A").getSection(1).getPlant());












    }
}
