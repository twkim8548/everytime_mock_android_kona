package com.softsquared.template.src.main.notice.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class NoticeInfo {


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

    public String getContentThumbnailURL() {
        return contentThumbnailURL;
    }

    public Date getWriteDay() {
        return writeDay;
    }

    public int getCountLike() {
        return countLike;
    }

    public int getCountComment() {
        return countComment;
    }

    public int getCountImage() {
        return countImage;
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

    @SerializedName("contentThumbnailURL")
    private String contentThumbnailURL;

    @SerializedName("writeDay")
    private Date writeDay;

    @SerializedName("countLike")
    private int countLike;

    @SerializedName("countComment")
    private int countComment;

    @SerializedName("countImage")
    private int countImage;
}
