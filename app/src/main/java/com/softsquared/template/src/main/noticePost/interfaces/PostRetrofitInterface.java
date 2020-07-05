package com.softsquared.template.src.main.noticePost.interfaces;

import com.softsquared.template.src.main.notice.models.NoticeResponse;
import com.softsquared.template.src.main.noticePost.models.NoticePostResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface PostRetrofitInterface {
    @GET("/notice/content/{contentIdx}")
    @Headers("Content-Type: application/json")
    Call<NoticePostResponse> getNotice(
            @Path("contentIdx") int contentIdx
    );


}
