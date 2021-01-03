package com.test.aop.user;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.test.aop.MyApp;
import com.test.aop.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void click_login(View view) {
        MyApp.isLogin = true;
        Toast.makeText(this,"登陆成功",Toast.LENGTH_SHORT).show();
        finish();
    }
}
