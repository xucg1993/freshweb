package com.fresh.model;

import java.util.ArrayList;

public class AppTeachingAssess {
    private String APPUSERID;
    private String TRAININGCLASS_ID;
    private ArrayList<TeacherAssessment> DATA;

    public String getAPPUSERID() {
        return APPUSERID;
    }

    public void setAPPUSERID(String APPUSERID) {
        this.APPUSERID = APPUSERID;
    }

    public String getTRAININGCLASS_ID() {
        return TRAININGCLASS_ID;
    }

    public void setTRAININGCLASS_ID(String TRAININGCLASS_ID) {
        this.TRAININGCLASS_ID = TRAININGCLASS_ID;
    }

    public ArrayList<TeacherAssessment> getDATA() {
        return DATA;
    }

    public void setDATA(ArrayList<TeacherAssessment> DATA) {
        this.DATA = DATA;
    }
}
