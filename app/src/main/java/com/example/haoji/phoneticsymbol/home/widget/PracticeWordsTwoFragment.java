package com.example.haoji.phoneticsymbol.home.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;

import com.example.haoji.phoneticsymbol.R;
import com.example.haoji.phoneticsymbol.base.BaseFragment;
import com.example.haoji.phoneticsymbol.myContents.ContentsJson;

import java.util.HashMap;

import zuo.biao.library.util.ZbLog;

/**
 * Created by HAOJI on 2019/12/14.
 */

@SuppressLint("ValidFragment")
public class PracticeWordsTwoFragment extends BaseFragment {

    private static Context context;
    private ImageView iv_practice,iv_practice_show;
    private VideoView vv;

    public PracticeWordsTwoFragment(){

    }

    public static PracticeWordsTwoFragment newInstance(Context mContext){
        context = mContext;
        return new PracticeWordsTwoFragment();
    }

    @Override
    public View initView() {
        View view =View.inflate(context, R.layout.practice_fragment,null);
        vv = view.findViewById(R.id.vv_practice_one);
        iv_practice = view.findViewById(R.id.iv_practice);
        iv_practice_show = view.findViewById(R.id.iv_practice_show);
        vv.setVideoPath(ContentsJson.BASE_ONE_JSON_VIDEO_REAL);
        initListener();
        initImage();
        return view;
    }

    private void initListener() {
        vv.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                iv_practice.setVisibility(View.VISIBLE);
                ZbLog.e("PracticeWordsFragment","--onCompletion----");
            }
        });
        iv_practice.setOnClickListener((View.OnClickListener) context);
        iv_practice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vv.setVisibility(View.VISIBLE);
                iv_practice_show.setVisibility(View.GONE);
                iv_practice.setVisibility(View.GONE);
                vv.start();
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (vv != null) {
            vv.stopPlayback();
            vv = null;
        }
    }

    private void initImage() {
        vv.setVisibility(View.GONE);
        iv_practice_show.setVisibility(View.VISIBLE);
        /**
         * MediaMetadataRetriever class provides a unified interface for retrieving
         * frame and meta data from an input media file.
         */
        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
        mmr.setDataSource(ContentsJson.BASE_ONE_JSON_VIDEO_REAL,new HashMap<String, String>());

        Bitmap bitmap = mmr.getFrameAtTime();//获取第一帧图片
        iv_practice_show.setImageBitmap(bitmap);
        mmr.release();//释放资源
    }
}
