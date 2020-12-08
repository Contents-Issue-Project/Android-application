package com.example.android_application.Domain.Leaf;



import com.example.android_application.Data.Leaf.LeafFormat;
import com.example.android_application.Data.Leaf.LeafParam;
import com.example.android_application.Data.Leaf.LeafRepository;

import io.reactivex.Single;

public class LeafServiceImpl implements LeafService {
    private LeafDataSource mLeafDataSource;

    public LeafServiceImpl(){
        mLeafDataSource = LeafRepository.getInstance();
    }

    @Override
    public Single<LeafFormat> getLeaf(LeafParam leafParam) {
        return mLeafDataSource.getLeaf(leafParam)
                .flatMap(this::someProcessing);
    }

    private Single<LeafFormat> someProcessing(LeafFormat resourceSingle){
        System.out.println("some processing_LeafServiceImpl");
        //System.out.println("가나다라마바사 : " + resourceSingle.content_id);
        return Single.just(resourceSingle);
    }
}
