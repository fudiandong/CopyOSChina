package com.fudd.app;

/**
 * Created by fudd-office on 2017-4-6 16:04.
 * Email: 5036175@qq.com
 * QQ: 5036175
 * Description:
 */

public class AppContext extends BaseApplication {

    private static AppContext instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static AppContext getInstance(){
        return instance;
    }

    public String getProperty(String key){
        return AppConfig.getAppConfig(this).get(key);
    }

    public void removeProperty(String... key){
        AppConfig.getAppConfig(this).remove(key);
    }

}
