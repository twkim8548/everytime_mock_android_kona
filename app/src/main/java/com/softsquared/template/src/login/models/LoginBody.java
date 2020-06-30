package com.softsquared.template.src.login.models;

import com.google.gson.annotations.SerializedName;

public class LoginBody {
    @SerializedName("userID")
    private String userID;

    @SerializedName("pw")
    private String pw;

    public LoginBody(String userID, String pw)
    {
        this.userID = userID;
        this.pw = pw;
    }
}
