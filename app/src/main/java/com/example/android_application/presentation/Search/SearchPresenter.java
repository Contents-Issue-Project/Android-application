package com.example.android_application.presentation.Search;

import com.example.android_application.Data.DataFormat;
import com.example.android_application.Data.Search.SearchParam.SearchParam;
import com.example.android_application.Domain.Search.SearchUseCase;
import com.example.android_application.util.DataUnavailableException;
import com.example.android_application.util.WrongRequestException;

public class SearchPresenter implements SearchContract.Presenter {
    private SearchContract.View view;
    private SearchUseCase searchUseCase;

    public SearchPresenter(SearchContract.View view) {
        this.view = view;
        searchUseCase = new SearchUseCase();
    }

    @Override
    public void loadSearch(SearchParam searchParam) {
        //TODO 얘도 사실은 주입해줘야
        searchUseCase.execute(searchParam, (response)->{
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
