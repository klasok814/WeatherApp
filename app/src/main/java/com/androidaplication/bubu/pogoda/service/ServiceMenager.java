package com.androidaplication.bubu.pogoda.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Klaudia on 2016-05-03.
 */
public class ServiceMenager {
    private static final String BASE_URL = "https://api.forecast.io/forecast/e5efb9df336d7e408cf79876c667edea/";

    public static Service getService(){
        Retrofit retrofit = getRetrofitInstance(BASE_URL);
        return retrofit.create(Service.class);
    }

    private static Retrofit getRetrofitInstance(String url){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
