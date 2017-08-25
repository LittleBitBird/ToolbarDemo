package com.example.guanhuawu.toolbardemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/**
 * Created by guanhua.wu on 2017/7/25.
 */

public class RoundImageView extends android.support.v7.widget.AppCompatImageView {
    private Paint paint;
    private Bitmap bmp;

    public RoundImageView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        init();
    }

    public RoundImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        init();
    }

    public RoundImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int w = getWidth();
        int h = getHeight();
        Drawable drawable = getDrawable();
        int i = canvas.saveLayer(0.0F, 0.0F, w, h, null, Canvas.ALL_SAVE_FLAG);
        int j = getWidth();
        int k = getHeight();
        drawable.setBounds(0, 0, j, k);
        drawable.draw(canvas);

        if (bmp == null){
            bmp = createMask();
        }
        canvas.drawBitmap(bmp, 0.0F, 0.0F, paint);
        canvas.restoreToCount(i);

    }

    public Bitmap createMask() {
        int i = getWidth();
        int j = getHeight();
        Bitmap.Config localConfig = Bitmap.Config.ARGB_8888;
        Bitmap localBitmap = Bitmap.createBitmap(i, j, localConfig);
        Canvas localCanvas = new Canvas(localBitmap);
        Paint localPaint = new Paint(1);
        localPaint.setColor(Color.WHITE);
        float f1 = getWidth();
        float f2 = getHeight();
        RectF localRectF = new RectF(0.0F, 0.0F, f1, f2);
        localCanvas.drawOval(localRectF, localPaint);
        return localBitmap;
    }

}