package com.softsquared.template.src.main.classReview.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ClassReviewResponse {


    public boolean getIsSuccess() {
        return isSuccess;
    }

    public ArrayList<ClassReviewInfo> getResult() {
        return result;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @SerializedName("result")
    private ArrayList<ClassReviewInfo> result;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;
}
