package com.example.android_application.presentation.Home.New;

import com.example.android_application.Data.DataFormat;
import com.example.android_application.Data.New.NewParam;
import com.example.android_application.Domain.New.NewUseCase;
import com.example.android_application.util.DataUnavailableException;
import com.example.android_application.util.WrongRequestException;

public class NewPresenter implements  NewContract.Presenter{
    private NewContract.View view;
    private NewUseCase newUseCase;

    public NewPresenter(NewContract.View view) {
        this.view = view;
        newUseCase = new NewUseCase();
    }

    @Override
    public void loadNew(NewParam newParam) {
        //TODO 얘도 사실은 주입해줘야
        newUseCase.execute(newParam, (response)->{
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
