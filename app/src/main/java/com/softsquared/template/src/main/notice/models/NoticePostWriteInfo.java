package com.softsquared.template.src.main.notice.models;

import com.google.gson.annotations.SerializedName;

public class NoticePostWriteInfo {

    public int getNoticeIdx() {
        return noticeIdx;
    }

    public String getNoticeName() {
        return noticeName;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public String getContentInf() {
        return contentInf;
    }

    public int getUserStatus() {
        return userStatus;
    }

    @SerializedName("noticeIdx")
    private int noticeIdx;

    @SerializedName("noticeName")
    private String noticeName;

    @SerializedName("contentTitle")
    private String contentTitle;

    @SerializedName("contentInf")
    private String contentInf;

    @SerializedName("userStatus")
    private int userStatus;



//    @SerializedName("contentImageURLList")
//    private arrayList
}
