package com.example.haoji.phoneticsymbol.type.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.haoji.phoneticsymbol.R;
import com.example.haoji.phoneticsymbol.type.adapter.LearnMeRecyclerViewAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by HAOJI on 2019/12/11.
 */

public class LearningMaterialaActivity extends Activity {

    @BindView(R.id.rv_learn)
    RecyclerView rv_learn;

    @BindView(R.id.iv_learn_back)
    ImageView iv_learn_back;

    private Context context =LearningMaterialaActivity.this;
    private SwipeRefreshLayout sf_learn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_materiala);
        ButterKnife.bind(this);

        LinearLayoutManager manager =new LinearLayoutManager(context);
        rv_learn.setLayoutManager(manager);
        LearnMeRecyclerViewAdapter lv =new LearnMeRecyclerViewAdapter(context);
        rv_learn.setAdapter(lv);

         sf_learn =findViewById(R.id.sf_learn);
        sf_learn.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_blue_bright, android.R.color.holo_blue_bright,
                android.R.color.holo_blue_bright);

        iv_learn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        sf_learn.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        sf_learn.setRefreshing(false);
                        Toast.makeText(context, "刷新成功", Toast.LENGTH_SHORT).show();
                    }
                },3000);
            }
        });


    }
}
