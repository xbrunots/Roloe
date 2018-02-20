package com.devbruno.superfit.presentation.drawer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;

import com.devbruno.superfit.R;
import com.devbruno.superfit.infraestruture.Constants;
import com.devbruno.superfit.model.DrawerItens;
import com.devbruno.superfit.presentation.drawer.adapter.DrawerAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.devbruno.superfit.infraestruture.mock.MockGenres.getMockDrawerItensArray;

/**
 * Created by bsilvabr on 12/02/2018.
 */

public class DrawerPresenter implements DrawerContract.Presenter {

    private DrawerContract.View mView;
    private Context mContext;
    private DrawerActivity mActivity;
    private Context context;
    ArrayList<DrawerItens> drawerItensArrayList;
    private DrawerAdapter drawerAdapter;
    private List<DrawerItens> genres;

    @Override
    public void getGenres() {
        if (mView.getRecyclerView() == null) {
            mView.hideLoading();
            mView.alertErroUI();
            return;
        }
        if (Constants.API_KEY.isEmpty()) {
            mView.hideLoading();
            mView.alertErroApi();
            return;
        }

        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 1);
        mView.getRecyclerView().setLayoutManager(gridLayoutManager);

        genres = getMockDrawerItensArray();
        drawerAdapter = new DrawerAdapter(genres, R.layout.item_genre, mContext);
        mView.getRecyclerView().setAdapter(drawerAdapter);

        mView.hideLoading();

    }

    @Override
    public DrawerAdapter getDrawerAdapter() {
        return drawerAdapter;
    }

    @Override
    public void onBackPressed() {
        mActivity.onBackPressed();
    }

    @Override
    public void filter(String text) {

    }

    public DrawerPresenter(@NonNull final DrawerContract.View view) {
        mView = view;
        mContext = view.getContext();
        mActivity = (DrawerActivity) mContext;
    }

    @Override
    public void start() {
        getGenres();
    }

}
