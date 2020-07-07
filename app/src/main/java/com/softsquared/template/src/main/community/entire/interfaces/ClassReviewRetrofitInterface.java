package com.softsquared.template.src.main.community.entire.interfaces;

import com.softsquared.template.src.main.community.entire.models.ClassCommentResponse;
import com.softsquared.template.src.main.community.entire.models.MyClassResponse;
import com.softsquared.template.src.main.community.models.PinBody;
import com.softsquared.template.src.main.community.models.PinPostResponse;
import com.softsquared.template.src.main.community.models.PinResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ClassReviewRetrofitInterface {

    @GET("/my-class")
    @Headers("Content-Type: application/json")
    Call<MyClassResponse> getMyClass();

    @GET("/class-comment")
    @Headers("Content-Type: application/json")
    Call<ClassCommentResponse> getClassComment();


}
