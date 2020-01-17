package com.example.haoji.phoneticsymbol.type.widget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.haoji.phoneticsymbol.R;
import com.example.haoji.phoneticsymbol.myContents.Contents;
import com.example.haoji.phoneticsymbol.myContents.ContentsJson;
import com.example.haoji.phoneticsymbol.type.adapter.LearnDownRecyclerViewAdapter;
import com.ipaulpro.afilechooser.utils.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import zuo.biao.library.ui.RoundCheckBox;
import zuo.biao.library.util.UploadUtil;
import zuo.biao.library.util.ZbLog;

/**
 * Created by HAOJI on 2020/1/7.
 */

public class ShowDownLoadActivity extends Activity {

    @BindView(R.id.ry_downLoad)
    RecyclerView ry_downLoad;

    @BindView(R.id.iv_hover_black)
    ImageView iv_hover_black;

    @BindView(R.id.btn_all_select)
    Button btn_all_select;

    @BindView(R.id.rcb_check)
    RoundCheckBox rcb_check;

    private Context context = ShowDownLoadActivity.this;
    private LearnDownRecyclerViewAdapter ldm;

    private static final String TAG = "ShowDownLoadActivity";
    private static final int REQUEST_CODE = 6384; // onActivityResult request

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_download);
        ButterKnife.bind(this);
        initData();
        initListener();
    }

    private void initListener() {

    }

    private void initData() {
        ldm = new LearnDownRecyclerViewAdapter(context, rcb_check);
        LinearLayoutManager ll = new LinearLayoutManager(context);
        ry_downLoad.setLayoutManager(ll);
        ry_downLoad.setAdapter(ldm);
    }

    @OnClick({R.id.iv_hover_black,R.id.btn_all_select})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_hover_black:
                finish();
                break;
            case R.id.btn_all_select:
                showChooser();
                ZbLog.e(TAG,"ENTER btn_all_select");
                break;
            default:
                break;
        }
    }

    private void showChooser() {
        // Use the GET_CONTENT intent from the utility class
        Intent target = FileUtils.createGetContentIntent();
        // Create the chooser Intent
        Intent intent = Intent.createChooser(
                target, "什么");
        try {
            startActivityForResult(intent, REQUEST_CODE);
        } catch (ActivityNotFoundException e) {
            // The reason for the existence of aFileChooser
        }
    }


    @SuppressLint("LongLogTag")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_CODE:
                // If the file selection was successful
                if (resultCode == RESULT_OK) {
                    if (data != null) {
                        // Get the URI of the selected file
                        final Uri uri = data.getData();
                        Log.i(TAG, "Uri = " + uri.toString());
                        try {
                            // Get the file path from the URI
                            final String path = FileUtils.getPath(this, uri);
                            Toast.makeText(ShowDownLoadActivity.this,
                                    "File Selected: " + path, Toast.LENGTH_LONG).show();
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                     File file =new File(path);
                                    try {
                                        Log.e("ShowDownLoadActivity", "path:" + path);
                                        UploadUtil.getInstance().upload(ContentsJson.UP_FOLDER, file);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }).start();
                        } catch (Exception e) {
                            Log.e("ShowDownLoadActivity", "File select error", e);
                        }
                    }
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}
