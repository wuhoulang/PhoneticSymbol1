package com.example.haoji.phoneticsymbol.study.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.haoji.phoneticsymbol.R;
import com.example.haoji.phoneticsymbol.main.interf.OnItemClickListener;
import com.example.haoji.phoneticsymbol.type.widget.ShowDetailActivity;


/**
 * Created by HAOJI on 2019/8/2.
 */

public class LearnMoreRecyclerViewAdapter extends RecyclerView.Adapter<LearnMoreRecyclerViewAdapter.ViewHolder> implements View.OnClickListener {


    private int currentType = 0;

    private static final int SHOW_LEARN = 1;

    private Context context;

    private OnItemClickListener mOnItemClickListener = null;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public LearnMoreRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(v,(int)v.getTag());
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout rl_learn;

        public ViewHolder(View view) {
            super(view);
            rl_learn = view.findViewById(R.id.rl_learn);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.learn_mater_list, parent, false);
            LearnMoreRecyclerViewAdapter.ViewHolder viewHolder = new LearnMoreRecyclerViewAdapter.ViewHolder(view);
            viewHolder.itemView.setOnClickListener(this);
            return viewHolder;
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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
         holder.rl_learn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(context, ShowDetailActivity.class);
                 context.startActivity(intent);
             }
         });
    }


    @Override
    public int getItemCount() {
        return 10;
    }


}
