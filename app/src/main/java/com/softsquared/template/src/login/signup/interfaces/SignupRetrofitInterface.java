package com.softsquared.template.src.login.signup.interfaces;

import com.softsquared.template.src.login.models.LoginBody;
import com.softsquared.template.src.login.models.LoginResponse;
import com.softsquared.template.src.login.signup.models.SignupBody;
import com.softsquared.template.src.login.signup.models.SignupResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface SignupRetrofitInterface {

    @POST("/user")
    @Headers("Content-Type: application/json")
    Call<SignupResponse> getSignup(
            @Body SignupBody signupBody);
}
