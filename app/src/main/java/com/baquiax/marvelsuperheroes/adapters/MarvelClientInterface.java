package com.baquiax.marvelsuperheroes.adapters;

import com.baquiax.marvelsuperheroes.models.*;
import com.baquiax.marvelsuperheroes.models.Character;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by baquiax on 15/3/2016.
 */
public interface MarvelClientInterface {
@GET("v1/public/characters")
Call<JsonObject> searchCharacters(@Query("apikey") String apiKey,
                                       @Query("nameStartsWith") String startWith,
                                       @Query("ts") String timeStamp,
                                       @Query("hash") String hash);
}
