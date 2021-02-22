package com.example.myapplication;

import android.app.Application;
import com.example.myapplication.data.network.Api;
import com.example.myapplication.model.Repo;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class Core extends Application {
    Api service;

    @Override
    public void onCreate() {
        super.onCreate();
        initApi();
    }

    private void initApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(Api.class);
    }

    public void requestData(String user, Callback<List<Repo>> callback) {
        service.listRepos(user).enqueue(callback);
    }
}
