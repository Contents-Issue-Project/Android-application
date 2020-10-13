package com.example.android_application.presentation;

import com.example.android_application.Data.DataFormat;
import com.example.android_application.Data.Trending.TrendingParam;
import com.example.android_application.util.DataUnavailableException;
import com.example.android_application.util.WrongRequestException;

public interface Contract {
    interface View{
        public void setUpContent(DataFormat dataFormat);
        public void handleWrongRequest(WrongRequestException exception);
        public void handleDataUnavailable(DataUnavailableException exception);
    }
    interface Presenter{
        void loadTrending(TrendingParam trendingParam);
        void bindView(DataFormat dataFormat);
    }
}
