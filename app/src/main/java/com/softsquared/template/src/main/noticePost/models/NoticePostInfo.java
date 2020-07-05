package com.softsquared.template.src.main.noticePost.models;

import com.google.gson.annotations.SerializedName;

public class NoticePostInfo {


    public int getContentIdx() {
        return contentIdx;
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

    public int getCountLike() {
        return countLike;
    }

    public int getCountComment() {
        return countComment;
    }

    public int getCountScrab() {
        return countScrab;
    }

    @SerializedName("contentIdx")
    private int contentIdx;

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

    @SerializedName("countScrab")
    private int countScrab;

//    @SerializedName("contentImageURLList")
//    private arrayList
}
