package com.example.otocapitalassignment.Remote;

import com.example.otocapitalassignment.Models.PopularList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("popular?")
    Call<PopularList> getPopularList(@Query("api_key") String name, @Query("language")String key,@Query("page")int i);
}
