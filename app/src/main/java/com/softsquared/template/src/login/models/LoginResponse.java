package com.softsquared.template.src.login.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class LoginResponse {
    public ArrayList<LoginInfo> getInf() {
        return inf;
    }

    public LoginJwt getResult() {
        return result;
    }

    @SerializedName("inf")
    private ArrayList<LoginInfo> inf;

    @SerializedName("result")
    private LoginJwt result;

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
