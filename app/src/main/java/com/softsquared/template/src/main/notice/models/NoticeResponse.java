package com.softsquared.template.src.main.notice.models;

import com.google.gson.annotations.SerializedName;
import com.softsquared.template.src.main.home.models.RealtimeInfo;

import java.util.ArrayList;

public class NoticeResponse {
    public ArrayList<NoticeInfo> getResult() {
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
    private ArrayList<NoticeInfo> result;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;
}
