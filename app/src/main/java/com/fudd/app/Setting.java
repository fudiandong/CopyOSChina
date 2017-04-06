package com.fudd.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;

import com.fudd.utils.TDevice;

/**
 * Created by fudd-office on 2017-4-6 15:34.
 * Email: 5036175@qq.com
 * QQ: 5036175
 * Description:
 */

public final class Setting {
    private static final String KEY_VERSION_CODE = "versionCode";

    public static boolean checkIsNewVersion(Context context){
        int saveVersionCode = getSaveVersionCode(context);
        int curremtVersionCode = TDevice.getVersionCode();
        if (saveVersionCode < curremtVersionCode){
            updateSaveVersionCode(context,curremtVersionCode);
            return true;
        }
        return false;
    }

    private static int updateSaveVersionCode(Context context, int curremtVersionCode) {
        SharedPreferences sp = getSettingPreferences(context);
        SharedPreferences.Editor editor = sp.edit().putInt(KEY_VERSION_CODE,curremtVersionCode);
        SharedPreferencesCompat.EditorCompat.getInstance().apply(editor);
        return curremtVersionCode;

    }

    private static int getSaveVersionCode(Context context) {
        SharedPreferences sp = getSettingPreferences(context);
        return sp.getInt(KEY_VERSION_CODE,0);
    }

    private static SharedPreferences getSettingPreferences(Context context) {
        return context.getSharedPreferences(Setting.class.getName(),Context.MODE_PRIVATE);
    }
}
