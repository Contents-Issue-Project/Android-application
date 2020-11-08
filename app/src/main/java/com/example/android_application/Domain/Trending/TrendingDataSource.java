package com.example.android_application.Domain.Trending;

import com.example.android_application.Data.DataFormat;
import com.example.android_application.Data.Trending.TrendingParam;

import io.reactivex.Single;

public interface TrendingDataSource {
    Single<DataFormat> getTrending(TrendingParam trendingParam);
}
