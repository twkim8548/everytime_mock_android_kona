package com.softsquared.template.src.main.community.entire.models;

import com.google.gson.annotations.SerializedName;

public class ClassCommentInfo {



    @SerializedName("classCommentIdx")
    private int classCommentIdx;

    @SerializedName("className")
    private String className;

    @SerializedName("professor")
    private String professor;

    @SerializedName("classCommentInf")
    private String classCommentInf;

    @SerializedName("classStudent")
    private String classStudent;

    @SerializedName("classStart")
    private double classStart;

    @SerializedName("classCommentLike")
    private int classCommentLike;

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

    public String getClassStudent() {
        return classStudent;
    }

    public double getClassStart() {
        return classStart;
    }

    public int getClassCommentLike() {
        return classCommentLike;
    }
}
