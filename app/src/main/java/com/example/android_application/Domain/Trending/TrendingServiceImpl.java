package com.example.android_application.Domain.Trending;

import com.example.android_application.Data.DataFormat;
import com.example.android_application.Data.Trending.TrendingParam;
import com.example.android_application.Data.Trending.TrendingRepository;

import io.reactivex.Single;

public class TrendingServiceImpl implements TrendingService {
    private TrendingDataSource mTrendingDataSource;

    public TrendingServiceImpl(){
        mTrendingDataSource = TrendingRepository.getInstance();
    }

    @Override
    public Single<DataFormat> getTrending(TrendingParam trendingParam) {
        return mTrendingDataSource.getTrending(trendingParam)
                .flatMap(this::someProcessing);
    }

    private Single<DataFormat> someProcessing(DataFormat resourceSingle){
        System.out.println("some processing");
        return Single.just(resourceSingle);
    }
}
