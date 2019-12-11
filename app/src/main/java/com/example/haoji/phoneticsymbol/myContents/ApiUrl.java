package com.example.haoji.phoneticsymbol.myContents;

import com.example.haoji.phoneticsymbol.home.bean.DataBean1;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by HAOJI on 2019/11/29.
 */

public interface ApiUrl {

    @GET(ContentsJson.BASE_ONE_JSON_DAN_ONE1)
    Call<DataBean1> getRetrofit();

    @GET(ContentsJson.BASE_ONE_JSON_DAN_ONE1)
    Observable<DataBean1> getDemo();

}
