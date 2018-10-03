package com.example.root.mvvmexampleapp.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.root.mvvmexampleapp.model.User;
import com.example.root.mvvmexampleapp.model.UserApiModel;
import com.example.root.mvvmexampleapp.networking.RestClient;
import com.example.root.mvvmexampleapp.networking.RestServices;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserViewModel extends ViewModel {
    //this is the data that we will fetch asynchronously
    private MutableLiveData<List<User>> userList;

    public MutableLiveData<List<User>> getUserList() {
        if (userList == null) { // if the list is null we will fetch the data from server
            userList = new MutableLiveData<>();
            loadTheDataFromServer();
        }
        return userList;
    }

    private void loadTheDataFromServer() {
        RestServices restService = RestClient.getApiClient().create(RestServices.class);
        Call<UserApiModel> call = restService.getStarWarsDetails(1);
        call.enqueue(new Callback<UserApiModel>() {
            @Override
            public void onResponse(Call<UserApiModel> call, Response<UserApiModel> response) {
                if (response.isSuccessful()) {
                    userList.setValue(response.body().getResults());
                }
            }

            @Override
            public void onFailure(Call<UserApiModel> call, Throwable t) {

            }
        });
    }
}
