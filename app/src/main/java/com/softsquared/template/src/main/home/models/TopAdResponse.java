package com.softsquared.template.src.main.home.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TopAdResponse {
    public ArrayList<TopAdInfo> getResult() {
        return result;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @SerializedName("result")
    private ArrayList<TopAdInfo> result;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    public boolean getIsSuccess() {
        return isSuccess;
    }
}
