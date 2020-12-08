package com.example.android_application.Domain.New;

import com.example.android_application.Data.DataFormat;
import com.example.android_application.Data.New.NewParam;
import com.example.android_application.Domain.UseCase;

import io.reactivex.Single;

public class NewUseCase extends UseCase<NewParam, DataFormat> {
    private NewService mNewService;

    public NewUseCase() {
        mNewService = new NewServiceImpl();
    }

//    public void setNewService(NewService mNewService) {
//        this.mNewService = mNewService;
//    }


    @Override
    protected Single<DataFormat> buildUseCaseSingle(NewParam newParam) {
        return mNewService.getNew(newParam);
    }

}
