package com.example.android_application.presentation.Details.Leaf;


import com.example.android_application.Data.Leaf.LeafFormat;
import com.example.android_application.Data.Leaf.LeafParam;
import com.example.android_application.Domain.Leaf.LeafUseCase;
import com.example.android_application.util.DataUnavailableException;
import com.example.android_application.util.WrongRequestException;

public class LeafPresenter implements LeafContract.Presenter {
    private LeafContract.View view;
    private LeafUseCase leafUseCase;

    public LeafPresenter(LeafContract.View view) {
        this.view = view;
        leafUseCase = new LeafUseCase();
    }

    @Override
    public void loadLeaf(LeafParam leafParam) {
        //TODO 얘도 사실은 주입해줘야
       System.out.println("쌉가능");
        leafUseCase.execute(leafParam, (response)->{
            bindView(response); //callback
        }, (error)->handleError(error));
    }

    @Override
    public void bindView(LeafFormat leafFormat) {
        view.setUpContent(leafFormat);
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