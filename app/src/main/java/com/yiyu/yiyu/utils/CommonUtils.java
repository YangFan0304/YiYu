package com.yiyu.yiyu.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.view.View;
import com.yiyu.yiyu.application.MyApplication;

/**
 * Created by yangfan on 2017/6/21.
 */

public class CommonUtils {

    //获取上下文
    public static Context getContext() {
        return MyApplication.getConText();
    }

    //获取主线程
    public static Thread getMainThread() {
        return MyApplication.getMainThread();
    }

    //获取Handler
    public static Handler getHandler() {
        return MyApplication.getHandler();
    }

    //获取线程Id
    public static int getMainThreadId() {
        return MyApplication.getMainId();
    }

    // 获取资源文件夹操作
    public static Resources getResources() {
        return getContext().getResources();
    }

    // string文件中的字符串
    public static String getString(int stringId) {
        return getResources().getString(stringId);
    }

    // 返回drawable操作
    public static Drawable getDrawable(int drawableId) {
        return getResources().getDrawable(drawableId);
    }

    // 从资源文件中获取字符串数组
    public static String[] getStringArray(int arrayId) {
        return getResources().getStringArray(arrayId);
    }

    // dip--->px, 1dp = 2px,定义一个控件的宽高 layoutParams(w,h)
    public static int dip2px(int dip) {
        // 获取dp和px的转换关系的变量
        float density = getResources().getDisplayMetrics().density;
        return (int) (dip * density + 0.5);
    }

    // px---->dp
    public static int px2dip(int px) {
        float density = getResources().getDisplayMetrics().density;
        return (int) (px / density + 0.5);
    }

    // 判断当前线程是否在主线程中
    public static boolean isRunInMainThread() {
        //先获取主线程的线程号然后和当前线程号比较
        return getMainThreadId() == android.os.Process.myTid();
    }
    // 区分是否在 主线程中,做UI处理
    public static void runOnMainThread(Runnable runnable) {
        if (isRunInMainThread()) {
            // 如果当前任务就在主线程中,直接运行
            runnable.run();
        } else {
            // 如果当任务在子线程中,则将其传递到主线程中去执行
            getHandler().post(runnable);
        }
    }

    // 根据id获取颜色选择器xml
    public static ColorStateList getColorStateList(int mTabTextColorResId) {
        return getResources().getColorStateList(mTabTextColorResId);
    }

    //布局加载器
    public static View inflate(int layoutId) {
        return View.inflate(getContext(), layoutId, null);
    }

    // 将dimens中的dp转换成像素值
    public static int getDimens(int dimensId) {
        return getResources().getDimensionPixelSize(dimensId);
    }

    public static void postDelayed(Runnable runnable, int delayed) {
        // 延时做任务方法
        getHandler().postDelayed(runnable, delayed);
    }

    public static boolean checkNetworkState(Context context) {
        boolean flag = false;
        //得到网络连接信息
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        //去进行判断网络是否连接
        if (manager.getActiveNetworkInfo() != null) {
            flag = manager.getActiveNetworkInfo().isAvailable();
        }
        return !flag;
    }
}
