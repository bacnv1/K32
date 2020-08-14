package com.t3h.buoi3.models;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

public class Star {
    private int color;
    private int x;
    private int y;
    private int size;
    private Random rd = new Random();

    public Star(int w, int h) {
        size = rd.nextInt(30) + 20;
        this.x = rd.nextInt(w - size);
        this.y = rd.nextInt(h - size);
    }

    private void createColor() {
        int r = rd.nextInt(256);
        int g = rd.nextInt(256);
        int b = rd.nextInt(256);
        color = Color.rgb(r, g, b);
    }

    public void draw(Canvas canvas) {
        createColor();
        Paint p = new Paint();
        p.setTextSize(size);
        p.setColor(color);
        canvas.drawText("*", x, y, p);
    }
}
