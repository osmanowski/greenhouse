package com.company;

import java.util.ArrayList;
import java.util.List;

public class Planthouse {
    private ArrayList<Row> rows = new ArrayList<>();

    public Planthouse(){
        this.initRows();

    }

    public Planthouse(ArrayList<Row> rows) {
        this.setRows(rows);
    }

    public ArrayList<Row> getRows() {
        return rows;
    }

    private void initRows() {
        this.rows= new ArrayList<>();
        this.rows.add(new Row("A"));
        this.rows.add(new Row("B"));
        this.rows.add(new Row("C"));
        this.rows.add(new Row("D"));
        this.rows.add(new Row("E"));
        this.rows.add(new Row("F"));




    }

    public void setRows(ArrayList<Row> rows) {
        this.rows = rows;
    }

    public void printPlanthouse(){
        for(Row row: rows) {
            System.out.println(row.getId());
            row.printSections();
        }

    }


    public Row getRow(String rowId) {
        for(Row row: rows) {
            if(row.getId().equals(rowId)) {
                return row;
            }
        }

        return null;
    }



        public Section getSection(Row row, Section section) {
        Planthouse planthouse = new Planthouse();
        planthouse.getRow(row.getId()).getSection(section.getNumber());
        return section;
        }
    }

