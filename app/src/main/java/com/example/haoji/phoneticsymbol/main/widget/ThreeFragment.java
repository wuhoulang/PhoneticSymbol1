package com.example.haoji.phoneticsymbol.main.widget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.haoji.phoneticsymbol.R;
import com.example.haoji.phoneticsymbol.base.BaseFragment;
import com.example.haoji.phoneticsymbol.main.adapter.MeRecyclerViewAdapter;
import com.example.haoji.phoneticsymbol.main.interf.LoginSuccessCallBack;
import com.example.haoji.phoneticsymbol.main.interf.OnItemClickListener;
import com.example.haoji.phoneticsymbol.main.presenter.MainPresenter;
import zuo.biao.library.ui.CircleImageView;

/**
 * Created by HAOJI on 2019/8/22.
 */

@SuppressLint("ValidFragment")
public class ThreeFragment extends BaseFragment implements View.OnClickListener {

    private static final int RUN_UI = 1;
    private static final int RUN_UI_GONE = 2;
    private static Context context;
    private RecyclerView id_ry2;
    private Button bt_login, bt_register;
    private TextView tv_person;
    private CircleImageView civ_person;
    private MainPresenter main;
    private MeRecyclerViewAdapter mv;

    private Handler mHandler =new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what==RUN_UI){
                civ_person.setVisibility(View.VISIBLE);
                bt_login.setVisibility(View.GONE);
                bt_register.setVisibility(View.GONE);
                tv_person.setVisibility(View.VISIBLE);
                Log.e("ThreeFragment","--成功接收到LoginSuccessCallBack--");
            }else if(msg.what==RUN_UI_GONE){
                civ_person.setVisibility(View.GONE);
                bt_login.setVisibility(View.VISIBLE);
                bt_register.setVisibility(View.VISIBLE);
                tv_person.setVisibility(View.GONE);
            }
            return false;
        }
    });

    public ThreeFragment() {
    }

    public static ThreeFragment newInstance(Context context1) {
        context=context1;
        ThreeFragment fragment = new ThreeFragment();
        return fragment;
    }

    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.main_fragment, null);
        initview(view);
        initListener();
        return view;
    }

    private void initListener() {

        mv.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.e("onItemClick", "======position:" + position);
                if (position==5){

                    Intent intent2 =new Intent(context, SubscribeActivity.class);
                    context.startActivity(intent2);
                }
            }
        });
    }


    private void initview(View view) {
        id_ry2 = view.findViewById(R.id.id_ry2);
        bt_login = view.findViewById(R.id.bt_login);
        bt_register = view.findViewById(R.id.bt_register);
        civ_person = view.findViewById(R.id.civ_person);
        tv_person = view.findViewById(R.id.tv_person);
         main =new MainPresenter();
        bt_login.setOnClickListener(this);
        bt_register.setOnClickListener(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        id_ry2.setLayoutManager(linearLayoutManager);
         mv = new MeRecyclerViewAdapter(context);
        id_ry2.setAdapter(mv);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_login:
                main.getLogin(context, new LoginSuccessCallBack() {
                    @Override
                    public void loginSuccess() {
                        if (bt_login.getVisibility()==View.VISIBLE && bt_register.getVisibility()==View.VISIBLE){
                            Message msg =new Message();
                            msg.what = RUN_UI;
                            mHandler.sendMessage(msg);
                        }
                    }

                    @Override
                    public void loginFail() {

                    }

                    @Override
                    public void loginout() {
                        if (civ_person.getVisibility()==View.VISIBLE && tv_person.getVisibility()==View.VISIBLE){
                            Message msg =new Message();
                            msg.what = RUN_UI_GONE;
                            mHandler.sendMessage(msg);
                        }
                    }
                });
                break;
            case R.id.bt_register:
                Intent intent2 =new Intent(context, RegisterActivity.class);
                context.startActivity(intent2);
                ((Activity)context).overridePendingTransition(R.anim.left_in, R.anim.left_out);
                break;
            default:
                break;
        }
    }
}
