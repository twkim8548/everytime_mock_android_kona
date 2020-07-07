package com.softsquared.template.src.main.timetable.models;

import com.google.gson.annotations.SerializedName;

public class TimetableTimeInfo {
    public String getClassTime() {
        return classTime;
    }

    @SerializedName("classTime")
    private String classTime;
}
