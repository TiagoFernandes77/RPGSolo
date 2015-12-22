package com.gtr2.rpgsolo.activity;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.gtr2.rpgsolo.R;

import static android.view.View.SCROLL_AXIS_HORIZONTAL;
import static android.view.View.SYSTEM_UI_FLAG_FULLSCREEN;

public class Screen1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen1);
        enableFullScreen();

        TextView textView = (TextView) findViewById(R.id.textView);

        textView.setText(getString(R.string.texto1));

        Typeface face = Typeface.createFromAsset(getAssets(),
                "pacifico.ttf");

        textView.setTypeface(face);

        Button bntact1 = (Button) findViewById(R.id.bntaction1);
        bntact1.setText(getString(R.string.btnaction1));

        final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.screen1);

        final ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView1);

        scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                int y = scrollView.getScrollY();
                //Log.d("info", String.valueOf(y));
                if(y>1150 && y<1250){
                    relativeLayout.setBackground(getResources().getDrawable(R.drawable.train));
                }

                if(y>2800 && y<2890){
                    relativeLayout.setBackground(getResources().getDrawable(R.drawable.office1));
                }
            }
        });

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
}
