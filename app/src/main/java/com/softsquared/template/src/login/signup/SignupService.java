package com.softsquared.template.src.login.signup;

import android.util.Log;

import com.softsquared.template.src.login.interfaces.LoginActivityView;
import com.softsquared.template.src.login.models.LoginResponse;
import com.softsquared.template.src.login.signup.interfaces.SignupActivityView;
import com.softsquared.template.src.login.signup.interfaces.SignupRetrofitInterface;
import com.softsquared.template.src.login.signup.models.SignupBody;
import com.softsquared.template.src.login.signup.models.SignupResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.template.src.ApplicationClass.TAG;
import static com.softsquared.template.src.ApplicationClass.getRetrofit;


public class SignupService {

    private SignupActivityView signupActivityView;

    SignupService(SignupActivityView signupActivityView)
    {
        this.signupActivityView = signupActivityView;
    }

    void postSignUp(String userID, String pw, String userNickname, String phoneNum, String univName, int univYear, String email)
    {
        SignupRetrofitInterface signupRetrofitInterface = getRetrofit().create(SignupRetrofitInterface.class);
        signupRetrofitInterface.getSignup(new SignupBody(userID, pw, userNickname, phoneNum, univName, univYear, email)).enqueue(new Callback<SignupResponse>() {
            @Override
            public void onResponse(Call<SignupResponse> call, Response<SignupResponse> response) {
                SignupResponse signupResponse = response.body();
                if(signupResponse == null)
                {
                    Log.e(TAG, "LoginResponse is null");
                    signupActivityView.onFailurePostSignup();
                }
                else if(!signupResponse.getIsSuccess())
                {
                    Log.e(TAG, "" + signupResponse.getCode());
                    Log.e(TAG, "" + signupResponse.getMessage());
                    signupActivityView.onFailurePostSignup();
                }
                Log.e("로그인성공", "Login Success!!!!!");
                Log.e("코드", "" + signupResponse.getCode());
                Log.e("메시지", "" + signupResponse.getMessage());
                Log.e("result", "" + signupResponse.getResult());

                signupActivityView.onSuccessPostSignup(signupResponse.getResult());

            }

            @Override
            public void onFailure(Call<SignupResponse> call, Throwable t) {

            }
        });
    }
}
