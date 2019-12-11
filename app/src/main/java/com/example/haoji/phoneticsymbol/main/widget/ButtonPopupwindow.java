package com.example.haoji.phoneticsymbol.main.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.example.haoji.phoneticsymbol.R;


/**
 * Created by HAOJI on 2019/8/12.
 */

public class ButtonPopupwindow extends PopupWindow {
    private Context context;
    public ButtonPopupwindow(Context context) {
        super(context);
        this.context=context;
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        setOutsideTouchable(true);
        setFocusable(true);
        setAnimationStyle(R.style.popwin_anim_style);
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        setBackgroundDrawable(dw);
        View contentView = LayoutInflater.from(context).inflate(R.layout.popup_test,
                null, false);
        setContentView(contentView);
    }


}