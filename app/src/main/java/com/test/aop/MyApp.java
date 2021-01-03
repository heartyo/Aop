package com.test.aop;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.test.aop.impl.ILogin;
import com.test.aop.init.LoginSDK;
import com.test.aop.user.LoginActivity;

public class MyApp extends Application {

    public static boolean isLogin = false;

    @Override
    public void onCreate() {
        super.onCreate();
        LoginSDK.getLoginSDK().initLogin(login, this);
    }


    ILogin login = new ILogin() {
        @Override
        public void login(Context context, int action) {
            switch (action) {
                case 0:
                    Intent intent = new Intent(context, LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    break;
                case 1:
                    Toast.makeText(context, "您还未登陆，登陆执行", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    Toast.makeText(context, "执行失败，您还未登陆", Toast.LENGTH_SHORT).show();
                    break;
            }
        }

        @Override
        public boolean isLogin() {
            return isLogin;
        }
    };
}
