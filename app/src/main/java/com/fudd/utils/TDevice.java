package com.fudd.utils;

import android.content.pm.PackageManager;

import com.fudd.app.BaseApplication;

/**
 * Created by fudd-office on 2017-4-6 15:42.
 * Email: 5036175@qq.com
 * QQ: 5036175
 * Description:
 */

public class TDevice {


    // 获取版本号
    public static int getVersionCode(){
        return  getVersionCode(BaseApplication.context().getPackageName());
    }

    private static int getVersionCode(String packageName) {

        try {
            return BaseApplication.context().getPackageManager().getPackageInfo(packageName,0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            return 0;
        }

    }
}
