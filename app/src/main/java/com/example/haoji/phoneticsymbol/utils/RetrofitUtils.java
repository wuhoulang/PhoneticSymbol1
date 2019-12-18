package com.example.haoji.phoneticsymbol.utils;

import android.util.Log;

import com.example.haoji.phoneticsymbol.home.interf.RetrofitTextCallback;
import com.example.haoji.phoneticsymbol.myContents.ContentsJson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HAOJI on 2019/12/18.
 */

public class RetrofitUtils {

    private static RetrofitUtils instance;
    private static OkHttpClient client;
    public static RetrofitUtils getInstance(){
        if (instance==null){
            synchronized (RetrofitUtils.class){
                if (instance==null){
                    instance =new RetrofitUtils();
                }
            }
        }
        return instance;
    }



    public RetrofitUtils(){
         client = new OkHttpClient().newBuilder()
                .readTimeout(ContentsJson.DEFAULT_TIME, TimeUnit.SECONDS)//设置读取超时时间
                .connectTimeout(ContentsJson.DEFAULT_TIME, TimeUnit.SECONDS)//设置请求超时时间
                .writeTimeout(ContentsJson.DEFAULT_TIME, TimeUnit.SECONDS)//设置写入超时时间
                .addInterceptor(new HttpLoggingInterceptor())//添加打印拦截器
                .retryOnConnectionFailure(true)//设置出现错误进行重新连接。
                .build();
    }

    public Retrofit getRetrofit(String baseUrl){
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                //添加GSON解析：返回数据转换成GSON类型
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

    public <T> void retrofitGetHttp(Call<T> call,final RetrofitTextCallback<T> modelCallback){

        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                Log.e("OneFragment", "请求成功信息: " + response.body().toString());
                modelCallback.onSuccess(response);
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                Log.e("OneFragment", "请求失败信息: " + t.getMessage());
//                tv_retrofit.setText(t.getMessage());
            }
        });
    }


}
