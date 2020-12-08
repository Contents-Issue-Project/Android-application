package com.example.android_application.presentation.Details.Season;


import com.example.android_application.Data.Season.SeasonFormat;
import com.example.android_application.Data.Season.SeasonParam;
import com.example.android_application.util.DataUnavailableException;
import com.example.android_application.util.WrongRequestException;

public interface SeasonContract {
    interface View{
        public void setUpContent(SeasonFormat seasonFormat);
        public void handleWrongRequest(WrongRequestException exception);
        public void handleDataUnavailable(DataUnavailableException exception);
    }
    interface Presenter{
        void loadSeason(SeasonParam seasonParam);
        void bindView(SeasonFormat seasonFormat);
    }
}
