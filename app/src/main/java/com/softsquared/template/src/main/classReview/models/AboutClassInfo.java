package com.softsquared.template.src.main.classReview.models;

import com.google.gson.annotations.SerializedName;
import com.softsquared.template.src.main.timetable.models.TimetableTimeInfo;

import java.util.ArrayList;

public class AboutClassInfo {


    @SerializedName("classIdx")
    private int classIdx;

    @SerializedName("className")
    private String className;

    @SerializedName("classSemester")
    private String classSemester;

    @SerializedName("countCode")
    private int classCode;

    @SerializedName("professor")
    private String professor;

    @SerializedName("classGrade")
    private String classGrade;

    @SerializedName("classType")
    private String classType;

    @SerializedName("classPoint")
    private int classPoint;

    @SerializedName("classPeople")
    private int classPeople;

    @SerializedName("timeTablePeople")
    private int timeTablePeople;

    @SerializedName("major")
    private String major;

    @SerializedName("time")
    private ArrayList<TimetableTimeInfo> time;

    public int getClassIdx() {
        return classIdx;
    }

    public String getClassName() {
        return className;
    }

    public String getClassSemester() {
        return classSemester;
    }

    public int getClassCode() {
        return classCode;
    }

    public String getProfessor() {
        return professor;
    }

    public String getClassGrade() {
        return classGrade;
    }

    public String getClassType() {
        return classType;
    }

    public int getClassPoint() {
        return classPoint;
    }

    public int getClassPeople() {
        return classPeople;
    }

    public int getTimeTablePeople() {
        return timeTablePeople;
    }

    public String getMajor() {
        return major;
    }

    public ArrayList<TimetableTimeInfo> getTime() {
        return time;
    }

}
