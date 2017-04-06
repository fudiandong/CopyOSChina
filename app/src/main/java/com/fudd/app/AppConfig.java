package com.fudd.app;

import android.content.Context;

import net.oschina.common.utils.StreamUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * Created by fudd-office on 2017-4-6 16:09.
 * Email: 5036175@qq.com
 * QQ: 5036175
 * Description: 应用程序配置类 用于保存用户相关信息及设置
 */

public class AppConfig {
    private final static String APP_CONFIG = "config";

    private static AppConfig appConfig;
    private Context mContext;

    public static AppConfig getAppConfig(Context context){
        if (appConfig == null){
            appConfig = new AppConfig();
            appConfig.mContext = context;
        }
        return appConfig;
    }

    public String get(String key){
        Properties props = get();
        return (props != null) ? props.getProperty(key):null;
    }

    public Properties get() {
        FileInputStream fis = null;
        Properties props = new Properties();
        try {
            File dirConf = mContext.getDir(APP_CONFIG,Context.MODE_PRIVATE);
            fis = new FileInputStream(dirConf.getPath() + File.separator + APP_CONFIG);
            props.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            StreamUtil.close(fis);
        }
        return props;
    }

    public void remove(String... key){
        Properties props = get();
        for (String k : key){
            props.remove(k);
        }
        setPorps(props);

    }

    private void setPorps(Properties props) {
        FileOutputStream fos = null;
        try {
            File dirConf = mContext.getDir(APP_CONFIG,Context.MODE_PRIVATE);
            File conf = new File(dirConf,APP_CONFIG);
            fos = new FileOutputStream(conf);
            props.store(fos,null);
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            StreamUtil.close(fos);
        }
    }


}
