package com.example.haoji.phoneticsymbol.main.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.haoji.phoneticsymbol.R;
import com.example.haoji.phoneticsymbol.main.adapter.SubRecyclerViewAdapter;
import com.example.haoji.phoneticsymbol.study.adapter.StudyRecyclerViewAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by HAOJI on 2019/12/18.
 */

public class SubscribeActivity extends Activity {

    @BindView(R.id.ry_subscribe)
    RecyclerView ry_subscribe;

    private Context context = SubscribeActivity.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscribe);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        LinearLayoutManager lm = new LinearLayoutManager(context);
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        ry_subscribe.setLayoutManager(lm);
        SubRecyclerViewAdapter srv = new SubRecyclerViewAdapter(context);
        ry_subscribe.setAdapter(srv);
    }
}
