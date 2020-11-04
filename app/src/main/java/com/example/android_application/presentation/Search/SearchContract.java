package com.example.android_application.presentation.Search;

import com.example.android_application.Data.DataFormat;
import com.example.android_application.Data.Search.SearchParam;
import com.example.android_application.util.DataUnavailableException;
import com.example.android_application.util.WrongRequestException;

public interface SearchContract {
    interface View{
        public void setUpContent(DataFormat dataFormat);
        public void handleWrongRequest(WrongRequestException exception);
        public void handleDataUnavailable(DataUnavailableException exception);
    }
    interface Presenter{
        void loadSearch(SearchParam searchParam);
        void bindView(DataFormat dataFormat);
    }
}
