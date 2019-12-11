package com.example.haoji.phoneticsymbol.base;

import android.app.Application;

import com.example.haoji.phoneticsymbol.utils.ScreenAdapterUtil;

/**
 * Created by HAOJI on 2019/12/6.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ScreenAdapterUtil.setup(this);
    }
}
