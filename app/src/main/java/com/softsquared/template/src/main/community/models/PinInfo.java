package com.softsquared.template.src.main.community.models;

import com.google.gson.annotations.SerializedName;


import java.util.Comparator;

public class PinInfo  {

    public PinInfo(int noticeIdx, String noticeName) {
        this.noticeIdx = noticeIdx;
        this.noticeName = noticeName;
    }

    public int getNoticeIdx() {
        return noticeIdx;
    }

    public String getNoticeName() {
        return noticeName;
    }

    @SerializedName("noticeIdx")
    private int noticeIdx;

    @SerializedName("noticeName")
    private String noticeName;

    public String getCheckNew() {
        return checkNew;
    }

    @SerializedName("checkNew")
    private String checkNew;

}
