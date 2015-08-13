package com.ivankocijan.hellomvvm.retrofit;

import com.ivankocijan.hellomvvm.model.Pokedex;
import com.ivankocijan.hellomvvm.model.Pokemon;

import android.util.Log;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 13.08.15.
 */
public class ApiManager {

    private static final String ENDPOINT = "http://pokeapi.co/api/v1";

    public interface ApiInterface {

        @GET("/pokemon/{id}")
        void getPokemon(@Path("id") int pId, Callback<Pokemon> callback);

        @GET("/pokedex/1")
        void getPokedex(Callback<Pokedex> callback);

    }

    public static ApiInterface getRestClient() {


        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(ENDPOINT)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setLog(new RestAdapter.Log() {
                    @Override
                    public void log(String message) {
                        Log.d("api_tag", message);
                    }
                })
                .build();


        return restAdapter.create(ApiInterface.class);
    }

}
