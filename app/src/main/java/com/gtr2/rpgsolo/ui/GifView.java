package com.gtr2.rpgsolo.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Movie;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.gtr2.rpgsolo.R;

import java.io.InputStream;

public class GifView extends View {

    private Movie mMovie;
    private long movieStart;
    private int gifId = 0;

    public GifView(Context context) {
        super(context);
        initializeView(gifId);
    }

    public GifView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeView(gifId);
    }

    public GifView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeView(gifId);
    }

    public GifView(Context context, int gifId) {
        super(context);
        initializeView(gifId);
    }

    private void initializeView(int gifId) {
        if(gifId == 0) gifId = R.raw.menu;

        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        InputStream is = getContext().getResources().openRawResource(
                gifId);
        mMovie = Movie.decodeStream(is);

    }

    public void setGifId(int id){
        gifId = id;
    }

    public int getDuration(){
        return mMovie.duration();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        long now = android.os.SystemClock.uptimeMillis();

        if (movieStart == 0) {
            movieStart = (int) now;
        }

        if (mMovie != null) {
            float x = getWidth()/2 - mMovie.width()/2;
            float y = getHeight()/2 - mMovie.height()/2;
            int relTime = (int) ((now - movieStart) % mMovie.duration());
            mMovie.setTime(relTime);
            mMovie.draw(canvas, x, y);
            this.invalidate();
        }
    }
}