package com.softsquared.template.src.main.home.models;

import com.google.gson.annotations.SerializedName;

public class FavoriteCommunityInfo {


    public String getNoticeName() {
        return noticeName;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public String getCheckNew() {
        return checkNew;
    }

    @SerializedName("noticeName")
    private String noticeName;

    @SerializedName("contentTitle")
    private String contentTitle;

    @SerializedName("checkNew")
    private String checkNew;
}
