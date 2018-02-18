package com.devbruno.fastshop.presentation.drawer;

import android.os.Bundle;
import android.view.Window;

import com.devbruno.fastshop.R;
import com.devbruno.fastshop.infraestruture.Constants;
import com.devbruno.fastshop.presentation.BaseActivity;

public class DrawerActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        setContentView(R.layout.activity_main);
        if (!hasCurrentFragment(R.id.frame_contaner)) {
            setCurrentFragment(R.id.frame_contaner,
                    DrawerFragment.newInstance(Constants.DRAWER_NAME));
        }
    }
}
