package com.softsquared.template.src.main.classReview.interfaces;

import com.softsquared.template.src.main.classReview.models.AboutClassResponse;
import com.softsquared.template.src.main.classReview.models.ClassReviewCommentResponse;
import com.softsquared.template.src.main.classReview.models.ClassReviewResponse;
import com.softsquared.template.src.main.community.entire.models.ClassCommentResponse;
import com.softsquared.template.src.main.community.entire.models.MyClassResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface ClassEvalRetorfitInterface {

    @GET("/class/{classIdx}")
    @Headers("Content-Type: application/json")
    Call<AboutClassResponse> getAboutClass(
            @Path("classIdx") int classIdx
    );

    @GET("/class/{classIdx}/class-comment")
    @Headers("Content-Type: application/json")
    Call<ClassReviewResponse> getClassReviewResponse(
            @Path("classIdx") int classIdx
    );

    @GET("/class/{classIdx}/class-comments")
    @Headers("Content-Type: application/json")
    Call<ClassReviewCommentResponse> getClassReviewCommentResponse(
            @Path("classIdx") int classIdx
    );




}
