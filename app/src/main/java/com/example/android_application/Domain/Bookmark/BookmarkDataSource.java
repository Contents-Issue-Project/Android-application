package com.example.android_application.Domain.Bookmark;

import com.example.android_application.Data.DataFormat;
import com.example.android_application.Data.Bookmark.BookmarkParam;

import io.reactivex.Single;

public interface BookmarkDataSource {
    Single<DataFormat> getBookmark(BookmarkParam bookmarkParam);
}
