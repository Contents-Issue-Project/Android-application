package com.example.android_application.Data.Search;

import com.example.android_application.Data.DataFormat;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface SearchApi {
    @GET("/v1/contents/trending/{result_count}")
    Single<Response<DataFormat>> getSearch(@Path("result_count") int result_count);
}
