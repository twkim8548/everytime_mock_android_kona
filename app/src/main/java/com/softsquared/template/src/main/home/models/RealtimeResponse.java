package com.softsquared.template.src.main.home.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RealtimeResponse {
    public ArrayList<RealtimeInfo> getResult() {
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
    private ArrayList<RealtimeInfo> result;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;
}
