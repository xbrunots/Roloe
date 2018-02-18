package com.devbruno.fastshop.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by bsilvabr on 12/02/2018.
 */

public class DrawerResponse {

    @SerializedName("genres")
    private List<DrawerItens> genres;

    public List<DrawerItens> getGenres() {
        return genres;
    }

    public void setGenres(List<DrawerItens> genres) {
        this.genres = genres;
    }

}
