package com.example.haoji.phoneticsymbol.study.widget;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.example.haoji.phoneticsymbol.R;
import com.example.haoji.phoneticsymbol.home.widget.MainActivity;
import com.example.haoji.phoneticsymbol.study.adapter.ReadPagerAdapter;
import com.example.haoji.phoneticsymbol.study.widget.show.ShowFourFragment;
import com.example.haoji.phoneticsymbol.study.widget.show.ShowOneFragment;
import com.example.haoji.phoneticsymbol.study.widget.show.ShowThreeFragment;
import com.example.haoji.phoneticsymbol.study.widget.show.ShowTwoFragment;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import zuo.biao.library.util.ZbLog;

/**
 * Created by HAOJI on 2019/11/6.
 */

public class ReadBookActivity extends FragmentActivity {

    private Context context = ReadBookActivity.this;

    @BindView(R.id.tab_book_layout)
    public TabLayout tab_book_layout;

    @BindView(R.id.show_book_vp)
    public ViewPager show_book_vp;

    @BindView(R.id.id_now_pay)
    public Button id_now_pay;

    @BindView(R.id.id_add_study)
    public Button id_add_study;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_book);
        ButterKnife.bind(this);
        initView();
    }

    @OnClick({R.id.id_now_pay, R.id.id_add_study})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.id_now_pay:
                ZbLog.e("ReadBookActivity", "----id_now_pay--------");
                break;
            case R.id.id_add_study:
                ZbLog.e("ReadBookActivity", "----id_add_study--------");
                break;
            default:
                break;
        }
    }

    private void initView() {
        tab_book_layout = findViewById(R.id.tab_book_layout);
        show_book_vp = findViewById(R.id.show_book_vp);
        ShowOneFragment one = ShowOneFragment.newInstance(context);
        ShowTwoFragment two = ShowTwoFragment.newInstance(context);
        ShowThreeFragment three = ShowThreeFragment.newInstance(context);
        ShowFourFragment four = ShowFourFragment.newInstance(context);
        List<Fragment> list = new ArrayList<>();
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);
        List<String> list1 = new ArrayList<>();
        String[] s = {"字幕听力", "名师视频", "配套练习", "配套资源"};
        list1.addAll(Arrays.asList(s));
        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        ReadPagerAdapter readPagerAdapter = new ReadPagerAdapter(context, list, manager, list1);
        show_book_vp.setAdapter(readPagerAdapter);
        tab_book_layout.setupWithViewPager(show_book_vp);
    }


}
