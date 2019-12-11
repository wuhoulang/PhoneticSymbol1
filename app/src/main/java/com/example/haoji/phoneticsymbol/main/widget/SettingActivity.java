package com.example.haoji.phoneticsymbol.main.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.haoji.phoneticsymbol.R;
import com.example.haoji.phoneticsymbol.main.presenter.MainPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zuo.biao.library.util.CommonUtil;


/**
 * Created by HAOJI on 2019/12/2.
 */

public class SettingActivity extends Activity {

    @BindView(R.id.id_vn)
    TextView id_vn;

    @BindView(R.id.id_line_control)
    RelativeLayout id_line_control;

    @BindView(R.id.ll_main)
    LinearLayout ll_main;

    @BindView(R.id.tl_logout)
    RelativeLayout tl_logout;

    private Context context =SettingActivity.this;
    private ButtonPopupwindow buttonPopupwindow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        buttonPopupwindow = new ButtonPopupwindow(this);

        id_line_control.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 0.7f;
                getWindow().setAttributes(lp);
                setPopupwindow();
            }
        });

        tl_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainPresenter.logoutCallback();
                finish();
            }
        });

        buttonPopupwindow.setOnDismissListener(new android.widget.PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1.f);
            }
        });
    }

    private void initData() {
        String versionName = CommonUtil.getVersionName(context);
        String s = "v."+versionName;
        Log.e("SettingActivity","versionName:"+versionName);
        id_vn.setText(s);
    }

    private void setPopupwindow() {
        backgroundAlpha(0.5f);
        buttonPopupwindow.showAtLocation(ll_main, Gravity.BOTTOM, 0, 0);
    }

    public void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        getWindow().setAttributes(lp);
    }

}
