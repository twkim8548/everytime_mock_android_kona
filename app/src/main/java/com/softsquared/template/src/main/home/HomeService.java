package com.softsquared.template.src.main.home;

import android.util.Log;

import com.softsquared.template.src.login.interfaces.LoginActivityView;
import com.softsquared.template.src.login.models.LoginResponse;
import com.softsquared.template.src.main.home.interfaces.HomeActivityView;
import com.softsquared.template.src.main.home.interfaces.HomeRetrofitInterface;
import com.softsquared.template.src.main.home.models.FavoriteCommunityResponse;
import com.softsquared.template.src.main.home.models.HotContentResponse;
import com.softsquared.template.src.main.home.models.RealtimeResponse;

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
        homeRetrofitInterface.getFavoriteCommunity().enqueue(new Callback<FavoriteCommunityResponse>() {
            @Override
            public void onResponse(Call<FavoriteCommunityResponse> call, Response<FavoriteCommunityResponse> response) {
                FavoriteCommunityResponse favoriteCommunityResponse = response.body();
                Log.e("확인", "확인용");

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
                Log.e("즐겨찾기 게시판 GET", "Favorite community Get Success!!!!!");
                Log.e("코드", "" + favoriteCommunityResponse.getCode());
                Log.e("메시지", "" + favoriteCommunityResponse.getMessage());
                homeActivityView.onSuccessGetFavoriteCommunity(favoriteCommunityResponse);

            }

            @Override
            public void onFailure(Call<FavoriteCommunityResponse> call, Throwable t) {
                Log.e(TAG, "HomeService::getFavoriteCommunityList: " + t);
                homeActivityView.onFailureGetFavoriteCommunity();

            }

        });
    }

    void getHotContent()
    {
        HomeRetrofitInterface homeRetrofitInterface = getRetrofit().create(HomeRetrofitInterface.class);
        homeRetrofitInterface.getHotContent().enqueue(new Callback<HotContentResponse>() {
            @Override
            public void onResponse(Call<HotContentResponse> call, Response<HotContentResponse> response) {
                HotContentResponse hotContentResponse = response.body();
                if(hotContentResponse == null)
                {
                    Log.e(TAG, "LoginResponse is null");
                    homeActivityView.onFailureGetHotContent();
                }
                else if(!hotContentResponse.getIsSuccess())
                {
                    Log.e(TAG, "" + hotContentResponse.getCode());
                    Log.e(TAG, "" + hotContentResponse.getMessage());
                    homeActivityView.onFailureGetHotContent();
                }
                Log.e("HOT게시물 GET", "Hot Content Get Success!!!!!");
                Log.e("코드", "" + hotContentResponse.getCode());
                Log.e("메시지", "" + hotContentResponse.getMessage());
                homeActivityView.onSuccessGetHotContent(hotContentResponse);
            }

            @Override
            public void onFailure(Call<HotContentResponse> call, Throwable t) {

            }
        });
    }

    void getRealtime()
    {
        HomeRetrofitInterface homeRetrofitInterface = getRetrofit().create(HomeRetrofitInterface.class);
        homeRetrofitInterface.getPopularContent().enqueue(new Callback<RealtimeResponse>() {
            @Override
            public void onResponse(Call<RealtimeResponse> call, Response<RealtimeResponse> response) {
                RealtimeResponse realtimeResponse = response.body();
                if(realtimeResponse == null)
                {
                    Log.e(TAG, "LoginResponse is null");
                    homeActivityView.onFailureGetPopularContent();
                }
                else if(!realtimeResponse.getIsSuccess())
                {
                    Log.e(TAG, "" + realtimeResponse.getCode());
                    Log.e(TAG, "" + realtimeResponse.getMessage());
                    homeActivityView.onFailureGetPopularContent();
                }
                Log.e("실시간 인기글 GET", "Realtime Get Success!!!!!");
                Log.e("코드", "" + realtimeResponse.getCode());
                Log.e("메시지", "" + realtimeResponse.getMessage());
                homeActivityView.onSuccessGetPopularContent(realtimeResponse);

            }

            @Override
            public void onFailure(Call<RealtimeResponse> call, Throwable t) {

            }
        });
    }


}
