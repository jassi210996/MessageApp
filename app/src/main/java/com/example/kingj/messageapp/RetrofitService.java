package com.example.kingj.messageapp;

import com.example.kingj.messageapp.Pojos.DetailsPojo;
import com.example.kingj.messageapp.Pojos.RecentPojo;
import com.example.kingj.messageapp.Pojos.UpcomingPojo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitService {

    @GET("movie/{type}?api_key=d883c71561d799acb1eb729418f054d6&language=en-US&page=?")
    Call<RecentPojo>getRecent(@Path("type") String type, @Query("page") long page);

    @GET("movie/{type}?api_key=d883c71561d799acb1eb729418f054d6&language=en-US&page=?")
    Call<UpcomingPojo>getUpcoming(@Path("type") String type, @Query("page") long page);

    @GET("movie/{id}?api_key=d883c71561d799acb1eb729418f054d6&language=en-US")
    Call<DetailsPojo>getDetails(@Path("id") long id);
}
