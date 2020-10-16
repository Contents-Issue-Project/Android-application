package com.example.android_application.presentation.Home.New;

import com.example.android_application.Data.DataFormat;
import com.example.android_application.Data.New.NewParam;
import com.example.android_application.util.DataUnavailableException;
import com.example.android_application.util.WrongRequestException;

public interface NewContract {
    interface View{
        public void setUpContent(DataFormat dataFormat);
        public void handleWrongRequest(WrongRequestException exception);
        public void handleDataUnavailable(DataUnavailableException exception);
    }
    interface Presenter{
        void loadNew(NewParam newParam);
        void bindView(DataFormat dataFormat);
    }
}
