package com.yiyu.yiyu.application;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Process;

import static com.yiyu.yiyu.constants.Constants.applicationContext;
import static com.yiyu.yiyu.constants.Constants.handler;
import static com.yiyu.yiyu.constants.Constants.mainId;
import static com.yiyu.yiyu.constants.Constants.thread;

/**
 * Created by yangfan on 2017/6/20.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //上下文
        applicationContext=getApplicationContext();
        //线程号
        mainId = Process.myTid();
        //获取主线程
        thread = Thread.currentThread();
        //Handler方法
        handler = new Handler();
    }
    //上下文的方法
    public static Context getConText(){
        return applicationContext;
    }
    //得到线程号的方法
    public static int getMainId(){
        return mainId;
    }
    //得到主线程的方法
    public static Thread getMainThread(){
        return thread;
    }
    //得到hander的方法
    public static Handler getHandler(){
        return handler;
    }
}
