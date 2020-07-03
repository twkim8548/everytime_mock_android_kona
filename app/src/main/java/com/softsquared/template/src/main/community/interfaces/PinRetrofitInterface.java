package com.softsquared.template.src.main.community.interfaces;

import com.softsquared.template.src.main.community.models.PinResponse;
import com.softsquared.template.src.main.home.models.FavoriteCommunityResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

public interface PinRetrofitInterface {

    @GET("/notice-list")
    @Headers("Content-Type: application/json")
    Call<PinResponse> getPinCommunity(
            @Header("x-access-token") String accessToken);
}
