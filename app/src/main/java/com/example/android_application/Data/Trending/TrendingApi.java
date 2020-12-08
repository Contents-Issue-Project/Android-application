package com.example.android_application.Data.Trending;

import com.example.android_application.Data.DataFormat;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;



public interface TrendingApi {
    @GET("/v1/contents/trending/{result_count}")
    Single<Response<DataFormat>> getTrending(@Path("result_count") int result_count);
}
