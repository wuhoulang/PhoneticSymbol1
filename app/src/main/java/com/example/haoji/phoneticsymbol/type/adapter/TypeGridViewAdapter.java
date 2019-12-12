package com.example.haoji.phoneticsymbol.type.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.haoji.phoneticsymbol.R;
import com.example.haoji.phoneticsymbol.myContents.Contents;


/**
 * Created by HAOJI on 2019/9/4.
 */

public class TypeGridViewAdapter extends BaseAdapter {

    private Context context;

    public TypeGridViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 7;
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

        switch (position) {
            case 0:
                holder.tv_type_list.setText("VOA慢速");
                break;
            case 1:
                holder.tv_type_list.setText("VOA常速");
                break;
            case 2:
                holder.tv_type_list.setText("BBC");
                break;
            case 3:
                holder.tv_type_list.setText("经济学人");
                break;
            case 4:
                holder.tv_type_list.setText("科学美国人");
                break;
            case 5:
                holder.tv_type_list.setText("NPR");
                break;
            case 6:
                holder.tv_type_list.setText("CRI News");
                break;
            default:
                break;
        }

        return convertView;
    }

    public class ViewHolder {
        TextView tv_type_list;
    }
}
