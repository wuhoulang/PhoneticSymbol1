package com.example.haoji.phoneticsymbol.main.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.haoji.phoneticsymbol.R;
import com.example.haoji.phoneticsymbol.main.interf.OnItemClickListener;
import com.example.haoji.phoneticsymbol.main.widget.SettingActivity;
import com.example.haoji.phoneticsymbol.main.widget.SubscribeActivity;

/**
 * Created by HAOJI on 2019/10/29.
 */

public class SubRecyclerViewAdapter extends RecyclerView.Adapter<SubRecyclerViewAdapter.ViewHolder> implements View.OnClickListener {

    private int currentType;

    private Context context;

    private OnItemClickListener mOnItemClickListener = null;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public SubRecyclerViewAdapter(Context context) {
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

        ImageView iv_learn;
        TextView tv_title_learn;
        TextView tv_xiang;

        public ViewHolder(View view) {
            super(view);
            iv_learn = view.findViewById(R.id.iv_learn);
            tv_title_learn = view.findViewById(R.id.tv_vip);
            tv_xiang = view.findViewById(R.id.tv_xiang);
        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.sub_list, parent, false);
            ViewHolder viewHolder = new ViewHolder(view);
            viewHolder.itemView.setOnClickListener(this);
            return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.itemView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return 8;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            default:
                break;
        }
        return currentType;
    }
}
