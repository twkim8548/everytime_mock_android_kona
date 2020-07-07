package com.softsquared.template.src.main.community.entire.models;

import com.google.gson.annotations.SerializedName;

public class MyClassInfo {



    @SerializedName("classIdx")
    private int classIdx;

    @SerializedName("className")
    private String className;


    @SerializedName("professor")
    private String professor;

    public int getClassIdx() {
        return classIdx;
    }

    public String getClassName() {
        return className;
    }

    public String getProfessor() {
        return professor;
    }


}
