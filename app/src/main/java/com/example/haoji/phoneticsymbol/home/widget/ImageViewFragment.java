package com.example.haoji.phoneticsymbol.home.widget;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.haoji.phoneticsymbol.myContents.Contents;
import com.example.haoji.phoneticsymbol.R;
import com.example.haoji.phoneticsymbol.component.MusicServices;
import com.example.haoji.phoneticsymbol.home.bean.GoodsBean;

import static android.content.Context.BIND_AUTO_CREATE;

/**
 * Created by HAOJI on 2019/10/23.
 */

@SuppressLint("ValidFragment")
public class ImageViewFragment extends Fragment implements View.OnClickListener {

    private GoodsBean goodsBean;
    private ImageView imagview,iv_show_biao;
    private TextView id_english;
    private TextView id_chinese;
    private Button id_play;
    private View view;
    private static final int CONTENT_bIT = 1;
    private Context context;
    private MediaPlayer mediaPlayer;
    private String path;
    private MusicServices ms;
    private int pos;
    private ServiceConnection con = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MusicServices.MyBinder myBinder = (MusicServices.MyBinder) iBinder;
            ms = myBinder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    public ImageViewFragment(GoodsBean goodsBean, Context context, MusicServices musicServices,int position) {
        this.goodsBean = goodsBean;
        this.context = context;
        this.ms = musicServices;
        this.pos = position;
    }

    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what == CONTENT_bIT) {
                Log.e("initMediaPlayer", "goodsBean--music:" + goodsBean.getMusic());
                id_english.setText(goodsBean.getEnglishname());
                id_chinese.setText(goodsBean.getChinesename());

                Glide.with(context).load(Contents.BASE_URl_IMAGE + goodsBean.getPicture()).into(imagview);
            }
            return false;
        }
    });

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.imageview_show, container, false);
        initview();
        return view;
    }

    @SuppressLint("WrongViewCast")
    private void initview() {
        imagview = view.findViewById(R.id.id_imageview_show2);
        iv_show_biao = view.findViewById(R.id.iv_show_biao);
        id_english = view.findViewById(R.id.id_english);
        id_chinese = view.findViewById(R.id.id_chinese);
        id_play = view.findViewById(R.id.id_play);
        id_play.setOnClickListener(this);
        path = goodsBean.getMusic();
        Intent intent2 = new Intent(context, MusicServices.class);
        intent2.putExtra("path", goodsBean.getMusic());
        getActivity().bindService(intent2, con, BIND_AUTO_CREATE);
        Message message = new Message();
        message.what = CONTENT_bIT;
        mHandler.sendMessage(message);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_play:
                ms.play();
//                play();
                Log.e("initMediaPlayer", "onclick");
                break;
            default:
                break;
        }
    }

    private void initMediaPlayer() {
        path = goodsBean.getMusic();
        Log.e("initMediaPlayer", "------------------------path-----------------------------" + path);
        Uri uri = Uri.parse(path);
        mediaPlayer = MediaPlayer.create(context, uri);
//        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+ "/music.mp3");
//        try {
////            mediaPlayer.reset();
////            mediaPlayer.setDataSource(context, uri);
//            mediaPlayer.prepare();
//            Log.e("initMediaPlayer", "prepare");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getActivity().unbindService(con);
//        if (mediaPlayer.isPlaying()) {
//            mediaPlayer.stop();
//        }
//        mediaPlayer.release();
//        mediaPlayer = null;
//        Log.e("initMediaPlayer", "onDestroyView");
    }
}
