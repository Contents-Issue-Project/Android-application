package com.example.android_application.Domain.Leaf;




import com.example.android_application.Data.Leaf.LeafFormat;
import com.example.android_application.Data.Leaf.LeafParam;

import io.reactivex.Single;

public interface LeafDataSource {
    Single<LeafFormat> getLeaf(LeafParam leafParam);
}
