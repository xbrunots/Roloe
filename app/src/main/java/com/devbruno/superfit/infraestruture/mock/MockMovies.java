package com.devbruno.superfit.infraestruture.mock;

import com.devbruno.superfit.model.Movie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bsilvabr on 18/02/2018.
 */

public class MockMovies implements Serializable {


    public static List<Movie> getMockMoviesArray() {
         List<Movie> listaAll = new ArrayList<Movie>();

        for (int i = 0; i < 5; i++) {

            listaAll.add(item("http://treinoparamulher.com.br/wp-content/uploads/2016/02/plano-de-treino-carnaval-featured.jpg",
                    "https://ganharmassamuscular.org/wp-content/uploads/2016/09/treino-para-ganhar-massa-muscular.png", "TREINO DOIDO :D"));

            listaAll.add(item("http://cdn.wp.clicrbs.com.br/farroupilha/files/2017/02/sasaasasas-e1487182521901.jpg",
                    "http://www.maisequilibrio.com.br/imagens/maisequilibrio/thumbs/2012/06/19/comida-x-treino-2-612-thumb-570.jpg", "TREINO ANITAA"));
            listaAll.add(item("http://s2.glbimg.com/WX7YtM-2dJrGiVNsp4YUmbXawNQ=/e.glbimg.com/og/ed/f/original/2017/05/31/grazi.jpg",
                    "http://www.queroviverbem.com.br/wp-content/uploads/2017/11/treino-de-forca-como-fazer.jpg", "Treino Grazy"));
            listaAll.add(item("https://www.treinomestre.com.br/wp-content/uploads/2016/08/treino-de-hipertrofia-erros-comuns.jpg",
                    "https://www.treinomestre.com.br/wp-content/uploads/2016/08/treino-de-hipertrofia-erros-comuns.jpg", "Treino Mestre peitorais"));
            listaAll.add(item("http://www.dicasdetreino.com.br/wp-content/uploads/2017/11/Construindo-Costa-Largas-Treino-completo-ara-Costas.jpg",
                    "https://treinomestre.com.br/wp-content/uploads/2014/08/Treino-de-musculacao-para-emagrecer.jpg", "TREINO DE CASAL"));

            listaAll.add(item("http://treinoparamulher.com.br/wp-content/uploads/2016/02/plano-de-treino-carnaval-featured.jpg",
                    "https://ganharmassamuscular.org/wp-content/uploads/2016/09/treino-para-ganhar-massa-muscular.png",
                    "Venha começar a sua família no Residencial Horto Villagio. São terrenos de vários tamanhos, para você construir a casa dos seus sonhos ao lado daquela pessoa especial. Clique e conheça!"));


        }
        return listaAll;
    }

    static Movie item(String posterPath, String backdropPath, String title) {
        List<Integer> genreIds = new ArrayList<Integer>();
        genreIds.add(1);
        genreIds.add(12);
        genreIds.add(5);
          String releaseDate = "2018-10-22";
        int id = 10;
        String originalTitle = "Treino de Bicpes Aurrr!";
        String originalLanguage = "asasas";
        String overview = "asasas";
        int voteCount = 230;
        Movie movie = new Movie(posterPath, false, overview, releaseDate, genreIds, id,
                originalTitle, originalLanguage, title, backdropPath, 7.5,
                voteCount, true, 8.6);
        return movie;
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
            String releaseDate = "2018-10-22";
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
