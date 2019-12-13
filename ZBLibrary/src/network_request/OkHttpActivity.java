package zuo.biao.library.network_request;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.mirkowu.baselibrarysample.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by HAOJI on 2019/8/29.
 */

public class OkHttpActivity extends Activity {
    private Context context=OkHttpActivity.this;
    private Button button;
    private ImageView vollet_image;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_layout);
        button=findViewById(R.id.id_volley);
        vollet_image=findViewById(R.id.vollet_image);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("onclick","--");
                requestGetOKhttp();
            }
        });
    }


    /**
     * okhttp get请求
     */
    private void requestGetOKhttp() {
            OkHttpClient okHttpClient = new OkHttpClient();
            Request request =new Request.Builder()
                    .url("http://www.uc123.com/")
                    .build();
            Call call=null;
            call=okHttpClient.newCall(request);
           call.enqueue(new Callback() {
               @Override
               public void onResponse(Call call, Response response) throws IOException {
                   if(response.isSuccessful()) {//回调的方法执行在子线程。
                       String responseData = response.body().string();
                       Log.d("responseData", "responseData:"+responseData);
                   }
               }
               @Override
               public void onFailure(Call call, IOException e) {
                   Log.d("kwwl", "获取数据失败了");

               }
           });
    }

    /**
     *  OkHttp post 请求
     */

    private void requestPostOKhttp(){
        OkHttpClient client =new OkHttpClient();
        FormBody.Builder formBody =new FormBody.Builder();
        formBody.add("","");
        Request request =new Request.Builder().url("http://www.uc123.com/").post(formBody.build()).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()) {//回调的方法执行在子线程。
                    String responseData = response.body().string();
                    Log.e("responseData", "responseData:"+responseData);
                }
            }
        });
    }

}
