package zuo.biao.library.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

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

    private UploadUtil(){
        okHttpClient =new OkHttpClient();
    }

    private static class UploadUtilgetInstance{
        private static final UploadUtil uploadUtil=new UploadUtil();
    }

    private UploadUtil getInstance(){
        return UploadUtilgetInstance.uploadUtil;
    }


    private ResponseBody upload(String url, File file) throws IOException{
        okHttpClient =new OkHttpClient();
        RequestBody requestBody =new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file",file.getName(), RequestBody.create(MediaType.parse("multipart/form-data"),file)).build();
        Request request =new Request.Builder().header("Authorization", "ClientID" + UUID.randomUUID())
                .url("")
                .post(requestBody)
                .build();
        Response response= okHttpClient.newCall(request).execute();
        if (!response.isSuccessful())
            throw new IOException("Unexpected code " + response);
        return response.body();
    }

}
