package com.devbruno.superfit.presentation.movieitem;

import android.widget.ImageView;

import com.devbruno.superfit.presentation.BasePresenter;
import com.devbruno.superfit.presentation.BaseView;

/**
 * Created by bsilvabr on 10/02/2018.
 */

public class MovieItemContract {

    public interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {
        void loadImageFromURL(ImageView imageView, String URL) ;

    }
}