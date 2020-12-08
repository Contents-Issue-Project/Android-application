package com.example.android_application.Data.Bookmark;

import com.example.android_application.Data.DataFormat;
import com.example.android_application.Data.Repository;
import com.example.android_application.Data.Bookmark.BookmarkRemote.BookmarkRemote;
import com.example.android_application.Domain.Bookmark.BookmarkDataSource;

import io.reactivex.Single;

public class BookmarkRepository extends Repository<DataFormat> implements BookmarkDataSource{
    private static BookmarkRepository INSTANCE = null;
    private final BookmarkDataSource mBookmarkRemote;

    // 싱글톤 구현 Start
//    private BookmarkRepository(BookmarkDataSource bookmarkRemote){
    private BookmarkRepository(){
        mBookmarkRemote = new BookmarkRemote();
    }

    //    public static BookmarkRepository getInstance(BookmarkDataSource bookmarkRemote){
    public static BookmarkRepository getInstance(){
        if (INSTANCE == null){
            INSTANCE = new BookmarkRepository();
        }
        return INSTANCE;
    }
    //싱글톤 구현 End

    @Override
    public Single<DataFormat> getBookmark(BookmarkParam bookmarkParam) {
        return setThread(mBookmarkRemote.getBookmark(bookmarkParam));
    }
}
