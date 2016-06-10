package com.example.danielcavalli.trbalho_jamv;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import java.util.Random;

public class Platform {
    public int x;
    public int y;
    public int w = 200;
    public int h = 100;
    public int g = 10;
    Random rand = new Random();

    public Platform(int lY){
        y = lY + (new Random()).nextInt(210);
        Log.d("MainActivity",x+":"+y);
    }

    public void Draw(Canvas canvas) {
        Paint p = new Paint();
        p.setColor(Color.BLACK);
        canvas.drawRect(x, y, w + x, h + y, p);
    }
    public void Update(Canvas canvas)
    {
        y += g;
        if(y >= canvas.getHeight())
        {
            y = -2*h;
            x =  rand.nextInt(canvas.getWidth()-w);
        }
    }
}