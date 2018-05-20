package com.example.gaope.canvasclip;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Region;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by gaope on 2018/5/20.
 */

public class ClipRect extends View {

    private Paint paint;

    public ClipRect(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(3);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(10,10);
        canvas.clipRect(0,0,300,300);
        canvas.clipRect(200,200,400,400, Region.Op.XOR);
        canvas.clipRect(0,0,400,400);
        canvas.drawColor(Color.BLUE);
        canvas.restore(   );
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        canvas.translate(10,10);
        canvas.drawCircle(0,0,10,paint);
        canvas.drawRect(0, 0, 300, 300, paint);
        paint.setColor(Color.RED);
        canvas.drawRect(200, 200, 400, 400,paint);
        invalidate();
    }
}
