package com.example.android_application.Domain.Bookmark;

import com.example.android_application.Data.DataFormat;
import com.example.android_application.Data.Bookmark.BookmarkParam;
import com.example.android_application.Domain.UseCase;

import io.reactivex.Single;

public class BookmarkUseCase extends UseCase<BookmarkParam, DataFormat> {
    private BookmarkService mBookmarkService;

    public BookmarkUseCase() {
        mBookmarkService = new BookmarkServiceImpl();
    }

//    public void setBookmarkService(BookmarkService mBookmarkService) {
//        this.mBookmarkService = mBookmarkService;
//    }


    @Override
    protected Single<DataFormat> buildUseCaseSingle(BookmarkParam bookmarkParam) {
        return mBookmarkService.getBookmark(bookmarkParam);
    }

}
