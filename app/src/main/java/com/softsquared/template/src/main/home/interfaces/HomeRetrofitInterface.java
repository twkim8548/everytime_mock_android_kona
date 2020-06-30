package com.softsquared.template.src.main.home.interfaces;

import com.softsquared.template.src.login.models.LoginJwt;
import com.softsquared.template.src.login.models.LoginResponse;
import com.softsquared.template.src.main.home.models.FavoriteCommunityInfo;
import com.softsquared.template.src.main.home.models.FavoriteCommunityResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

public interface HomeRetrofitInterface {
    @GET("/myNotice")
    @Headers("Content-Type: application/json")
    Call<FavoriteCommunityResponse> getFavoriteCommunity(
            @Header("x-access-token") String accessToken);

}
