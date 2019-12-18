package com.example.haoji.phoneticsymbol.type.interf;

import android.content.Context;

import com.example.haoji.phoneticsymbol.home.interf.SuccessCallBack;
import com.example.haoji.phoneticsymbol.home.interf.SuccessTextCallBack;

/**
 * Created by HAOJI on 2019/11/25.
 */

public interface TwoMethod {


     void getPostBean(Context context, String url, String picur,String id ,String title,String sutitle,SuccessCallBack successCallBack);


}
