package com.example.haoji.phoneticsymbol.home.model;

import android.content.Context;
import android.util.Log;

import com.example.haoji.phoneticsymbol.myContents.ApiUrl;
import com.example.haoji.phoneticsymbol.myContents.ContentsJson;
import com.example.haoji.phoneticsymbol.home.bean.DataBean1;
import com.example.haoji.phoneticsymbol.home.interf.ModelCallback;
import com.example.haoji.phoneticsymbol.home.interf.RetrofitModelCallback;

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

public class BeanModel {



    public static void getModel(Context context, String url, final ModelCallback modelCallback) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String string = response.body().string();
                    Log.e("string", string);
                    modelCallback.onSuccess(string);

                }
            }
        });
    }

    public static void requestPostOKhttp(Context context, String url, String account , String password, final ModelCallback modelCallback){
        OkHttpClient client =new OkHttpClient();
        FormBody.Builder formBody =new FormBody.Builder();
        formBody.add("name",account);
        formBody.add("password",password);
        Request request =new Request.Builder().url(url).post(formBody.build()).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()) {//回调的方法执行在子线程。
                    String responseData = response.body().string();
                    JSONObject jsonObject = null;
                    try {
                        jsonObject = new JSONObject(responseData.toString());
                        int code = jsonObject.getInt("Code");
                        if (code==0){
                            modelCallback.onSuccess(responseData);
                        }else {
                            modelCallback.onFailure(responseData);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    Log.e("responseData", "responseData:"+responseData);
                }
            }
        });
    }


    public static void requestGetRetrofit(Context context, String url, final RetrofitModelCallback modelCallback){
        OkHttpClient client = new OkHttpClient().newBuilder()
                .readTimeout(ContentsJson.DEFAULT_TIME, TimeUnit.SECONDS)//设置读取超时时间
                .connectTimeout(ContentsJson.DEFAULT_TIME, TimeUnit.SECONDS)//设置请求超时时间
                .writeTimeout(ContentsJson.DEFAULT_TIME,TimeUnit.SECONDS)//设置写入超时时间
                .addInterceptor(new HttpLoggingInterceptor())//添加打印拦截器
                .retryOnConnectionFailure(true)//设置出现错误进行重新连接。
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(ContentsJson.URL_BASE)
                //添加GSON解析：返回数据转换成GSON类型
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiUrl api = retrofit.create(ApiUrl.class);
        retrofit2.Call<DataBean1> demo = api.getRetrofit();
        demo.enqueue(new retrofit2.Callback<DataBean1>() {
            @Override
            public void onResponse(retrofit2.Call<DataBean1> call, retrofit2.Response<DataBean1> response) {
                Log.e("OneFragment", "请求成功信息: "+response.body().toString());
                modelCallback.onSuccess(response);
            }

            @Override
            public void onFailure(retrofit2.Call<DataBean1> call, Throwable t) {
                Log.e("OneFragment", "请求失败信息: " +t.getMessage());
//                tv_retrofit.setText(t.getMessage());
            }
        });
    }



}
