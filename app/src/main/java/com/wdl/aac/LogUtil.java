package com.wdl.aac;

import android.util.Log;

/**
 * 创建时间： 2018/12/20 16:09
 * 描述：    日志控制工具类
 */
@SuppressWarnings("unused")
public class LogUtil {
    private static final boolean log = true;
    private final static String TAG = "wdl";

    public static void d(String msg) {
        if (log) {
            Log.d(TAG, msg);
        }
    }

    public static void e(String msg) {
        if (log) {
            Log.e(TAG, msg);
        }
    }

    public static void i(String msg) {
        if (log) {
            Log.i(TAG, msg);
        }
    }

    public static void v(String msg) {
        if (log) {
            Log.v(TAG, msg);
        }
    }

    public static void w(String msg) {
        if (log) {
            Log.w(TAG, msg);
        }
    }
}
