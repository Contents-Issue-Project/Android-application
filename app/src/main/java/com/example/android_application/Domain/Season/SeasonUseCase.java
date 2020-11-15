package com.example.android_application.Domain.Season;



import com.example.android_application.Data.Season.SeasonFormat;
import com.example.android_application.Data.Season.SeasonParam;
import com.example.android_application.Domain.UseCase;

import io.reactivex.Single;

public class SeasonUseCase extends UseCase<SeasonParam, SeasonFormat> {
    private SeasonService mSeasonService;

    public SeasonUseCase() {
        mSeasonService = new SeasonServiceImpl();
    }


    @Override
    protected Single<SeasonFormat> buildUseCaseSingle(SeasonParam seasonParam) {
        return mSeasonService.getSeason(seasonParam);
    }

}
