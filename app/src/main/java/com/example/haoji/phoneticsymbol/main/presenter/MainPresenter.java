package com.example.haoji.phoneticsymbol.main.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.example.haoji.phoneticsymbol.R;
import com.example.haoji.phoneticsymbol.home.bean.DataBean1;
import com.example.haoji.phoneticsymbol.home.interf.FiveMethod;
import com.example.haoji.phoneticsymbol.home.interf.ModelCallback;
import com.example.haoji.phoneticsymbol.home.interf.RetrofitModelCallback;
import com.example.haoji.phoneticsymbol.home.interf.SuccessCallBack;
import com.example.haoji.phoneticsymbol.home.model.BeanModel;
import com.example.haoji.phoneticsymbol.home.view.ProgreesView;
import com.example.haoji.phoneticsymbol.main.interf.LoginSuccessCallBack;
import com.example.haoji.phoneticsymbol.main.interf.ThreeMethod;
import com.example.haoji.phoneticsymbol.main.widget.LoginActivity;

/**
 * Created by HAOJI on 2019/11/25.
 */

public class MainPresenter implements ThreeMethod {

    public static MainPresenter biaoUser = null;

    private Context context;

    private static LoginSuccessCallBack successCallBack;

    public ProgreesView mView;


    public MainPresenter(){

    }

    @Override
    public void getLogin(Context context, LoginSuccessCallBack successCallBack) {
        this.successCallBack=successCallBack;
        Intent intent =new Intent(context, LoginActivity.class);
        context.startActivity(intent);
        ((Activity)context).overridePendingTransition(R.anim.left_in, R.anim.left_out);
    }

    public static void logCallback() {
        successCallBack.loginSuccess();
    }

    public static void logoutCallback() {
        successCallBack.loginout();
    }

}
