package com.example.android_application.Domain.Search;

import com.example.android_application.Data.DataFormat;
import com.example.android_application.Data.Search.SearchParam;
import com.example.android_application.Domain.UseCase;

import io.reactivex.Single;

public class SearchUseCase extends UseCase<SearchParam, DataFormat> {
    private SearchService mSearchService;

    public SearchUseCase() {
        mSearchService = new SearchServiceImpl();
    }

//    public void setSearchService(SearchService mSearchService) {
//        this.mSearchService = mSearchService;
//    }


    @Override
    protected Single<DataFormat> buildUseCaseSingle(SearchParam searchParam) {
        return mSearchService.getSearch(searchParam);
    }

}
