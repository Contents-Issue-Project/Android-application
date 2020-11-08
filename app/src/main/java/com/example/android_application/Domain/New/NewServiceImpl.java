package com.example.android_application.Domain.New;

import com.example.android_application.Data.DataFormat;
import com.example.android_application.Data.New.NewRepository;
import com.example.android_application.Data.New.NewParam;
import com.example.android_application.Data.New.NewRepository;

import io.reactivex.Single;

public class NewServiceImpl implements NewService {
    private NewDataSource mNewDataSource;

    public NewServiceImpl(){
        mNewDataSource = NewRepository.getInstance();
    }

    @Override
    public Single<DataFormat> getNew(NewParam newParam) {
        return mNewDataSource.getNew(newParam)
                .flatMap(this::someProcessing);
    }

    private Single<DataFormat> someProcessing(DataFormat resourceSingle){
        System.out.println("some processing");
        return Single.just(resourceSingle);
    }
}
