package com.example.android_application.presentation.Home.Bookmark;

import com.example.android_application.Data.DataFormat;
import com.example.android_application.Data.Bookmark.BookmarkParam;
import com.example.android_application.Domain.Bookmark.BookmarkUseCase;
import com.example.android_application.util.DataUnavailableException;
import com.example.android_application.util.WrongRequestException;

public class BookmarkPresenter implements BookmarkContract.Presenter {
    private BookmarkContract.View view;
    private BookmarkUseCase bookmarkUseCase;

    public BookmarkPresenter(BookmarkContract.View view) {
        this.view = view;
        bookmarkUseCase = new BookmarkUseCase();
    }

    @Override
    public void loadBookmark(BookmarkParam bookmarkParam) {
        //TODO 얘도 사실은 주입해줘야
        bookmarkUseCase.execute(bookmarkParam, (response)->{
            bindView(response); //callback
        }, (error)->handleError(error));
    }

    @Override
    public void bindView(DataFormat dataFormat) {
        view.setUpContent(dataFormat);
    }
    public void handleError(Throwable e){
        if(e instanceof DataUnavailableException){
            view.handleDataUnavailable((DataUnavailableException)e);
        }
        else if(e instanceof WrongRequestException){
            view.handleWrongRequest((WrongRequestException)e);
        }
        else{
            System.out.println("other errors");
        }
    }
}