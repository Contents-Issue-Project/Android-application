package com.example.android_application.Data.Bookmark.BookmarkApi;

import com.example.android_application.Data.DataFormat;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BookmarkApi {
    @GET("/v1/user/bookmark")
    Single<Response<DataFormat>> getBookmark(@Header("Authentication") String Authentication,
                                             @Query("result_number") int result_number);
}
