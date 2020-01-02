package com.example.haoji.phoneticsymbol.type.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.haoji.phoneticsymbol.R;
import com.example.haoji.phoneticsymbol.home.bean.DataBean1;
import com.example.haoji.phoneticsymbol.home.interf.SuccessCallBack;
import com.example.haoji.phoneticsymbol.type.model.UserData;
import com.example.haoji.phoneticsymbol.type.adapter.LearnMeRecyclerViewAdapter;
import com.example.haoji.phoneticsymbol.type.model.TypeModel;
import com.example.haoji.phoneticsymbol.type.presenter.TypePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Response;
import zuo.biao.library.util.ZbLog;

/**
 * Created by HAOJI on 2019/12/11.
 */

public class ShowDetailActivity extends Activity implements MyScrollView.OnFixHeadListener {

    @BindView(R.id.iv_hover_black)
    public ImageView iv_hover_black;

    @BindView(R.id.id_add_study)
    public Button id_add_study;

    @BindView(R.id.click_to)
    public TextView click_to;

    @BindView(R.id.ho_recyclerview)
    public RecyclerView recyclerView;

    @BindView(R.id.view_hover)
    public MyScrollView view_hover;

    @BindView(R.id.head_bar_linear)
    public RelativeLayout headBarLayout;

    private LinearLayoutManager manager;
    private boolean fixedFlag = false, resetFlag = false;
    private TypePresenter typePresenter;
    private Context context = ShowDetailActivity.this;

    @OnClick({R.id.iv_hover_black,R.id.id_add_study,R.id.click_to})
    public void onViewClicked(View v){
        switch (v.getId()) {
            case R.id.iv_hover_black:
                finish();
                break;
            case R.id.id_add_study:
                if (UserData.userId.equals("")){
                    return;
                }
                String userId = UserData.userId;
                typePresenter.getPostBean(context, "http://192.168.0.44:9093/collect", "http://dsfdsfdsf", userId, "的方式fsafs收到", "胜多负少的", new SuccessCallBack() {
                    @Override
                    public void IsSuccess(String data) {
                        ZbLog.e("ShowDetailActivity","--data:"+data.toString());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(context,"订阅成功",Toast.LENGTH_SHORT).show();
                            }
                        });

                    }

                    @Override
                    public void IsFailed(String msg) {

                    }

                    @Override
                    public void IsReSuccess(Response<DataBean1> data) {

                    }
                });
                ZbLog.e("ShowDetailActivity","--id_add_study---click-");
                break;
            case R.id.click_to:
                clearlyMove2Position(11);
                view_hover.post(new Runnable() {
                    @Override
                    public void run() {
                        view_hover.scrollTo(0, headBarLayout.getTop());
                    }
                });
                ZbLog.e("ShowDetailActivity","--click_to---click-");
                break;
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hover);
        ButterKnife.bind(this);

        data();
        initListener();

    }

    private void data() {
         typePresenter =new TypePresenter(this);
        view_hover.setFixHeadListener(this);
        manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.getLayoutParams().height = getScreenHeight(this) - dp2px(this, 50);
        LearnMeRecyclerViewAdapter lv = new LearnMeRecyclerViewAdapter(this);
        recyclerView.setAdapter(lv);
    }

    private void initListener() {

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int last = manager.findLastVisibleItemPosition();
                int first = manager.findFirstVisibleItemPosition();
                int count = manager.getChildCount();
                System.out.println("first=" + first + ";last=" + last + ";count=" + count);
            }

        });

    }

    //move Method without animation
    private void clearlyMove2Position(int pos) {
        manager.scrollToPositionWithOffset(pos, 0);
        manager.setStackFromEnd(false);
    }

    @Override
    public void onFix() {
        enableNestedScrolling(recyclerView);
    }

    @Override
    public void onReset() {
        disableNestedScrolling(recyclerView);
    }

    //Enable nested scrolling of recyclerView in ScrollView
    private void enableNestedScrolling(RecyclerView recyclerView) {
        if (recyclerView != null) {
            if (!fixedFlag) {
                setFixedFlag();
                recyclerView.setNestedScrollingEnabled(true);
            }
        }
    }

    //Disable nested scrolling of recyclerView in ScrollView
    private void disableNestedScrolling(RecyclerView recyclerView) {
        if (recyclerView != null) {
            if (!resetFlag) {
                setResetFlag();
                recyclerView.setNestedScrollingEnabled(false);
            }
        }
    }

    private void setFixedFlag() {
        setFlag(false);
    }

    private void setResetFlag() {
        setFlag(true);
    }

    //True:reset;false:fix
    private void setFlag(boolean reset) {
        if (reset) {
            resetFlag = true;
            fixedFlag = false;
        } else {
            fixedFlag = true;
            resetFlag = false;
        }
    }

    public int getScreenHeight(Context context) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public int dp2px(Context context, float dpValue) {
        if (null == context) {
            return 0;
        }
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


}
