package com.example.android_application.Data.Contents;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ContentsApi {
    @GET("/v1/contents/{content_id}")
    Single<Response<ContentsFormat>> getContents(@Path("content_id") String content_id);
}
