package com.example.blackbird.myapplication.api.retrofit;


import com.example.blackbird.myapplication.api.response.BaseResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by blackbird on 7/10/17.
 */


public interface RetrofitInterface {

    @GET("forecast.json")
    Call<BaseResponse> weatherApiData(@Query("key") String apiKey, @Query("q") String locationName, @Query("days") int days);


}
