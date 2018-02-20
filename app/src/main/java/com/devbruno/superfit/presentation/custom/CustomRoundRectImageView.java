package com.devbruno.superfit.presentation.custom;

/**
 * Created by bsilvabr on 12/02/2018.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;

public class CustomRoundRectImageView extends android.support.v7.widget.AppCompatImageView {

    private float radius = 200.0f;
    private Path path;
    private RectF rect;

    public CustomRoundRectImageView(Context context) {
        super(context);
        init();
    }

    public CustomRoundRectImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomRoundRectImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        path = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {


        rect = new RectF(0, 0, this.getWidth(), this.getHeight());
        path.addRoundRect(rect, radius, radius, Path.Direction.CW);

        canvas.clipPath(path);

        super.onDraw(canvas);
    }
}