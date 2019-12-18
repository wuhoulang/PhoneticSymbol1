package com.example.haoji.phoneticsymbol.main.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.haoji.phoneticsymbol.type.model.UserData;
import com.example.haoji.phoneticsymbol.main.presenter.MainPresenter;
import com.example.haoji.phoneticsymbol.myContents.ContentsJson;
import com.example.haoji.phoneticsymbol.R;
import com.example.haoji.phoneticsymbol.home.bean.DataBean1;
import com.example.haoji.phoneticsymbol.home.interf.SuccessCallBack;
import com.example.haoji.phoneticsymbol.home.presenter.HomePresenter;
import com.example.haoji.phoneticsymbol.home.view.ProgreesView;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Response;

/**
 * Created by HAOJI on 2019/11/26.
 */

public class LoginActivity extends Activity implements ProgreesView {
    @BindView(R.id.bt_login2)
    Button bt_login2;

    @BindView(R.id.et_account2)
    EditText et_account2;

    @BindView(R.id.et_password2)
    EditText et_password2;

    @BindView(R.id.tv_cancel)
    TextView tv_cancel;


    private Context context = LoginActivity.this;
    private HomePresenter biaoUser;
    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        et_password2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.e("LoginActivity", "--setOnEditorActionListener---"+et_password2.getText().toString());
                if (!et_password2.getText().toString().equals("")){
                    if (bt_login2.getBackground().getAlpha()!=1){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                bt_login2.setAlpha(1.0f);
                            }
                        });
                    }
                }else if (et_password2.getText().toString().equals("")) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            bt_login2.setAlpha(0.3f);
                        }
                    });
                }
            }
        });

        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        loadingDialog = new LoadingDialog(context,"加载中...");
        biaoUser = new HomePresenter(this);
    }

    @OnClick(R.id.bt_login2)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_login2:
                if (et_account2.getText().toString().equals("")||et_password2.getText().toString().equals("")){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(context, "所输账号或密码不能为空", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    });
                }
                final String account = et_account2.getText().toString();
                final String password = et_password2.getText().toString();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        login(account, password);
                    }
                }).start();
                Log.e("LoginActivity", "--onViewClicked---");
                break;
            default:
                break;
        }
    }

    private void login(String account, String password) {
        biaoUser.getPostBean(context, ContentsJson.URL_LOGIN_BASE, account, password, new SuccessCallBack() {
            @Override
            public void IsSuccess(String data) {
                Log.e("LoginActivity", "-----response:" + data);
                try {
                    JSONObject jsonObject = new JSONObject(data);
                    int code = jsonObject.getInt("Code");
                    String userId = jsonObject.getString("Param");
                    UserData.userId= userId;
                    Log.e("LoginActivity", "-----userId:" + userId);
                    if (code == 0) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                MainPresenter.logCallback();
                                Toast.makeText(context, "登录成功", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        });
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void IsReSuccess(Response<DataBean1> data) {
            }

            @Override
            public void IsFailed(final String msg) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                JSONObject jsonObject = new JSONObject(msg);
                                int code = jsonObject.getInt("Code");
                                if (code==1){
                                    Toast.makeText(context, "登录失败", Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });

            }
        });
    }

    @Override
    public void showLoading() {
    }

    @Override
    public void hideLoading() {

    }

}
