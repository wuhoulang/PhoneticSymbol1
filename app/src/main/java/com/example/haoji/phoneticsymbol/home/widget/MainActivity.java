package com.example.haoji.phoneticsymbol.home.widget;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.haoji.phoneticsymbol.R;
import com.example.haoji.phoneticsymbol.base.BaseFragment;
import com.example.haoji.phoneticsymbol.home.widget.need.BottomNavigationViewHelper;
import com.example.haoji.phoneticsymbol.main.widget.ThreeFragment;
import com.example.haoji.phoneticsymbol.study.widget.StudyFragment;
import com.example.haoji.phoneticsymbol.type.widget.TwoNewFragment;
import com.example.haoji.phoneticsymbol.utils.PermissionsUtils;
import com.example.haoji.phoneticsymbol.utils.ScreenAdapterUtil;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by HAOJI on 2019/8/22.
 */

public class MainActivity extends FragmentActivity {
    private List<BaseFragment> fragments;
    private Context context = MainActivity.this;
    private BottomNavigationView rg_main;
    private int position = 0;
    private BaseFragment mContext;
    private FrameLayout frameLayout;
    private long mExitTime = 0; //这个是全局变量

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initview();
    }

    private void initview() {
        //设计图纸的总宽度，屏幕宽度为 1080px，480DPI，屏幕总dp宽度为 1080 / (480 / 160) = 360dp
        //屏幕的总 px 宽度 / density = 360dp 屏幕的总 dp 宽度(与屏幕总dp宽度保持一致)
        //当前设备屏幕总宽度（px）/ 设计图总宽度（单位为 dp) = density
        ScreenAdapterUtil.match(context, 360);
        setContentView(R.layout.activity_main);
        frameLayout = findViewById(R.id.frameLayout);
        rg_main = (BottomNavigationView) findViewById(R.id.rg_main);
        //取消底部导航栏位移效果
        BottomNavigationViewHelper.disableShiftMode(rg_main);
        fragments = new ArrayList<>();
        HomeFragment one = HomeFragment.newInstance(context);
        StudyFragment stu =StudyFragment.newInstance(context);
        ThreeFragment three = ThreeFragment.newInstance(context);
        TwoNewFragment two = TwoNewFragment.newInstance(context);
        fragments.add(one);
        fragments.add(stu);
        fragments.add(two);
        fragments.add(three);
        initOnListener();
        rg_main.setSelectedItemId(R.id.one_rt);
    }

    private void initOnListener() {
        rg_main.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.one_rt:
                        position = 0;
                        base();
                        return true;
                    case R.id.new_rt:
                        position = 1;
                        base();
                        return true;
                    case R.id.two_rt:
                        position = 2;
                        base();
                        return true;
                    case R.id.three_rt:
                        position = 3;
                        base();
                        return true;

                }
                return false;
            }
        });
    }

    private void base() {
        BaseFragment baseFragment = getFragment(position);
        switchFragment(mContext, baseFragment);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    private BaseFragment getFragment(int position) {
        if (fragments != null && fragments.size() > 0) {
            BaseFragment baseFragment = fragments.get(position);
            return baseFragment;
        }
        return null;
    }

    private void switchFragment(Fragment fromFragment, BaseFragment nextFragment) {
        if (mContext != nextFragment) {
            mContext = nextFragment;
            if (nextFragment != null) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                //判断nextFragment是否添加
                if (!nextFragment.isAdded()) {
                    //隐藏当前Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                        Log.e("switchFragment", "----11--------");
                    }
                    transaction.add(R.id.frameLayout, nextFragment).commit();
                    Log.e("switchFragment", "----2222222--------");
                } else {
                    //隐藏当前Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.show(nextFragment).commit();
                }
            }
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //就多一个参数this
        PermissionsUtils.getInstance().onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                if ((System.currentTimeMillis() - mExitTime) > 2000) {
                    Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
                    mExitTime = System.currentTimeMillis();
                    Log.e("PY", "2000");
                } else {
                    finish();
                    Log.e("PY", "finish");
                }
                return true;

            default:
                break;
        }
        return super.onKeyDown(keyCode, event);
    }


}
