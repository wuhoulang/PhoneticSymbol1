package com.example.haoji.phoneticsymbol.type.model;

import android.content.Context;
import android.util.Log;

import com.example.haoji.phoneticsymbol.home.bean.DataBean1;
import com.example.haoji.phoneticsymbol.home.bean.TextViewDataBean;
import com.example.haoji.phoneticsymbol.home.interf.ModelCallback;
import com.example.haoji.phoneticsymbol.home.interf.RetrofitTextCallback;
import com.example.haoji.phoneticsymbol.myContents.ApiUrl;
import com.example.haoji.phoneticsymbol.myContents.ContentsJson;
import com.example.haoji.phoneticsymbol.utils.OkHttpUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HAOJI on 2019/11/25.
 */

public class TypeModel {


    public static void requestPostOKhttp(Context context, String url, String picUrl,String upUserId,String title,String subTitle, final ModelCallback modelCallback){
        FormBody.Builder formBody =new FormBody.Builder();
        formBody.add("picUrl",picUrl);
        formBody.add("upUserId",upUserId);
        formBody.add("title",title);
        formBody.add("subTitle",subTitle);
        Log.e("ShowDetailActivity","--data:"+picUrl+upUserId+title+subTitle);
        OkHttpUtil.getInstance().postOkHttp(url,formBody,modelCallback);
    }

}
