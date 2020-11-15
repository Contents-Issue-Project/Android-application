package com.example.android_application.Domain.Season;



import com.example.android_application.Data.Contents.ContentsFormat;
import com.example.android_application.Data.Contents.ContentsParam;
import com.example.android_application.Data.Season.SeasonFormat;
import com.example.android_application.Data.Season.SeasonParam;

import io.reactivex.Single;

public interface SeasonDataSource {
    Single<SeasonFormat> getSeason(SeasonParam SeasonParam);
}
