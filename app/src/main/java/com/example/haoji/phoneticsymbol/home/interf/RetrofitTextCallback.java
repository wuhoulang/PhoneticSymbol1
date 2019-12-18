package com.example.haoji.phoneticsymbol.home.interf;


import com.example.haoji.phoneticsymbol.home.bean.DataBean1;
import com.example.haoji.phoneticsymbol.home.bean.TextViewDataBean;

import retrofit2.Response;

/**
 * Created by HAOJI on 2019/11/25.
 */

public abstract interface RetrofitTextCallback<T> {


    void onSuccess(Response<T> data);

    void onFailure(String msg);

}
