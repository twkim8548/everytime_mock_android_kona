package com.softsquared.template.src.main.home.models;

import com.google.gson.annotations.SerializedName;

public class ReviewInfo {
    public int getClassCommentIdx() {
        return classCommentIdx;
    }

    public String getClassName() {
        return className;
    }

    public String getProfessor() {
        return professor;
    }

    public String getClassCommentInf() {
        return classCommentInf;
    }

    public int getClassStar() {
        return classStar;
    }

    @SerializedName("classCommentIdx")
    private int classCommentIdx;

    @SerializedName("className")
    private String className;

    @SerializedName("professor")
    private String professor;

    @SerializedName("classCommentInf")
    private String classCommentInf;

    @SerializedName("classStar")
    private int classStar;
}
