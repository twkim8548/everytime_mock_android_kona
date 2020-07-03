package com.softsquared.template.src.main.home.mypage;

import android.util.Log;

import com.softsquared.template.src.login.interfaces.LoginActivityView;
import com.softsquared.template.src.login.models.LoginResponse;
import com.softsquared.template.src.main.home.mypage.interfaces.MypageActivityView;
import com.softsquared.template.src.main.home.mypage.interfaces.MypageRetrofitInterface;
import com.softsquared.template.src.main.home.mypage.models.MypageResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.template.src.ApplicationClass.TAG;
import static com.softsquared.template.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.softsquared.template.src.ApplicationClass.getRetrofit;



public class MypageService {

    private MypageActivityView mypageActivityView;

    MypageService(MypageActivityView mypageActivityView)
    {
        this.mypageActivityView = mypageActivityView;
    }

    void getMypage()
    {
        MypageRetrofitInterface mypageRetrofitInterface = getRetrofit().create(MypageRetrofitInterface.class);
        mypageRetrofitInterface.getMypage(X_ACCESS_TOKEN).enqueue(new Callback<MypageResponse>() {
            @Override
            public void onResponse(Call<MypageResponse> call, Response<MypageResponse> response) {
                MypageResponse mypageResponse = response.body();
                if(mypageResponse == null)
                {
                    Log.e(TAG, "LoginResponse is null");
                    mypageActivityView.onFailureGetMypage();
                }
                else if(!mypageResponse.getIsSuccess())
                {
                    Log.e(TAG, "" + mypageResponse.getCode());
                    Log.e(TAG, "" + mypageResponse.getMessage());
                    mypageActivityView.onFailureGetMypage();
                }
                Log.e("마이페이지 GET", "Mypage Get Success!!!!!");
                Log.e("코드", "" + mypageResponse.getCode());
                Log.e("메시지", "" + mypageResponse.getMessage());

                mypageActivityView.onSuccessGetMypage(mypageResponse.getResult());
            }

            @Override
            public void onFailure(Call<MypageResponse> call, Throwable t) {
                Log.e("마이페이지 GET 실패", "Mypage Failure");
                mypageActivityView.onFailureGetMypage();

            }
        });
    }
}
