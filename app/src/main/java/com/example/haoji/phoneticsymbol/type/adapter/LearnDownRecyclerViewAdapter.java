package com.example.haoji.phoneticsymbol.type.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;

import com.example.haoji.phoneticsymbol.R;
import com.example.haoji.phoneticsymbol.main.interf.OnItemClickListener;
import com.example.haoji.phoneticsymbol.type.widget.ShowDetailActivity;
import com.example.haoji.phoneticsymbol.type.widget.ShowDownLoadActivity;

import java.util.ArrayList;
import java.util.List;

import zuo.biao.library.ui.RoundCheckBox;
import zuo.biao.library.util.ZbLog;


/**
 * Created by HAOJI on 2019/8/2.
 */

public class LearnDownRecyclerViewAdapter extends RecyclerView.Adapter<LearnDownRecyclerViewAdapter.ViewHolder> implements View.OnClickListener {


    private int currentType = 0;

    private static final int SHOW_LEARN = 1;

    private Context context;

    private OnItemClickListener mOnItemClickListener = null;

    private RoundCheckBox rcb_check ;

    private List<String> list = new ArrayList<>();
    private List<Boolean> booleanlist = new ArrayList<>();

    private boolean isNotCheckAll = true;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public LearnDownRecyclerViewAdapter(Context context,RoundCheckBox rcb_check) {
        this.context = context;
        this.rcb_check = rcb_check;

//        rcb_check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked){
//                    selectAll();
//                    ZbLog.e("ShowDownLoadActivity","----rcb_check--selectAll----------");
//                }else {
//                    unSelectAll();
//                    ZbLog.e("ShowDownLoadActivity","---rcb_check---unSelectAll----------");
//                }
//            }
//        });

        rcb_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNotCheckAll){
                    selectAll();
                    isNotCheckAll = false;
                }else {
                    unSelectAll();
                    isNotCheckAll = true;
                }
            }
        });

        for (int i = 0; i < 12; i++) {
            //设置默认的显示
            booleanlist.add(false);
        }
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(v, (int) v.getTag());
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout rl_learn;
        RoundCheckBox tv_down_cb;

        public ViewHolder(View view) {
            super(view);
            rl_learn = view.findViewById(R.id.rl_learn);
            tv_down_cb = view.findViewById(R.id.tv_down_cb);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.learn_down_list, parent, false);
        LearnDownRecyclerViewAdapter.ViewHolder viewHolder = new LearnDownRecyclerViewAdapter.ViewHolder(view);
        viewHolder.itemView.setOnClickListener(this);
        return viewHolder;
    }

    public void selectAll(){
        initCheck(true);
        notifyDataSetChanged();
    }
    public void unSelectAll() {
        initCheck(false);
        notifyDataSetChanged();
    }

    public void initCheck(boolean flag) {

        for (int i = 0; i < 12; i++) {
            //更改指定位置的数据
            booleanlist.set(i,flag);
        }
    }

//    @Override
//    public int getItemViewType(int position) {
//        switch (position) {
//            case 0:
//                currentType = SHOW_LEARN;
//                break;
//            default:
//                break;
//        }
//        return currentType;
//    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.tv_down_cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                booleanlist.set(position,isChecked);
                if (booleanlist.get(position)==false){
                    rcb_check.setChecked(false);
                    isNotCheckAll = true ;
                    ZbLog.e("ShowDownLoadActivity","------onCheckedChanged----------");
                }else {
                    for (int i = 0; i < booleanlist.size(); i++) {
                        if (booleanlist.get(i)==false) {
                            ZbLog.e("ShowDownLoadActivity","------booleanlist.get(i)==false----------");
                            return;
                        } else {
                              if(i==booleanlist.size()-1){
                                  isNotCheckAll = false ;
                                  rcb_check.setChecked(true);
                                  ZbLog.e("ShowDownLoadActivity","------i==booleanlist.size()----------");
                              }
                            ZbLog.e("ShowDownLoadActivity","------booleanlist.get(i)==true----------");
                        }
                    }
                }
            }
        });
        holder.tv_down_cb.setChecked(booleanlist.get(position));
    }


    @Override
    public int getItemCount() {
        return 12;
    }


}
