package com.softsquared.template.src.login.signup.models;

import com.google.gson.annotations.SerializedName;

public class SignupInfo {
    public String getUserID() {
        return userID;
    }

    public String getPw() {
        return pw;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getUnivName() {
        return univName;
    }

    public String getUnivYear() {
        return univYear;
    }

    public String getEmail() {
        return email;
    }

    @SerializedName("userID")
    private String userID;

    @SerializedName("pw")
    private String pw;

    @SerializedName("userNickname")
    private String userNickname;

    @SerializedName("phoneNum")
    private String phoneNum;

    @SerializedName("univName")
    private String univName;

    @SerializedName("univYear")
    private String univYear;

    @SerializedName("email")
    private String email;
}
