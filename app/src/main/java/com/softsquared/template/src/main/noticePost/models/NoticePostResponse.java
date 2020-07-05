package com.softsquared.template.src.main.noticePost.models;

import com.google.gson.annotations.SerializedName;
import com.softsquared.template.src.main.notice.models.NoticeInfo;

import java.util.ArrayList;

public class NoticePostResponse {
    public NoticePostInfo getResult() {
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
    private NoticePostInfo result;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;
}
