package com.softsquared.template.src.main.home.mypage.models;

import com.google.gson.annotations.SerializedName;
import com.softsquared.template.src.main.home.models.FavoriteCommunityInfo;

import java.util.ArrayList;

public class MypageResponse {

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public MypageInfo getResult() {
        return result;
    }

    @SerializedName("result")
    private MypageInfo result;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;


}
