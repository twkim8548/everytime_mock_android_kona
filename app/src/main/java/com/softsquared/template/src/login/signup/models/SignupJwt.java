package com.softsquared.template.src.login.signup.models;

import com.google.gson.annotations.SerializedName;

public class SignupJwt {

    public String getJwt() {
        return jwt;
    }

    @SerializedName("jwt")
    private String jwt;
}
