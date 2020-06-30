package com.softsquared.template.src.main.home.interfaces;

import com.softsquared.template.src.login.models.LoginBody;
import com.softsquared.template.src.login.models.LoginResponse;
import com.softsquared.template.src.main.home.models.FavoriteCommunityInfo;
import com.softsquared.template.src.main.home.models.FavoriteCommunityResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface HomeActivityView {

    void onSuccessGetFavoriteCommunity(FavoriteCommunityResponse favoriteCommunityResponse);

    void onFailureGetFavoriteCommunity();


}
