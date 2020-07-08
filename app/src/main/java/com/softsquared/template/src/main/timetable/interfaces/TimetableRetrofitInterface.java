package com.softsquared.template.src.main.timetable.interfaces;

import com.softsquared.template.src.login.models.LoginBody;
import com.softsquared.template.src.login.models.LoginResponse;
import com.softsquared.template.src.main.timetable.models.AddTimetableBody;
import com.softsquared.template.src.main.timetable.models.AddTimetableResponse;
import com.softsquared.template.src.main.timetable.models.MyTimetableListResponse;
import com.softsquared.template.src.main.timetable.models.MyTimetableResponse;
import com.softsquared.template.src.main.timetable.models.TimetableResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TimetableRetrofitInterface {

    @GET("/class")
    @Headers("Content-Type: application/json")
    Call<TimetableResponse> getTimetable();

    @GET("/time-table/{timeTableIdx}")
    @Headers("Content-Type: application/json")
    Call<MyTimetableResponse> getMyTimetable(
            @Path("timeTableIdx") int timeTableIdx
    );

    @POST("/time-table/{timeTableIdx}/class")
    @Headers("Content-Type: application/json")
    Call<AddTimetableResponse> postAddTimetable(
            @Path("timeTableIdx") int timeTableIdx,
            @Body AddTimetableBody addTimetableBody);

    @GET("/time-table")
    @Headers("Content-Type: application/json")
    Call<MyTimetableListResponse> getMyTimetableList();
}
