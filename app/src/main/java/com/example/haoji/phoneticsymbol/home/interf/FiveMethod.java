package com.example.haoji.phoneticsymbol.home.interf;

import android.content.Context;

/**
 * Created by HAOJI on 2019/11/25.
 */

public interface FiveMethod {

     void getDataBean(Context context, String url, SuccessCallBack successCallBack);

     void getPostBean(Context context, String url, String account, String password, SuccessCallBack successCallBack);

     void getRetrofitBean(Context context, String base_url, SuccessCallBack successCallBack);

}
