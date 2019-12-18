package com.example.haoji.phoneticsymbol.home.interf;


import com.example.haoji.phoneticsymbol.home.bean.DataBean1;
import com.example.haoji.phoneticsymbol.home.bean.TextViewDataBean;

import retrofit2.Response;

/**
 * Created by HAOJI on 2019/11/25.
 */

public abstract interface SuccessTextCallBack {


    abstract void IsFailed(String msg);

    abstract void IsSuccess(Response<TextViewDataBean> data);

}
