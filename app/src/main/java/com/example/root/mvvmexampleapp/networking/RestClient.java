package com.example.root.mvvmexampleapp.networking;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {
    private static Retrofit restClient;

    public static synchronized Retrofit getApiClient() {
        if (restClient == null ) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            restClient =
                    new Retrofit.Builder()
                            .baseUrl("https://swapi.co/api/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(builder.build()).build();
        }
        return restClient;
    }
}
