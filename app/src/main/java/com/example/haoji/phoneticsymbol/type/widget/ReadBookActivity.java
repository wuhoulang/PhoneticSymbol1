package com.example.haoji.phoneticsymbol.type.widget;

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
import com.example.haoji.phoneticsymbol.type.adapter.ReadPagerAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by HAOJI on 2019/11/6.
 */

public class ReadBookActivity extends FragmentActivity {

    private Context context = ReadBookActivity.this;
    private Button id_now_pay;
    private TabLayout tab_book_layout;
    private ViewPager show_book_vp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_book);
        initView();
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

    private void initView() {
        tab_book_layout = findViewById(R.id.tab_book_layout);
        show_book_vp = findViewById(R.id.show_book_vp);
        id_now_pay = findViewById(R.id.id_now_pay);

        id_now_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }


}
