package com.softsquared.template.src.login.signup.models;

import com.google.gson.annotations.SerializedName;
import com.softsquared.template.src.login.models.LoginJwt;

import java.util.ArrayList;

public class SignupResponse {

    @SerializedName("result")
    private SignupJwt result;

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
