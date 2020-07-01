package com.softsquared.template.src.login.signup;

import com.softsquared.template.src.login.interfaces.LoginActivityView;
import com.softsquared.template.src.login.signup.interfaces.SignupActivityView;

public class SignupService {

    private SignupActivityView signupActivityView;

    SignupService(SignupActivityView signupActivityView)
    {
        this.signupActivityView = signupActivityView;
    }

    void signUp(String userID, String pw, String userNickname, String phoneNum, String univName, String univYear, String email)
    {

    }
}
