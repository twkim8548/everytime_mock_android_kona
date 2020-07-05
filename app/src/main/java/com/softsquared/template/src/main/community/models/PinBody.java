package com.softsquared.template.src.main.community.models;

import com.google.gson.annotations.SerializedName;

public class PinBody {
    public PinBody(int noticeIdx) {
        this.noticeIdx = noticeIdx;
    }

    public int getNoticeIdx() {
        return noticeIdx;
    }

    @SerializedName("noticeIdx")
    private int noticeIdx;
}
