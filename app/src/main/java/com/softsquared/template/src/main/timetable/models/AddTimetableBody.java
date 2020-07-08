package com.softsquared.template.src.main.timetable.models;

import com.google.gson.annotations.SerializedName;

public class AddTimetableBody {



    @SerializedName("classIdx")
    private int classIdx;

    public AddTimetableBody(int classIdx) {
        this.classIdx = classIdx;
    }
}
