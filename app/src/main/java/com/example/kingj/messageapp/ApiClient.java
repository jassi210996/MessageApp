package com.example.kingj.messageapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit;
    private static RetrofitService service;

    static Retrofit getInstance()
    {
        if(retrofit==null)
        {
            Retrofit.Builder builder = new Retrofit.Builder()
                                        .baseUrl("https://api.themoviedb.org/3/")
                                        .addConverterFactory(GsonConverterFactory.create());
            retrofit=builder.build();
        }
        return retrofit;
    }

    public static RetrofitService getService()
    {
        if(service==null)
        {
            service=getInstance().create(RetrofitService.class);
        }
        return service;
    }
}
