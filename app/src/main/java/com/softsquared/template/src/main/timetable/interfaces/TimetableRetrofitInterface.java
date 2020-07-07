package com.softsquared.template.src.main.timetable.interfaces;

import com.softsquared.template.src.main.timetable.models.TimetableResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface TimetableRetrofitInterface {

    @GET("/class")
    @Headers("Content-Type: application/json")
    Call<TimetableResponse> getTimetable();
}
