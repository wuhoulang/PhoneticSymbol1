package com.example.haoji.phoneticsymbol.component;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.IOException;

/**
 * Created by HAOJI on 2019/9/7.
 */

public class MusicServices extends Service {
    private static final String TAG = "myservice";
    public MyBinder mbinder = new MyBinder();
    private MediaPlayer mediaPlayer =new MediaPlayer();
    private String path;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        path = intent.getStringExtra("path");
        Log.e(TAG, "path:" +path);
        Log.e(TAG, "onBind" );
        prepare_play();
        return mbinder;
    }

    public class MyBinder extends Binder {
        public MusicServices getService() {
            return MusicServices.this;
        }

        public void start(){
            Log.e(TAG, "start:" );
        }
        public void end(){
            Log.e(TAG, "end:" );
        }


    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate" );
    }

    public void prepare_play(){
        try {
            Uri uri = Uri.parse(path);
            mediaPlayer.reset();
            mediaPlayer.setDataSource(this,uri);
            mediaPlayer.prepareAsync();
            Log.e(TAG,"-prepare_play-");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void play(){
        if(!mediaPlayer.isPlaying()){
             mediaPlayer.start();
            Log.e(TAG,"play--");
        }
    }

    public void stop(){
        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            Log.e(TAG,"stop");
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
            Log.e(TAG,"onDestroy");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        if (mediaPlayer.isPlaying()){
            mediaPlayer.release();
        }
        Log.e(TAG,"onUnbind");
        mediaPlayer=null;
        return super.onUnbind(intent);
    }

}
