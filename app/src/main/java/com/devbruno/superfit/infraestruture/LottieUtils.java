package com.devbruno.superfit.infraestruture;

import com.airbnb.lottie.LottieAnimationView;

/**
 * Created by bsilvabr on 18/02/2018.
 */

public class LottieUtils {
    public static void animate(LottieAnimationView animationView, String json) {
        animate(animationView, json, true);
    }

    public static void animate(LottieAnimationView animationView, String json, boolean loop) {
        animationView.setAnimation(json);
        animationView.loop(loop);
        animationView.playAnimation();
    }
}
