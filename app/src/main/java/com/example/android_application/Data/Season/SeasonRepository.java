package com.example.android_application.Data.Season;


import com.example.android_application.Data.Repository;
import com.example.android_application.Domain.Season.SeasonDataSource;

import io.reactivex.Single;

public class SeasonRepository extends Repository<SeasonFormat> implements SeasonDataSource {
    private static SeasonRepository INSTANCE = null;
    private final SeasonDataSource mSeasonRemote;

    private SeasonRepository(){
        mSeasonRemote = new SeasonRemote();
    }


    public static SeasonRepository getInstance(){
        if (INSTANCE == null){
            INSTANCE = new SeasonRepository();
        }
        return INSTANCE;
    }


    @Override
    public Single<SeasonFormat> getSeason(SeasonParam seasonParam) {
        return setThread(mSeasonRemote.getSeason(seasonParam));
    }
}
