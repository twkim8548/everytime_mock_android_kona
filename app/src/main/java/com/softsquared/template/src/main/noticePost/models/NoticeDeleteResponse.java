package com.softsquared.template.src.main.noticePost.models;

import com.google.gson.annotations.SerializedName;

public class NoticeDeleteResponse {
    public NoticeDeleteInfo getResult() {
        return result;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    @SerializedName("result")
    private NoticeDeleteInfo result;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;
}
