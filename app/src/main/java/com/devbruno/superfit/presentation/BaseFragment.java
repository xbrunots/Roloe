package com.devbruno.superfit.presentation;

import android.support.v4.app.Fragment;
import android.content.Context;

/**
 * Created by bsilvabr on 10/02/2018.
 */

public abstract class BaseFragment extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);

    }

}
