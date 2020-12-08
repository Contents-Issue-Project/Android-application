package com.example.android_application.presentation.Home.Bookmark;

import com.example.android_application.Data.DataFormat;
import com.example.android_application.Data.Bookmark.BookmarkParam;
import com.example.android_application.util.DataUnavailableException;
import com.example.android_application.util.WrongRequestException;

import java.util.ArrayList;

public interface BookmarkContract {
    interface View{
        public void setUpContent(DataFormat dataFormat);
        public void handleWrongRequest(WrongRequestException exception);
        public void handleDataUnavailable(DataUnavailableException exception);
    }
    interface Presenter{
        void loadBookmark(BookmarkParam bookmarkParam);
        void bindView(DataFormat dataFormat);
    }
}
