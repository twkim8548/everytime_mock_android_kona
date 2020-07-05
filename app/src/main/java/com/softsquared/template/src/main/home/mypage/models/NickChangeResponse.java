package com.softsquared.template.src.main.home.mypage.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NickChangeResponse {
    public NickChangeInfo getResult() {
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
    private NickChangeInfo result;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;
}
