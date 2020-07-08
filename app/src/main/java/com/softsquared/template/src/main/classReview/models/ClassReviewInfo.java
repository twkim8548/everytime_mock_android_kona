package com.softsquared.template.src.main.classReview.models;

import com.google.gson.annotations.SerializedName;
import com.softsquared.template.src.main.timetable.models.TimetableTimeInfo;

import java.util.ArrayList;

public class ClassReviewInfo {


    @SerializedName("classStar")
    private int classStar;

    @SerializedName("selectHw")
    private String selectHw;

    @SerializedName("selectTeam")
    private String selectTeam;

    @SerializedName("selectRate")
    private String selectRate;

    @SerializedName("selectAtt")
    private String selectAtt;

    @SerializedName("selectTest")
    private String selectTest;

    public int getClassStar() {
        return classStar;
    }

    public String getSelectHw() {
        return selectHw;
    }

    public String getSelectTeam() {
        return selectTeam;
    }

    public String getSelectRate() {
        return selectRate;
    }

    public String getSelectAtt() {
        return selectAtt;
    }

    public String getSelectTest() {
        return selectTest;
    }
}
