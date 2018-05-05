package com.sheygam.java_19_04_05_18;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;

public class MyView extends Button {

    private Paint p;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private void init() {
        p = new Paint();
        p.setColor(Color.rgb(0,0,0));
        p.setStrokeWidth(4);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.d("MY_TAG", "onMeasure: ");
        super.onMeasure(1200, 1200);
    }



    @Override
    protected void onDraw(Canvas canvas) {
        Log.d("MY_TAG", "onDraw: ");

        Log.d("MY_TAG", "onDraw: " + canvas.getHeight() + " " + canvas.getWidth());

        super.onDraw(canvas);
    }
}
