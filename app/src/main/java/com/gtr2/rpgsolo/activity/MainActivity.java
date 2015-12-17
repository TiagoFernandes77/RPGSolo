package com.gtr2.rpgsolo.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.gtr2.rpgsolo.R;
import com.gtr2.rpgsolo.ui.GifView;

import static android.view.View.SYSTEM_UI_FLAG_FULLSCREEN;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        enableFullScreen();

        GifView gv = new GifView(this, R.raw.grt2);

        Handler timerHandler = new Handler();

        Runnable endActivity = new Runnable() {
            @Override
            public void run() {
                nextScreen();
            }
        };

        setContentView(gv);

        if (getIntent().getBooleanExtra("EXIT", false))
            finish();
        else
            timerHandler.postDelayed(endActivity, gv.getDuration()-300);

    }

    private void enableFullScreen(){
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    private void nextScreen(){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}
