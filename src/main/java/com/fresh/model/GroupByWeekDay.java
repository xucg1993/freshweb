package com.fresh.model;

import java.util.ArrayList;

public class GroupByWeekDay {
    private String weekDay;
    private ArrayList<PageData> courseList;

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public ArrayList<PageData> getCourseList() {
        return courseList;
    }

    public void setCourseList(ArrayList<PageData> courseList) {
        this.courseList = courseList;
    }
}
