package com.example.android_application.Data.Bookmark;

import com.example.android_application.Data.DataFormat;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BookmarkApi {
    @GET("/v1/contents/new/{result_count}")
    Single<Response<DataFormat>> getBookmark(@Path("result_count") int result_count);
}
