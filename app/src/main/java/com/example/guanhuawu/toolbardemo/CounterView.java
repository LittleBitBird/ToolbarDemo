package com.example.guanhuawu.toolbardemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by guanhua.wu on 2017/7/24.
 */

public class CounterView extends View implements View.OnClickListener {
    private Paint mPaint;

    private Rect mBounds;

    private int mCount;

    public CounterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBounds = new Rect();
        setOnClickListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int r = getHeight()/2;
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.STROKE);
        RectF oval = new RectF(0, 0,
                getHeight(), getHeight());
        canvas.drawArc(oval, 90, 180, false, mPaint);//画圆弧，这个时候，绘制没有经过圆心
        RectF oval2 = new RectF(getWidth()-2*r, 0,
                getWidth(), 2*r);
        canvas.drawArc(oval2, -90, 180, false, mPaint);//画圆弧，这个时候，绘制没有经过圆心

        canvas.drawLine(r,0,getWidth()-r,0,mPaint);
        canvas.drawLine(r,getHeight(),getWidth()-r,getHeight(),mPaint);

//        mPaint.setColor(Color.WHITE);
//        canvas.drawRect(r, 0, getWidth()-r, getHeight()-1, mPaint);

//        mPaint.setColor(Color.YELLOW);
//        mPaint.setTextSize(30);
//        String text = String.valueOf(mCount);
//        mPaint.getTextBounds(text, 0, text.length(), mBounds);
//        float textWidth = mBounds.width();
//        float textHeight = mBounds.height();
//        canvas.drawText(text, getWidth() / 2 - textWidth / 2, getHeight() / 2
//                + textHeight / 2, mPaint);
    }

    @Override
    public void onClick(View view) {

    }
}
