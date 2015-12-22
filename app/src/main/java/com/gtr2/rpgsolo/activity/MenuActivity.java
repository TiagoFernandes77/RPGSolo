package com.gtr2.rpgsolo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gtr2.rpgsolo.R;
import com.gtr2.rpgsolo.ui.GifView;

import static android.view.View.SYSTEM_UI_FLAG_FULLSCREEN;

public class MenuActivity extends Activity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        intent = new Intent(this, Screen1Activity.class);

        enableFullScreen();
        setContentView(R.layout.activity_menu);

        Button exitBnt = (Button) findViewById(R.id.exit);

        exitBnt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Button continueBnt = (Button) findViewById(R.id.continue_button);
        continueBnt.setEnabled(false);

        Button startBnt = (Button) findViewById(R.id.start);
        startBnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        GifView gif = (GifView) findViewById(R.id.gif);
        gif.setGifId(R.raw.menu);
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXIT", true);
        startActivity(intent);
    }
}
