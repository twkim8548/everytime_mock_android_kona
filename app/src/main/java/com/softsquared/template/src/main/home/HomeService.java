package com.softsquared.template.src.main.home;

import android.util.Log;

import com.softsquared.template.src.login.interfaces.LoginActivityView;
import com.softsquared.template.src.login.models.LoginResponse;
import com.softsquared.template.src.main.home.interfaces.HomeActivityView;
import com.softsquared.template.src.main.home.interfaces.HomeRetrofitInterface;
import com.softsquared.template.src.main.home.models.FavoriteCommunityResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.template.src.ApplicationClass.TAG;
import static com.softsquared.template.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.softsquared.template.src.ApplicationClass.getRetrofit;

public class HomeService {

    private HomeActivityView homeActivityView;

    HomeService(HomeActivityView homeActivityView)
    {
        this.homeActivityView = homeActivityView;
    }

    void getFavoriteCommunityList()
    {
        final HomeRetrofitInterface homeRetrofitInterface = getRetrofit().create(HomeRetrofitInterface.class);
        homeRetrofitInterface.getFavoriteCommunity(X_ACCESS_TOKEN).enqueue(new Callback<FavoriteCommunityResponse>() {
            @Override
            public void onResponse(Call<FavoriteCommunityResponse> call, Response<FavoriteCommunityResponse> response) {
                FavoriteCommunityResponse favoriteCommunityResponse = response.body();
                if(favoriteCommunityResponse == null)
                {
                    Log.e(TAG, "LoginResponse is null");
                    homeActivityView.onFailureGetFavoriteCommunity();
                }
                else if(!favoriteCommunityResponse.getIsSuccess())
                {
                    Log.e(TAG, "" + favoriteCommunityResponse.getCode());
                    Log.e(TAG, "" + favoriteCommunityResponse.getMessage());
                    homeActivityView.onFailureGetFavoriteCommunity();
                }
                homeActivityView.onSuccessGetFavoriteCommunity(favoriteCommunityResponse);
            }

            @Override
            public void onFailure(Call<FavoriteCommunityResponse> call, Throwable t) {
                Log.e(TAG, "HomeService::getFavoriteCommunityList: " + t);
                homeActivityView.onFailureGetFavoriteCommunity();

            }

        });
    }

}
