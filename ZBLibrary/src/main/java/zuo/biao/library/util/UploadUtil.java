package zuo.biao.library.util;

import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by HAOJI on 2019/9/3.
 */

public class UploadUtil {

    private OkHttpClient okHttpClient;

    private UploadUtil() {
        okHttpClient = new OkHttpClient();
    }

    private static class UploadUtilgetInstance {
        private static final UploadUtil uploadUtil = new UploadUtil();
    }

    public static UploadUtil getInstance() {
        return UploadUtilgetInstance.uploadUtil;
    }

    public void upload(String url, File file) throws IOException {
        okHttpClient = new OkHttpClient();
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file", URLEncoder.encode(file.getName()), RequestBody.create(MediaType.parse("application/x-www-form-urlencoded;charset=utf-8"), file)).build();
        Log.e("ShowDownLoadActivity", "file.getName():" + file.getName());
        Request request = new Request.Builder().header("Authorization", "ClientID" + UUID.randomUUID())
                .url(url)
                .post(requestBody)
                .build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            if(response.isSuccessful()){
                String result = response.body().string();
                Log.e("ShowDownLoadActivity", "result" + result);
            }
            response.body().close();
        } catch (Exception e) {
            //TODO
        }
    }

}
