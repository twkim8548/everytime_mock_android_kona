package com.softsquared.template.src.main.timetable.models;

import com.google.gson.annotations.SerializedName;

public class AddTimetableInfo {
    @SerializedName("classIdx")
    private int classIdx;

    public int getClassIdx() {
        return classIdx;
    }
}
