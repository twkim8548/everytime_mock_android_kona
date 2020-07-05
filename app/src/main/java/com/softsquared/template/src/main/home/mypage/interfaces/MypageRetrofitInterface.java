package com.softsquared.template.src.main.home.mypage.interfaces;

import com.softsquared.template.src.login.signup.models.SignupBody;
import com.softsquared.template.src.main.home.models.FavoriteCommunityResponse;
import com.softsquared.template.src.main.home.mypage.models.MypageResponse;
import com.softsquared.template.src.main.home.mypage.models.NickChangeBody;
import com.softsquared.template.src.main.home.mypage.models.NickChangeResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;

public interface MypageRetrofitInterface {
    @GET("/user")
    @Headers("Content-Type: application/json")
    Call<MypageResponse> getMypage(
    );

    @PATCH("/user")
    @Headers("Content-Type: application/json")
    Call<NickChangeResponse> patchNickChange(
            @Body NickChangeBody nickChangeBody
    );

}
