package com.example.haoji.phoneticsymbol.home.interf;


import com.example.haoji.phoneticsymbol.home.bean.DataBean1;

/**
 * Created by HAOJI on 2019/11/25.
 */

public abstract interface RetrofitModelCallback {


    void onSuccess(retrofit2.Response<DataBean1> data);
    void onFailure(String msg);

}
