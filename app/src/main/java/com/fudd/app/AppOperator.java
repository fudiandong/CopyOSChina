package com.fudd.app;

import com.google.gson.Gson;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by fudd-office on 2017-4-6 15:13.
 * Email: 5036175@qq.com
 * QQ: 5036175
 * Description:
 */

public final class AppOperator {
    // 用到 gson库
    private static Gson GSON_INSTANCE;
    private static ExecutorService EXECUTOR_INSTANCE; // AS 大小写切换  Ctrl + Shift + U

    public static Executor getExecutor(){
        if (EXECUTOR_INSTANCE == null){
            synchronized (AppOperator.class){
                if (EXECUTOR_INSTANCE == null){
                    EXECUTOR_INSTANCE = Executors.newFixedThreadPool(6);
                }
            }
        }
        return EXECUTOR_INSTANCE;
    }

    public static void runOnThread(Runnable runnable){
        getExecutor().execute(runnable);
    }
}
