package com.example.android_application.Data.Search;

import com.example.android_application.Data.DataFormat;
import com.example.android_application.Data.Repository;
import com.example.android_application.Data.Search.SearchParam.SearchParam;
import com.example.android_application.Domain.Search.SearchDataSource;

import io.reactivex.Single;

public class SearchRepository extends Repository<DataFormat> implements SearchDataSource{
    private static SearchRepository INSTANCE = null;
    private final SearchDataSource mSearchRemote;

    // 싱글톤 구현 Start
//    private SearchRepository(SearchDataSource searchRemote){
    private SearchRepository(){
        mSearchRemote = new SearchRemote();
    }

    //    public static SearchRepository getInstance(SearchDataSource searchRemote){
    public static SearchRepository getInstance(){
        if (INSTANCE == null){
            INSTANCE = new SearchRepository();
        }
        return INSTANCE;
    }
    //싱글톤 구현 End

    @Override
    public Single<DataFormat> getSearch(SearchParam searchParam) {
        return setThread(mSearchRemote.getSearch(searchParam));
    }
}
