package com.example.haoji.phoneticsymbol.type.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.haoji.phoneticsymbol.R;
import com.example.haoji.phoneticsymbol.type.adapter.LearnMeRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HAOJI on 2019/12/11.
 */

public class ShowDetailActivity extends Activity implements MyScrollView.OnFixHeadListener{
    private MyScrollView view_hover;
    private RecyclerView recyclerView;
    private RelativeLayout headBarLayout;
    private LinearLayoutManager manager;
    private boolean fixedFlag = false, resetFlag = false;
    private List<String> headTitles = new ArrayList<>();
    private int selectPos = 0;
    private TextView other,airStop;
    private ImageView iv_hover_black;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hover);
        view_hover = (MyScrollView) findViewById(R.id.view_hover);
        iv_hover_black = findViewById(R.id.iv_hover_black);
        view_hover.setFixHeadListener(this);
        headBarLayout = (RelativeLayout) findViewById(R.id.head_bar_linear);
        findViewById(R.id.click_to).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearlyMove2Position(11);
                view_hover.post(new Runnable() {
                    @Override
                    public void run() {
                        view_hover.scrollTo(0, headBarLayout.getTop());
                    }
                });
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.getLayoutParams().height = getScreenHeight(this) - dp2px(this, 50);
        LearnMeRecyclerViewAdapter lv =new LearnMeRecyclerViewAdapter(this);
        recyclerView.setAdapter(lv);

        iv_hover_black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

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
