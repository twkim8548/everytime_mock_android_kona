package com.softsquared.template.src.main.notice.interfaces;

import com.softsquared.template.src.main.home.models.FavoriteCommunityResponse;
import com.softsquared.template.src.main.home.models.HotContentResponse;
import com.softsquared.template.src.main.home.models.RealtimeResponse;
import com.softsquared.template.src.main.notice.models.NoticeResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NoticeRetrofitInterface {
    @GET("/notice/{noticeIdx}/contents")
    @Headers("Content-Type: application/json")
    Call<NoticeResponse> getNotice(
            @Path("noticeIdx") int noticeidx
    );


}
