//package zuo.biao.library.network_request;
//
//import android.app.Activity;
//import android.content.Context;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageView;
//
//import com.bumptech.glide.Glide;
//import com.bumptech.glide.load.engine.DiskCacheStrategy;
//import com.bumptech.glide.request.RequestOptions;
//import com.mirkowu.baselibrarysample.R;
//
///**
// * Created by HAOJI on 2019/8/28.
// */
//
//public class GlideActivity extends Activity {
//    private Context context=GlideActivity.this;
//    private Button button;
//    private ImageView vollet_image;
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.base_layout);
//        button=findViewById(R.id.id_volley);
//        vollet_image=findViewById(R.id.vollet_image);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.e("onclick","--");
//                requestImage();
//            }
//        });
//    }
//   // 点击按钮加载的时候，需等一会才显示出来，因为网络加载需要时间，
//    private void requestImage() {
//        String url = "http://cn.bing.com/az/hprichbg/rb/Dongdaemun_ZH-CN10736487148_1920x1080.jpg";
//        /**
//         * 普通用法，有延时
//         */
////        Glide.with(context).load(url).into(vollet_image);
//        /**
//         *  占位图,并取消缓存，让占位图可以显示出来   ----固定大小.override(100, 100)--
//         */
//
//          Glide.with(context).load(url).apply(new RequestOptions().placeholder(R.drawable.flower).diskCacheStrategy(DiskCacheStrategy.NONE)).into(vollet_image);
//
////        // 加载本地图片
////        File file = new File(getExternalCacheDir() + "/image.jpg");
////        Glide.with(this).load(file).into(vollet_image);
//
//// 加载应用资源
////        int resource = R.drawable.image;
////        Glide.with(this).load(resource).into(vollet_image);
////
////// 加载二进制流
////        byte[] image = getImageBytes();
////        Glide.with(this).load(image).into(vollet_image);
////
////// 加载Uri对象
////        Uri imageUri = getImageUri();
////        Glide.with(this).load(imageUri).into(vollet_image);
//
//    }
//
//
//}
