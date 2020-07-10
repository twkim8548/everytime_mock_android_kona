package com.softsquared.template.src.login.signup;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.softsquared.template.R;
import com.softsquared.template.src.BaseActivity;
import com.softsquared.template.src.login.LoginActivity;
import com.softsquared.template.src.login.signup.interfaces.SignupActivityView;
import com.softsquared.template.src.login.signup.models.SignupJwt;
import com.softsquared.template.src.main.MainActivity;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import static com.softsquared.template.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.softsquared.template.src.ApplicationClass.sSharedPreferences;

public class SignupActivity extends BaseActivity implements SignupActivityView {

    private SignupService signupService;
    private EditText signUpIdEt, signUpPwEt, signUpPwRightEt, signUpNicknameEt, signUpPhoneEt,
                     signUpYearEt, signUpUnivEt, signUpEmailEt;
    private ConstraintLayout signUpCompleteConst, signUpCloseConst;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_layout);
        signupService = new SignupService(this);

        setView();
    }

    public void setView()
    {
        signUpIdEt = findViewById(R.id.sign_up_id_in_et);
        signUpPwEt = findViewById(R.id.sign_up_pw_in_et);
        signUpPwRightEt = findViewById(R.id.sign_up_pw_second_in_et);
        signUpNicknameEt = findViewById(R.id.sign_up_nickname_in_et);
        signUpPhoneEt = findViewById(R.id.sign_up_phoneNum_in_et);
        signUpYearEt = findViewById(R.id.sign_up_entrance_year_in_et);
        signUpUnivEt = findViewById(R.id.sign_up_entrance_univ_in_et);
        signUpEmailEt = findViewById(R.id.sign_up_email_in_et);
        signUpCompleteConst = findViewById(R.id.sign_up_next);
        signUpCloseConst = findViewById(R.id.sign_up_close);

        signUpCompleteConst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tryPostSignup();
            }
        });

        signUpCloseConst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void tryPostSignup()
    {
        signupService.postSignUp(
                signUpIdEt.getText().toString(),
                signUpPwEt.getText().toString(),
                signUpNicknameEt.getText().toString(),
                signUpPhoneEt.getText().toString(),
                signUpUnivEt.getText().toString(),
                Integer.parseInt(signUpYearEt.getText().toString()),
                signUpEmailEt.getText().toString());
    }

    public void signUpComplete()
    {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("회원가입이 완료되었습니다.").setMessage("에브리타임\n" +
                "2020년 7월 10일\n" +
                "광고성 정보 수신 동의 완료");
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                intent.putExtra("jwt", X_ACCESS_TOKEN);
                startActivity(intent);
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


    @Override
    public void onSuccessPostSignup(SignupJwt jwt) {
        SharedPreferences.Editor editor = sSharedPreferences.edit();
        editor.putString(X_ACCESS_TOKEN, jwt.getJwt());
        editor.commit();
        Log.e("과연", "" + jwt.getJwt());
        Log.e("로그인 성공", "LoginActivity::onSuccessLogin() jwt: " + sSharedPreferences.getString(X_ACCESS_TOKEN, ""));
        signUpComplete();

    }

    @Override
    public void onFailurePostSignup() {
        Toast.makeText(this,"가입 실패", Toast.LENGTH_SHORT).show();

    }
}
