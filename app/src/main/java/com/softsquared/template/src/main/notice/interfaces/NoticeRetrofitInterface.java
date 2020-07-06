package com.softsquared.template.src.main.notice.interfaces;

import com.softsquared.template.src.main.notice.models.NoticeResponse;
import com.softsquared.template.src.main.noticePost.models.NoticeDeleteResponse;
import com.softsquared.template.src.main.notice.models.NoticePostWriteBody;
import com.softsquared.template.src.main.notice.models.NoticePostWriteResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface NoticeRetrofitInterface {
    @GET("/notice/{noticeIdx}/contents")
    @Headers("Content-Type: application/json")
    Call<NoticeResponse> getNotice(
            @Path("noticeIdx") int noticeidx
    );

    @POST("/notice/{noticeIdx}/content")
    @Headers("Content-Type: application/json")
    Call<NoticePostWriteResponse> postNoticeWrite(
            @Body NoticePostWriteBody noticePostWriteBody,
            @Path("noticeIdx") int noticeIdx);


}
