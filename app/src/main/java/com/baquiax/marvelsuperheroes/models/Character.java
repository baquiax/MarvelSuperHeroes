package com.baquiax.marvelsuperheroes.models;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

/**
 * Created by baquiax on 13/3/2016.
 */
public class Character {
    private int id;
    private String name;
    private String imageUrl;

    public Character(int id, String name, String imageUrl) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

}
