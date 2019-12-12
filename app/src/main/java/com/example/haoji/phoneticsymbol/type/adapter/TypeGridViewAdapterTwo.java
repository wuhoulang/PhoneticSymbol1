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

public class TypeGridViewAdapterTwo extends BaseAdapter {

    private Context context;

    public TypeGridViewAdapterTwo(Context context) {
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

        switch (position) {
            case 0:
                holder.tv_type_list.setText("TOP外教");
                break;
            case 1:
                holder.tv_type_list.setText("英语音标");
                break;
            case 2:
                holder.tv_type_list.setText("旅游口语");
                break;
            case 3:
                holder.tv_type_list.setText("商业英语");
                break;
            case 4:
                holder.tv_type_list.setText("求职英语");
                break;
            case 5:
                holder.tv_type_list.setText("外贸英语");
                break;
            case 6:
                holder.tv_type_list.setText("趣味口语");
                break;
            case 7:
                holder.tv_type_list.setText("行业口语");
                break;
            case 8:
                holder.tv_type_list.setText("日常口语");
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
