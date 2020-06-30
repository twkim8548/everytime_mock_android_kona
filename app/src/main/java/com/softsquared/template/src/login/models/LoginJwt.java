package com.softsquared.template.src.login.models;

import com.google.gson.annotations.SerializedName;

public class LoginJwt {

    @SerializedName("jwt")
    private String jwt;

    public String getJwt()
    {
        return jwt;
    }
}
