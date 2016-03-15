package com.baquiax.marvelsuperheroes.models;

import java.util.HashMap;

/**
 * Created by baquiax on 13/3/2016.
 */
public class Character {
    private int id;
    private String name;
    private String thumbnail;

    public Character(int id, String name, String thumbnail) {
        this.id = id;
        this.name = name;
        this.thumbnail = thumbnail;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }


}
