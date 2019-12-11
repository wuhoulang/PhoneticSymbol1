package com.example.haoji.phoneticsymbol.home.presenter;

import android.content.Context;

import com.example.haoji.phoneticsymbol.home.bean.DataBean1;
import com.example.haoji.phoneticsymbol.home.interf.FiveMethod;
import com.example.haoji.phoneticsymbol.home.interf.ModelCallback;
import com.example.haoji.phoneticsymbol.home.interf.RetrofitModelCallback;
import com.example.haoji.phoneticsymbol.home.model.BeanModel;
import com.example.haoji.phoneticsymbol.home.view.ProgreesView;
import com.example.haoji.phoneticsymbol.home.interf.SuccessCallBack;
import com.example.haoji.phoneticsymbol.main.presenter.MainPresenter;

/**
 * Created by HAOJI on 2019/11/25.
 */

public class HomePresenter implements FiveMethod {

    public static HomePresenter biaoUser = null;

    private Context context;

    private SuccessCallBack successCallBack;

    public ProgreesView mView;

    public HomePresenter(ProgreesView view){
        this.mView = view;
    }

    @Override
    public void getDataBean(Context context, String url, final SuccessCallBack successCallBack) {
        this.context = context;
        this.successCallBack = successCallBack;
        mView.showLoading();
        BeanModel.getModel(context,url ,new ModelCallback() {
            @Override
            public void onSuccess(String data) {
                mView.hideLoading();
                successCallBack.IsSuccess(data);
            }

            @Override
            public void onFailure(String msg) {
                mView.hideLoading();
                successCallBack.IsFailed(msg);
            }
        });
    }

    @Override
    public void getPostBean(Context context, String url, String account , String password, final SuccessCallBack successCallBack) {
        mView.showLoading();
        BeanModel.requestPostOKhttp(context,url , account , password,new ModelCallback() {
            @Override
            public void onSuccess(String data) {
                mView.hideLoading();
                successCallBack.IsSuccess(data);
            }

            @Override
            public void onFailure(String msg) {
                mView.hideLoading();
                successCallBack.IsFailed(msg);
            }
        });
    }

    @Override
    public void getRetrofitBean(Context context, String base_url, final SuccessCallBack successCallBack) {
        BeanModel.requestGetRetrofit(context, base_url, new RetrofitModelCallback() {
            @Override
            public void onSuccess(retrofit2.Response<DataBean1> data) {
                successCallBack.IsReSuccess(data);
            }

            @Override
            public void onFailure(String msg) {

            }


        });


    }


}
