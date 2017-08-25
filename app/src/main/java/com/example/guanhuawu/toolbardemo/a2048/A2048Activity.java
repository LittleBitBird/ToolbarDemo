package com.example.guanhuawu.toolbardemo.a2048;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.guanhuawu.toolbardemo.R;

public class A2048Activity extends AppCompatActivity {
    private static final int ITEM_MAX_NUMBER_ROW = 4;
    private static final int ITEM_MAX_INDEX_ROW = 3;
    a2048Item[] a2048Items = new a2048Item[4];
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a2048);
        final a2048Item view1 = findViewById(R.id.view1);
        final a2048Item view2 = findViewById(R.id.view2);
        final a2048Item view3 = findViewById(R.id.view3);
        final a2048Item view4 = findViewById(R.id.view4);
        layout = (LinearLayout) findViewById(R.id.content);
        Button button = (Button) findViewById(R.id.button);
        view1.initItem("2");
        view1.setLastX(0);
        view2.initItem("2");
        view2.setLastX(1);
        view3.initItem("1");
        view3.setLastX(2);
        view4.initItem("2");
        view4.setLastX(3);
        a2048Items[0] = view1;
        a2048Items[1] = view2;
//        a2048Items[2] = view3;
        a2048Items[3] = view4;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                right();
            }
        });
        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                onTouchEvent(motionEvent);
                return false;
            }
        });
    }

    public void right() {
        boolean merged = false;
        for (int i = 3; i > -1; i--) {
            int index = i;
            for (int j = 0; j < 3; j++) {
                if (a2048Items[i] != null) {
                    if (i + 1 < 4 && a2048Items[i + 1] == null) {
                        a2048Items[i + 1] = a2048Items[i];
                        a2048Items[i] = null;
                    } else if (i + 1 < 4 && a2048Items[i + 1] != null) {
                        if (a2048Items[i].getText().equals(a2048Items[i + 1].getText()) && !merged) {
                            Log.e("merge", "merge" + a2048Items[i].getLastX());
                            a2048Items[i] = null;
                            merged = true;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < a2048Items.length; i++) {
            if (a2048Items[i] != null) {
                int deltX = i - a2048Items[i].getLastX();
//                moveItem(a2048Items[i], deltX);
                Log.e(i + " :", a2048Items[i].getText().toString() + "Lastindex: " + a2048Items[i].getLastX() + "index: " + i + "move: " + deltX);
                a2048Items[i].setLastX(i);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("ACTION_DOWN", "ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("ACTION_MOVE", "ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e("ACTION_UP", "ACTION_UP");
                break;
        }
        return true;
    }

    public int getItemLength(int i) {
        return i * getResources().getDimensionPixelOffset(R.dimen.a2048_item_width)
                + i * getResources().getDimensionPixelOffset(R.dimen.a2048_item_padding);
    }

    public void moveItem(View view1, int to) {
        final View view = view1;
        final int toM = to * getResources().getDimensionPixelOffset(R.dimen.a2048_item_width)
                + to * getResources().getDimensionPixelOffset(R.dimen.a2048_item_padding);
        final int max = 4 * getResources().getDimensionPixelOffset(R.dimen.a2048_item_width)
                + 3 * getResources().getDimensionPixelOffset(R.dimen.a2048_item_padding);
        if ((view.getLeft() + view.getWidth() + toM) > max) {
            return;
        }
        TranslateAnimation animation = new TranslateAnimation(0, toM, 0, 0);
        animation.setDuration(600);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                int left = view.getLeft() + toM;
                int top = view.getTop();
                int width = view.getWidth();
                int height = view.getHeight();
                view.clearAnimation();
                view.layout(left, top, left + width, top + height);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(animation);
    }
}
