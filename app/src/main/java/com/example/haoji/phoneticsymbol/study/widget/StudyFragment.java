package com.example.haoji.phoneticsymbol.study.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.haoji.phoneticsymbol.R;
import com.example.haoji.phoneticsymbol.base.BaseFragment;
import com.example.haoji.phoneticsymbol.home.widget.HomeFragment;
import com.example.haoji.phoneticsymbol.study.adapter.StudyRecyclerViewAdapter;

import zuo.biao.library.util.ZbLog;

/**
 * Created by HAOJI on 2019/12/12.
 */

@SuppressLint("ValidFragment")
public class StudyFragment extends BaseFragment {

    private static Context context;
    private View view;
    private RecyclerView rv_study;

    public StudyFragment() {
    }

    public static StudyFragment newInstance(Context mContext) {
        context = mContext;
        StudyFragment fragment = new StudyFragment();
        return fragment;
    }

    @Override
    public View initView() {
        view = View.inflate(context, R.layout.fragment_study, null);
        init();
        return view;
    }

    private void init() {
        rv_study = view.findViewById(R.id.rv_study);
        LinearLayoutManager lm = new LinearLayoutManager(context);
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        rv_study.setLayoutManager(lm);
        StudyRecyclerViewAdapter srv = new StudyRecyclerViewAdapter(context);
        rv_study.setAdapter(srv);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ZbLog.e("StudyFragment","----ondestroy-------");
    }
}
