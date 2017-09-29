package com.solomode.project.uminaja.TipsActivity;

import android.app.Application;

/**
 * Created by madeinsap on 9/29/2017.
 */

public class Intro extends Application{

    @Override
    public void onCreate(){

        super.onCreate();
        Globals.init(this);

    }
}
