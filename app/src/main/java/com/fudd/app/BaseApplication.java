package com.fudd.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by fudd-office on 2017-4-6 15:49.
 * Email: 5036175@qq.com
 * QQ: 5036175
 * Description:
 */

public class BaseApplication extends Application {

    static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context =  getApplicationContext();
        // LeakCanary.install(this); 检测
    }

    public static synchronized BaseApplication context(){
        return (BaseApplication) context;
    }
}
