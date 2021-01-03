package com.test.aop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.test.aop.annotation.BehaviorTrace;
import com.test.aop.annotation.LoginFilter;
import com.test.aop.init.LoginSDK;
import com.test.aop.user.UserInfoActivity;

public class MainActivity extends AppCompatActivity {

    private TextView btnSafeLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSafeLogin = findViewById(R.id.btn_safeLogin);
    }

    @BehaviorTrace("学习")
    public void click_study(View view) {
        Log.d("click_study", "click_study");
    }

    public void click_work(View view) {

    }

    public void click_eat(View view) {

    }

    public void click_play(View view) {

    }

    //个人中心
    @LoginFilter()
    public void click(View view) {
        startActivity(new Intent(this, UserInfoActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnSafeLogin.setText(LoginSDK.getLoginSDK().getLogin().isLogin()?"个人中心":"个人中心(未登录)");
    }
}