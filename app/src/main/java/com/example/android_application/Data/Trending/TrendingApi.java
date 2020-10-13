package com.example.android_application.Data.Trending;

import com.example.android_application.Data.DataFormat;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;



public interface TrendingApi {
    @GET("/test/redis/?")
    Single<Response<DataFormat>> getTrending(@Query("key") String Key);
}
