package com.example.android_application.Domain.Contents;



import com.example.android_application.Data.Contents.ContentsFormat;
import com.example.android_application.Data.Contents.ContentsParam;
import com.example.android_application.Domain.UseCase;

import io.reactivex.Single;

public class ContentsUseCase extends UseCase<ContentsParam, ContentsFormat> {
    private ContentsService mContentsService;

    public ContentsUseCase() {
        mContentsService = new ContentsServiceImpl();
    }

//    public void setBookmarkService(BookmarkService mBookmarkService) {
//        this.mBookmarkService = mBookmarkService;
//    }


    @Override
    protected Single<ContentsFormat> buildUseCaseSingle(ContentsParam contentsParam) {
        return mContentsService.getContents(contentsParam);
    }

}
