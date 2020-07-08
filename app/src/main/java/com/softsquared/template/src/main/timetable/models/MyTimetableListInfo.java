package com.softsquared.template.src.main.timetable.models;

import com.google.gson.annotations.SerializedName;

public class MyTimetableListInfo {




    @SerializedName("timeTableIdx")
    private int timeTableIdx;

    @SerializedName("timeTableYear")
    private String timeTableYear;

    @SerializedName("timeTableName")
    private String timeTableName;

    public int getTimeTableIdx() {
        return timeTableIdx;
    }

    public String getTimeTableYear() {
        return timeTableYear;
    }

    public String getTimeTableName() {
        return timeTableName;
    }
}
