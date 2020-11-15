package com.example.android_application.Data.Leaf;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface LeafApi {
    @GET("/v1/contents/{content_id}/season/{season_number}/episode/{episode_number}")
    Single<Response<LeafFormat>> getLeaf(@Path("content_id") String content_id,
                                         @Path("season_number") int season_number,
                                         @Path("episode number") int episode_number);
}
