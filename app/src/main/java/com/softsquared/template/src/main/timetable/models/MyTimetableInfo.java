package com.softsquared.template.src.main.timetable.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MyTimetableInfo {




    @SerializedName("classIdx")
    private int classIdx;

    @SerializedName("className")
    private String className;

    @SerializedName("classRoom")
    private String classRoom;

    @SerializedName("classDay")
    private String classDay;

    @SerializedName("classTime")
    private int classTime;

    public int getClassIdx() {
        return classIdx;
    }

    public String getClassName() {
        return className;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public String getClassDay() {
        return classDay;
    }

    public int getClassTime() {
        return classTime;
    }
}
