package com.devbruno.superfit.presentation.home.adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.devbruno.superfit.R;
import com.devbruno.superfit.infraestruture.Constants;
import com.devbruno.superfit.infraestruture.DateUtils;
import com.devbruno.superfit.infraestruture.ImageUtil.ImageDownloadAndCache;
import com.devbruno.superfit.infraestruture.LottieUtils;
import com.devbruno.superfit.model.Movie;
import com.devbruno.superfit.presentation.custom.CustomOpenPost;
import com.devbruno.superfit.presentation.home.HomeActivity;
import com.devbruno.superfit.presentation.movieitem.MovieItemActivity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private final HomeActivity mActivity;
    public List<Movie> movies;
    private int rowLayout;
    private Context context;
    ArrayList<Movie> movieArrayList;
    ArrayList<Movie> defaultMovieArrayList;

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        RelativeLayout relativeFotos;
        LinearLayout relativeFooters;
        TextView movieTitle;
        TextView data;
        TextView movieDescription;
        TextView rating;
        ImageView poster_path, like;
        LottieAnimationView likeAnimate;


        public MovieViewHolder(View v) {
            super(v);
            moviesLayout = (LinearLayout) v.findViewById(R.id.movies_layout);
            relativeFotos = (RelativeLayout) v.findViewById(R.id.relativeFoto);
            relativeFooters = (LinearLayout) v.findViewById(R.id.reletiveFooter);
            movieTitle = (TextView) v.findViewById(R.id.title);
            data = (TextView) v.findViewById(R.id.subtitle);
            movieDescription = (TextView) v.findViewById(R.id.description);
            rating = (TextView) v.findViewById(R.id.rating);
            poster_path = (ImageView) v.findViewById(R.id.imageViewPoster);
            like = v.findViewById(R.id.imageButtonLike);
            likeAnimate = (LottieAnimationView) v.findViewById(R.id.animation_view);
        }
    }

    public MoviesAdapter(List<Movie> movies, int rowLayout, Context context, Comparator<Movie> comparator) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
        this.mActivity = (HomeActivity) context;
    }

    @Override
    public MoviesAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }

    public void add(Movie item, int position) {
        movies.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(Movie item) {
        int position = movies.indexOf(item);
        movies.remove(position);
        notifyItemRemoved(position);
    }

    public int getPosition(Movie item) {
        return movies.indexOf(item);
    }

    public void setFilter(List<Movie> newList, List<Movie> defaultList) {
        defaultMovieArrayList = new ArrayList<>();
        defaultMovieArrayList.addAll(defaultList);
        movieArrayList = new ArrayList<>();
        movieArrayList.addAll(newList);
        movies.clear();
        if (newList.size() < 1) {
            movies.addAll(defaultMovieArrayList);
        } else {
            movies.addAll(movieArrayList);
        }
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(final MovieViewHolder holder, final int position) {
        holder.data.setText(DateUtils.convertDateENtoBR(movies.get(position).getReleaseDate()));
        holder.movieDescription.setText(movies.get(position).getOverview());
        holder.rating.setText(movies.get(position).getVoteAverage().toString());
        holder.movieTitle.setText(movies.get(position).getTitle().toString());

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(mActivity, MovieItemActivity.class);
                //intent.putExtra(Constants.ARGUMENT_MOVIES, movies.get(position));
               // mActivity.startActivity(intent);

                CustomOpenPost customOpenPost = new CustomOpenPost(mActivity);
                customOpenPost.setPost(movies.get(position));
                customOpenPost.show();

            }
        };

        if (movies.get(position).getPosterPath() != null) {
            new ImageDownloadAndCache.DownloadImageTask(holder.poster_path,
                    mActivity).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,
                    Constants.BASE_POSTER_URL.concat(movies.get(position).getPosterPath().toString()));
        }


        holder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.like.setVisibility(View.GONE);
                holder.likeAnimate.setVisibility(View.VISIBLE);
                LottieUtils.animate(holder.likeAnimate, "like.json", false);
            }
        });

        holder.likeAnimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.likeAnimate.setVisibility(View.GONE);
                holder.like.setVisibility(View.VISIBLE);
            }
        });


       // holder.moviesLayout.setOnClickListener(onClickListener);
        //holder.relativeFooters.setOnClickListener(onClickListener);
        holder.relativeFotos.setOnClickListener(onClickListener);
    }


    @Override
    public int getItemCount() {
        return movies.size();
    }
}