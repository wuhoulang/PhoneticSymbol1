package com.example.haoji.phoneticsymbol.study.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.haoji.phoneticsymbol.R;


/**
 * Created by HAOJI on 2019/9/4.
 */

public class GridViewStudyAdapter extends BaseAdapter {

    private Context context;

    public GridViewStudyAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint("WrongViewCast")
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder = new ViewHolder();
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.study_list_item, null);
            holder.iv_list_study = convertView.findViewById(R.id.iv_list_study);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (position==0) {
            holder.iv_list_study.setImageResource(R.drawable.gri_one);
        } else if (position==1) {
            holder.iv_list_study.setImageResource(R.drawable.gri_two);
        } if (position==2) {
            holder.iv_list_study.setImageResource(R.drawable.gri_three);
        } else if (position==3) {
            holder.iv_list_study.setImageResource(R.drawable.gri_four);
        }
        return convertView;
    }

    public class ViewHolder {
        ImageView iv_list_study;
    }
}
