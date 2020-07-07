package com.softsquared.template.src.main.community.entire.models;

import com.google.gson.annotations.SerializedName;
import com.softsquared.template.src.main.community.models.PinInfo;

import java.util.ArrayList;

public class ClassCommentResponse {
    public ArrayList<ClassCommentInfo> getResult() {
        return result;
    }

    @SerializedName("result")
    private ArrayList<ClassCommentInfo> result;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }
}
