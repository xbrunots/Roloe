package com.devbruno.superfit.infraestruture.Repository;

import com.devbruno.superfit.model.DrawerResponse;
import com.devbruno.superfit.model.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {
    @GET("movie/top_rated")
    Call<MoviesResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("movie/{id}")
    Call<MoviesResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);


    @GET("/3/genre/{id}/movies")
    Call<MoviesResponse> getMoviesForGenres(@Path("id") int id, @Query("api_key") String apiKey);


    @GET("/3/genre/movie/list")
    Call<DrawerResponse> getGenres(@Query("api_key") String apiKey);

}


