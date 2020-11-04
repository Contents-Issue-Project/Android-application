package com.example.android_application.Domain.Search;

import com.example.android_application.Data.DataFormat;
import com.example.android_application.Data.Search.SearchParam;
import com.example.android_application.Data.Search.SearchRepository;

import io.reactivex.Single;

public class SearchServiceImpl implements SearchService {
    private SearchDataSource mSearchDataSource;

    public SearchServiceImpl(){
        mSearchDataSource = SearchRepository.getInstance();
    }

    @Override
    public Single<DataFormat> getSearch(SearchParam searchParam) {
        return mSearchDataSource.getSearch(searchParam)
                .flatMap(this::someProcessing);
    }

    private Single<DataFormat> someProcessing(DataFormat resourceSingle){
        System.out.println("some processing");
        return Single.just(resourceSingle);
    }
}
