package com.softsquared.template.src.login.signup.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SignupResponse {
    @SerializedName("result")
    private ArrayList<SignupInfo> result;
}
