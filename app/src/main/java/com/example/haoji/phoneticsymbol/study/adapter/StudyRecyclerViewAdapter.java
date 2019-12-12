package com.example.haoji.phoneticsymbol.study.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.haoji.phoneticsymbol.R;
import com.example.haoji.phoneticsymbol.study.need.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import static com.youth.banner.BannerConfig.CIRCLE_INDICATOR;

/**
 * Created by HAOJI on 2019/12/12.
 */

public class StudyRecyclerViewAdapter extends RecyclerView.Adapter<StudyRecyclerViewAdapter.ViewHolder> {

    private  ArrayList<String> images;
    private  ArrayList<String> titles;
    private  Banner banner;
    private  Context context;
    private int currentType = 0;

    private static final int BANNER = 0;
    private static final int TYPE = 1;
    private static final int SHHOW = 2;
    private static final int BOOK = 3;
    private ViewHolder viewHolder;

    public StudyRecyclerViewAdapter(Context context){
        this.context =context;
         images =new ArrayList<>();
        images.add("http://192.168.0.44:80/atguigu/img_biao/apple.jpg");
        images.add("http://192.168.0.44:80/atguigu/img_biao/ba.jpg");
        images.add("http://192.168.0.44:80/atguigu/img_biao/bat.png");
         titles =new ArrayList<>();
        images.add("什么1");
        images.add("什么2");
        images.add("什么3");
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==BANNER){
            View view = LayoutInflater.from(context).inflate(R.layout.list_banner,parent,false);
             viewHolder =new ViewHolder(view);
        }else if (viewType == TYPE) {
            View view = LayoutInflater.from(context).inflate(R.layout.activity_hover,parent,false);
            viewHolder =new ViewHolder(view);
        } else if (viewType == SHHOW) {
            View view = LayoutInflater.from(context).inflate(R.layout.activity_hover,parent,false);
            viewHolder =new ViewHolder(view);
        }else if (viewType == BOOK){
            View view = LayoutInflater.from(context).inflate(R.layout.activity_hover,parent,false);
            viewHolder =new ViewHolder(view);
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
           if (position == 0){
               //设置banner样式
               banner.setBannerStyle(CIRCLE_INDICATOR);
               //设置图片加载器
               banner.setImageLoader(new GlideImageLoader());
               //设置图片集合
               banner.setImages(images);
               //设置banner动画效果
               banner.setBannerAnimation(Transformer.DepthPage);
//               设置标题集合（当banner样式有显示title时）
               banner.setBannerTitles(titles);
               //设置自动轮播，默认为true
               banner.isAutoPlay(false);
               //设置轮播时间
               banner.setDelayTime(5000);
               //设置指示器位置（当banner模式中有指示器时）
               banner.setIndicatorGravity(BannerConfig.CENTER);
               //banner设置方法全部调用完毕时最后调用
               banner.start();
           }
    }


    @Override
    public int getItemViewType(int position) {
        switch (position){
            case BANNER :
                currentType = BANNER;
                break;
            case TYPE :
                currentType = TYPE;
                break;
            case SHHOW :
                currentType = SHHOW;
                break;
            case BOOK :
                currentType = BOOK;
                break;
        }
        return currentType;
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View view) {
            super(view);
             banner = view.findViewById(R.id.banner);
        }
    }

}
