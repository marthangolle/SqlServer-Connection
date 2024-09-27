package com.example.sqlverbindung.retrofit;


import com.example.sqlverbindung.model.Container;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface ContainerApi{

    @GET("/Container/get-All")
    Call<List<Container>>getAllContainers();

    @POST("/Container/save")
    Call<Container> save(@Body Container container);
    }


