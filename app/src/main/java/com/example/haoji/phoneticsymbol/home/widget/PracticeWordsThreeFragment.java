package com.example.haoji.phoneticsymbol.home.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.haoji.phoneticsymbol.R;
import com.example.haoji.phoneticsymbol.base.BaseFragment;
import com.example.haoji.phoneticsymbol.home.bean.DataBean1;
import com.example.haoji.phoneticsymbol.home.interf.SuccessCallBack;
import com.example.haoji.phoneticsymbol.home.presenter.HomePresenter;

import retrofit2.Response;
import zuo.biao.library.util.Log;

/**
 * Created by HAOJI on 2019/12/14.
 */

@SuppressLint("ValidFragment")
public class PracticeWordsThreeFragment extends BaseFragment {

    private static Context context;
    private  HomePresenter homePresenter;
    private View view;
    private TextView tv_practice_title_one,tv_practice_five_one,
            tv_practice_sutitle_one,tv_practice_title_two,tv_practice_five_two,tv_practice_title_three,tv_practice_five_three,tv_practice_title_four,tv_practice_five_four;
    private TextView id_prathree_sutitle_one,tv_practice_sutitle_two,tv_practice_sutitle_three,tv_practice_sutitle_four;
    private static String pic;
    public PracticeWordsThreeFragment(){
    }

    public static PracticeWordsThreeFragment newInstance(Context mContext,String mPic){
        context = mContext;
        pic = mPic;
        return new PracticeWordsThreeFragment();
    }

    @Override
    public View initView() {
         view =View.inflate(context, R.layout.practice_fragment_three,null);
        init();
        return view;
    }

    private void init() {

        String[] split = pic.split("\\,",-1);
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            Log.e("PracticeWordsThreeFragment","split:"+s);
        }

        LinearLayout linearLayoutOne= view.findViewById(R.id.practice_in_one);
        tv_practice_title_one = linearLayoutOne.findViewById(R.id.tv_practice_title);
        tv_practice_five_one  = linearLayoutOne.findViewById(R.id.id_prathree_five);
        id_prathree_sutitle_one  = linearLayoutOne.findViewById(R.id.id_prathree_sutitle);


        if (!split[0].equals("")){
            tv_practice_title_one.setText(split[0]);
        }

        if (!split[1].equals("")){
            tv_practice_five_one.setText(split[1]);
        }

        if (!split[2].equals("")){
            id_prathree_sutitle_one.setText(split[2]);
        }

        LinearLayout linearLayoutTwo= view.findViewById(R.id.practice_in_two);
        tv_practice_title_two = linearLayoutTwo.findViewById(R.id.tv_practice_title);
        tv_practice_five_two  = linearLayoutTwo.findViewById(R.id.id_prathree_five);
        tv_practice_sutitle_two  = linearLayoutTwo.findViewById(R.id.id_prathree_sutitle);
        if (!split[3].equals("")){
            tv_practice_title_two.setText(split[3]);
        }


        if (!split[4].equals("")){
            tv_practice_five_two.setText(split[4]);
        }


        if (!split[5].equals("")){
            tv_practice_sutitle_two.setText(split[5]);
        }

        LinearLayout linearLayoutThree= view.findViewById(R.id.practice_in_three);
        tv_practice_title_three = linearLayoutThree.findViewById(R.id.tv_practice_title);
        tv_practice_five_three = linearLayoutThree.findViewById(R.id.id_prathree_five);
        tv_practice_sutitle_three = linearLayoutThree.findViewById(R.id.id_prathree_sutitle);



        if (!split[6].equals("")){
            tv_practice_title_three.setText(split[6]);
        }

        if (!split[7].equals("")){
            tv_practice_five_three.setText(split[7]);
        }

        if (!split[8].equals("")){
            tv_practice_sutitle_three.setText(split[8]);
        }

        LinearLayout linearLayoutFour= view.findViewById(R.id.practice_in_four);
        tv_practice_title_four = linearLayoutFour.findViewById(R.id.tv_practice_title);
        tv_practice_five_four  = linearLayoutFour.findViewById(R.id.id_prathree_five);
        tv_practice_sutitle_four  = linearLayoutFour.findViewById(R.id.id_prathree_sutitle);


        if (!split[9].equals("")){
            tv_practice_title_four.setText(split[9]);
        }

        if (!split[10].equals("")){
            tv_practice_five_four.setText(split[10]);
        }

        if (!split[11].equals("")){
            tv_practice_sutitle_four.setText(split[11]);
        }

    }

}
