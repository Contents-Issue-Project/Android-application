package com.example.android_application.Domain.Bookmark;

import com.example.android_application.Data.DataFormat;
import com.example.android_application.Data.Bookmark.BookmarkParam;
import com.example.android_application.Data.Bookmark.BookmarkRepository;

import io.reactivex.Single;

public class BookmarkServiceImpl implements BookmarkService {
    private BookmarkDataSource mBookmarkDataSource;

    public BookmarkServiceImpl(){
        mBookmarkDataSource = BookmarkRepository.getInstance();
    }

    @Override
    public Single<DataFormat> getBookmark(BookmarkParam bookmarkParam) {
        return mBookmarkDataSource.getBookmark(bookmarkParam)
                .flatMap(this::someProcessing);
    }

    private Single<DataFormat> someProcessing(DataFormat resourceSingle){
        System.out.println("some processing");
        return Single.just(resourceSingle);
    }
}
