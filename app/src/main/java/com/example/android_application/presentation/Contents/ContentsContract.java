package com.example.android_application.presentation.Contents;


import com.example.android_application.Data.Contents.ContentsFormat;
import com.example.android_application.Data.Contents.ContentsParam;
import com.example.android_application.util.DataUnavailableException;
import com.example.android_application.util.WrongRequestException;

public interface ContentsContract {
    interface View{
        public void setUpContent(ContentsFormat contentsFormat);
        public void handleWrongRequest(WrongRequestException exception);
        public void handleDataUnavailable(DataUnavailableException exception);
    }
    interface Presenter{
        void loadContents(ContentsParam contentsParam);
        void bindView(ContentsFormat contentsFormat);
    }
}
