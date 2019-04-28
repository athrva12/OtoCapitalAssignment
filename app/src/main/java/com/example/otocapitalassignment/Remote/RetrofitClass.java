package com.example.otocapitalassignment.Remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClass {

    public static final String BaseUrl ="https://api.themoviedb.org/3/movie/";

    private static Retrofit getRetroInstance()
    {

        return new Retrofit.Builder().baseUrl(BaseUrl).addConverterFactory(GsonConverterFactory.create()).build();
    }
    public static ApiService getAPIService()
    {

        return getRetroInstance().create(ApiService.class);

    }


}
