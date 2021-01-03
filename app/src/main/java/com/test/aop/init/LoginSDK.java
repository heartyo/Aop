package com.test.aop.init;

import android.content.Context;

import com.test.aop.impl.ILogin;

public class LoginSDK {
    private static volatile LoginSDK loginSDK ;
    private Context context;

    private ILogin iLogin;

    public static LoginSDK getLoginSDK(){
        if (loginSDK == null) {
            synchronized (LoginSDK.class) {
                if (loginSDK == null) {
                    loginSDK = new LoginSDK();
                }
            }
        }
        return loginSDK;
    }

    public void initLogin(ILogin iLogin, Context context) {
        this.iLogin = iLogin;
        this.context = context;
    }

    public ILogin getLogin() {
        return iLogin;
    }

    public Context getContext() {
        return context;
    }
}
