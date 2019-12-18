package zuo.biao.library.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by HAOJI on 2019/12/18.
 */

public class NoUseOkHttpUtil {
    private static NoUseOkHttpUtil instance;
    private static OkHttpClient mOkHttpClient;

    /**
     * Get instance http util.
     *
     * @return the http util
     */
    public static synchronized NoUseOkHttpUtil getInstance() {
        if (instance == null) {
            synchronized (NoUseOkHttpUtil.class) {
                if (instance == null) {
                    instance = new NoUseOkHttpUtil();
                }
            }
        }
        return instance;
    }
    public NoUseOkHttpUtil() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(30, TimeUnit.SECONDS);//读取超时
        builder.connectTimeout(10, TimeUnit.SECONDS);//连接超时
        builder.writeTimeout(60, TimeUnit.SECONDS);//写入超时
//        builder.sslSocketFactory(HttpsTrustManager.createSSLSocketFactory());
//        builder.hostnameVerifier(new HttpsTrustManager.TrustAllHostnameVerifier());
        mOkHttpClient =  builder.build();
    }
    /**
     * On async get. 异步GET请求
     *
     * @param
     * @author Fsnzzz
     */
    private void onAsyncGET(String url) {
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
//                netCallBack.onFailure(e.getMessage().toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
//                netCallBack.onSucceed(response);
            }
        });
    }

    /**
     * 同步GET请求
     *
     * @param
     * @throws IOException
     */
    private void onSyncGet(String url) throws IOException {
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        Call call = mOkHttpClient.newCall(request);
        Response response = call.execute();
//        netCallBack.onSucceed(response);
    }

    /**
     * 同步POST请求 无 headers 
     * @param url
     * @param bodyParams
     * @return
     */
    private Response onSyncPOST_Body(String url, Map<String,String> bodyParams) throws IOException {
        RequestBody body = getBodyParams(bodyParams);
        Request.Builder builder = new Request.Builder();
        Request request = builder.post(body)
                .url(url)
                .build();
        Call call = mOkHttpClient.newCall(request);
        //请求加入调度
        Response response = call.execute();
        return response;
    }

    /**
     * 同步POST请求 有 headers 
     * @param url
     * @param bodyParams
     * @return
     */
    private Response onSyncPOST_BodyAndHeader(String url, Map<String,String> bodyParams,Map<String,String> headersParams) throws IOException {
        RequestBody body = getBodyParams(bodyParams);
        Request.Builder builder = new Request.Builder();
        Request request = builder.post(body)
                .headers(getRequestHeaders(headersParams))
                .url(url)
                .build();
        Call call = mOkHttpClient.newCall(request);
        Response response = call.execute();
        return response;
    }

    /**
     * 异步post请求 无 headers
     * @param url
     * @param bodyParams
     */

    private void onAsyncPOST_Body(String url,Map<String,String> bodyParams){
        Request.Builder builder = new Request.Builder();
        Request request = builder.post(getBodyParams(bodyParams))
                .url(url)
                .build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
//                netCallBack.onFailure(e.getMessage());
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
            }
        });
    }

    /**
     * 异步post请求 有 headers
     * @param url
     * @param bodyParams
     */

    private void onAsyncPOST_BodyAndHeaders(String url,Map<String,String> bodyParams,Map<String,String> headersParams){
        Request.Builder builder = new Request.Builder();
        Request request = builder.post(getBodyParams(bodyParams))
                .headers(getRequestHeaders(headersParams))
                .url(url)
                .build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

//                netCallBack.onFailure(e.getMessage());
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
//                netCallBack.onSucceed(response);
            }
        });
    }

    /**
     * 不带参 图片上传
     * @param url
     *
     * @param data  通过new JSONObject(Map<String,String> imgs)：key->标识   val->图片file路径
     * @param
     */
    public void onUpImage(String url, JSONObject data){
        MultipartBody.Builder builder = new MultipartBody.Builder();
        if (data != null){
            Iterator<String> keys = data.keys();
            while (keys.hasNext()){
                File file = null;
                try {
                    String key = keys.next();
                    file = new File(data.getString(key));
                    builder.addFormDataPart(key, file.getAbsolutePath(), RequestBody.create(MediaType.parse("multipart/form-data"), file));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        builder.setType(MultipartBody.FORM);
        MultipartBody multipartBody = builder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(multipartBody)
                .build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
//                netCallBack.onFailure(e.getMessage());
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
//                netCallBack.onSucceed(response);
            }
        });

    }

    /**
     * 异步GET请求
     * @param url
     * @param
     * @return
     */
    public static void getAsyncGET(String url){
        getInstance().onAsyncGET(url);
    }


    /**
     * 同步GET请求
     * @param url
     * @param
     * @return
     */
    public static void getSyncGET(String url) throws IOException {
//        getInstance().onSyncGet(url,netCallBack);
    }

    /**
     * 同步POST请求 无  headers
     * @param url
     * @param bodyParams
     * @return
     * @throws IOException
     */
    public static Response getSyncPOST_Body(String url,Map<String,String> bodyParams) throws IOException {
        return getInstance().onSyncPOST_Body(url,bodyParams);
    }

    /**
     * 同步POST请求 有 headers
     * @param url
     * @param bodyParams
     * @return
     * @throws IOException
     */
    public static Response getSyncPOST_BodyAndHeaders(String url,Map<String,String> bodyParams,Map<String,String> headersParams) throws IOException {
        return getInstance().onSyncPOST_BodyAndHeader(url,bodyParams,headersParams);
    }
    /**
     * 设置bodyParams
     * @param bodyParams
     * @return RequestBody
     */
    private RequestBody getBodyParams(Map<String,String> bodyParams){
        RequestBody body = null;
        FormBody.Builder formBody = new FormBody.Builder();
        if (bodyParams != null){
            Iterator<String> iterator = bodyParams.keySet().iterator();
            String key = "";
            while (iterator.hasNext()){
                key = iterator.next().toString();
                formBody.add(key,bodyParams.get(key));
            }
        }
        return formBody.build();
    }

    /**
     * 异步post 无headers
     * @param url
     * @param bodyParams
     * @param
     */

    public static void getAsyncPostBody(String url,Map<String,String> bodyParams){
        getInstance().onAsyncPOST_Body(url,bodyParams);

    }

    /**
     * 异步post 有headers
     * @param url
     * @param bodyParams
     * @param
     */

    public static void getAsyncPostBodyHeaders(String url,Map<String,String> bodyParams,Map<String,String> headersParams){
        getInstance().onAsyncPOST_BodyAndHeaders(url,bodyParams,headersParams);
    }

    /**
     * 设置
     * @param hedersParams
     * @return
     */

    private Headers getRequestHeaders(Map<String,String> hedersParams){
        Headers headers = null;
        Headers.Builder builder = new Headers.Builder();
        if (hedersParams != null){
            Iterator<String> iterator = hedersParams.keySet().iterator();
            while (iterator.hasNext()){
                String key = iterator.next();
                builder.add(key,hedersParams.get(key));
            }
        }
        headers = builder.build();
        return headers;
    }


    /**
     *  判断是否联网
     * @param context
     * @return
     */
    public static boolean isNetWorkAvailable(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null){
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()){
                if (networkInfo.getState() == NetworkInfo.State.CONNECTED){
                    return true;
                }
            }
        }
        return false;
    }

}
