package com.softsquared.template.src.main.home.mypage.models;

import com.google.gson.annotations.SerializedName;

public class NickChangeInfo {

    public String getUserNickname() {
        return userNickname;
    }

    public String getUserID() {
        return userID;
    }

    @SerializedName("userNickname")
    private String userNickname;

    @SerializedName("userID")
    private String userID;


}
