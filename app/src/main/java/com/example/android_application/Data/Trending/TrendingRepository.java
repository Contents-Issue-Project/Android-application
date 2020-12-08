package com.example.android_application.Data.Trending;

import com.example.android_application.Data.DataFormat;
import com.example.android_application.Data.Repository;
import com.example.android_application.Domain.Trending.TrendingDataSource;

import io.reactivex.Single;

public class TrendingRepository extends Repository<DataFormat> implements TrendingDataSource{
    private static TrendingRepository INSTANCE = null;
    private final TrendingDataSource mTrendingRemote;

    // 싱글톤 구현 Start
//    private TrendingRepository(TrendingDataSource trendingRemote){
    private TrendingRepository(){
        mTrendingRemote = new TrendingRemote();
    }

    //    public static TrendingRepository getInstance(TrendingDataSource trendingRemote){
    public static TrendingRepository getInstance(){
        if (INSTANCE == null){
            INSTANCE = new TrendingRepository();
        }
        return INSTANCE;
    }
    //싱글톤 구현 End

    @Override
    public Single<DataFormat> getTrending(TrendingParam trendingParam) {
        return setThread(mTrendingRemote.getTrending(trendingParam));
    }
}
