//package zuo.biao.library.network_request;
//
//import android.app.Activity;
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Message;
//import android.support.annotation.Nullable;
//import android.support.v7.widget.DividerItemDecoration;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.ImageRequest;
//import com.android.volley.toolbox.JsonObjectRequest;
//import com.android.volley.toolbox.StringRequest;
//import com.android.volley.toolbox.Volley;
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
//import com.mirkowu.baselibrarysample.Adapter.RecyclerViewAdapter;
//import com.mirkowu.baselibrarysample.R;
//import com.mirkowu.baselibrarysample.bean.WheatherBean;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.util.List;
//
///**
// * Created by HAOJI on 2019/8/27.
// */
//
//public class VolleyActivity extends Activity {
//    private Context context=VolleyActivity.this;
//    private Button button;
//    private ImageView vollet_image;
//    private TextView id_Tv;
//    private static final int LIST=1;
//    private List<WheatherBean> userList;
//    private RecyclerView id_rv;
//    private Handler mHandler =new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            //switch语句
//            switch (msg.what) {
//                case LIST:
//                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
//                    id_rv.addItemDecoration(new DividerItemDecoration(context,DividerItemDecoration.VERTICAL));
//                    id_rv.setLayoutManager(linearLayoutManager);
//                     RecyclerViewAdapter rv =new RecyclerViewAdapter(userList,context);
//                    id_rv.setAdapter(rv);
//                    break;
////                case code:
////                    break;
////                case code:
////                    break;
//                default:
//                    break;
//            }
//        }
//    };
//
//
//
//    private Handler handler =new Handler(new Handler.Callback() {
//        @Override
//        public boolean handleMessage(Message message) {
//            switch (message.what) {
//                case LIST:
//                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
//                    id_rv.addItemDecoration(new DividerItemDecoration(context,DividerItemDecoration.VERTICAL));
//                    id_rv.setLayoutManager(linearLayoutManager);
//                    RecyclerViewAdapter rv =new RecyclerViewAdapter(userList,context);
//                    id_rv.setAdapter(rv);
//                    break;
//                default:
//                    break;
//            }
//            return false;
//        }
//    });
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if (handler!=null){
//            handler.removeMessages(LIST);
//        }
//    }
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.base_layout);
//        button=findViewById(R.id.id_volley);
//        vollet_image=findViewById(R.id.vollet_image);
//        id_rv=findViewById(R.id.id_rv);
//        id_Tv=findViewById(R.id.id_Tv);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.e("onclick","--");
//                requestInternet();
//
//            }
//        });
//    }
//
//    /**
//          volley get请求
//     **/
//
//    private void requestInternet() {
//        RequestQueue requestQueue = Volley.newRequestQueue(context);
//        StringRequest stringRequest =new StringRequest("http://guolin.tech/api/china", new Response.Listener<String>() {
//            @Override
//            public void onResponse(String s) {
//                Log.e("onResponse","s:"+s);
//                Gson gson =new Gson();
//                userList = gson.fromJson(s, new TypeToken<List<WheatherBean>>(){}.getType());
//
//                Log.e("ImageBea","----"+userList.size());
//                Message msg =new Message();
//                msg.what=LIST;
//                if(userList!=null) {
//                    handler.sendMessage(msg);
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError volleyError) {
//
//            }
//        });
//        requestQueue.add(stringRequest);
//    }
//
//    /**
//     * volley post 请求
//     */
//    private JSONObject json;
//    private void requestJsonObject() {
//        RequestQueue queue =Volley.newRequestQueue(context);
////        Map<String,String> params =new HashMap<>();
////        params.put("name","Li");
////        params.put("age","13");
//        try {
//             json =new JSONObject();
//            json.put("name","Li");
//            json.put("age","13");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        JsonObjectRequest jr =new JsonObjectRequest(Request.Method.POST, "", json, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject jsonObject) {
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError volleyError) {
//
//            }
//        });
//        queue.add(jr);
//    }
//
//    /**
//     * volley 请求网络图片框架
//     */
//
//    private void requestImage(){
//        RequestQueue queue =Volley.newRequestQueue(context);
//        ImageRequest imageRequest=new ImageRequest("http://pic.sc.chinaz.com/files/pic/pic9/201908/hpic1365.jpg", new Response.Listener<Bitmap>() {
//            @Override
//            public void onResponse(Bitmap bitmap) {
//                vollet_image.setImageBitmap(bitmap);
//            }
//        }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError volleyError) {
//
//            }
//        });
//        queue.add(imageRequest);
//    }
//
//
//}
