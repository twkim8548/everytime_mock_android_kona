package com.softsquared.template.src.login.signup.interfaces;

import com.softsquared.template.src.login.models.LoginJwt;
import com.softsquared.template.src.login.signup.models.SignupJwt;

public interface SignupActivityView {

    void onSuccessPostSignup(SignupJwt jwt);

    void onFailurePostSignup();
}
