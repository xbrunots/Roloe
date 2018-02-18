package com.devbruno.fastshop.infraestruture.mock;

import com.devbruno.fastshop.model.Movie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bsilvabr on 18/02/2018.
 */

public class MockMovies implements Serializable {


    public static List<Movie> getMockMoviesArray() {
        List<Integer> genreIds = new ArrayList<Integer>();
        List<Movie> listaAll = new ArrayList<Movie>();
        genreIds.add(1);
        genreIds.add(12);
        genreIds.add(5);

        for (int i = 0; i < 30; i++) {
            String posterPath = "http://treinoparamulher.com.br/wp-content/uploads/2016/02/plano-de-treino-carnaval-featured.jpg";
            String backdropPath = "https://ganharmassamuscular.org/wp-content/uploads/2016/09/treino-para-ganhar-massa-muscular.png";
            String releaseDate = "2018-10-22"  ;
            int id = i * 10;
            String originalTitle = "asasas";
            String originalLanguage = "asasas";
            String title = "asasas";
            String overview = "asasas";
            int voteCount = 230 + i;
            Movie movie = new Movie(posterPath, false, overview, releaseDate, genreIds, id,
                    originalTitle, originalLanguage, title, backdropPath, 7.5,
                    voteCount, true, 8.6);
                           listaAll.add(movie);
        }

        return listaAll;
    }


    public static List<Movie> getMockBallsTrainingArray() {
        List<Integer> genreIds = new ArrayList<Integer>();
        List<Movie> listaAll = new ArrayList<Movie>();
        genreIds.add(1);
        genreIds.add(12);
        genreIds.add(5);

        for (int i = 0; i < 10; i++) {
            String posterPath = "http://upl.stack.com/wp-content/uploads/2015/09/Air-Squats-STACK.jpg";
            String backdropPath = "http://upl.stack.com/wp-content/uploads/2015/09/Air-Squats-STACK.jpg";
            String releaseDate = "2018-10-22"  ;
            int id = i * 10;
            String originalTitle = "asasas";
            String originalLanguage = "asasas";
            String title = "asasas";
            String overview = "asasas";
            int voteCount = 230 + i;
            Movie movie = new Movie(posterPath, false, overview, releaseDate, genreIds, id,
                    originalTitle, originalLanguage, title, backdropPath, 7.5,
                    voteCount, true, 8.6);
            listaAll.add(movie);
        }

        return listaAll;
    }


}
