package com.softsquared.template.src.main.community;

import android.util.Log;

import com.softsquared.template.src.login.interfaces.LoginRetrofitInterface;
import com.softsquared.template.src.login.models.LoginBody;
import com.softsquared.template.src.login.models.LoginResponse;
import com.softsquared.template.src.main.community.interfaces.CommunityActivityView;
import com.softsquared.template.src.main.community.interfaces.CommunityRetrofitInterface;
import com.softsquared.template.src.main.community.models.PinBody;
import com.softsquared.template.src.main.community.models.PinPostResponse;
import com.softsquared.template.src.main.community.models.PinResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.template.src.ApplicationClass.TAG;
import static com.softsquared.template.src.ApplicationClass.getRetrofit;

public class CommunityService {

    public CommunityActivityView communityActivityView;

    public CommunityService(CommunityActivityView communityActivityView)
    {
        this.communityActivityView = communityActivityView;
    }

    public void getPinList()
    {
        final CommunityRetrofitInterface communityRetrofitInterface = getRetrofit().create(CommunityRetrofitInterface.class);
        communityRetrofitInterface.getPinCommunity().enqueue(new Callback<PinResponse>() {
            @Override
            public void onResponse(Call<PinResponse> call, Response<PinResponse> response) {
                PinResponse pinResponse = response.body();
                if(pinResponse == null)
                {
                    Log.e(TAG, "PinResponse is null");
                    communityActivityView.onFailureGetPin();
                }
                else if(!pinResponse.getIsSuccess())
                {
                    Log.e(TAG, "" + pinResponse.getCode());
                    Log.e(TAG, "" + pinResponse.getMessage());
                    communityActivityView.onFailureGetPin();
                }
                Log.e("핀 커뮤니티 GET", "Pin Community Get Success!!!!!");
                Log.e("코드", "" + pinResponse.getCode());
                Log.e("메시지", "" + pinResponse.getMessage());
                communityActivityView.onSuccessGetPin(pinResponse);
            }

            @Override
            public void onFailure(Call<PinResponse> call, Throwable t) {
                Log.e(TAG, "CommunityService::getPinList: " + t);
                communityActivityView.onFailureGetPin();

            }

        });
    }

    public void postPin(int noticeIdx)
    {
        final CommunityRetrofitInterface communityRetrofitInterface = getRetrofit().create(CommunityRetrofitInterface.class);
        communityRetrofitInterface.postPin(new PinBody(noticeIdx)).enqueue(new Callback<PinPostResponse>() {
            @Override
            public void onResponse(Call<PinPostResponse> call, Response<PinPostResponse> response) {
                PinPostResponse pinPostResponse = response.body();
                if(pinPostResponse == null)
                {
                    Log.e(TAG, "PinResponse is null");
                    communityActivityView.onFailurePostPin();
                }
                else if(!pinPostResponse.getIsSuccess())
                {
                    Log.e(TAG, "" + pinPostResponse.getCode());
                    Log.e(TAG, "" + pinPostResponse.getMessage());
                    communityActivityView.onFailurePostPin();
                }
                Log.e("포스트 pin", "Post pin Success!!!!!");
                Log.e("코드", "" + pinPostResponse.getCode());
                Log.e("메시지", "" + pinPostResponse.getMessage());
                Log.e("result", "" + pinPostResponse.getResult());

                communityActivityView.onSuccessPostPin(pinPostResponse.getResult());

            }

            @Override
            public void onFailure(Call<PinPostResponse> call, Throwable t) {
                Log.e(TAG, "post pin Failure");
                communityActivityView.onFailurePostPin();

            }
        });

    }
}
