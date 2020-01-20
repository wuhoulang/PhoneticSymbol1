package zuo.biao.library.util;

import android.util.Log;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
    private static String CHARSET = "utf-8";
    private static String TAG = "ShowDownLoadActivity";

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

        public static int uploadFile(File file,String imgUrl) {
            int res = 0;
            String result = null;
            String BOUNDARY = UUID.randomUUID().toString(); // 边界标识 随机生成
            String PREFIX = "--", LINE_END = "\r\n";
            String CONTENT_TYPE = "multipart/form-data"; // 内容类型

            try {
                URL url = new URL(imgUrl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(2000);
                conn.setConnectTimeout(2000);
                conn.setDoInput(true); // 允许输入流
                conn.setDoOutput(true); // 允许输出流
                conn.setUseCaches(false); // 不允许使用缓存
                conn.setRequestMethod("POST"); // 请求方式
                conn.setRequestProperty("Charset", CHARSET); // 设置编码
                conn.setRequestProperty("connection", "keep-alive");
                conn.setRequestProperty("Content-Type", CONTENT_TYPE + ";boundary="
                        + BOUNDARY);

                if (file != null) {
                    /**
                     * 当文件不为空时执行上传
                     */
                    DataOutputStream dos = new DataOutputStream(
                            conn.getOutputStream());
                    StringBuffer sb = new StringBuffer();
                    sb.append(PREFIX);
                    sb.append(BOUNDARY);
                    sb.append(LINE_END);
                    /**
                     * 这里重点注意： name里面的值为服务器端需要key 只有这个key 才可以得到对应的文件
                     * filename是文件的名字，包含后缀名
                     */

                    sb.append("Content-Disposition: form-data; name=\"file\"; filename=\""
                            + file.getName() + "\"" + LINE_END);
                    sb.append("Content-Type: application/octet-stream; charset="
                            + CHARSET + LINE_END);
                    sb.append(LINE_END);
                    dos.write(sb.toString().getBytes());
                    InputStream is = new FileInputStream(file);
                    byte[] bytes = new byte[1024];
                    int len = 0;
                    while ((len = is.read(bytes)) != -1) {
                        dos.write(bytes, 0, len);
                    }
                    is.close();
                    dos.write(LINE_END.getBytes());
                    byte[] end_data = (PREFIX + BOUNDARY + PREFIX + LINE_END)
                            .getBytes();
                    dos.write(end_data);
                    dos.flush();
                    /**
                     * 获取响应码 200=成功 当响应成功，获取响应的流
                     */
                    res = conn.getResponseCode();
                    Log.e(TAG, "response code:" + res);
                    if (res == 200) {
                        Log.e(TAG, "request success");
                        InputStream input = conn.getInputStream();
                        StringBuffer sb1 = new StringBuffer();
                        int ss;
                        while ((ss = input.read()) != -1) {
                            sb1.append((char) ss);
                        }
                        result = sb1.toString();
                        Log.e(TAG, "result : " + result);
                    } else {
                        Log.e(TAG, "request error");
                    }
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return res;
        }



}
