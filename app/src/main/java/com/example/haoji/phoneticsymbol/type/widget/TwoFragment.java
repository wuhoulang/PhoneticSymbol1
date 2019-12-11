package com.example.haoji.phoneticsymbol.type.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.haoji.phoneticsymbol.R;
import com.example.haoji.phoneticsymbol.base.BaseFragment;
import com.example.haoji.phoneticsymbol.type.adapter.ClassifyPagerAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by HAOJI on 2019/8/22.
 */

@SuppressLint("ValidFragment")
public class TwoFragment extends BaseFragment {

    private static Context context;


    public TwoFragment() {
    }

    public static TwoFragment newInstance(Context context1) {
        context=context1;
        TwoFragment fragment = new TwoFragment();
        return fragment;
    }

    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.type_fragment, null);
        TabLayout tab_layout = view.findViewById(R.id.tab_layout);
        ViewPager vp= view.findViewById(R.id.vp_class);
        BookOneFragment bookOne = BookOneFragment.newInstance(context);
        BookTwoFragment booktwo = BookTwoFragment.newInstance(context);
        List<Fragment> list =new ArrayList<>();
        list.add(bookOne);
        list.add(booktwo);
        FragmentManager fm = getActivity().getSupportFragmentManager();
        List<String> list1 =new ArrayList<>();
        list1.add("四级");
        list1.add("六级");
        ClassifyPagerAdapter cp =new ClassifyPagerAdapter(context,list,fm,list1);
        vp.setAdapter(cp);
        tab_layout.setupWithViewPager(vp);
        return view;
    }


}
