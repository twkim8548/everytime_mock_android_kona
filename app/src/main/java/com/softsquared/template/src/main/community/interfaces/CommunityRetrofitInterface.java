package com.softsquared.template.src.main.community.interfaces;

import com.softsquared.template.src.login.models.LoginBody;
import com.softsquared.template.src.login.models.LoginResponse;
import com.softsquared.template.src.main.community.models.PinBody;
import com.softsquared.template.src.main.community.models.PinPostResponse;
import com.softsquared.template.src.main.community.models.PinResponse;
import com.softsquared.template.src.main.home.models.FavoriteCommunityResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface CommunityRetrofitInterface {

    @GET("/notice-list")
    @Headers("Content-Type: application/json")
    Call<PinResponse> getPinCommunity();

    @POST("/myNotice")
    @Headers("Content-Type: application/json")
    Call<PinPostResponse> postPin(
            @Body PinBody pinBody);


}
