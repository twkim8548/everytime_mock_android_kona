package com.softsquared.template.src.main.classReview.models;

import com.google.gson.annotations.SerializedName;

public class ClassReviewCommentInfo {


    @SerializedName("classCommentIdx")
    private int classCommentIdx;

    @SerializedName("classCommentInf")
    private String classCommentInf;

    @SerializedName("classStudent")
    private String classStudent;

    @SerializedName("classStar")
    private int classStar;

    @SerializedName("classCommentLike")
    private int classCommentLike;

    public int getClassCommentIdx() {
        return classCommentIdx;
    }

    public String getClassCommentInf() {
        return classCommentInf;
    }

    public String getClassStudent() {
        return classStudent;
    }

    public int getClassStar() {
        return classStar;
    }

    public int getClassCommentLike() {
        return classCommentLike;
    }
}
