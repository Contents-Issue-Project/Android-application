package com.example.android_application.Domain.Search;

import com.example.android_application.Data.DataFormat;
import com.example.android_application.Data.Search.SearchParam.SearchParam;

import io.reactivex.Single;

public interface SearchService {
    public Single<DataFormat> getSearch(SearchParam searchParam);
}
