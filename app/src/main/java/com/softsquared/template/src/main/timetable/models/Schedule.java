package com.softsquared.template.src.main.timetable.models;

public class Schedule {
    private String className;
    private int classTime;

    public String getClassName() {
        return className;
    }

    public int getClassTime() {
        return classTime;
    }

    public Schedule(String className, int classTime) {
        this.className = className;
        this.classTime = classTime;
    }
}
