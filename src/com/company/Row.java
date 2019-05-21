package com.company;

import java.util.ArrayList;


public class Row {
    private String id;
    private ArrayList<Section> sections;

    public Row(String id) {
        this.id = id;
        this.initSections();

    }

    public Row(String id, ArrayList<Section> sections) {
        this.id = id;
        this.setSections(sections);

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Section> getSections() {
        return sections;
    }

    public void setSections(ArrayList<Section> sections) {
        this.sections = sections;
    }


    public void initSections() {
        this.sections = new ArrayList<>();
            for (int i = 1; i <=25; i++) {
               this.sections.add(new Section(i));


            }

       }

        public void printSections() {
            for (Section section : sections) {
                System.out.println(section.getNumber());
            }
        }
        public Row(){

        }

    @Override
    public String toString() {
        return "\n Row" +
                "'" + id + '\'' + "\n" +
                  sections;
    }

    public Section getSection(int sectionnumber){

        //Section section = new Section(sectionnumber);
        Section section = sections.get(sectionnumber-1);

        return section;

    }
}









