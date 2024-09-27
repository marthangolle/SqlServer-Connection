package com.example.sqlverbindung.retrofit;

import com.google.gson.Gson;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private Retrofit retrofit;

    public RetrofitService() {
        initializeRetrofit();
    }

    private void initializeRetrofit() {
        // Correct base URL for the REST API interacting with SQL Server
        retrofit = new Retrofit.Builder()
                .baseUrl("http://127.0.0.1:1433/")  // Make sure this is the correct API URL
                .addConverterFactory(GsonConverterFactory.create(new Gson())) // Chained correctly
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}


