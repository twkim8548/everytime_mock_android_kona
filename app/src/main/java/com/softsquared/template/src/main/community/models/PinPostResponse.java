package com.softsquared.template.src.main.community.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PinPostResponse {


    public PinPostResult getResult() {
        return result;
    }

    @SerializedName("result")
    private PinPostResult result;

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
