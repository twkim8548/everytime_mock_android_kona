package com.softsquared.template.src.main.home.mypage.models;

import com.google.gson.annotations.SerializedName;

public class NickChangeBody {
    public NickChangeBody(String userNickname) {
        this.userNickname = userNickname;
    }

    @SerializedName("userNickname")
    private String userNickname;
}
