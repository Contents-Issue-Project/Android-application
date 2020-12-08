package com.example.android_application.Data.Contents;


import com.example.android_application.Data.Repository;
import com.example.android_application.Domain.Contents.ContentsDataSource;

import io.reactivex.Single;

public class ContentsRepository extends Repository<ContentsFormat> implements ContentsDataSource {
    private static ContentsRepository INSTANCE = null;
    private final ContentsDataSource mContentsRemote;

    private ContentsRepository(){
        mContentsRemote = new ContentsRemote();
    }


    public static ContentsRepository getInstance(){
        if (INSTANCE == null){
            INSTANCE = new ContentsRepository();
        }
        return INSTANCE;
    }


    @Override
    public Single<ContentsFormat> getContents(ContentsParam contentsParam) {
        return setThread(mContentsRemote.getContents(contentsParam));
    }
}
