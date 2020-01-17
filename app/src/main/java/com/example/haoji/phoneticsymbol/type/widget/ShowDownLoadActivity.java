package com.example.haoji.phoneticsymbol.type.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.example.haoji.phoneticsymbol.R;
import com.example.haoji.phoneticsymbol.type.adapter.LearnDownRecyclerViewAdapter;

import java.net.URLEncoder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zuo.biao.library.ui.RoundCheckBox;
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

    @OnClick({R.id.iv_hover_black})
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.iv_hover_black:
                finish();
                break;
            case R.id.btn_all_select:
                break;
            default:
                break;
        }
    }

}
