package com.devbruno.superfit.presentation.home;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.animation.AnimationUtils;

import com.devbruno.superfit.R;
import com.devbruno.superfit.infraestruture.Constants;
import com.devbruno.superfit.model.Movie;
import com.devbruno.superfit.presentation.drawer.DrawerActivity;
import com.devbruno.superfit.presentation.home.adapter.MoviesAdapter;
import com.devbruno.superfit.presentation.home.adapter.MoviesStoriesAdapter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.devbruno.superfit.infraestruture.mock.MockMovies.getMockBallsTrainingArray;
import static com.devbruno.superfit.infraestruture.mock.MockMovies.getMockMoviesArray;

/**
 * Created by bsilvabr on 10/02/2018.
 */

public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View mView;
    private Context mContext;
    private HomeActivity mActivity;
    private MoviesAdapter moviesAdapter;
    private MoviesStoriesAdapter moviesAdapterStories;
    private final Comparator<Movie> mComparator = null;
    private List<Movie> movies;
    private ArrayList<Movie> defaultList;
    private List<Movie> moviesBackup = null;

    public HomePresenter(@NonNull final HomeContract.View view) {
        mView = view;
        mContext = view.getContext();
        mActivity = (HomeActivity) mContext;
    }

    @Override
    public void start() {
        mView.showLoading();
        getMovies();
    }

    public static List<Movie> filter(List<Movie> models, String query) {
        final String lowerCaseQuery = query.toLowerCase();

        final List<Movie> filteredModelList = new ArrayList<>();
        for (Movie model : models) {
            final String text = model.getTitle().toLowerCase();
            if (text.contains(lowerCaseQuery)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }

    public void getGenresDrawer() {
        // mActivity.initFragment(new DrawerFragment(), Constants.GENRES_NAME, mActivity);

        mActivity.startActivity(new Intent(mActivity, DrawerActivity.class));
        mView.getRecyclerView().clearAnimation();
        mView.getRecyclerViewEstories().clearAnimation();
        mView.getRecyclerView().startAnimation(AnimationUtils.loadAnimation(mView.getRecyclerView().getContext(), R.anim.move_all_r));
        mView.getRecyclerViewEstories().startAnimation(AnimationUtils.loadAnimation(mView.getRecyclerViewEstories().getContext(), R.anim.move_all_r));
    }


    @Override
    public void getMovies() {
        getBalls();

        mView.hideGenreTitle();
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
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        mView.getRecyclerViewEstories().setLayoutManager(layoutManager);

        if (mView.getDrawerItens() != null) {
            //call = apiService.getMoviesForGenres(mView.getDrawerItens().getId(), Constants.API_KEY);
            mView.setGenreTitle(mView.getDrawerItens().getName().toUpperCase());
        }
        movies = getMockMoviesArray();
        defaultList = new ArrayList<>();
        defaultList.addAll(movies);
        if (defaultList != moviesBackup) {
            moviesBackup = defaultList;
            moviesAdapter = new MoviesAdapter(movies, R.layout.list_item_movie, mContext, mComparator);
            mView.getRecyclerView().setAdapter(moviesAdapter);
            moviesAdapter.notifyDataSetChanged();
        }
        mView.hideLoading();
    }

    public void getBalls() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        mView.getRecyclerViewEstories().setLayoutManager(layoutManager);
        List<Movie> balls = getMockBallsTrainingArray();
        defaultList = new ArrayList<>();
        defaultList.addAll(balls);
        moviesAdapterStories = new MoviesStoriesAdapter(balls, R.layout.list_item_around, mContext, mComparator);
        mView.getRecyclerViewEstories().setAdapter(moviesAdapterStories);
        moviesAdapterStories.notifyDataSetChanged();
    }




    @Override
    public void filter(String text) {
        text = text.toLowerCase();
        if (text.isEmpty()) {
            try {
                moviesAdapterStories.setFilter(defaultList, defaultList);
                moviesAdapter.setFilter(defaultList, defaultList);
                mView.getRecyclerView().setAdapter(moviesAdapter);
                mView.getRecyclerViewEstories().setAdapter(moviesAdapterStories);
                moviesAdapter.notifyDataSetChanged();
                moviesAdapterStories.notifyDataSetChanged();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            ArrayList<Movie> newList = new ArrayList<>();
            for (Movie mMovies : movies) {
                String movieName = mMovies.getTitle().toLowerCase();
                if (movieName.contains(text)) {
                    newList.add(mMovies);
                }
            }
            moviesAdapter.setFilter(newList, defaultList);
            mView.getRecyclerViewEstories().setAdapter(moviesAdapter);
            moviesAdapter.notifyDataSetChanged();

            try {
                moviesAdapterStories.setFilter(newList, defaultList);
                mView.getRecyclerViewEstories().setAdapter(moviesAdapterStories);
                moviesAdapterStories.notifyDataSetChanged();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void getShowSearch() {
        mView.showSearch();
    }

    @Override
    public void getHideSearch() {
        mView.hideSearch();
    }

    @Override
    public MoviesAdapter getMovieAdapter() {
        return moviesAdapter;
    }

    @Override
    public MoviesStoriesAdapter getMovieStoriesAdapter() {
        return moviesAdapterStories;
    }


}
