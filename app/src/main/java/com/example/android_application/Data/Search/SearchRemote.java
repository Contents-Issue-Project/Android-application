package com.example.android_application.Data.Search;

import com.example.android_application.Data.DataFormat;
import com.example.android_application.Data.Search.SearchParam.SearchBodyParam;
import com.example.android_application.Data.Search.SearchParam.SearchParam;
import com.example.android_application.Data.Search.SearchParam.SearchPathParam;
import com.example.android_application.Domain.Search.SearchDataSource;
import com.example.android_application.util.DataUnavailableException;
import com.example.android_application.util.WrongRequestException;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchRemote implements SearchDataSource {

    @Override
    public Single<DataFormat> getSearch(SearchParam searchParam) {
        //TODO 재사용 불가능?

        SearchBodyParam searchBodyParam = new SearchBodyParam(searchParam.search_word, searchParam.sub_type, searchParam.date_range);
        SearchPathParam searchPathParam = new SearchPathParam(searchParam.content_type);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.andang.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(SearchApi.class).getSearch(
                searchPathParam.content_type, searchBodyParam)
                .flatMap((response)->{
                    switch(response.code()){
                        case 200:
                            System.out.println("요청은 성공");
                            return Single.just(response.body());
                        case 204:
                            return Single.just(new DataFormat());
                        case 400:
                        case 401:
                        case 404:
                            throw new WrongRequestException(response.message());
                        case 500:
                        case 502:
                        case 503:
                            throw new DataUnavailableException(response.message());
                        default:
                            throw new RuntimeException(response.message());
                    }
                });
    }
}
