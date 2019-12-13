//package zuo.biao.library.network_request;
//
//import android.app.Activity;
//import android.graphics.Bitmap;
//import android.media.MediaMetadataRetriever;
//import android.os.Bundle;
//import android.os.Environment;
//import android.support.annotation.Nullable;
//import android.util.Log;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.MediaController;
//import android.widget.VideoView;
//
//import com.mirkowu.baselibrarysample.R;
//
///**
// * Created by HAOJI on 2019/9/2.
// */
//
//public class VideoViewActivity extends Activity implements View.OnClickListener {
//    private VideoView videoView;
//    private ImageView imageView;
//    private String url;
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.videoview);
//        initview();
//        initData();
//        initImage();
//    }
//
//    private void initImage() {
//        videoView.setVisibility(View.GONE);
//        imageView.setVisibility(View.VISIBLE);
//
//        /**
//         * MediaMetadataRetriever class provides a unified interface for retrieving
//         * frame and meta data from an input media file.
//         */
//        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
//        mmr.setDataSource(url);
//
//        Bitmap bitmap = mmr.getFrameAtTime();//获取第一帧图片
//        imageView.setImageBitmap(bitmap);
//        mmr.release();//释放资源
//    }
//
//
//    private void initData() {
//        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
//        Log.e("path","path:"+path);
//        String path2="/video/UC-download.mp4";
//         url =path+path2;
//        Log.e("path","url:"+url);
//        videoView.setVideoPath(url);
//        MediaController mediaController =new MediaController(VideoViewActivity.this);
//        videoView.setMediaController(mediaController);
//        videoView.requestFocus();
//    }
//
//    private void initview() {
//        videoView=findViewById(R.id.id_vv);
//        imageView=findViewById(R.id.id_iv);
//        imageView.setOnClickListener(this);
//    }
//
//    @Override
//    public void onClick(View v) {
//        if(v.getId()==R.id.id_iv){
//            videoView.setVisibility(View.VISIBLE);
//            imageView.setVisibility(View.GONE);
//            videoView.start();
//        }
//    }
//}
