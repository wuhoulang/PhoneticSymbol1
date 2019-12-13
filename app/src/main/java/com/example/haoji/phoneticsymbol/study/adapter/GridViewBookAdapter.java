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

public class GridViewBookAdapter extends BaseAdapter {

    private Context context;

    public GridViewBookAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 6;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.book_list_item, null);
            holder.four_rt = convertView.findViewById(R.id.iv_book);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.four_rt.setImageResource(R.drawable.fire);
        return convertView;
    }

    public class ViewHolder {
        ImageView four_rt;
    }
}
