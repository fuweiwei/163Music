package com.veer.music.support.eventbus;

import android.graphics.Color;

/**
 * 描述
 * Created by Veer
 * date 17/2/27.
 */

public class ThemeChangeEvent {
    private int color = Color.RED;
    public  ThemeChangeEvent(int color){
        this.color = color;

    }
    public  int getColor(){
        return  color;
    }
}
