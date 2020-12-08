package com.example.android_application.presentation.Details.Contents;


import com.example.android_application.Data.Contents.ContentsFormat;
import com.example.android_application.Data.Contents.ContentsParam;
import com.example.android_application.Domain.Contents.ContentsUseCase;
import com.example.android_application.util.DataUnavailableException;
import com.example.android_application.util.WrongRequestException;

public class ContentsPresenter implements ContentsContract.Presenter {
    private ContentsContract.View view;
    private ContentsUseCase contentsUseCase;

    public ContentsPresenter(ContentsContract.View view) {
        this.view = view;
        contentsUseCase = new ContentsUseCase();
    }

    @Override
    public void loadContents(ContentsParam contentsParam) {
        //TODO 얘도 사실은 주입해줘야
        contentsUseCase.execute(contentsParam, (response)->{
            bindView(response); //callback
        }, (error)->handleError(error));
    }

    @Override
    public void bindView(ContentsFormat contentsFormat) {
        view.setUpContent(contentsFormat);
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