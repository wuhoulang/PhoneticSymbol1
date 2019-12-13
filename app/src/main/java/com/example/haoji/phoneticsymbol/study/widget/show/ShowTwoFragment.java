package com.example.haoji.phoneticsymbol.study.widget.show;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.haoji.phoneticsymbol.R;


/**
 * Created by HAOJI on 2019/8/22.
 */

@SuppressLint("ValidFragment")
public class ShowTwoFragment extends Fragment {


    private static Context context;
    private View view;
    private Button bt_video;

    public ShowTwoFragment() {
    }

    public static ShowTwoFragment newInstance(Context context1) {
        context = context1;
        ShowTwoFragment fragment = new ShowTwoFragment();
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.show_two, container, false);
        initview();
        return view;
    }

    private void initview() {
        bt_video = view.findViewById(R.id.bt_video);
        bt_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, VideoViewActivity.class);
                startActivity(intent);
            }
        });
    }

}
