package com.example.haoji.phoneticsymbol.home.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.haoji.phoneticsymbol.myContents.Contents;
import com.example.haoji.phoneticsymbol.R;


/**
 * Created by HAOJI on 2019/9/4.
 */

public class GridViewAdapter2 extends BaseAdapter {

    private Context context;
    private int line;

    public GridViewAdapter2(Context context, int position) {
        this.context = context;
        this.line = position;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, null);
            holder.four_rt = convertView.findViewById(R.id.four_rt);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        String ps = String.valueOf(position);
        String ps2 = ps + ".png";
//        Log.e("Gridview", "GridViewAdapter2:" + String.valueOf(position));
//                Log.e("Gridview", "GridViewAdapter2:" + "line"+line);
        switch (line) {
            case 0:
                Glide.with(context).load(Contents.BASE_ONE_IMAGE_DAN_TWO + ps2).into(holder.four_rt);
                break;
            case 3:
                Glide.with(context).load(Contents.BASE_TWO_IMAGE_DAN_TWO + ps2).into(holder.four_rt);
                break;
            case 5:
                Glide.with(context).load(Contents.BASE_THREE_IMAGE_DAN_TWO + ps2).into(holder.four_rt);
                break;
            case 7:
                Glide.with(context).load(Contents.BASE_FOUR_IMAGE_DAN_TWO + ps2).into(holder.four_rt);
                break;
            case 9:
                Glide.with(context).load(Contents.BASE_FIVE_IMAGE_DAN_TWO + ps2).into(holder.four_rt);
                break;
            case 11:
                Glide.with(context).load(Contents.BASE_SIX_IMAGE_DAN_TWO + ps2).into(holder.four_rt);
                break;
            case 13:
                Glide.with(context).load(Contents.BASE_SEVENIMAGE_DAN_TWO + ps2).into(holder.four_rt);
                break;
            default:
                break;
        }
        return convertView;
    }

    public class ViewHolder {
        ImageView four_rt;
    }
}
