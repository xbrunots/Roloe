package com.devbruno.superfit.presentation.movieitem;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.Window;

import com.devbruno.superfit.R;
import com.devbruno.superfit.infraestruture.Constants;
import com.devbruno.superfit.presentation.BaseActivity;


public class MovieItemActivity extends BaseActivity {
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        overridePendingTransition(R.anim.fade_in, R.anim.chat_move_down_negative);
        setContentView(R.layout.movie_item_main);
        if (!hasCurrentFragment(R.id.frame_contaner)) {
            setCurrentFragment(R.id.frame_contaner,
                    MovieItemFragment.newInstance(Constants.HOME_TITLE));
        }

    }

}
