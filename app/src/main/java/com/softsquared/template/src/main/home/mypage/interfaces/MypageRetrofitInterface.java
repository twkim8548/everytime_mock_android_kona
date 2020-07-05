package com.softsquared.template.src.main.home.mypage.interfaces;

import com.softsquared.template.src.main.home.models.FavoriteCommunityResponse;
import com.softsquared.template.src.main.home.mypage.models.MypageResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

public interface MypageRetrofitInterface {
    @GET("/user")
    @Headers("Content-Type: application/json")
    Call<MypageResponse> getMypage(
    );

}
