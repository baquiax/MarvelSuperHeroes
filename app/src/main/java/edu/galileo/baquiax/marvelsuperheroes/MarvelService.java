package edu.galileo.baquiax.marvelsuperheroes;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by alexanderbaquiax on 9/02/16.
 */
interface MarvelService {
    @GET("/v1/public/characters")
    List<Character> getCharacters (
            @Query("apikey") String apiKey,
            @Query("nameStartsWith") String nsw
    );
}