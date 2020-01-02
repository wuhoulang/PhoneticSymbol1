package com.example.haoji.phoneticsymbol.home.widget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.haoji.phoneticsymbol.myContents.ContentsJson;
import com.example.haoji.phoneticsymbol.R;
import com.example.haoji.phoneticsymbol.base.BaseFragment;
import com.example.haoji.phoneticsymbol.home.adapter.RecyclerViewAdapter;
import com.example.haoji.phoneticsymbol.home.bean.DataBean1;
import com.example.haoji.phoneticsymbol.home.presenter.HomePresenter;
import com.example.haoji.phoneticsymbol.home.view.ProgreesView;
import com.example.haoji.phoneticsymbol.home.interf.SuccessCallBack;

import java.util.ArrayList;
import java.util.List;

import zuo.biao.library.util.ZbLog;

/**
 * Created by HAOJI on 2019/8/22.
 */
@SuppressLint("ValidFragment")
public class HomeFragment extends BaseFragment implements ProgreesView {
    private static Context context;
    //    private Context context;
    private RecyclerView id_rlv;
    private LinearLayoutManager manager;
    private RecyclerViewAdapter rva;
    private Activity mActivity;
    private static final int CONTENT_INT = 1;
    private List<String> list_data;

    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what == CONTENT_INT) {
                rva = new RecyclerViewAdapter(context, page_data1, page_data2, page_data3, page_data4, page_data5, page_data6, page_data7, page_data8, page_data9, page_data10, page_data11, page_data12, page_data13, page_data14);
                id_rlv.setAdapter(rva);
            }
            return false;
        }
    });
    private HomePresenter biaoUser;
    private List<DataBean1.LineOneBean.ContentBean.PageDataBean> page_data1;
    private List<DataBean1.LineTwoBean.ContentBeanX.PageDataBeanX> page_data2;
    private List<DataBean1.LineThreeBean.ContentBeanXX.PageDataBeanXX> page_data3;
    private List<DataBean1.LineFourBean.ContentBeanXXX.PageDataBeanXXX> page_data4;
    private List<DataBean1.LineFiveBean.ContentBeanXXXX.PageDataBeanXXXX> page_data5;
    private List<DataBean1.LineSixBean.ContentBeanXXXXX.PageDataBeanXXXXX> page_data6;
    private List<DataBean1.LineSevenBean.ContentBeanXXXXXX.PageDataBeanXXXXXX> page_data7;
    private List<DataBean1.LineEightBean.ContentBeanXXXXXXX.PageDataBeanXXXXXXX> page_data8;
    private List<DataBean1.LineNineBean.ContentBeanXXXXXXXX.PageDataBeanXXXXXXXX> page_data9;
    private List<DataBean1.LineTenBean.ContentBeanXXXXXXXXX.PageDataBeanXXXXXXXXX> page_data10;
    private List<DataBean1.LineElevenBean.ContentBeanXXXXXXXXXX.PageDataBeanXXXXXXXXXX> page_data11;
    private List<DataBean1.LineTwelveBean.ContentBeanXXXXXXXXXXX.PageDataBeanXXXXXXXXXXX> page_data12;
    private List<DataBean1.LineThirteenBean.ContentBeanXXXXXXXXXXXX.PageDataBeanXXXXXXXXXXXX> page_data13;
    private List<DataBean1.LineFourteenBean.ContentBeanXXXXXXXXXXXXX.PageDataBeanXXXXXXXXXXXXX> page_data14;


    public HomeFragment() {
    }

    public static HomeFragment newInstance(Context context1) {
        context = context1;
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.home_fragment, null);
        id_rlv = view.findViewById(R.id.id_rlv);
        manager = new LinearLayoutManager(context);
        id_rlv.setLayoutManager(manager);
        list_data = new ArrayList<>();
        biaoUser = new HomePresenter(this);
        return view;
    }

    @Override
    public void initData() {
        getRetrofit();
    }

    private void getRetrofit() {
        biaoUser.getRetrofitBean(context, ContentsJson.BASE_ONE_JSON_DAN_ONE1, new SuccessCallBack() {
            @Override
            public void IsSuccess(String data) {
            }

            @Override
            public void IsReSuccess(retrofit2.Response<DataBean1> data) {
                page_data1 = data.body().getLine_one().getContent().getPage_data();
                page_data2 = data.body().getLine_two().getContent().getPage_data();
                page_data3 = data.body().getLine_three().getContent().getPage_data();
                page_data4 = data.body().getLine_four().getContent().getPage_data();
                page_data5 = data.body().getLine_five().getContent().getPage_data();
                page_data6 = data.body().getLine_six().getContent().getPage_data();
                page_data7 = data.body().getLine_seven().getContent().getPage_data();
                page_data8 = data.body().getLine_eight().getContent().getPage_data();
                page_data9 = data.body().getLine_nine().getContent().getPage_data();
                page_data10 = data.body().getLine_ten().getContent().getPage_data();
                page_data11 = data.body().getLine_eleven().getContent().getPage_data();
                page_data12 = data.body().getLine_twelve().getContent().getPage_data();
                page_data13 = data.body().getLine_thirteen().getContent().getPage_data();
                page_data14 = data.body().getLine_fourteen().getContent().getPage_data();
                Message msg = new Message();
                msg.what = CONTENT_INT;
                mHandler.sendMessage(msg);
            }

            @Override
            public void IsFailed(String msg) {

            }
        });

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ZbLog.e("HomeFragment", "---ondestory----");
    }

}
