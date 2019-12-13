package com.example.haoji.phoneticsymbol.study.widget.show;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.haoji.phoneticsymbol.R;


/**
 * Created by HAOJI on 2019/11/22.
 */

public class VideoViewActivity extends Activity {

    private VideoView vv_teacher;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        隐藏标题栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//
        setContentView(R.layout.video_play);
        vv_teacher = findViewById(R.id.vv_teacher);
        MediaController mediaController = new MediaController(this);
        vv_teacher.setMediaController(mediaController);
        vv_teacher.setVideoPath("https://flv2.bn.netease.com/videolib1/1811/26/OqJAZ893T/HD/OqJAZ893T-mobile.mp4");
        vv_teacher.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("PY", "onDestroy");
        if (vv_teacher != null) {
            vv_teacher.stopPlayback();
            vv_teacher = null;
        }
    }
}
