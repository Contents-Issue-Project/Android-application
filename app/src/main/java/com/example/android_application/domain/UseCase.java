package com.example.android_application.domain;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;

public abstract class UseCase<RequestFormat, ResponseFormat> {
    public void execute(RequestFormat requestParam, ISuccessCallBack<ResponseFormat> successCallback,
                        IErrorCallBack errorCallback){
        buildUseCaseSingle(requestParam)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((response)->successCallback.onResponse(response),
                        (e)->errorCallback.onError(e));
    }
    protected abstract Single<ResponseFormat> buildUseCaseSingle(RequestFormat requestParam);

    public interface ISuccessCallBack<ResponseFormat>{
        void onResponse(ResponseFormat response);
    }
    public interface IErrorCallBack{
        void onError(Throwable e);
    }
}
