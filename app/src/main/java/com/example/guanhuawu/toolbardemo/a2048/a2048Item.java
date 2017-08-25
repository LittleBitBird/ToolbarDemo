package com.example.guanhuawu.toolbardemo.a2048;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.Gravity;

import com.example.guanhuawu.toolbardemo.R;

/**
 * Created by guanhua.wu on 2017/8/24.
 */

public class a2048Item extends android.support.v7.widget.AppCompatTextView {
    private int lastX;
    private int nowX;
    private int lastY;
    private int nowY;

    public a2048Item(Context context) {
        this(context, null);
    }

    public a2048Item(String text, Context context) {
        this(context);
        initItem(text);
    }

    public a2048Item(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public a2048Item(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setWidth(getContext().getResources().getDimensionPixelOffset(R.dimen.a2048_item_width));
        this.setHeight(getContext().getResources().getDimensionPixelOffset(R.dimen.a2048_item_width));
        this.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.a2048_2_background));
        this.setText("2");
        this.setTextSize(40);
        this.setGravity(Gravity.CENTER);
        this.getPaint().setFakeBoldText(true);
    }

    public void initItem(String text) {
        this.setText(text);
        switch (text) {
            case "2":
                this.setText("2");
                break;
            case "4":
                this.setText("4");
                break;
            case "8":
                this.setText("8");
                break;
            case "16":
                this.setText("16");
                break;
            case "32":
                this.setText("32");
                break;
            case "64":
                this.setText("64");
                break;
            case "128":
                this.setText("128");
                break;
            case "256":
                this.setText("256");
                break;
            case "512":
                this.setText("512");
                break;
            case "1024":
                this.setText("1024");
                break;
            case "2048":
                this.setText("2048");
                break;
            case "4096":
                this.setText("4096");
                break;
            default:
                this.setVisibility(INVISIBLE);
                this.setText("");
                this.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.a2048_null_background));
        }
    }

    public int getLastX() {
        return lastX;
    }

    public void setLastX(int lastX) {
        this.lastX = lastX;
    }

    public int getNowX() {
        return nowX;
    }

    public void setNowX(int nowX) {
        this.nowX = nowX;
    }

    public int getLastY() {
        return lastY;
    }

    public void setLastY(int lastY) {
        this.lastY = lastY;
    }

    public int getNowY() {
        return nowY;
    }

    public void setNowY(int nowY) {
        this.nowY = nowY;
    }
}
