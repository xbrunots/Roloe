package com.devbruno.fastshop.presentation.drawer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;

import com.devbruno.fastshop.R;
import com.devbruno.fastshop.infraestruture.Constants;
import com.devbruno.fastshop.infraestruture.Repository.ApiClient;
import com.devbruno.fastshop.infraestruture.Repository.ApiInterface;
import com.devbruno.fastshop.model.DrawerItens;
import com.devbruno.fastshop.model.DrawerResponse;
import com.devbruno.fastshop.presentation.drawer.adapter.DrawerAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.devbruno.fastshop.infraestruture.ConnectionUtils.isOnline;

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

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<DrawerResponse> call = apiService.getGenres(Constants.API_KEY);
        call.enqueue(new Callback<DrawerResponse>() {
            @Override
            public void onResponse(Call<DrawerResponse> call, Response<DrawerResponse> response) {
                int statusCode = response.code();
                if (statusCode == 200 && isOnline(mContext)) {
                    Log.e(Constants.TAG_GENERIC, response.raw().toString());
                    genres = response.body().getGenres();
                    drawerAdapter = new DrawerAdapter(genres, R.layout.item_genre, mContext);
                    mView.getRecyclerView().setAdapter(drawerAdapter);
                } else {
                    mView.alertErroApi();
                }
                mView.hideLoading();
            }

            @Override
            public void onFailure(Call<DrawerResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(Constants.TAG_GENERIC, t.toString());
                mView.hideLoading();
            }
        });
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
