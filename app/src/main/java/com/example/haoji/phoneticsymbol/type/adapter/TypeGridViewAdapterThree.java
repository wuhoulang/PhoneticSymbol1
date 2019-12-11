package com.example.haoji.phoneticsymbol.type.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.haoji.phoneticsymbol.R;


/**
 * Created by HAOJI on 2019/9/4.
 */

public class TypeGridViewAdapterThree extends BaseAdapter {

    private Context context;

    public TypeGridViewAdapterThree(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 9;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.type_list_item_one, null);
            holder.tv_type_list = convertView.findViewById(R.id.tv_type_list);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (position<9){
            holder.tv_type_list.setText("VOA慢速");
        }

        return convertView;
    }

    public class ViewHolder {
        TextView tv_type_list;
    }
}
