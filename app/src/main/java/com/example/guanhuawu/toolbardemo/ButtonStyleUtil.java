package com.example.guanhuawu.toolbardemo;

import android.content.Context;
import android.widget.Button;

/**
 * Created by guanhua.wu on 2017/7/26.
 */

public class ButtonStyleUtil{

    public static void mainButtonEnable(Button button,Context context){
        button.setBackground(context.getResources().getDrawable(R.drawable.main_button_enable));
        button.setTextColor(context.getResources().getColor(R.color.alo7_white));
    }

    public static void mainButtonDisable(Button button,Context context){
        button.setBackground(context.getResources().getDrawable(R.drawable.main_button_disable));
        button.setTextColor(context.getResources().getColor(R.color.alo7_white));
    }

    public static void mainButtonPressed(Button button,Context context){
        button.setBackground(context.getResources().getDrawable(R.drawable.main_button_pressed));
        button.setTextColor(context.getResources().getColor(R.color.alo7_white));
    }

    public static void auxiliaryButtonEnable(Button button,Context context){
        button.setBackground(context.getResources().getDrawable(R.drawable.auxiliary_button_enable));
        button.setTextColor(context.getResources().getColor(R.color.alo7_blue));
    }

    public static void auxiliaryButtonDisable(Button button,Context context){
        button.setBackground(context.getResources().getDrawable(R.drawable.auxiliary_button_disable));
        button.setTextColor(context.getResources().getColor(R.color.alo7_disable_gray));
    }

    public static void auxiliaryButtonPressed(Button button,Context context){
        button.setBackground(context.getResources().getDrawable(R.drawable.auxiliary_button_pressed));
        button.setTextColor(context.getResources().getColor(R.color.alo7_blue));
    }

    public static void wordButtonEnable(Button button,Context context){
        button.setBackground(context.getResources().getDrawable(R.drawable.word_button_enable));
        button.setTextColor(context.getResources().getColor(R.color.alo7_blue));
    }

    public static void wordButtonDisable(Button button,Context context){
        button.setBackground(context.getResources().getDrawable(R.drawable.word_button_disable));
        button.setTextColor(context.getResources().getColor(R.color.alo7_disable_gray));
    }

    public static void wordButtonPressed(Button button,Context context){
        button.setBackground(context.getResources().getDrawable(R.drawable.word_button_pressed));
        button.setTextColor(context.getResources().getColor(R.color.alo7_pressed_blue));
    }
}
