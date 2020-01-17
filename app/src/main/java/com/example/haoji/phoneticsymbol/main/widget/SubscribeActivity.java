package com.example.haoji.phoneticsymbol.main.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.haoji.phoneticsymbol.R;
import com.example.haoji.phoneticsymbol.home.bean.DataBean1;
import com.example.haoji.phoneticsymbol.home.interf.SuccessCallBack;
import com.example.haoji.phoneticsymbol.main.adapter.SubRecyclerViewAdapter;
import com.example.haoji.phoneticsymbol.main.model.CollectBean;
import com.example.haoji.phoneticsymbol.main.presenter.MainPresenter;
import com.example.haoji.phoneticsymbol.study.adapter.StudyRecyclerViewAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Response;
import zuo.biao.library.util.ZbLog;

/**
 * Created by HAOJI on 2019/12/18.
 */

public class SubscribeActivity extends Activity {

    @BindView(R.id.ry_subscribe)
    RecyclerView ry_subscribe;

    private Context context = SubscribeActivity.this;
    private LinearLayoutManager lm;
    private MainPresenter mainPresenter;
    private CollectBean collectBean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscribe);
        ButterKnife.bind(this);
         collectBean =new CollectBean();
        mainPresenter = new MainPresenter();
        lm = new LinearLayoutManager(context);
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        ry_subscribe.setLayoutManager(lm);
        setData();
//        initData();
    }

    private void setData(){
        ArrayList<CollectBean> list = new ArrayList<>();
        for (int i = 0; i <4 ; i++) {
            collectBean.setPicUrl("");
            collectBean.setTitle("dsfsd");
            collectBean.setSubtitle("fuuuuuuuuuuuuuuuuu");
            list.add(collectBean);
        }

        SubRecyclerViewAdapter srv = new SubRecyclerViewAdapter(context,list);
        ry_subscribe.setAdapter(srv);
    }

    private void initData() {

        mainPresenter.getPostBean(context, "http://192.168.0.44:9093/get", "1", new SuccessCallBack() {
            @Override
            public void IsSuccess(String data) {
                Log.e("SubscribeActivity", "data" + data);
//                String[] string = null;
//                try {
//                    JSONObject jsonObject = new JSONObject(data);
//                    String param = jsonObject.getString("Param");
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }

                ArrayList<CollectBean> list = new ArrayList<>();
                for (int i = 0; i <4 ; i++) {
                    collectBean.setPicUrl("");
                    collectBean.setTitle("dsfsd");
                    collectBean.setSubtitle("fuuuuuuuuuuuuuuuuu");
                    list.add(collectBean);
                }

                SubRecyclerViewAdapter srv = new SubRecyclerViewAdapter(context,list);
                ry_subscribe.setAdapter(srv);

            }

            @Override
            public void IsFailed(String msg) {

            }

            @Override
            public void IsReSuccess(Response<DataBean1> data) {

            }
        });

    }
}
