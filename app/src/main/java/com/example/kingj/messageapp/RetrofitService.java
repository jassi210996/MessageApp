package com.example.kingj.messageapp;

import com.example.kingj.messageapp.Pojos.RecentPojo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitService {

    @GET("movie/{type}?api_key=d883c71561d799acb1eb729418f054d6&language=en-US&page=?")
    Call<RecentPojo>getRecent(@Path("type") String type, @Query("page") long page);
}
