package com.androidaplication.bubu.pogoda.service;

import com.androidaplication.bubu.pogoda.data.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Klaudia on 2016-05-03.
 */
public interface Service {

    @GET("{latitude},{longitude}")
    Call<Weather> getWeather(@Path("latitude") String latitude,
                             @Path("longitude") String longitude);

}
