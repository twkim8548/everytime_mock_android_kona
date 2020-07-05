package com.softsquared.template.src.main.community.models;

import com.google.gson.annotations.SerializedName;

public class PinPostResult {

    public int getNoticeIdx() {
        return noticeIdx;
    }

    public String getNoticeName() {
        return noticeName;
    }

    public int getCheckStatus() {
        return checkStatus;
    }

    @SerializedName("noticeIdx")
    private int noticeIdx;

    @SerializedName("noticeName")
    private String noticeName;

    @SerializedName("checkStatus")
    private int checkStatus;
}
