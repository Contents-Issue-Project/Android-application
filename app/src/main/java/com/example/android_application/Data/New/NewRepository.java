package com.example.android_application.Data.New;

import com.example.android_application.Data.DataFormat;
import com.example.android_application.Data.Repository;
import com.example.android_application.Data.New.NewParam;
import com.example.android_application.Data.New.NewRemote;
import com.example.android_application.Data.New.NewRepository;
import com.example.android_application.Domain.New.NewDataSource;

import io.reactivex.Single;

public class NewRepository extends Repository<DataFormat> implements NewDataSource {
    private static NewRepository INSTANCE = null;
    private final NewDataSource mNewRemote;

    // 싱글톤 구현 Start
//    private NewRepository(NewDataSource newRemote){
    private NewRepository(){
        mNewRemote = new NewRemote();
    }

    //    public static NewRepository getInstance(NewDataSource newRemote){
    public static NewRepository getInstance(){
        if (INSTANCE == null){
            INSTANCE = new NewRepository();
        }
        return INSTANCE;
    }
    //싱글톤 구현 End

    @Override
    public Single<DataFormat> getNew(NewParam newParam) {
        return setThread(mNewRemote.getNew(newParam));
    }
}
