package com.softsquared.template.src.main.community.models;

import com.google.gson.annotations.SerializedName;

public class PinResponse {
    public PinInfo getResult() {
        return result;
    }

    @SerializedName("result")
    private PinInfo result;

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
