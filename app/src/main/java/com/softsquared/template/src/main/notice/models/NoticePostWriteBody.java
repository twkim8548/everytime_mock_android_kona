package com.softsquared.template.src.main.notice.models;

import com.google.gson.annotations.SerializedName;

public class NoticePostWriteBody {

    public NoticePostWriteBody(String contentTitle, String contentInf, int userStatus) {
        this.contentTitle = contentTitle;
        this.contentInf = contentInf;
        this.userStatus = userStatus;
    }

    @SerializedName("contentTitle")
    private String contentTitle;

    @SerializedName("contentInf")
    private String contentInf;

    @SerializedName("userStatus")
    private int userStatus;
}
