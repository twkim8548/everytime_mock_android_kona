package com.softsquared.template.src.main.timetable.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MyTimetableResponse {
    public ArrayList<MyTimetableInfo> getResult() {
        return result;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    @SerializedName("result")
    private ArrayList<MyTimetableInfo> result;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;
}
