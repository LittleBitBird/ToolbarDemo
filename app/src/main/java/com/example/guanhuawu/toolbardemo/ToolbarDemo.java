package com.example.guanhuawu.toolbardemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class ToolbarDemo extends AppCompatActivity implements View.OnClickListener {


    private Toolbar toolbar;
    private Button auxiliary_button_enable;
    private Button auxiliary_button_unenable;
    private Button main_button_enable;
    private Button main_button_unenable;
    private PetImage first_circle_view;
    private PetImage second_circle_view;
    private PetImage[] petImages;
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_demo);
        initView();

        first_circle_view.circleImageView.setOnClickListener(onclickPetImage1);
        second_circle_view.circleImageView.setOnClickListener(onclickPetImage2);
        setPressedEvent();
    }


    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        auxiliary_button_enable = (Button) findViewById(R.id.auxiliary_button_enable);
        auxiliary_button_unenable = (Button) findViewById(R.id.auxiliary_button_unenable);
        main_button_enable = (Button) findViewById(R.id.main_button_enable);
        main_button_unenable = (Button) findViewById(R.id.main_button_unenable);
        first_circle_view = (PetImage) findViewById(R.id.first_circle_view);
        second_circle_view = (PetImage) findViewById(R.id.second_circle_view);

        auxiliary_button_enable.setOnClickListener(this);
        auxiliary_button_unenable.setOnClickListener(this);
        main_button_enable.setOnClickListener(this);
        main_button_unenable.setOnClickListener(this);
        petImages = new PetImage[]{first_circle_view, second_circle_view};
    }

    public void setPressedEvent(){
        final Context context = this.getApplicationContext();
        auxiliary_button_enable.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    ButtonStyleUtil.mainButtonPressed((Button)view,context);
                }
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.auxiliary_button_enable:
                getAllButtonStyle(v);
                break;
            case R.id.auxiliary_button_unenable:

                break;
            case R.id.main_button_enable:

                break;
            case R.id.main_button_unenable:

                break;
        }
    }

    public void getAllButtonStyle(View view) {
        int i = index % 9;
        index++;
        switch (i) {
            case 0:
                ButtonStyleUtil.mainButtonEnable((Button) view, this.getApplicationContext());
                break;
            case 1:
                ButtonStyleUtil.mainButtonPressed((Button) view, this.getApplicationContext());
                break;
            case 2:
                ButtonStyleUtil.mainButtonDisable((Button) view, this.getApplicationContext());
                break;
            case 3:
                ButtonStyleUtil.auxiliaryButtonEnable((Button) view, this.getApplicationContext());
                break;
            case 4:
                ButtonStyleUtil.auxiliaryButtonPressed((Button) view, this.getApplicationContext());
                break;
            case 5:
                ButtonStyleUtil.auxiliaryButtonDisable((Button) view, this.getApplicationContext());
                break;
            case 6:
                ButtonStyleUtil.wordButtonEnable((Button) view, this.getApplicationContext());
                break;
            case 7:
                ButtonStyleUtil.wordButtonPressed((Button) view, this.getApplicationContext());
                break;
            case 8:
                ButtonStyleUtil.wordButtonDisable((Button) view, this.getApplicationContext());
                break;
        }
    }

    View.OnClickListener onclickPetImage1 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            clearPetImages();
            PetImage petImage = first_circle_view;
            petImage.initT();
            petImage.circleImageView.setBorderColor(getResources().getColor(R.color.alo7_blue));
            petImage.t.setVisibility(View.VISIBLE);
        }
    };

    View.OnClickListener onclickPetImage2 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            clearPetImages();
            PetImage petImage = second_circle_view;
            petImage.initT();
            petImage.circleImageView.setBorderColor(getResources().getColor(R.color.alo7_blue));
            petImage.t.setVisibility(View.VISIBLE);
        }
    };


    public void clearPetImages() {
        for (int i = 0; i < petImages.length; i++) {
            Log.e("a", "onClick2");
            petImages[i].circleImageView.setBorderColor(getResources().getColor(R.color.alo7_light_gray));
            petImages[i].t.setVisibility(View.GONE);
        }
    }
}
