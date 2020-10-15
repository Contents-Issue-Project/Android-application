package com.example.android_application.presentation.trending;

import com.example.android_application.Data.DataFormat;
import com.example.android_application.Data.Trending.TrendingParam;
import com.example.android_application.Domain.Trending.TrendingUseCase;
import com.example.android_application.util.DataUnavailableException;
import com.example.android_application.util.WrongRequestException;

public class TrendingPresenter implements TrendingContract.Presenter {
    private TrendingContract.View view;
    private TrendingUseCase trendingUseCase;

    public TrendingPresenter(TrendingContract.View view) {
        this.view = view;
        trendingUseCase = new TrendingUseCase();
    }

    @Override
    public void loadTrending(TrendingParam trendingParam) {
        //TODO 얘도 사실은 주입해줘야
        trendingUseCase.execute(trendingParam, (response)->{
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
