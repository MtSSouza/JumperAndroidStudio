package com.example.danielcavalli.trbalho_jamv;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class GameView extends View implements Runnable{

    public Handler handler = new Handler();
    public Player Jamv;
    public ArrayList<Platform> pL;
    public static boolean movControl;

    public GameView (Context c)
    {
        super(c);
        Jamv = new Player(50,1024,c);
        int m =300;
        pL = new ArrayList<Platform>();
        pL.add(new Platform(300));
        pL.add(new Platform(400));
        pL.add(new Platform(500));
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        invalidate();
        super.onDraw(canvas);
        for(Platform p : pL){
            p.Update(canvas);
            p.Draw(canvas);
            Log.d("MainActivity",p.x +","+p.y);
        }

        Jamv.Draw(canvas);
        Jamv.Update(canvas.getWidth(), canvas.getHeight(), pL, canvas);
    }
    @Override
    public void run(){
        handler.postDelayed(this,30);
        invalidate();
    }
}

