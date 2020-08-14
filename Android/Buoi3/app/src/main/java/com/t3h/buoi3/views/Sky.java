package com.t3h.buoi3.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.t3h.buoi3.models.Star;

import java.util.ArrayList;
import java.util.Random;

public class Sky extends LinearLayout implements Runnable, View.OnTouchListener {

    private ArrayList<Star> stars = new ArrayList<>();
    private Random rd = new Random();

    public Sky(Context context) {
        super(context);
        init();
    }

    public Sky(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Sky(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Sky(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {

        setBackgroundColor(Color.BLACK);

        int w = getContext().getResources().getDisplayMetrics().widthPixels;
        int h = getContext().getResources().getDisplayMetrics().heightPixels;
        for (int i = 0; i < 300; i++) {
            Star star = new Star(w, h);
            stars.add(star);
        }

        Thread t = new Thread(this);
        t.start();

        setOnTouchListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (Star s : stars) {
            s.draw(canvas);
        }
    }

    @Override
    public void run() {
        while (true) {
            postInvalidate();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                setBackgroundColor(Color.WHITE);
                break;
            case MotionEvent.ACTION_MOVE:
                setBackgroundColor(Color.YELLOW);
                break;
            case MotionEvent.ACTION_UP:
                setBackgroundColor(Color.BLACK);
                break;
        }
        return true;
    }
}
