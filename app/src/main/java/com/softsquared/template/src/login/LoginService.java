package com.softsquared.template.src.login;

import android.util.Log;

import com.softsquared.template.src.login.interfaces.LoginActivityView;
import com.softsquared.template.src.login.interfaces.LoginRetrofitInterface;
import com.softsquared.template.src.login.models.LoginBody;
import com.softsquared.template.src.login.models.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.template.src.ApplicationClass.TAG;
import static com.softsquared.template.src.ApplicationClass.getRetrofit;

public class LoginService {

    private LoginActivityView loginActivityView;

    LoginService(LoginActivityView loginActivityView)
    {
        this.loginActivityView = loginActivityView;
    }

    void login(String userID, String pw)
    {
        final LoginRetrofitInterface loginRetrofitInterface = getRetrofit().create(LoginRetrofitInterface.class);
        loginRetrofitInterface.getLogin(new LoginBody(userID, pw)).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();
                if(loginResponse == null)
                {
                    Log.e(TAG, "LoginResponse is null");
                    loginActivityView.onFailureLogin();
                }
                else if(!loginResponse.getIsSuccess())
                {
                    Log.e(TAG, "" + loginResponse.getCode());
                    Log.e(TAG, "" + loginResponse.getMessage());
                    loginActivityView.onFailureLogin();
                }
                Log.e("로그인성공", "Login Success!!!!!");
                Log.e("코드", "" + loginResponse.getCode());
                Log.e("메시지", "" + loginResponse.getMessage());
                Log.e("result", "" + loginResponse.getResult().getJwt());

                loginActivityView.onSuccessLogin(loginResponse.getResult());
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.e(TAG, "Login Failure");
                loginActivityView.onFailureLogin();
            }
        });
    }



}
