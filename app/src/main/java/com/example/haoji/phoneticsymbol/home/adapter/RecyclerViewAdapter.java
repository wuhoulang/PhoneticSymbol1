package com.example.haoji.phoneticsymbol.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import com.example.haoji.phoneticsymbol.R;
import com.example.haoji.phoneticsymbol.component.MusicServices;
import com.example.haoji.phoneticsymbol.home.bean.DataBean1;
import com.example.haoji.phoneticsymbol.home.bean.GoodsBean;
import com.example.haoji.phoneticsymbol.home.widget.SpeakActivity;

import java.io.Serializable;
import java.util.List;


/**
 * Created by HAOJI on 2019/8/2.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    //extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder
    public Context mContext;
    public MusicServices service;
    private static final int EEGLISHSPEAK = 0;

    private static final int EEGLISHIMAGE = 1;

    private static final int EEGLISHBIAO = 2;

    private static final int EEGLISHIMAGE_TWO = 3;

    private static final int EEGLISHBIAO_TWO = 4;

    private static final int EEGLISHIMAGE_THREE = 5;

    private static final int EEGLISHBIAO_THREE = 6;

    private static final int EEGLISHIMAGE_FOUR = 7;

    private static final int EEGLISHBIAO_FOUT = 8;

    private static final int EEGLISHIMAGE_FIVE = 9;

    private static final int EEGLISHBIAO_FIVE = 10;

    private static final int EEGLISHIMAGE_SIX = 11;

    private static final int EEGLISHBIAO_SIX = 12;

    private static final int EEGLISHIMAGE_SEVEN = 13;

    private int currentType = EEGLISHSPEAK;

    private List<DataBean1.LineOneBean.ContentBean.PageDataBean> page_data1;
    private List<DataBean1.LineTwoBean.ContentBeanX.PageDataBeanX> page_data2;
    private List<DataBean1.LineThreeBean.ContentBeanXX.PageDataBeanXX> page_data3;
    private List<DataBean1.LineFourBean.ContentBeanXXX.PageDataBeanXXX> page_data4;
    private List<DataBean1.LineFiveBean.ContentBeanXXXX.PageDataBeanXXXX> page_data5;
    private List<DataBean1.LineSixBean.ContentBeanXXXXX.PageDataBeanXXXXX> page_data6;
    private List<DataBean1.LineSevenBean.ContentBeanXXXXXX.PageDataBeanXXXXXX> page_data7;
    private List<DataBean1.LineEightBean.ContentBeanXXXXXXX.PageDataBeanXXXXXXX> page_data8;
    private List<DataBean1.LineNineBean.ContentBeanXXXXXXXX.PageDataBeanXXXXXXXX> page_data9;
    private List<DataBean1.LineTenBean.ContentBeanXXXXXXXXX.PageDataBeanXXXXXXXXX> page_data10;
    private List<DataBean1.LineElevenBean.ContentBeanXXXXXXXXXX.PageDataBeanXXXXXXXXXX> page_data11;
    private List<DataBean1.LineTwelveBean.ContentBeanXXXXXXXXXXX.PageDataBeanXXXXXXXXXXX> page_data12;
    private List<DataBean1.LineThirteenBean.ContentBeanXXXXXXXXXXXX.PageDataBeanXXXXXXXXXXXX> page_data13;
    private List<DataBean1.LineFourteenBean.ContentBeanXXXXXXXXXXXXX.PageDataBeanXXXXXXXXXXXXX> page_data14;


    public RecyclerViewAdapter(Context context, List<DataBean1.LineOneBean.ContentBean.PageDataBean> page_data1, List<DataBean1.LineTwoBean.ContentBeanX.PageDataBeanX> page_data2, List<DataBean1.LineThreeBean.ContentBeanXX.PageDataBeanXX> page_data3, List<DataBean1.LineFourBean.ContentBeanXXX.PageDataBeanXXX> page_data4, List<DataBean1.LineFiveBean.ContentBeanXXXX.PageDataBeanXXXX> page_data5, List<DataBean1.LineSixBean.ContentBeanXXXXX.PageDataBeanXXXXX> page_data6, List<DataBean1.LineSevenBean.ContentBeanXXXXXX.PageDataBeanXXXXXX> page_data7, List<DataBean1.LineEightBean.ContentBeanXXXXXXX.PageDataBeanXXXXXXX> page_data8,
                               List<DataBean1.LineNineBean.ContentBeanXXXXXXXX.PageDataBeanXXXXXXXX> page_data9, List<DataBean1.LineTenBean.ContentBeanXXXXXXXXX.PageDataBeanXXXXXXXXX> page_data10, List<DataBean1.LineElevenBean.ContentBeanXXXXXXXXXX.PageDataBeanXXXXXXXXXX> page_data11, List<DataBean1.LineTwelveBean.ContentBeanXXXXXXXXXXX.PageDataBeanXXXXXXXXXXX> page_data12, List<DataBean1.LineThirteenBean.ContentBeanXXXXXXXXXXXX.PageDataBeanXXXXXXXXXXXX> page_data13, List<DataBean1.LineFourteenBean.ContentBeanXXXXXXXXXXXXX.PageDataBeanXXXXXXXXXXXXX> page_data14) {
                this.mContext = context;
        this.page_data1 = page_data1;
        this.page_data2 = page_data2;
        this.page_data3 = page_data3;
        this.page_data4 = page_data4;
        this.page_data5 = page_data5;
        this.page_data6 = page_data6;
        this.page_data7 = page_data7;
        this.page_data8 = page_data8;
        this.page_data9 = page_data9;
        this.page_data10 = page_data10;
        this.page_data11 = page_data11;
        this.page_data12 = page_data12;
        this.page_data13 = page_data13;
        this.page_data14 = page_data14;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        GridView id_gv;
        GridView id_gv2;

        public ViewHolder(View view) {
            super(view);
            id_gv = view.findViewById(R.id.id_gv);
            id_gv2 = view.findViewById(R.id.id_gv2);
//            id_iv10 = view.findViewById(R.id.id_iv10);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == EEGLISHSPEAK) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.activity_main2, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        } else if (viewType == EEGLISHIMAGE) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.activity_image, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        } else if (viewType == EEGLISHBIAO) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.activity_title, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        } else if (viewType == EEGLISHIMAGE_TWO) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.activity_main2, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        } else if (viewType == EEGLISHBIAO_TWO) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.activity_title, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        } else if (viewType == EEGLISHIMAGE_THREE) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.activity_main2, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        } else if (viewType == EEGLISHBIAO_THREE) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.activity_title, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        } else if (viewType == EEGLISHIMAGE_FOUR) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.activity_main2, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        } else if (viewType == EEGLISHBIAO_FOUT) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.activity_title, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        } else if (viewType == EEGLISHIMAGE_FIVE) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.activity_main2, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        } else if (viewType == EEGLISHBIAO_FIVE) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.activity_title, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        } else if (viewType == EEGLISHIMAGE_SIX) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.activity_main2, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        } else if (viewType == EEGLISHBIAO_SIX) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.activity_title, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        } else if (viewType == EEGLISHIMAGE_SEVEN) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.activity_main2, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }
        return null;
    }


    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case EEGLISHSPEAK:
                currentType = EEGLISHSPEAK;
                break;
            case EEGLISHIMAGE:
                currentType = EEGLISHIMAGE;
                break;
            case EEGLISHBIAO:
                currentType = EEGLISHBIAO;
                break;
            case EEGLISHIMAGE_TWO:
                currentType = EEGLISHIMAGE_TWO;
                break;
            case EEGLISHBIAO_TWO:
                currentType = EEGLISHBIAO_TWO;
                break;
            case EEGLISHIMAGE_THREE:
                currentType = EEGLISHIMAGE_THREE;
                break;
            case EEGLISHBIAO_THREE:
                currentType = EEGLISHBIAO_THREE;
                break;
            case EEGLISHIMAGE_FOUR:
                currentType = EEGLISHIMAGE_FOUR;
                break;
            case EEGLISHBIAO_FOUT:
                currentType = EEGLISHBIAO_FOUT;
                break;
            case EEGLISHIMAGE_FIVE:
                currentType = EEGLISHIMAGE_FIVE;
                break;
            case EEGLISHBIAO_FIVE:
                currentType = EEGLISHBIAO_FIVE;
                break;
            case EEGLISHIMAGE_SIX:
                currentType = EEGLISHIMAGE_SIX;
                break;
            case EEGLISHBIAO_SIX:
                currentType = EEGLISHBIAO_SIX;
                break;
            case EEGLISHIMAGE_SEVEN:
                currentType = EEGLISHIMAGE_SEVEN;
                break;
        }
        return currentType;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (position==0||position == 3 || position == 5 || position == 7 || position == 9 || position == 11 || position == 13) {
            GridViewAdapter ga = new GridViewAdapter(mContext, position);
            holder.id_gv.setAdapter(ga);
            GridViewAdapter2 ga2 = new GridViewAdapter2(mContext, position);
            holder.id_gv2.setAdapter(ga2);
            setItemData(holder, position);
        }


    }

    private void setItemData(@NonNull ViewHolder holder, final int pos) {
        holder.id_gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                GoodsBean goodsBean1 =null;
                Intent intent = new Intent(mContext, SpeakActivity.class);
                if (pos == 0) {
                     goodsBean1 =new GoodsBean(page_data1.get(position).getChinesename(),page_data1.get(position).getEnglishname(),page_data1.get(position).getPicture(),page_data1.get(position).getMusic(),page_data1.get(position).getYinbiao());
                    intent.putExtra("name", goodsBean1);
                } else if (pos == 3) {
                    goodsBean1 =new GoodsBean(page_data3.get(position).getChinesename(),page_data3.get(position).getEnglishname(),page_data3.get(position).getPicture(),page_data3.get(position).getMusic(),page_data3.get(position).getYinbiao());
                    intent.putExtra("name", (Serializable) page_data3);
                } else if (pos == 5) {
                    goodsBean1 =new GoodsBean(page_data5.get(position).getChinesename(),page_data5.get(position).getEnglishname(),page_data5.get(position).getPicture(),page_data5.get(position).getMusic(),page_data5.get(position).getYinbiao());
                    intent.putExtra("name", (Serializable) page_data5);
                }else if (pos == 7) {
                    goodsBean1 =new GoodsBean(page_data7.get(position).getChinesename(),page_data7.get(position).getEnglishname(),page_data7.get(position).getPicture(),page_data7.get(position).getMusic(),page_data7.get(position).getYinbiao());
                    intent.putExtra("name", (Serializable) page_data7);
                }else if (pos == 9) {
                    goodsBean1 =new GoodsBean(page_data9.get(position).getChinesename(),page_data9.get(position).getEnglishname(),page_data9.get(position).getPicture(),page_data9.get(position).getMusic(),page_data9.get(position).getYinbiao());
                    intent.putExtra("name", (Serializable) page_data9);
                }else if (pos == 11) {
                    goodsBean1 =new GoodsBean(page_data11.get(position).getChinesename(),page_data11.get(position).getEnglishname(),page_data11.get(position).getPicture(),page_data11.get(position).getMusic(),page_data11.get(position).getYinbiao());
                    intent.putExtra("name", (Serializable) page_data11);
                }else if (pos == 13) {
                    goodsBean1 =new GoodsBean(page_data13.get(position).getChinesename(),page_data13.get(position).getEnglishname(),page_data13.get(position).getPicture(),page_data13.get(position).getMusic(),page_data13.get(position).getYinbiao());
                    intent.putExtra("name", (Serializable) page_data13);
                }
                intent.putExtra("name", goodsBean1);
                intent.putExtra("position", pos);
                mContext.startActivity(intent);
                Log.e("onItemClick", "--int:" + position);
            }
        });

        holder.id_gv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                GoodsBean goodsBean1 = null;
                Intent intent = new Intent(mContext, SpeakActivity.class);
                if (pos == 0) {
                    goodsBean1 =new GoodsBean(page_data2.get(position).getChinesename(),page_data2.get(position).getEnglishname(),page_data2.get(position).getPicture(),page_data2.get(position).getMusic(),page_data2.get(position).getYinbiao());
                    intent.putExtra("name", (Serializable) page_data2);
                } else if (pos == 3) {
                    goodsBean1 =new GoodsBean(page_data4.get(position).getChinesename(),page_data4.get(position).getEnglishname(),page_data4.get(position).getPicture(),page_data4.get(position).getMusic(),page_data4.get(position).getYinbiao());
                    intent.putExtra("name", (Serializable) page_data4);
                } else if (pos == 5) {
                    goodsBean1 =new GoodsBean(page_data6.get(position).getChinesename(),page_data6.get(position).getEnglishname(),page_data6.get(position).getPicture(),page_data6.get(position).getMusic(),page_data6.get(position).getYinbiao());
                    intent.putExtra("name", (Serializable) page_data6);
                }else if (pos == 7) {
                    goodsBean1 =new GoodsBean(page_data8.get(position).getChinesename(),page_data8.get(position).getEnglishname(),page_data8.get(position).getPicture(),page_data8.get(position).getMusic(),page_data8.get(position).getYinbiao());
                    intent.putExtra("name", (Serializable) page_data8);
                }else if (pos == 9) {
                    goodsBean1 =new GoodsBean(page_data10.get(position).getChinesename(),page_data10.get(position).getEnglishname(),page_data10.get(position).getPicture(),page_data10.get(position).getMusic(),page_data10.get(position).getYinbiao());
                    intent.putExtra("name", (Serializable) page_data10);
                }else if (pos == 11) {
                    goodsBean1 =new GoodsBean(page_data12.get(position).getChinesename(),page_data12.get(position).getEnglishname(),page_data12.get(position).getPicture(),page_data12.get(position).getMusic(),page_data12.get(position).getYinbiao());
                    intent.putExtra("name", (Serializable) page_data12);
                }else if (pos == 13) {
                    goodsBean1 =new GoodsBean(page_data14.get(position).getChinesename(),page_data14.get(position).getEnglishname(),page_data14.get(position).getPicture(),page_data14.get(position).getMusic(),page_data14.get(position).getYinbiao());
                    intent.putExtra("name", (Serializable) page_data14);
                }
                intent.putExtra("name", goodsBean1);
                intent.putExtra("position", pos);
                mContext.startActivity(intent);
                Log.e("onItemClick", "--int:" + position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 14;
    }


}
