package com.example.guanhuawu.toolbardemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by guanhua.wu on 2017/7/25.
 */

public class PetImage extends RelativeLayout implements View.OnFocusChangeListener, View.OnClickListener {
    CircleImageView circleImageView;
    ImageView t;
    int circleViewPath;

    public PetImage(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.image, this, true);
        this.setFocusable(true);
        this.setFocusableInTouchMode(true);
        this.setClickable(true);

        initCircleImageView();
        initT();

    }

    public void initCircleImageView() {
        circleImageView = (CircleImageView) findViewById(R.id.circleImageView);
//        circleImageView.setFocusable(true);
//        circleImageView.setFocusableInTouchMode(true);
//        circleImageView.setOnFocusChangeListener(this);
//        circleImageView.setOnClickListener(this);
    }

    public void initT() {
        t = (ImageView) findViewById(R.id.ivt);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics())); //WRAP_CONTENT param can be FILL_PARENT
        params.leftMargin =(int)Math.floor(circleImageView.getWidth() * 0.75);  //XCOORD
        params.topMargin = (int)Math.floor(circleImageView.getHeight() * 0.75); //YCOORD

        t.setLayoutParams(params);
        t.setVisibility(GONE);

//        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CircleImageView, defStyle, 0);
//
//        circleViewPath = a.getInteger(R.styleable.P)
    }

    public void changePetView(int petView) {
        circleImageView.setImageResource(petView);
    }


    @Override
    public void onFocusChange(View view, boolean b) {
        if (b) {
            Log.e("a", "focused" + circleViewPath);
            circleImageView.setBorderColor(getResources().getColor(R.color.alo7_blue));
            initT();
            t.setVisibility(VISIBLE);
        } else {
            Log.e("a", "unfocused" + circleViewPath);
            circleImageView.setBorderColor(getResources().getColor(R.color.alo7_light_gray));
            t.setVisibility(GONE);
        }
    }

    @Override
    public void onClick(View view) {
//        circleImageView.requestFocus();
        initT();
        Log.e("a", "Override" + circleViewPath);
        circleImageView.setBorderColor(getResources().getColor(R.color.alo7_blue));
    }

    public double convertToDp(int i){
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, i, getResources().getDisplayMetrics());
    }
}
