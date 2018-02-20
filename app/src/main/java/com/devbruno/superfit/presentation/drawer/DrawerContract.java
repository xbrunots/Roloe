package com.devbruno.superfit.presentation.drawer;

import android.support.v7.widget.RecyclerView;

import com.devbruno.superfit.presentation.BasePresenter;
import com.devbruno.superfit.presentation.BaseView;
import com.devbruno.superfit.presentation.drawer.adapter.DrawerAdapter;

/**
 * Created by bsilvabr on 12/02/2018.
 */

public class DrawerContract {
    public interface View extends BaseView<DrawerContract.Presenter> {
        RecyclerView getRecyclerView();
    }

    interface Presenter extends BasePresenter {
        void getGenres();

        DrawerAdapter getDrawerAdapter();

        void onBackPressed();

        void filter(String text);
    }
}
