package com.softsquared.template.src.main.home.models;

import com.google.gson.annotations.SerializedName;

public class RealtimeInfo {



    public int getCountLike() {
        return countLike;
    }

    public int getCountComment() {
        return countComment;
    }

    public String getContentWriter() {
        return contentWriter;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public String getContentInf() {
        return contentInf;
    }

    public String getNoticeName() {
        return noticeName;
    }

    public String getWriteDay() {
        return writeDay;
    }

    @SerializedName("contentWriter")
    private String contentWriter;

    @SerializedName("contentTitle")
    private String contentTitle;

    @SerializedName("contentInf")
    private String contentInf;

    @SerializedName("noticeName")
    private String noticeName;

    @SerializedName("writeDay")
    private String writeDay;

    @SerializedName("countLike")
    private int countLike;

    @SerializedName("countComment")
    private int countComment;
}
