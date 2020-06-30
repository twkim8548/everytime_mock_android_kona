package com.softsquared.template.src.main.home.models;

import com.google.gson.annotations.SerializedName;

public class FavoriteCommunityInfo {


    public String getFav_commu_name() {
        return fav_commu_name;
    }

    public String getFav_commu_article() {
        return fav_commu_article;
    }

    public String getFav_commu_recent() {
        return fav_commu_recent;
    }

    @SerializedName("게시판 이름")
    private String fav_commu_name;

    @SerializedName("글제목")
    private String fav_commu_article;

    @SerializedName("최신여부")
    private String fav_commu_recent;
}
