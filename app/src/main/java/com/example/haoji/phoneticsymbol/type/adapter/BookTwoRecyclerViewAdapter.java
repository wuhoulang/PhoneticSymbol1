package com.example.haoji.phoneticsymbol.type.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.haoji.phoneticsymbol.R;


/**
 * Created by HAOJI on 2019/8/2.
 */

public class BookTwoRecyclerViewAdapter extends RecyclerView.Adapter<BookTwoRecyclerViewAdapter.ViewHolder> {

    private int currentType = 0;

    private static final int SHOW_BOOK = 0;
    private static final int SHOW_BOOK_ONE = 1;

    private Context context;

    public BookTwoRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        GridView gv_book;

        public ViewHolder(View view) {
            super(view);
            gv_book = view.findViewById(R.id.gv_book);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == SHOW_BOOK) {
            View view = LayoutInflater.from(context).inflate(R.layout.show_book_item, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        } else if (viewType == SHOW_BOOK_ONE) {
            View view = LayoutInflater.from(context).inflate(R.layout.show_book_item, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                currentType = SHOW_BOOK;
                break;
            case 1:
                currentType = SHOW_BOOK_ONE;
                break;
            default:
                break;
        }
        return currentType;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (position == 0) {
            GridViewBookTwoAdapter gv = new GridViewBookTwoAdapter(context);
            holder.gv_book.setAdapter(gv);
            holder.gv_book.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Log.e("gv_book","1111111111111111111111111111111");
                }
            });
        }else if (position == 1) {
            GridViewBookTwoAdapter gv1 = new GridViewBookTwoAdapter(context);
            holder.gv_book.setAdapter(gv1);
            holder.gv_book.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Log.e("gv_book","2222222222222222222222222");
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return 2;
    }


}
