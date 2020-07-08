package com.softsquared.template.src.main.classReview.models;

import com.google.gson.annotations.SerializedName;
import com.softsquared.template.src.main.timetable.models.TimetableInfo;
import com.softsquared.template.src.main.timetable.models.TimetableTimeInfo;

import java.util.ArrayList;

public class AboutClassResponse {


    public boolean getIsSuccess() {
        return isSuccess;
    }

    public ArrayList<AboutClassInfo> getResult() {
        return result;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @SerializedName("result")
    private ArrayList<AboutClassInfo> result;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;
}
