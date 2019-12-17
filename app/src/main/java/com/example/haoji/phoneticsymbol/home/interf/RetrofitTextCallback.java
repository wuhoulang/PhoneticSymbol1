package com.example.haoji.phoneticsymbol.home.interf;


import com.example.haoji.phoneticsymbol.home.bean.DataBean1;
import com.example.haoji.phoneticsymbol.home.bean.TextViewDataBean;

/**
 * Created by HAOJI on 2019/11/25.
 */

public abstract interface RetrofitTextCallback {


    void onSuccess(retrofit2.Response<TextViewDataBean> data);

    void onFailure(String msg);

}
