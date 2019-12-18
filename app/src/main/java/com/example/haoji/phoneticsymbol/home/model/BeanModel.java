package com.example.haoji.phoneticsymbol.home.model;

import android.content.Context;
import android.util.Log;

import com.example.haoji.phoneticsymbol.home.bean.TextViewDataBean;
import com.example.haoji.phoneticsymbol.home.interf.RetrofitTextCallback;
import com.example.haoji.phoneticsymbol.myContents.ApiUrl;
import com.example.haoji.phoneticsymbol.myContents.ContentsJson;
import com.example.haoji.phoneticsymbol.home.bean.DataBean1;
import com.example.haoji.phoneticsymbol.home.interf.ModelCallback;
import com.example.haoji.phoneticsymbol.utils.OkHttpUtil;
import com.example.haoji.phoneticsymbol.utils.RetrofitUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HAOJI on 2019/11/25.
 */

public class BeanModel {


    public static void getModel(Context context, String url, final ModelCallback modelCallback) {
        OkHttpUtil.getInstance().getOkHttp(url, modelCallback);
    }

    public static void requestPostOKhttp(Context context, String url, String account, String password, final ModelCallback modelCallback) {

        FormBody.Builder formBody = new FormBody.Builder();
        formBody.add("name", account);
        formBody.add("password", password);
        OkHttpUtil.getInstance().postOkHttp(url,formBody,modelCallback);
        Log.e("BeanModel","requestPostOKhttp--------------------------------");
    }


    public static void requestGetRetrofit(Context context, String url, final RetrofitTextCallback<DataBean1> modelCallback) {
        Retrofit retrofit = RetrofitUtils.getInstance().getRetrofit(ContentsJson.URL_BASE);
        ApiUrl api = retrofit.create(ApiUrl.class);
        retrofit2.Call<DataBean1> call = api.getRetrofit();
        RetrofitUtils.getInstance().retrofitGetHttp(call,modelCallback);
    }

    public static void requestGetTextRetrofit(Context context, String url ,final RetrofitTextCallback<TextViewDataBean> modelCallback) {
        Retrofit retrofit = RetrofitUtils.getInstance().getRetrofit(ContentsJson.URL_BASE);
        ApiUrl api = retrofit.create(ApiUrl.class);
        Call<TextViewDataBean> call = api.getDemo();
        RetrofitUtils.getInstance().retrofitGetHttp(call,modelCallback);
    }


}
