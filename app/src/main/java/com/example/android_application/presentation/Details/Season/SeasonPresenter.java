package com.example.android_application.presentation.Details.Season;


import com.example.android_application.Data.Season.SeasonFormat;
import com.example.android_application.Data.Season.SeasonParam;
import com.example.android_application.Domain.Season.SeasonUseCase;
import com.example.android_application.util.DataUnavailableException;
import com.example.android_application.util.WrongRequestException;

public class SeasonPresenter implements SeasonContract.Presenter {
    private SeasonContract.View view;
    private SeasonUseCase seasonUseCase;

    public SeasonPresenter(SeasonContract.View view) {
        this.view = view;
        seasonUseCase = new SeasonUseCase();
    }

    @Override
    public void loadSeason(SeasonParam seasonParam) {
        //TODO 얘도 사실은 주입해줘야
        seasonUseCase.execute(seasonParam, (response)->{
            bindView(response); //callback
        }, (error)->handleError(error));
    }

    @Override
    public void bindView(SeasonFormat seasonFormat) {
        view.setUpContent(seasonFormat);
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