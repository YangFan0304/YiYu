package com.yiyu.yiyu.constants;

import android.content.Context;
import android.os.Handler;

/**
 * Created by yangfan on 2017/6/20.
 */

public class Constants {
    //表示界面的状态
    public static final int STATE_UNLOAD = 1;
    public static final int STATE_LOAD = 2;
    public static final int STATE_LOAD_ERROR = 3;
    public static final int STATE_LOAD_EMPTY = 4;
    public static final int STATE_LOAD_SUCCESS = 5;
    //上下文
    public static Context applicationContext;
    //线程号
    public static int mainId;
    //获取主线程
    public static Thread thread;
    public static Handler handler;
    //标志现在界面所在的Fragment
    public static final int HomeFragment=0;
    public static final int FishingGroFragment=1;
    public static final int FriendsFragment=3;
    public static final int MineFragment=4;
}
