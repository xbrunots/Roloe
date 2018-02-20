package com.devbruno.superfit.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by bsilvabr on 12/02/2018.
 */

public class DrawerItens implements Serializable {
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    public DrawerItens(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
