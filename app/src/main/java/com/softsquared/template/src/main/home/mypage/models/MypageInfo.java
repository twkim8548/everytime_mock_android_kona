package com.softsquared.template.src.main.home.mypage.models;

import com.google.gson.annotations.SerializedName;

public class MypageInfo {
    public String getUserNickname() {
        return userNickname;
    }

    public String getUserID() {
        return userID;
    }

    public String getUnivName() {
        return univName;
    }

    public String getUnivYear() {
        return univYear;
    }

    @SerializedName("userNickname")
    private String userNickname;

    @SerializedName("userID")
    private String userID;

    @SerializedName("univName")
    private String univName;

    @SerializedName("univYear")
    private String univYear;



}
