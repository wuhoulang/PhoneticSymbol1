package com.example.haoji.phoneticsymbol.study.widget.show;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.haoji.phoneticsymbol.R;


/**
 * Created by HAOJI on 2019/8/22.
 */

@SuppressLint("ValidFragment")
public class ShowFourFragment extends Fragment {

    private static Context context;

    public ShowFourFragment() {
    }

    public static ShowFourFragment newInstance(Context context1) {
        context = context1;
        ShowFourFragment fragment = new ShowFourFragment();
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.show_four,container,false);
        return view;
    }


}
