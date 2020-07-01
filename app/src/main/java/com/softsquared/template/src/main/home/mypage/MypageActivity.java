package com.softsquared.template.src.main.home.mypage;

import android.os.Bundle;

import com.softsquared.template.R;
import com.softsquared.template.src.BaseActivity;

import androidx.annotation.Nullable;

public class MypageActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage_layout);
    }
}
