package com.example.haoji.phoneticsymbol.main.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.haoji.phoneticsymbol.R;
import com.example.haoji.phoneticsymbol.main.interf.OnItemClickListener;
import com.example.haoji.phoneticsymbol.main.model.CollectBean;
import com.example.haoji.phoneticsymbol.main.widget.SettingActivity;
import com.example.haoji.phoneticsymbol.main.widget.SubscribeActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HAOJI on 2019/10/29.
 */

public class SubRecyclerViewAdapter extends RecyclerView.Adapter<SubRecyclerViewAdapter.ViewHolder> implements View.OnClickListener {

    private int currentType;

    private Context context;

    private List<CollectBean> list;

    private OnItemClickListener mOnItemClickListener = null;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

//    private Handler mHander = new Handler(new Handler.Callback() {
//        @Override
//        public boolean handleMessage(Message msg) {
//            switch (msg.what) {
//                case 1:
//
//                    break;
//                default:
//                    break;
//            }
//            return false;
//        }
//    });

    public SubRecyclerViewAdapter(Context context, List<CollectBean> mList) {
        this.context = context;
        this.list =  mList;
        Log.e("SubscribeActivity","SubRecyclerViewAdapter---------------list1:"+list.get(1));
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(v, (int) v.getTag());
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_learn;
        TextView tv_title_learn;
        TextView tv_xiang;

        public ViewHolder(View view) {
            super(view);
            iv_learn = view.findViewById(R.id.iv_learn);
            tv_title_learn = view.findViewById(R.id.tv_title_learn);
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
        if (list.get(1).equals("")){
            return;
        }
        holder.tv_title_learn.setText(list.get(position).getTitle());
        holder.tv_xiang.setText(list.get(position).getSubtitle());
//         Message msg = new Message();
//         msg.what = 1;
//         mHander.se
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
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
