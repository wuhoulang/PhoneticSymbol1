package com.example.haoji.phoneticsymbol.home.interf;


import com.example.haoji.phoneticsymbol.home.bean.DataBean1;

/**
 * Created by HAOJI on 2019/11/25.
 */

public abstract interface SuccessCallBack {

    abstract void IsSuccess(String data);

    abstract void IsFailed(String msg);

    abstract void IsReSuccess(retrofit2.Response<DataBean1> data);

}
