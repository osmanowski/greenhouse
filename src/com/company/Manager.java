package com.company;



import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.rmi.activation.ActivationGroup_Stub;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

public class Manager {
    private static Manager ourInstance = new Manager();

    public static Manager getInstance() {
        return ourInstance;
    }

    private Manager() {
    }

    Planthouse planthouse = new Planthouse();


    public void addCocktailTomato() {
        try {


            Scanner scanner = new Scanner(System.in);

            System.out.println("Input Id:");
            String id = scanner.nextLine();
            System.out.println("Input Row");
            String row = scanner.nextLine();
            System.out.println("Input sectionnumber");
            Integer sectionnumber = scanner.nextInt();
            planthouse.getRow(row).getSection(sectionnumber).addPlant(id, row, sectionnumber);

        }catch (Exception e) {
            System.out.println("Wrong input. Rows: A-E. Sections: 1-25");
        }

    }

    public void getPlantlist() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press 1 to see section \n Press 2 to see row \n Press 3 to see all \n Press 0 to break");
        try {


            Integer choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    break;
                case 1:
                    System.out.println("Input row:");
                    String row = scanner.nextLine();
                    System.out.println("Input sectionnumber:");
                    Integer sectionnumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(planthouse.getRow(row).getSection(sectionnumber).getPlants());
                    break;
                case 2:
                    System.out.println("Input row:");
                    String r = scanner.nextLine();
                    for (int i = 1; i <= planthouse.getRow(r).getSections().size(); i++) {
                        System.out.println(planthouse.getRow(r).getSection(i));
                    }
                    break;
                case 3:
                    System.out.println(planthouse.getRows());
                    break;

            }


        }catch (Exception e) {
            System.out.println("Wrong input. Rows: A-E. Sections: 1-25");
        }

    }
    public void addStabTomato() {
        Scanner scanner = new Scanner(System.in);
        try {


            System.out.println("Input Id:");
            String id = scanner.nextLine();
            System.out.println("Input row:");
            String row = scanner.nextLine();
            System.out.println("Input sectionnumber:");
            Integer sectionnumber = scanner.nextInt();
            planthouse.getRow(row).getSection(sectionnumber).addPlants(id, row, sectionnumber);

        }catch (Exception e) {
            System.out.println("Wrong input. Rows: A-E. Sections: 1-25");
        }
    }
    public void addFleischTomato() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Input Id:");
            String id = scanner.nextLine();
            System.out.println("Input row:");
            String row = scanner.nextLine();
            System.out.println("Input sectionnumber:");
            Integer sectionnumber = scanner.nextInt();
            planthouse.getRow(row).getSection(sectionnumber).addFleischPlants(id, row, sectionnumber);
        }catch (Exception e) {
            System.out.println("Wrong input. Rows: A-E. Sections: 1-25");
        }
    }
    public void editPlant() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Row:");
        String row = scanner.nextLine();
        System.out.println("Input sectionnumber");
        Integer sectionnumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Input PlantId:");
        String plantId = scanner.nextLine();
        //TomatoPlant plant = planthouse.getRow(row).getSection(sectionnumber).getPlant(plantId, row, sectionnumber);
        System.out.println("Press 1 to change TodayWatered status: \n Press 2 to change ReadyForHarvest status: \n Press 3 to set Harvest: \n Press 0 to break");
        Integer choice = scanner.nextInt();

        switch (choice) {
            case 0:
                break;
            case 1:
                if (planthouse.getRow(row).getSection(sectionnumber).getPlant(row, sectionnumber, plantId) != null) {
                    if (!planthouse.getRow(row).getSection(sectionnumber).getPlant(row, sectionnumber, plantId).isTodayWatered()) {
                        planthouse.getRow(row).getSection(sectionnumber).getPlant(row, sectionnumber, plantId).setTodayWatered(true);
                        System.out.println("Plant " + planthouse.getRow(row).getSection(sectionnumber).getPlant(row, sectionnumber, plantId).getId() + " is today watered");
                    } else {
                        planthouse.getRow(row).getSection(sectionnumber).getPlant(row, sectionnumber, plantId).setTodayWatered(false);
                        System.out.println("Plant " + planthouse.getRow(row).getSection(sectionnumber).getPlant(row, sectionnumber, plantId).getId() + " is today not watered");
                    }
                } else {
                    System.out.println("No plant found");
                }
                break;
            case 2:
                if (!planthouse.getRow(row).getSection(sectionnumber).getPlant(row, sectionnumber, plantId).isReadyForHarvest()) {
                    planthouse.getRow(row).getSection(sectionnumber).getPlant(row, sectionnumber, plantId).setReadyForHarvest(true);
                    System.out.println("Plant " + planthouse.getRow(row).getSection(sectionnumber).getPlant(row, sectionnumber, plantId).getId() + " is ready for harvest");
                } else {
                    planthouse.getRow(row).getSection(sectionnumber).getPlant(row, sectionnumber, plantId).setReadyForHarvest(false);
                    System.out.println("Plant " + planthouse.getRow(row).getSection(sectionnumber).getPlant(row, sectionnumber, plantId).getId() + " is not ready for harvest");
                }
                break;
            case 3:
                System.out.println("Input Harvest");
                Double harvest = scanner.nextDouble();
                planthouse.getRow(row).getSection(sectionnumber).getPlant(row, sectionnumber, plantId).setHarvest(harvest);
                System.out.println("Now is the harvest of Plant " + planthouse.getRow(row).getSection(sectionnumber).getPlant(row, sectionnumber, plantId).getId() + " is  " + planthouse.getRow(row).getSection(sectionnumber).getPlant(row, sectionnumber, plantId).getHarvest());
                break;
        }

    }


    public void deletePlant() {
        Scanner scanner = new Scanner(System.in);
        try {


            System.out.println("Input Row:");
            String row = scanner.nextLine();
            System.out.println("Input sectionnumber");
            Integer sectionnumber = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Input PlantId:");
            String plantId = scanner.nextLine();
            if (planthouse.getRow(row).getSection(sectionnumber).getPlant(row, sectionnumber, plantId) != null) {


                System.out.println("Plant " + planthouse.getRow(row).getSection(sectionnumber).getPlant(row, sectionnumber, plantId).getId() + " is deleted!");
                planthouse.getRow(row).getSection(sectionnumber).removePlant(row, sectionnumber, plantId);

            } else {
                System.out.println("No such plant found!");
            }

        }catch (Exception e) {
            System.out.println("Wrong input");
        }
    }

    public void plantautomatically() {
        ArrayList<Row> rows = planthouse.getRows();
        Iterator<Row> iterator = rows.iterator();
        while (iterator.hasNext()) {
            Row row = iterator.next();
            if (row.getId().equals("A") || row.getId().equals("B") || row.getId().equals("C")) {

                ArrayList<Section> sections = planthouse.getRow(row.getId()).getSections();
                Iterator<Section> sectionIterator = sections.iterator();
                while (sectionIterator.hasNext()) {
                    Section section = sectionIterator.next();
                    for (int i = 1; i <= 6; i++) {
                        section.addPlants(i + row.getId() + section.getNumber(), row.getId(), section.getNumber());


                    }
                }


            }

            if (row.getId().equals("D") || row.getId().equals("E")) {
                ArrayList<Section> sections = planthouse.getRow(row.getId()).getSections();
                Iterator<Section> sectionIterator = sections.iterator();
                while (sectionIterator.hasNext()) {
                    Section section = sectionIterator.next();
                    for (int i = 1; i <= 10; i++) {
                        section.addPlant(i + row.getId() + section.getNumber(), row.getId(), section.getNumber());
                    }
                }
            }

            if (row.getId().equals("E") || row.getId().equals("F")) {
                ArrayList<Section> sections = planthouse.getRow(row.getId()).getSections();
                Iterator<Section> sectionIterator = sections.iterator();
                while (sectionIterator.hasNext()) {
                    Section section = sectionIterator.next();
                    for (int i = 11; i <= 14; i++) {
                        section.addFleischPlants(i + row.getId() + section.getNumber(), row.getId(), section.getNumber());
                    }
                }


            }
        }

        System.out.println("Planthouse has been planted automatically");
    }

    public void emptyPlanthouse() {
        ArrayList<Row> rows = planthouse.getRows();
        Iterator<Row> rowIterator = rows.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            for (int i = 1; i <= planthouse.getRow(row.getId()).getSections().size(); i++) {
                planthouse.getRow(row.getId()).getSection(i).getPlants().clear();

            }
        }
        System.out.println("Planthouse has been emptied");
    }

    public void newDay() {
        LocalDateTime midnight = LocalDateTime.of(LocalDate.now(), LocalTime.of(23, 59, 59));
        if (LocalDateTime.now().equals(midnight)) {
            ArrayList<Row> rows = planthouse.getRows();
            Iterator<Row> rowIterator = rows.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                for (int i = 1; i <= planthouse.getRow(row.getId()).getSections().size(); i++) {
                    for (int j = 1; j <= planthouse.getRow(row.getId()).getSection(i).getPlants().size(); j++) {
                        if (planthouse.getRow(row.getId()).getSection(i).getPlants().get(j) != null) {
                            planthouse.getRow(row.getId()).getSection(i).getPlant().setTodayWatered(false);
                        }
                    }
                }


            }

        }


    }

    public void allTodayWatered() {
        ArrayList<Row> rows = planthouse.getRows();
        Iterator<Row> rowIterator = rows.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            for (int i = 1; i <= row.getSections().size(); i++) {
                for (int j = 0; j < row.getSection(i).getPlants().size(); j++) {
                    if (row.getSection(i).getPlantss(j) != null) {
                        row.getSection(i).getPlantss(j).setTodayWatered(true);
                    }
                }
            }


        }

        System.out.println("All plants are now watered");
    }


    public void writeToXml() {
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            Element root = document.createElement("planthouse");
            document.appendChild(root);
            for (int i = 0; i < planthouse.getRows().size(); i++) {
                Element row = document.createElement("Row");
                root.appendChild(row);
                Attr rowAttr = document.createAttribute("id");
                rowAttr.setValue(planthouse.getRows().get(i).getId());
                row.setAttributeNode(rowAttr);
                for (int j = 0; j < planthouse.getRows().get(i).getSections().size(); j++) {
                    String sectionnumber = Integer.toString(planthouse.getRows().get(i).getSections().get(j).getNumber());
                    Element section = document.createElement("Section");
                    row.appendChild(section);
                    Attr sectionAttr = document.createAttribute("number");
                    sectionAttr.setValue(sectionnumber);
                    section.setAttributeNode(sectionAttr);
                    for (int k = 0; k < planthouse.getRows().get(i).getSections().get(j).getPlants().size(); k++) {
                        Element plant = document.createElement(planthouse.getRows().get(i).getSections().get(j).getPlantss(k).output());
                        section.appendChild(plant);
                        Attr attr = document.createAttribute("id");
                        attr.setValue(planthouse.getRows().get(i).getSections().get(j).getPlantss(k).getId());
                        plant.setAttributeNode(attr);
                        Attr plantRowAttr = document.createAttribute("row");
                        plantRowAttr.setValue(planthouse.getRows().get(i).getSections().get(j).getPlantss(k).getRow());
                        plant.setAttributeNode(plantRowAttr);
                        Attr plantSectionAttr = document.createAttribute("sectionnumber");
                        plantSectionAttr.setValue(sectionnumber);
                        plant.setAttributeNode(plantSectionAttr);
                        Attr isPlantedAttr = document.createAttribute("is_planted");
                        String isPlantedString = Boolean.toString(planthouse.getRows().get(i).getSections().get(j).getPlantss(k).isPlanted());
                        isPlantedAttr.setValue(isPlantedString);
                        plant.setAttributeNode(isPlantedAttr);
                        Attr todayWateredAttr = document.createAttribute("Today_watered");
                        String todayWateredString = Boolean.toString(planthouse.getRows().get(i).getSections().get(j).getPlantss(k).isTodayWatered());
                        todayWateredAttr.setValue(todayWateredString);
                        plant.setAttributeNode(todayWateredAttr);
                        Attr readyForHarvestAttr = document.createAttribute("Ready_for_Harvest");
                        String readyForHarvestString = Boolean.toString(planthouse.getRows().get(i).getSections().get(j).getPlantss(k).isReadyForHarvest());
                        readyForHarvestAttr.setValue(readyForHarvestString);
                        plant.setAttributeNode(readyForHarvestAttr);
                        Attr harvestAttr = document.createAttribute("Harvest");
                        String harvestString = Double.toString(planthouse.getRows().get(i).getSections().get(j).getPlantss(k).getHarvest());
                        harvestAttr.setValue(harvestString);
                        plant.setAttributeNode(harvestAttr);

                    }
                }
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("planthouse.xml"));

            transformer.transform(domSource, streamResult);
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }

    public void readFromFile() {
        try {
            File inputFile = new File("planthouse.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
            Document doc = dbBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("PlantStabtomato");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                for (int j = 0; j < planthouse.getRows().size(); j++) {
                    for (int k = 0; k < planthouse.getRows().get(j).getSections().size(); k++) {
                        String section = Integer.toString(planthouse.getRows().get(j).getSections().get(k).getNumber());

                        if (element.getAttribute("sectionnumber").equals(section) && element.getAttribute("row").equals(planthouse.getRows().get(j).getId())) {
                            Stabtomatos stabtomatos = new Stabtomatos("A", "A", 1, true, false, false, 0);
                            planthouse.getRows().get(j).getSections().get(k).getPlants().add(stabtomatos);
                            stabtomatos.setId(element.getAttribute("id"));
                            stabtomatos.setRow(element.getAttribute("row"));
                            stabtomatos.setSectionnumber(k + 1);
                            if (element.getAttribute("Ready_for_Harvest").equals("false")) {
                                stabtomatos.setReadyForHarvest(false);
                            } else if (element.getAttribute("Ready_for_Harvest").equals("true")) {
                                stabtomatos.setReadyForHarvest(true);
                            }
                            if (element.getAttribute("Today_watered").equals("true")) {
                                stabtomatos.setTodayWatered(true);
                            } else if (element.getAttribute("Today_watered").equals("false")) {
                                stabtomatos.setTodayWatered(false);
                            }
                            Double harvest = Double.valueOf(element.getAttribute("Harvest"));
                            stabtomatos.setHarvest(harvest);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File inputFile = new File("planthouse.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
            Document doc = dbBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("PlantFleischtomato");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                for (int j = 0; j < planthouse.getRows().size(); j++) {
                    for (int k = 0; k < planthouse.getRows().get(j).getSections().size(); k++) {
                        String section = Integer.toString(planthouse.getRows().get(j).getSections().get(k).getNumber());

                        if (element.getAttribute("sectionnumber").equals(section) && element.getAttribute("row").equals(planthouse.getRows().get(j).getId())) {
                            Fleischtomatos stabtomatos = new Fleischtomatos("A", "A", 1, true, false, false, 0);
                            planthouse.getRows().get(j).getSections().get(k).getPlants().add(stabtomatos);
                            stabtomatos.setId(element.getAttribute("id"));
                            stabtomatos.setRow(element.getAttribute("row"));
                            stabtomatos.setSectionnumber(k + 1);
                            if (element.getAttribute("Ready_for_Harvest").equals("false")) {
                                stabtomatos.setReadyForHarvest(false);
                            } else if (element.getAttribute("Ready_for_Harvest").equals("true")) {
                                stabtomatos.setReadyForHarvest(true);
                            }
                            if (element.getAttribute("Today_watered").equals("true")) {
                                stabtomatos.setTodayWatered(true);
                            } else if (element.getAttribute("Today_watered").equals("false")) {
                                stabtomatos.setTodayWatered(false);
                            }
                            Double harvest = Double.valueOf(element.getAttribute("Harvest"));
                            stabtomatos.setHarvest(harvest);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();


        }

        try {
            File inputFile = new File("planthouse.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
            Document doc = dbBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("PlantCocktailtomato");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                for (int j = 0; j < planthouse.getRows().size(); j++) {
                    for (int k = 0; k < planthouse.getRows().get(j).getSections().size(); k++) {
                        String section = Integer.toString(planthouse.getRows().get(j).getSections().get(k).getNumber());

                        if (element.getAttribute("sectionnumber").equals(section) && element.getAttribute("row").equals(planthouse.getRows().get(j).getId())) {
                            Cocktailtomatos stabtomatos = new Cocktailtomatos("A", "A", 1, true, false, false, 0);
                            planthouse.getRows().get(j).getSections().get(k).getPlants().add(stabtomatos);
                            stabtomatos.setId(element.getAttribute("id"));
                            stabtomatos.setRow(element.getAttribute("row"));
                            stabtomatos.setSectionnumber(k + 1);
                            if (element.getAttribute("Ready_for_Harvest").equals("false")) {
                                stabtomatos.setReadyForHarvest(false);
                            } else if (element.getAttribute("Ready_for_Harvest").equals("true")) {
                                stabtomatos.setReadyForHarvest(true);
                            }
                            if (element.getAttribute("Today_watered").equals("true")) {
                                stabtomatos.setTodayWatered(true);
                            } else if (element.getAttribute("Today_watered").equals("false")) {
                                stabtomatos.setTodayWatered(false);
                            }
                            Double harvest = Double.valueOf(element.getAttribute("Harvest"));
                            stabtomatos.setHarvest(harvest);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();


        }

    }



    public void deleteData() {
        try {
           PrintWriter writer = new PrintWriter("planthouse.xml");
           writer.print("");
           writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}