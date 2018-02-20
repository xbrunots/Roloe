package com.devbruno.superfit.presentation.custom;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import com.airbnb.lottie.LottieAnimationView;
import com.devbruno.superfit.R;
import com.devbruno.superfit.infraestruture.LottieUtils;

/**
 * Created by bsilvabr on 10/02/2018.
 */
public class CustomLoadingDialog extends Dialog implements android.view.View.OnClickListener {
    private RelativeLayout relativeBody;
    private Activity activity;
    LottieAnimationView animationView;

    public CustomLoadingDialog(Activity activity) {
        super(activity);
        // TODO Auto-generated constructor stub
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.lightbox_dialog);
        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        init();
        setListeners();
        animAfterViews();
    }

    private void init() {
        relativeBody = (RelativeLayout) findViewById(R.id.relative_body);
        animationView = (LottieAnimationView) findViewById(R.id.animation_view);
        LottieUtils.animate(animationView,"loading.json");
   }

    private void setListeners() {
        relativeBody.setOnClickListener(this);
    }

    private void animAfterViews() {
        relativeBody.startAnimation(AnimationUtils.loadAnimation(relativeBody.getContext(), R.anim.chat_move_down));
    }

    private void close() {
        dismiss();
    }

    private void animateClose() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.relative_body:
                animateClose();
                break;
            default:
                break;
        }
        close();
    }

}