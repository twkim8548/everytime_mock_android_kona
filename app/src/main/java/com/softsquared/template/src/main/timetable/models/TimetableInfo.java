package com.softsquared.template.src.main.timetable.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TimetableInfo {
    public int getClassIdx() {
        return classIdx;
    }

    public String getClassName() {
        return className;
    }

    public String getClassGrade() {
        return classGrade;
    }

    public String getClassType() {
        return classType;
    }

    public String getClassPoint() {
        return classPoint;
    }

    public int getClassPeople() {
        return classPeople;
    }

    public int getClassCode() {
        return classCode;
    }

    public String getProfessor() {
        return professor;
    }

    public int getClassStar() {
        return classStar;
    }

    public int getTimeTablePeople() {
        return timeTablePeople;
    }

    public ArrayList<TimetableTimeInfo> getTime() {
        return time;
    }

    @SerializedName("classIdx")
    private int classIdx;

    @SerializedName("className")
    private String className;

    @SerializedName("classGrade")
    private String classGrade;

    @SerializedName("classType")
    private String classType;

    @SerializedName("classPoint")
    private String classPoint;

    @SerializedName("classPeople")
    private int classPeople;

    @SerializedName("countCode")
    private int classCode;

    @SerializedName("professor")
    private String professor;

    @SerializedName("classStar")
    private int classStar;

    @SerializedName("timeTablePeople")
    private int timeTablePeople;

    @SerializedName("time")
    private ArrayList<TimetableTimeInfo> time;
}
