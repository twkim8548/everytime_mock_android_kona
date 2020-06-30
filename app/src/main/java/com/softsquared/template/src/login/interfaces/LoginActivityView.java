package com.softsquared.template.src.login.interfaces;

import com.softsquared.template.src.login.models.LoginJwt;

public interface LoginActivityView {

    void onSuccessLogin(LoginJwt jwt);

    void onFailureLogin();
}
