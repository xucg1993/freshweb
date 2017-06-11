package com.fresh.model;

import java.util.ArrayList;

public class GroupByPingYing {
    private String FirstLetter;
    private ArrayList<PageData> classmateList;

    public String getFirstLetter() {
        return FirstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        FirstLetter = firstLetter;
    }

    public ArrayList<PageData> getClassmateList() {
        return classmateList;
    }

    public void setClassmateList(ArrayList<PageData> classmateList) {
        this.classmateList = classmateList;
    }
}
