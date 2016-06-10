package com.example.danielcavalli.trbalho_jamv;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;

import android.graphics.Paint;
import android.opengl.Matrix;

import java.util.ArrayList;


public class Player
{
    public int x;
    public int y;
    public int w = 50;
    public int h = 50;
    public float g = 10;
    public Paint color;
    public Context ctx;

    public Player(int x2, int y2,Context c)
    {
        x = x2;
        y = y2;
        ctx = c;
    }
    /*public Bitmap getResizedBitmap(Bitmap bm, int newHeight, int newWidth)
    {
        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // create a matrix for the manipulation
        Matrix matrix = new Matrix();
        // resize the bit map
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);
        return resizedBitmap;
    }*/

    public void Draw(Canvas canvas)
    {
        color=new Paint();
        Bitmap b = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.player);
        //b = getResizedBitmap(b,h,w);
        //b.setHeight(h);
        color.setColor(Color.BLUE);
        canvas.drawBitmap(b, x, y, color);
    }

    boolean Collision(int x1,int y1,int w1, int h1)
    {
        return ((x+w > x1) && (x < x1 + w1) && (y+h <= y1) && (y+h >= y1 - 3));
    }

    public void Update(int cW,int cH, ArrayList<Platform> pL ,Canvas c)
    {
        for(Platform p : pL)
        {
            if((Collision(p.x, p.y, p.w, p.h)) && (g >= 0))
            {
                g =-50;
                p.g = 15;
            }
        }
        if(g < 50) {
            g += 2;
        }
        x -= MainActivity.x * 2.5;
            y += g;
        if(y+4*h >= cH)
        {
            g = -50;
        }
        if(x +4*w < 0)
        {
            x = c.getWidth();
        }
        else if (x+3 > c.getWidth())
        {
            x = -w;
        }
    }
}

