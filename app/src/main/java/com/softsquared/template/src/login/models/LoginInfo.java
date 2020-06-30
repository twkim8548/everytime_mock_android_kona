package com.softsquared.template.src.login.models;

import com.google.gson.annotations.SerializedName;

public class LoginInfo {
    public String getLogin_userID() {
        return login_userID;
    }

    public String getLogin_nickname() {
        return login_nickname;
    }

    public String getLogin_univ() {
        return login_univ;
    }

    @SerializedName("유저ID")
    private String login_userID;

    @SerializedName("닉네임")
    private String login_nickname;

    @SerializedName("대학교")
    private String login_univ;
}
