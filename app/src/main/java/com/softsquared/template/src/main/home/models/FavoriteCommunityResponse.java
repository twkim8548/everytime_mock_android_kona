package com.softsquared.template.src.main.home.models;

import com.google.gson.annotations.SerializedName;
import com.softsquared.template.src.login.models.LoginInfo;
import com.softsquared.template.src.login.models.LoginJwt;

import java.util.ArrayList;

public class FavoriteCommunityResponse {
    public ArrayList<FavoriteCommunityInfo> getResult() {
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
    private ArrayList<FavoriteCommunityInfo> result;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;


}
