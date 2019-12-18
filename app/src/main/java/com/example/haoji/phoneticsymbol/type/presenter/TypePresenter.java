package com.example.haoji.phoneticsymbol.type.presenter;

import android.content.Context;

import com.example.haoji.phoneticsymbol.home.bean.DataBean1;
import com.example.haoji.phoneticsymbol.home.bean.TextViewDataBean;
import com.example.haoji.phoneticsymbol.home.interf.FiveMethod;
import com.example.haoji.phoneticsymbol.home.interf.ModelCallback;
import com.example.haoji.phoneticsymbol.home.interf.RetrofitTextCallback;
import com.example.haoji.phoneticsymbol.home.interf.SuccessCallBack;
import com.example.haoji.phoneticsymbol.home.interf.SuccessTextCallBack;
import com.example.haoji.phoneticsymbol.home.model.BeanModel;
import com.example.haoji.phoneticsymbol.home.view.ProgreesView;
import com.example.haoji.phoneticsymbol.type.interf.TwoMethod;
import com.example.haoji.phoneticsymbol.type.model.TypeModel;

import retrofit2.Response;

/**
 * Created by HAOJI on 2019/11/25.
 */

public class TypePresenter implements TwoMethod {

    public static TypePresenter biaoUser = null;

    private Context context;

    private SuccessCallBack successCallBack;

    public ProgreesView mView;

    public TypePresenter(Context mContext){
        this.context = mContext;
    }

    public TypePresenter(ProgreesView view){
        this.mView = view;
    }

    @Override
    public void getPostBean(Context context, String url, String picur, String id, String title, String sutitle, final SuccessCallBack successCallBack) {
        TypeModel.requestPostOKhttp(context, url, picur,id,title,sutitle, new ModelCallback() {
            @Override
            public void onSuccess(String data) {
                successCallBack.IsSuccess(data);
            }

            @Override
            public void onFailure(String msg) {

            }
        });
    }
}
