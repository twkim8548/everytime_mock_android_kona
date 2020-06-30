package com.softsquared.template.src.login.signup;

import android.os.Bundle;

import com.softsquared.template.R;
import com.softsquared.template.src.BaseActivity;

import androidx.annotation.Nullable;

public class SignupActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_layout);
    }
}
