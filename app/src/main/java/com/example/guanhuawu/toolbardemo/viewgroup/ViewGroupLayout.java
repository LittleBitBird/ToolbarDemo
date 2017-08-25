package com.example.guanhuawu.toolbardemo.viewgroup;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by guanhua.wu on 2017/8/14.
 */

public class ViewGroupLayout extends ViewGroup {
    int r = 0;

    public ViewGroupLayout(Context context) {
        this(context, null);
    }

    public ViewGroupLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ViewGroupLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TextView view = new TextView(getContext());
        view.setText("123");
        this.addView(view);
    }

    @Override
    protected void onLayout(boolean b, int i0, int i1, int i2, int i3) {
        int childcount = getChildCount();
        int height = 0;
        for (int i = 0; i < childcount; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() == GONE) {
                continue;
            }
            child.layout(0, 0, 30, 30);
            height += child.getMeasuredHeight();
            Log.d("tag", "onLayout: i:" + i + ",width:" + child.getMeasuredWidth() + ",height:" + child.getMeasuredHeight());
        }
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        logModeAndSize(widthMeasureSpec);
        logModeAndSize(heightMeasureSpec);
        Log.e("tag", "onMeasure: height" + getMeasuredHeight() + ";width:" + getMeasuredWidth());
    }

    //打印测量模式和大小
    private void logModeAndSize(int measureSpec) {
        switch (MeasureSpec.getMode(measureSpec)) {
            case MeasureSpec.UNSPECIFIED:
                Log.d("tag", "UNSPECIFIED: " + MeasureSpec.getSize(measureSpec));
                break;
            case MeasureSpec.AT_MOST:
                Log.d("tag", "AT_MOST: " + MeasureSpec.getSize(measureSpec));
                break;
            case MeasureSpec.EXACTLY:
                Log.d("tag", "EXACTLY: " + MeasureSpec.getSize(measureSpec));
                break;
        }
    }
}
