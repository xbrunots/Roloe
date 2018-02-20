package com.devbruno.superfit.infraestruture;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;

/**
 * Created by bsilvabr on 18/02/2018.
 */

public class AnimationUtils {
    public static void setAnimateInstaStyle(View view) {
        AnimationDrawable animationDrawable = (AnimationDrawable) view.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
    }

    public static void startCustomAnimation(final Activity activity, final View view, final int xml, int time) {
        startCustomAnimation(activity, view, xml, time, false);
    }

    public static void startCustomAnimation(final Activity activity, final View view, final int xml, int time, final boolean isGone) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation fadeInAnimation = android.view.animation.AnimationUtils.loadAnimation(
                        activity, xml);
                view.startAnimation(fadeInAnimation);
                fadeInAnimation.setAnimationListener(new Animation.AnimationListener() {

                    @Override
                    public void onAnimationStart(Animation animation) {
                        view.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        // TODO Auto-generated method stub
                        if (isGone) {
                            view.setVisibility(View.GONE);

                        }

                    }
                });
            }

        }, time);
    }

}
