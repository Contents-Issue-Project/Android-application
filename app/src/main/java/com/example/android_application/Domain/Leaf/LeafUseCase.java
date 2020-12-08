package com.example.android_application.Domain.Leaf;



import com.example.android_application.Data.Leaf.LeafFormat;
import com.example.android_application.Data.Leaf.LeafParam;
import com.example.android_application.Domain.UseCase;

import io.reactivex.Single;

public class LeafUseCase extends UseCase<LeafParam, LeafFormat> {
    private LeafService mLeafService;

    public LeafUseCase() {
        mLeafService = new LeafServiceImpl();
    }

//    public void setBookmarkService(BookmarkService mBookmarkService) {
//        this.mBookmarkService = mBookmarkService;
//    }


    @Override
    protected Single<LeafFormat> buildUseCaseSingle(LeafParam leafParam) {
        return mLeafService.getLeaf(leafParam);
    }

}
