package com.example.haoji.phoneticsymbol.study.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.haoji.phoneticsymbol.R;
import com.example.haoji.phoneticsymbol.myContents.Contents;
import com.example.haoji.phoneticsymbol.myContents.ContentsJson;
import com.example.haoji.phoneticsymbol.study.need.GlideImageLoader;
import com.example.haoji.phoneticsymbol.study.widget.MatingActivity;
import com.example.haoji.phoneticsymbol.study.widget.need.ChildRecyclerView;
import com.example.haoji.phoneticsymbol.type.adapter.LearnMeRecyclerViewAdapter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import zuo.biao.library.util.ZbLog;

import static com.youth.banner.BannerConfig.CIRCLE_INDICATOR;

/**
 * Created by HAOJI on 2019/12/12.
 */

public class StudyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<String> images;
    private ArrayList<String> titles;
    private Banner banner;
    private Context context;
    private int currentType = 0;

    private static final int BANNER = 0;
    private static final int TYPE = 1;
    private static final int SHHOW = 2;
    private static final int BOOK = 3;


    public StudyRecyclerViewAdapter(Context context) {
        this.context = context;
        images = new ArrayList<>();
        images.add("http://192.168.0.44:80/atguigu/img_biao/apple.jpg");
        images.add("http://192.168.0.44:80/atguigu/img_biao/ba.jpg");
        images.add("http://192.168.0.44:80/atguigu/img_biao/bat.png");
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == BANNER) {
            View view = LayoutInflater.from(context).inflate(R.layout.list_banner, parent, false);
            return new BannerManager(view);
        } else if (viewType == TYPE) {
            View view = LayoutInflater.from(context).inflate(R.layout.list_study_grid, parent, false);
            return new GridManager(view);
        } else if (viewType == SHHOW) {
            View view = LayoutInflater.from(context).inflate(R.layout.list_study_image, parent, false);
            return new ImagviewManager(view);
        } else if (viewType == BOOK) {
            View view = LayoutInflater.from(context).inflate(R.layout.list_study_reycler, parent, false);
            return new RecyclerViewManager(view);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (position == BANNER) {
            BannerManager bm = (BannerManager) holder;
            bm.setData();
        }else if (position==TYPE){
            GridManager gm = (GridManager) holder;
            gm.setData();
        }else if (position==SHHOW){
            ImagviewManager manager = (ImagviewManager) holder;
            manager.setData();
        }else if (position==BOOK){
            RecyclerViewManager rym = (RecyclerViewManager) holder;
            rym.setData();
        }
    }


    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case BANNER:
                currentType = BANNER;
                break;
            case TYPE:
                currentType = TYPE;
                break;
            case SHHOW:
                currentType = SHHOW;
                break;
            case BOOK:
                currentType = BOOK;
                break;
        }
        return currentType;
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class BannerManager extends RecyclerView.ViewHolder {

        public BannerManager(View view) {
            super(view);
            banner = view.findViewById(R.id.banner);
        }

        public void setData(){
            //设置banner样式
            banner.setBannerStyle(CIRCLE_INDICATOR);
            //设置图片加载器
            banner.setImageLoader(new GlideImageLoader());
            //设置图片集合
            banner.setImages(images);
            //设置banner动画效果
            banner.setBannerAnimation(Transformer.DepthPage);
//               设置标题集合（当banner样式有显示title时）
//            banner.setBannerTitles(titles);
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

    public class GridManager extends RecyclerView.ViewHolder {

        GridView gv_study ;

        public GridManager(View view) {
            super(view);
            gv_study = view.findViewById(R.id.gv_study);
        }

        public void setData(){
            GridViewStudyAdapter gv =new GridViewStudyAdapter(context);
            gv_study.setSelector(new ColorDrawable(Color.TRANSPARENT));
            gv_study.setAdapter(gv);
            gv_study.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    ZbLog.e("GridViewStudyAdapter","----position: "+position);
                    Intent intent =new Intent(context, MatingActivity.class);
                    context.startActivity(intent);
                }
            });
        }

    }

    public class RecyclerViewManager extends RecyclerView.ViewHolder {

        RecyclerView ry_study ;

        public RecyclerViewManager(View view) {
            super(view);
            ry_study = view.findViewById(R.id.ry_study);
        }

        public void setData(){
            ry_study.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
            LearnMoreRecyclerViewAdapter sty =new LearnMoreRecyclerViewAdapter(context);
            ry_study.setAdapter(sty);
        }

    }

    public class ImagviewManager extends RecyclerView.ViewHolder {

        ImageView iv_study_ad ;

        public ImagviewManager(View view) {
            super(view);
            iv_study_ad = view.findViewById(R.id.iv_study_ad);
        }

        public void setData(){
            String url = Contents.BASE_URl_IMAGE+"/zhanwei.jpg";
            Glide.with(context).load(url).apply(new RequestOptions().placeholder(R.drawable.zhan).diskCacheStrategy(DiskCacheStrategy.NONE)).into(iv_study_ad);
        }

    }

}
