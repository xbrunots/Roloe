package com.devbruno.superfit.presentation.home;

import android.support.v7.widget.RecyclerView;

import com.devbruno.superfit.model.DrawerItens;
import com.devbruno.superfit.presentation.BasePresenter;
import com.devbruno.superfit.presentation.BaseView;
import com.devbruno.superfit.presentation.home.adapter.MoviesAdapter;
import com.devbruno.superfit.presentation.home.adapter.MoviesStoriesAdapter;

/**
 * Created by bsilvabr on 10/02/2018.
 */

public class HomeContract {

    public interface View extends BaseView<Presenter> {
        RecyclerView getRecyclerView();

        RecyclerView getRecyclerViewEstories();

        void showSearch();

        void hideSearch();

        DrawerItens getDrawerItens();

        void closeGenresDrawer();
        void hideGenreTitle();

        void setGenreTitle(String name);
    }

    interface Presenter extends BasePresenter {
        void getMovies();
        void getGenresDrawer();

        MoviesStoriesAdapter getMovieStoriesAdapter();

        MoviesAdapter getMovieAdapter();

        void filter(String text);

        void getShowSearch();

        void getHideSearch();
    }
}