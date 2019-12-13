package zuo.biao.library.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by HAOJI on 2019/12/13.
 * 用于解决RecyclerView嵌套RecyclerView触摸冲突的问题
 */

public class ChildRecyclerView extends RecyclerView {

    public ChildRecyclerView(Context context) {
        super(context);
    }

    public ChildRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ChildRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        //父层ViewGroup不要拦截点击事件
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(ev);
    }

}
