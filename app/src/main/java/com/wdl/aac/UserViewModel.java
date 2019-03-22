package com.wdl.aac;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.wdl.aac.data.User;

/**
 * 创建时间： 2019/3/22 13:51
 * 描述：    TODO
 */
@SuppressWarnings("unused")
public class UserViewModel extends ViewModel {
    private MutableLiveData<User> userInfo;

    public MutableLiveData<User> getUserInfo() {
        if (userInfo == null) {
            userInfo = new MutableLiveData<>();
        }
        userInfo.setValue(load());
        return userInfo;
    }

    public void setInfo(User user) {
        if (userInfo != null)
            userInfo.setValue(user);
    }

    private User load() {
        return new User(1, "1", 1, "1");
    }
}
