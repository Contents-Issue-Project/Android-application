package com.example.android_application.Domain.Season;



import com.example.android_application.Data.Season.SeasonFormat;
import com.example.android_application.Data.Season.SeasonParam;
import com.example.android_application.Data.Season.SeasonRepository;

import io.reactivex.Single;

public class SeasonServiceImpl implements SeasonService {
    private SeasonDataSource mSeasonDataSource;

    public SeasonServiceImpl(){
        mSeasonDataSource = SeasonRepository.getInstance();
    }

    @Override
    public Single<SeasonFormat> getSeason(SeasonParam seasonParam) {
        return mSeasonDataSource.getSeason(seasonParam)
                .flatMap(this::someProcessing);
    }

    private Single<SeasonFormat> someProcessing(SeasonFormat resourceSingle){
        System.out.println("some processing_SeasonServiceImpl");
        //System.out.println("가나다라마바사 : " + resourceSingle.content_id);
        return Single.just(resourceSingle);
    }
}
