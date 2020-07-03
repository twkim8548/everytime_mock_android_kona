package com.softsquared.template.src.main.home.mypage;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.softsquared.template.R;
import com.softsquared.template.src.BaseActivity;
import com.softsquared.template.src.main.home.mypage.interfaces.MypageActivityView;
import com.softsquared.template.src.main.home.mypage.models.MypageInfo;
import com.softsquared.template.src.main.home.mypage.models.MypageResponse;

import androidx.annotation.Nullable;

import static com.softsquared.template.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.softsquared.template.src.ApplicationClass.sSharedPreferences;

public class MypageActivity extends BaseActivity implements MypageActivityView {

    private ImageView profileImg;
    private TextView profileNickname, profileName, profileUnivName, profileUnivNum;
    private MypageService mypageService;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage_layout);
        Log.e("jwt 확인", "LoginActivity::onSuccessLogin() jwt: " + sSharedPreferences.getString(X_ACCESS_TOKEN, ""));
        Intent intent = getIntent();
        mypageService = new MypageService(this);
        setView();
        mypageService.getMypage();
    }

    private void setView()
    {
        profileImg = findViewById(R.id.mypage_myprofilie_myimg);
        profileNickname = findViewById(R.id.mypage_myprofile_nickname);
        profileName = findViewById(R.id.mypage_myprofile_name_id);
        profileUnivName = findViewById(R.id.mypage_myprofile_univName);
        profileUnivNum = findViewById(R.id.mypage_myprofile_univNum);

    }

    @Override
    public void onSuccessGetMypage(MypageInfo mypageInfo) {
       profileName.setText(mypageInfo.getUserID());
       profileNickname.setText(mypageInfo.getUserNickname());
       profileUnivName.setText(mypageInfo.getUnivName());
       profileUnivNum.setText(mypageInfo.getUnivYear());

    }

    @Override
    public void onFailureGetMypage() {

    }
}
