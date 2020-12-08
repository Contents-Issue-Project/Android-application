package com.example.android_application.Domain.Season;




import com.example.android_application.Data.Season.SeasonFormat;
import com.example.android_application.Data.Season.SeasonParam;

import io.reactivex.Single;

public interface SeasonService {
    public Single<SeasonFormat> getSeason(SeasonParam seasonParam);
}
