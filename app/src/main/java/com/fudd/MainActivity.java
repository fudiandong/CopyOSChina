package com.fudd;

import android.text.TextUtils;

import com.fudd.app.AppOperator;
import com.fudd.app.MyApplication;
import com.fudd.app.Setting;
import com.fudd.base.acitivities.BaseAcitivity;

/**
 * 应用入口启动界面
 */
public class MainActivity extends BaseAcitivity {

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initDate() {
        super.initDate();
        // 在此检测 是否是新版本安装，如果是则进行老版本数据迁移工作
        // 该工作耗时比较大，所有放在自线程中进行
        AppOperator.runOnThread(new Runnable() {
            @Override
            public void run() {
                doMerge();
            }
        });
    }

    private void doMerge() {
        // 判断是否是新版本
        if (Setting.checkIsNewVersion(this)){
            // cookie 迁移  不懂
            String cookie = MyApplication.getInstance().getProperty("cookie");
            if (!TextUtils.isEmpty(cookie)){
                MyApplication.getInstance().removeProperty("cookie");
            }

        }



    }
}
