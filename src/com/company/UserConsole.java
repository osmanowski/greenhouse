package com.company;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserConsole {

    public static void menu() throws InputMismatchException {
        boolean quit = false;

        while (!quit) {
            System.out.println("Plant:");
            System.out.println("1.Add Plant");
            System.out.println("2.Edit Plant");
            System.out.println("3.Delete Plant");
            System.out.println("Planthouse:");
            System.out.println("4.Plant planthouse automatically");
            System.out.println("5.See planting");
            System.out.println("6.Empty planthouse");
            System.out.println("7.Set all plants today watered");
            System.out.println("8.Save changes");
            System.out.println("0.Quit");
            System.out.println("Press key 1-7 to choose option");
            Scanner scan = new Scanner(System.in);
            try{
            Integer choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Press 1 to add Cocktailtomato \n Press 2 to add Stabtomato \n Press 3 to add Fleischtomato");
                    try {


                        Integer choice1 = scan.nextInt();
                        switch (choice1) {
                            case 0:
                                System.out.println("quit");
                                quit = true;
                                break;
                            case 1:
                                Manager.getInstance().addCocktailTomato();
                                break;
                            case 2:
                                Manager.getInstance().addStabTomato();
                                break;
                            case 3:
                                Manager.getInstance().addFleischTomato();
                                break;


                        }
                    } catch (Exception e) {
                        System.out.println("Wrong input. Please enter the key 0-8");
                    }

                    break;
                case 2:
                    Manager.getInstance().editPlant();
                    break;
                case 3:
                    Manager.getInstance().deletePlant();
                    break;
                case 4:
                    Manager.getInstance().plantautomatically();
                    break;
                case 5:
                    Manager.getInstance().getPlantlist();
                    break;
                case 6:
                    Manager.getInstance().emptyPlanthouse();
                    break;
                case 7:
                    Manager.getInstance().allTodayWatered();
                    break;
                case 8:
                    try {
                        Manager.getInstance().deleteData();


                        Manager.getInstance().writeToXml();
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("File not found");
                    }
                    break;
                case 0:
                    quit=true;

            }
                } catch (InputMismatchException e) {

                System.out.println("Wrong input. Please enter the key 0-8");
                quit=false;
            }


        }
    }
}
