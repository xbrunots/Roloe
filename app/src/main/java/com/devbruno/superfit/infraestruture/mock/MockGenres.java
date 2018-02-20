package com.devbruno.superfit.infraestruture.mock;

import com.devbruno.superfit.model.DrawerItens;
import com.devbruno.superfit.model.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bsilvabr on 18/02/2018.
 */

public class MockGenres {

    public static List<DrawerItens> getMockDrawerItensArray() {
        List<DrawerItens> listaAll = new ArrayList<DrawerItens>();

        for (int i = 0; i < 30; i++) {
            int id = i * 10;
            String nome = "Superior ".concat(String.valueOf(i));
            DrawerItens movie = new DrawerItens(id, nome);
            listaAll.add(movie);
        }

        return listaAll;
    }
}
