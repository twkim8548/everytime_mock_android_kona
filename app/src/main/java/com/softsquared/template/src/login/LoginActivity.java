package com.softsquared.template.src.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.softsquared.template.R;
import com.softsquared.template.src.BaseActivity;
import com.softsquared.template.src.login.interfaces.LoginActivityView;
import com.softsquared.template.src.login.models.LoginJwt;
import com.softsquared.template.src.login.signup.SignupActivity;
import com.softsquared.template.src.main.MainActivity;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import static com.softsquared.template.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.softsquared.template.src.ApplicationClass.sSharedPreferences;

public class LoginActivity extends BaseActivity implements LoginActivityView {

    private EditText id_editText;
    private EditText pw_editText;
    private ConstraintLayout login_const;
    private TextView signup_textView;

    private LoginService loginService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        loginService = new LoginService(this);

        setView();

    }

    private void setView()
    {
        id_editText = findViewById(R.id.id_editText);
        pw_editText = findViewById(R.id.pw_editText);
        login_const = findViewById(R.id.login_imageView);
        signup_textView = findViewById(R.id.sign_up_tv);

        login_const.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tryPostLogin();
            }
        });

        signup_textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void tryPostLogin()
    {
        loginService.login(id_editText.getText().toString(), pw_editText.getText().toString());
    }

    @Override
    public void onSuccessLogin(LoginJwt jwt) {
        SharedPreferences.Editor editor = sSharedPreferences.edit();
        editor.putString(X_ACCESS_TOKEN, jwt.getJwt());
        editor.commit();
        Log.e("과연", "" + jwt.getJwt());
        Log.e("로그인 성공", "LoginActivity::onSuccessLogin() jwt: " + sSharedPreferences.getString(X_ACCESS_TOKEN, ""));

        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.putExtra("jwt", X_ACCESS_TOKEN);
        startActivity(intent);
        finish();


    }

    @Override
    public void onFailureLogin() {
        Log.e("로그인 실패", "LoginActivity::onFailureLogin()");
    }
}
