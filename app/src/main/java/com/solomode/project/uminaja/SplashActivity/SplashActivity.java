package com.solomode.project.uminaja.SplashActivity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.solomode.project.uminaja.MainActivity.MainActivity;
import com.solomode.project.uminaja.R;

public class SplashActivity extends AppCompatActivity {

    private final int SPLASH = 5000;
    android.widget.ProgressBar ProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        startMain();
        ProgressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

    void startMain(){
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
                SplashActivity.this.startActivity(mainIntent);
                SplashActivity.this.finish();
            }
        }, SPLASH);
    }
}
