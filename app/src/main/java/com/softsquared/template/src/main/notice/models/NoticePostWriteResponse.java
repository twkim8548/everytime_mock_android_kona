package com.softsquared.template.src.main.notice.models;

import com.google.gson.annotations.SerializedName;

public class NoticePostWriteResponse {
    public NoticePostWriteInfo getResult() {
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
    private NoticePostWriteInfo result;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;
}
