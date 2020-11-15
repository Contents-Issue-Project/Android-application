package com.example.android_application.Data.Leaf;


import com.example.android_application.Data.Repository;
import com.example.android_application.Domain.Leaf.LeafDataSource;

import io.reactivex.Single;

public class LeafRepository extends Repository<LeafFormat> implements LeafDataSource {
    private static LeafRepository INSTANCE = null;
    private final LeafDataSource mLeafRemote;

    private LeafRepository(){
        mLeafRemote = new LeafRemote();
    }


    public static LeafRepository getInstance(){
        if (INSTANCE == null){
            INSTANCE = new LeafRepository();
        }
        return INSTANCE;
    }


    @Override
    public Single<LeafFormat> getLeaf(LeafParam leafParam) {
        return setThread(mLeafRemote.getLeaf(leafParam));
    }
}
