package com.gtr2.rpgsolo.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Movie;
import android.graphics.Paint;
import android.view.View;

import java.io.InputStream;

public class GifView extends View {

    private Movie mMovie;
    private long movieStart;
    Paint paint = new Paint();

    public GifView(Context context, int gifId) {
        super(context);
        initializeView(gifId);
    }

    private void initializeView(int gifId) {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        InputStream is = getContext().getResources().openRawResource(
                gifId);
        mMovie = Movie.decodeStream(is);
    }

    public int getDuration(){
        return mMovie.duration();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.WHITE);

        canvas.drawRect(0, getWidth(), 0, getHeight(), paint);

        long now = android.os.SystemClock.uptimeMillis();

        if (movieStart == 0) {
            movieStart = (int) now;
        }

        float x = getWidth()/2 - mMovie.width()/2;
        float y = getHeight()/2 - mMovie.height()/2;

        if (mMovie != null) {
            int relTime = (int) ((now - movieStart) % mMovie.duration());
            mMovie.setTime(relTime);
            mMovie.draw(canvas, x, y);
            this.invalidate();
        }
    }
}