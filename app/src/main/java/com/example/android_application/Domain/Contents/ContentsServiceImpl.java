package com.example.android_application.Domain.Contents;



import com.example.android_application.Data.Contents.ContentsFormat;
import com.example.android_application.Data.Contents.ContentsParam;
import com.example.android_application.Data.Contents.ContentsRepository;

import io.reactivex.Single;

public class ContentsServiceImpl implements ContentsService {
    private ContentsDataSource mContentsDataSource;

    public ContentsServiceImpl(){
        mContentsDataSource = ContentsRepository.getInstance();
    }

    @Override
    public Single<ContentsFormat> getContents(ContentsParam contentsParam) {
        return mContentsDataSource.getContents(contentsParam)
                .flatMap(this::someProcessing);
    }

    private Single<ContentsFormat> someProcessing(ContentsFormat resourceSingle){
        System.out.println("some processing_ContentsServiceImpl");
        //System.out.println("가나다라마바사 : " + resourceSingle.content_id);
        return Single.just(resourceSingle);
    }
}
