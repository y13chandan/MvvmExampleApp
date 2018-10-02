package com.example.root.mvvmexampleapp.networking;

import com.example.root.mvvmexampleapp.model.UserApiModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by chandan on 02/10/18.
 */


public interface RestServices {

    @GET("people/")
    Call<UserApiModel> getStarWarsDetails(
            @Query("page") int page
    );
}
