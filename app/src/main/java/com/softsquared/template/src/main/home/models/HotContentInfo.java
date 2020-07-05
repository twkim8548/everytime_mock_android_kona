package com.softsquared.template.src.main.home.models;

import com.google.gson.annotations.SerializedName;

public class HotContentInfo {

    public String getContentTitle() {
        return contentTitle;
    }

    public String getWriteDay() {
        return writeDay;
    }

    public int getCountLike() {
        return countLike;
    }

    public int getCountComment() {
        return countComment;
    }


    @SerializedName("contentTitle")
    private String contentTitle;

    @SerializedName("writeDay")
    private String writeDay;

    @SerializedName("countLike")
    private int countLike;

    @SerializedName("countComment")
    private int countComment;
}
