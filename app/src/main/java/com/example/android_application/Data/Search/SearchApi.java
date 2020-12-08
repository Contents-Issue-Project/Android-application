package com.example.android_application.Data.Search;

import com.example.android_application.Data.DataFormat;
import com.example.android_application.Data.Search.SearchParam.SearchBodyParam;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface SearchApi {
    @POST("/v1/search/{content_type}")
    Single<Response<DataFormat>> getSearch(@Path("content_type") String content_type,
                                           @Body SearchBodyParam searchBodyParam);
}
