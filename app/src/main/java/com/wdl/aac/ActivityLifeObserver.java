package com.wdl.aac;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

/**
 * 创建时间： 2019/3/22 11:35
 * 描述：    Activity生命周期的管理类，与实现了LifecycleOwner接口的Ac/Fg等建立映射关系。有效避免内存泄漏
 *          对外界提供一个接口，管理生命周期使得生命周期从Activity/Fg解耦出来
 */
@SuppressWarnings("unused")
public class ActivityLifeObserver implements LifecycleObserver {

    private static final String TAG = ActivityLifeObserver.class.getSimpleName();

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        LogUtil.e("onCreate");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        LogUtil.e("onStart");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        LogUtil.e("onResume");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        LogUtil.e("onPause");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        LogUtil.e("onDestroy");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    public void onAny() {
        //LogUtil.e("onAny");
    }
}
