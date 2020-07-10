package com.softsquared.template.src.main.home.mypage;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.softsquared.template.R;
import com.softsquared.template.src.BaseActivity;
import com.softsquared.template.src.login.LoginActivity;
import com.softsquared.template.src.login.signup.SignupActivity;
import com.softsquared.template.src.main.MainActivity;
import com.softsquared.template.src.main.home.mypage.interfaces.MypageActivityView;
import com.softsquared.template.src.main.home.mypage.models.MypageInfo;
import com.softsquared.template.src.main.home.mypage.models.MypageResponse;
import com.softsquared.template.src.main.home.mypage.models.NickChangeInfo;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import static com.softsquared.template.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.softsquared.template.src.ApplicationClass.sSharedPreferences;

public class MypageActivity extends BaseActivity implements MypageActivityView {

    private ImageView profileImg;
    private TextView profileNickname, profileName, profileUnivName, profileUnivNum;
    private MypageService mypageService;
    private ConstraintLayout arrowConst, nicknameChangeConst;


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
        arrowConst = findViewById(R.id.mypage_arrow_const);
        nicknameChangeConst = findViewById(R.id.mypage_account_nickname_change_const);

        arrowConst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MypageActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        nicknameChangeConst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                patchNicknameChange();
            }
        });

    }

    public void patchNicknameChange()
    {
        final EditText nickEditText = new EditText(this);
        nickEditText.setBackgroundColor(000000);

        FrameLayout container = new FrameLayout(getApplicationContext());
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.leftMargin = getResources().getDimensionPixelSize(R.dimen.dialog_margin);
        params.rightMargin = getResources().getDimensionPixelSize(R.dimen.dialog_margin);
        nickEditText.setLayoutParams(params);
        container.addView(nickEditText);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("닉네임 변경");
        builder.setView(container);
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mypageService.patchUser(nickEditText.getText().toString());
                finish();
            }
        });

        builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
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

    @Override
    public void onSuccessPatchUser(NickChangeInfo nickChangeInfo) {
        Log.e("patch success", "patch 성공");
        Log.e("userId", "" + nickChangeInfo.getUserID());
        Log.e("userNickname", "" + nickChangeInfo.getUserNickname());
    }

    @Override
    public void onFailuerPatchUser() {

    }
}
