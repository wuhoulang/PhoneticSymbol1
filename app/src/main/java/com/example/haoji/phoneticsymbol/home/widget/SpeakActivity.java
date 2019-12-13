package com.example.haoji.phoneticsymbol.home.widget;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.haoji.phoneticsymbol.myContents.ContentsJson;
import com.example.haoji.phoneticsymbol.R;
import com.example.haoji.phoneticsymbol.component.MusicServices;
import com.example.haoji.phoneticsymbol.home.bean.GoodsBean;
import com.example.haoji.phoneticsymbol.main.widget.RegisterActivity;


/**
 * Created by HAOJI on 2019/10/17.
 */

public class SpeakActivity extends FragmentActivity implements View.OnClickListener {
    private GoodsBean goodsBean;
    private TextView id_title;
    private Button btn_next, btn_last;
    private ImageView id_title_p;
    private ContentLoadingProgressBar id_progressBar;
    private Context context = SpeakActivity.this;
    private int min;
    private ImageViewFragment imageViewFragment;
    private MusicServices service;
    public boolean pro = false;
    public static final int OBX = 0;

    private Handler handler =new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            if (message.what==OBX){
                id_title.setText("前元音");
                Glide.with(context).load(ContentsJson.BASE + goodsBean.getYinbiao()).into(id_title_p);
            }
            return false;
        }
    });


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speak_fragment);
        min = 20;
        id_title = findViewById(R.id.id_title);
        btn_last = findViewById(R.id.btn_last);
        btn_next = findViewById(R.id.btn_next);
        id_title_p = findViewById(R.id.id_title_p);
        id_progressBar = findViewById(R.id.id_progressBar);
        btn_next.setOnClickListener(this);
        btn_last.setOnClickListener(this);
        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 15);
        goodsBean = (GoodsBean) intent.getSerializableExtra("name");
        if (goodsBean != null) {
            switch (position) {
                case 0:
                    id_title.setText("前元音");
                    sendMessage();
                    break;
                case 1:
                    id_title.setText("中元音");
                    sendMessage();
                    break;
                case 2:
                    id_title.setText("后元音");
                    sendMessage();
                    break;
                case 3:
                    id_title.setText("开合双元音");
                    sendMessage();
                    break;
                case 4:
                    id_title.setText("开合双元音");
                    sendMessage();
                    break;
                case 5:
                    id_title.setText("爆破音");
                    sendMessage();
                    break;
                case 6:
                    id_title.setText("浊辅音");
                    sendMessage();
                    break;
                case 7:
                    id_title.setText("清辅音");
                    sendMessage();
                    break;
                case 8:
                    id_title.setText("清辅音");
                    sendMessage();
                    break;
                case 9:
                    id_title.setText("浊辅音");
                    sendMessage();
                    break;
                case 10:
                    id_title.setText("清辅音");
                    sendMessage();
                    break;
                case 11:
                    id_title.setText("浊辅音");
                    sendMessage();
                    break;
                case 12:
                    id_title.setText("鼻音");
                    sendMessage();
                    break;
                case 13:
                    id_title.setText("浊辅音");
                    sendMessage();
                    break;
                default:
                    id_title.setText("元音");
                    sendMessage();
                    break;
            }

        }
        imageViewFragment = new ImageViewFragment(goodsBean, context, service, position);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(R.id.id_imageview_show, imageViewFragment);
        ft.commit();
    }

    private void sendMessage() {
        Message msg =new Message();
        msg.what = OBX ;
        handler.sendMessage(msg);
    }

    public class MyAsyncTask extends AsyncTask<String, String, String> {

        public boolean pro1;

        public MyAsyncTask(boolean pro) {
            pro1 = pro;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            synchronized (RegisterActivity.class) {
                int count = 0;
                int length = 1;
                if (pro1 == true) {
                    if (min == 100) {
                        min = 0;
                    }
                    try {
                        while (count < 20) {
                            count = count + 1;
                            min = min + length;
                            Log.e("SpeakActivity", "count:" + count);
                            publishProgress(String.valueOf(min));
                            Thread.sleep(2);
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    if (min!=20){
                        try {
                            while (count < 20) {
                                count = count + 1;
                                min = min - length;
                                Log.e("SpeakActivity", "count:" + count);
                                publishProgress(String.valueOf(min));
                                Thread.sleep(25);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }


            return null;
    }


    @Override
    protected void onProgressUpdate(String... values) {
        id_progressBar.setProgress(Integer.parseInt(values[0]));
        Log.e("SpeakActivity", "onProgressUpdate:" + values[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

}

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_next:
                pro = true;
                new MyAsyncTask(pro).execute();
                break;
            case R.id.btn_last:
                pro = false;
                new MyAsyncTask(pro).execute();
                break;
            default:
                break;
        }
    }

}
