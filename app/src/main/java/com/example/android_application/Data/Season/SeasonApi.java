package com.example.android_application.Data.Season;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SeasonApi {
    @GET("/v1/contents/{content_id}/season/{season_number}")
    Single<Response<SeasonFormat>> getSeason(@Path("content_id") String content_id,
                                             @Path("season_number") int season_number);
}
