package com.example.haoji.phoneticsymbol.main.model;

import android.content.Context;
import android.util.Log;

import com.example.haoji.phoneticsymbol.home.interf.ModelCallback;
import com.example.haoji.phoneticsymbol.utils.OkHttpUtil;

import okhttp3.FormBody;

public class MainModel {

    public static void requestPostOKhttp(Context context, String url, String account, final ModelCallback modelCallback) {

        FormBody.Builder formBody = new FormBody.Builder();
        formBody.add("userId", account);
        OkHttpUtil.getInstance().postOkHttp(url,formBody,modelCallback);
        Log.e("BeanModel","requestPostOKhttp--------------------------------");
    }

}
