package com.example.haoji.phoneticsymbol.type.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.haoji.phoneticsymbol.R;
import com.example.haoji.phoneticsymbol.base.BaseFragment;
import com.example.haoji.phoneticsymbol.type.adapter.TypeGridViewAdapter;
import com.example.haoji.phoneticsymbol.type.adapter.TypeGridViewAdapterFour;
import com.example.haoji.phoneticsymbol.type.adapter.TypeGridViewAdapterThree;
import com.example.haoji.phoneticsymbol.type.adapter.TypeGridViewAdapterTwo;

import zuo.biao.library.util.ZbLog;

/**
 * Created by HAOJI on 2019/12/9.
 */

public class TwoNewFragment extends BaseFragment {

    public static Context context;
    private SwipeRefreshLayout swipeRefreshLayout;
    private GridView broadcast;
    private GridView speak;
    private GridView videl;
    private GridView brand;

    public TwoNewFragment() {

    }

    public static TwoNewFragment newInstance(Context mContext) {
        context = mContext;
        TwoNewFragment newFragment = new TwoNewFragment();
        return newFragment;
    }

    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.two_new_fragment, null);

        swipeRefreshLayout = view.findViewById(R.id.main_srl);
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light, android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                        Toast.makeText(context, "刷新成功", Toast.LENGTH_SHORT).show();
                    }
                }, 3000);
            }
        });

        broadcast = view.findViewById(R.id.gv_broadcast);
        broadcast.setSelector(new ColorDrawable(Color.TRANSPARENT));

        speak = view.findViewById(R.id.gv_speak);
        speak.setSelector(new ColorDrawable(Color.TRANSPARENT));

        videl = view.findViewById(R.id.gv_video);
        videl.setSelector(new ColorDrawable(Color.TRANSPARENT));

        brand = view.findViewById(R.id.gv_brand);
        brand.setSelector(new ColorDrawable(Color.TRANSPARENT));

        TypeGridViewAdapter typeGridViewAdapter = new TypeGridViewAdapter(context);
        broadcast.setAdapter(typeGridViewAdapter);

        TypeGridViewAdapterTwo two = new TypeGridViewAdapterTwo(context);
        speak.setAdapter(two);

        TypeGridViewAdapterThree three = new TypeGridViewAdapterThree(context);
        videl.setAdapter(three);

        TypeGridViewAdapterFour four = new TypeGridViewAdapterFour(context);
        brand.setAdapter(four);

        initListener();

        return view;
    }

    private void initListener() {

        broadcast.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position < 9) {
                    Intent intent = new Intent(context, LearningMaterialaActivity.class);
                    context.startActivity(intent);
                }
            }
        });

        videl.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position < 9) {
                    Intent intent = new Intent(context, LearningMaterialaActivity.class);
                    context.startActivity(intent);
                }
            }
        });

        brand.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position < 9) {
                    Intent intent = new Intent(context, LearningMaterialaActivity.class);
                    context.startActivity(intent);
                }
            }
        });

        speak.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position < 9) {
                    Intent intent = new Intent(context, LearningMaterialaActivity.class);
                    context.startActivity(intent);
                }
            }
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ZbLog.e("TwoNewFragment","----ondestroy-------");
    }
}
