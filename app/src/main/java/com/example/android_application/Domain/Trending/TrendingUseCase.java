package com.example.android_application.Domain.Trending;

import com.example.android_application.Data.DataFormat;
import com.example.android_application.Data.Trending.TrendingParam;
import com.example.android_application.Domain.UseCase;

import io.reactivex.Single;

public class TrendingUseCase extends UseCase<TrendingParam, DataFormat> {
    private TrendingService mTrendingService;

    public TrendingUseCase() {
        mTrendingService = new TrendingServiceImpl();
    }

//    public void setTrendingService(TrendingService mTrendingService) {
//        this.mTrendingService = mTrendingService;
//    }


    @Override
    protected Single<DataFormat> buildUseCaseSingle(TrendingParam trendingParam) {
        return mTrendingService.getTrending(trendingParam);
    }

}
