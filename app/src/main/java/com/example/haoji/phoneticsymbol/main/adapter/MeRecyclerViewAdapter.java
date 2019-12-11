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

/**
 * Created by HAOJI on 2019/10/29.
 */

public class MeRecyclerViewAdapter extends RecyclerView.Adapter<MeRecyclerViewAdapter.ViewHolder> implements View.OnClickListener {

    private int currentType;

    private static final int VIPZONE = 0;

    private static final int CACHE = 1;

    private static final int HISTROY = 2;

    private static final int NOTEBOOK = 3;

    private static final int COLLECTION = 4;

    private static final int SUBSCRIBE = 5;

    private static final int EXCEPTIONAL = 6;

    private static final int SETTING = 7;


    private Context context;

    private OnItemClickListener mOnItemClickListener = null;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public MeRecyclerViewAdapter(Context context) {
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

        ImageView iv_vip;
        TextView tv_vip;
        LinearLayout ll_me;

        public ViewHolder(View view) {
            super(view);
            iv_vip = view.findViewById(R.id.iv_vip);
            tv_vip = view.findViewById(R.id.tv_vip);
            ll_me = view.findViewById(R.id.ll_me);
        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIPZONE || viewType == CACHE || viewType == HISTROY || viewType == NOTEBOOK || viewType == COLLECTION || viewType == SUBSCRIBE || viewType == EXCEPTIONAL || viewType == SETTING) {
            View view = LayoutInflater.from(context).inflate(R.layout.me_list, parent, false);
            ViewHolder viewHolder = new ViewHolder(view);
            viewHolder.itemView.setOnClickListener(this);
            return viewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        switch (position) {
            case 0:
                holder.iv_vip.setImageResource(R.drawable.my_btn_vip);
                holder.tv_vip.setText("vip专区");
                break;
            case 1:
                holder.iv_vip.setImageResource(R.drawable.my_btn_cache);
                holder.tv_vip.setText("缓存管理");
                break;
            case 2:
                holder.iv_vip.setImageResource(R.drawable.my_btn_history);
                holder.tv_vip.setText("播放历史");
                break;
            case 3:
                holder.iv_vip.setImageResource(R.drawable.my_btn_note);
                holder.tv_vip.setText("笔记本");
                break;
            case 4:
                holder.iv_vip.setImageResource(R.drawable.my_btn_collect);
                holder.tv_vip.setText("收藏的文章");
                break;
            case 5:
                holder.iv_vip.setImageResource(R.drawable.my_btn_rss);
                holder.tv_vip.setText("订阅的节目");
                break;
            case 6:
                holder.iv_vip.setImageResource(R.drawable.my_btn_award);
                holder.tv_vip.setText("打赏");
                break;
            case 7:
                holder.iv_vip.setImageResource(R.drawable.my_btn_setting);
                holder.tv_vip.setText("设置");
                holder.ll_me.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent(context, SettingActivity.class);
                        context.startActivity(intent);
                    }
                });
                break;
            default:
                break;
        }

        holder.itemView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return 8;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case VIPZONE:
                currentType = VIPZONE;
                break;
            case CACHE:
                currentType = CACHE;
                break;
            case HISTROY:
                currentType = HISTROY;
                break;
            case NOTEBOOK:
                currentType = NOTEBOOK;
                break;
            case COLLECTION:
                currentType = COLLECTION;
                break;
            case SUBSCRIBE:
                currentType = SUBSCRIBE;
                break;
            case EXCEPTIONAL:
                currentType = EXCEPTIONAL;
                break;
            case SETTING:
                currentType = SETTING;
                break;
            default:
                break;
        }
        return currentType;
    }
}
