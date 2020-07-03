package com.softsquared.template.src.main.community;

import android.util.Log;

import com.softsquared.template.src.main.community.interfaces.PinActivityView;
import com.softsquared.template.src.main.community.interfaces.PinRetrofitInterface;
import com.softsquared.template.src.main.community.models.PinResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.template.src.ApplicationClass.TAG;
import static com.softsquared.template.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.softsquared.template.src.ApplicationClass.getRetrofit;

public class CommunityService {

    private PinActivityView pinActivityView;

    CommunityService(PinActivityView pinActivityView)
    {
        this.pinActivityView = pinActivityView;
    }

    void getPinList()
    {
        final PinRetrofitInterface pinRetrofitInterface = getRetrofit().create(PinRetrofitInterface.class);
        pinRetrofitInterface.getPinCommunity(X_ACCESS_TOKEN).enqueue(new Callback<PinResponse>() {
            @Override
            public void onResponse(Call<PinResponse> call, Response<PinResponse> response) {
                PinResponse pinResponse = response.body();
                if(pinResponse == null)
                {
                    Log.e(TAG, "PinResponse is null");
                    pinActivityView.onFailureGetPin();
                }
                else if(!pinResponse.getIsSuccess())
                {
                    Log.e(TAG, "" + pinResponse.getCode());
                    Log.e(TAG, "" + pinResponse.getMessage());
                    pinActivityView.onFailureGetPin();
                }
                pinActivityView.onSuccessGetPin(pinResponse.getResult());
            }

            @Override
            public void onFailure(Call<PinResponse> call, Throwable t) {
                Log.e(TAG, "CommunityService::getPinList: " + t);
                pinActivityView.onFailureGetPin();

            }

        });
    }
}
