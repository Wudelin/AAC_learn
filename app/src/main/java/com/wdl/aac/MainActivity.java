package com.wdl.aac;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.wdl.aac.data.User;

@SuppressWarnings("unused")
public class MainActivity extends AppCompatActivity implements LifecycleOwner {
    private ActivityLifeObserver observer;
    private LifecycleRegistry registry;
    private UserViewModel userViewModel;
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 实例化LifecycleRegistry
        registry = new LifecycleRegistry(this);
        // 实例化要监听的生命周期的类
        observer = new ActivityLifeObserver();
        // 注册监听
        registry.addObserver(observer);
        // 获取实例
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        mTv = findViewById(R.id.tv_content);
        mTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userViewModel.getUserInfo().setValue(new User(1,"wdl",23,"Fuzhou"));
            }
        });

        //userViewModel.getUserInfo().setValue();
        // 创建一个监听
        final Observer<User> userObserver = new Observer<User>() {
            /**
             * 监听回调（数据源更改）
             * @param user User
             */
            @Override
            public void onChanged(@Nullable User user) {
                assert user != null;
                mTv.setText(user.toString());
            }
        };
        // 进行绑定
        userViewModel.getUserInfo().observe(this,userObserver);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 移除监听
        registry.removeObserver(observer);
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return registry;
    }
}
