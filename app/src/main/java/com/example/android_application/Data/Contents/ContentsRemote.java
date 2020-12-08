package com.example.android_application.Data.Contents;

import com.example.android_application.Domain.Contents.ContentsDataSource;
import com.example.android_application.util.DataUnavailableException;
import com.example.android_application.util.WrongRequestException;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ContentsRemote implements ContentsDataSource {

    @Override
    public Single<ContentsFormat> getContents(ContentsParam contentsParam) {
        //TODO 재사용 불가능?
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.andang.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(ContentsApi.class).getContents(
                contentsParam.content_id)
                .flatMap((response) -> {
                    switch (response.code()) {
                        case 200:
                            System.out.println("요청 결과 : 200");
                            return Single.just(response.body());
                        case 204:
                            System.out.println("요청 결과 : 204");
                            return Single.just(new ContentsFormat());
                        case 400:
                        case 401:
                        case 404:
                            System.out.println("요청 결과 : 400대");
                            throw new WrongRequestException(response.message());
                        case 500:
                        case 502:
                        case 503:
                            System.out.println("요청 결과 : 500대");
                            throw new DataUnavailableException(response.message());
                        default:
                            System.out.println("요청 결과 : default");
                            throw new RuntimeException(response.message());
                    }
                });
    }
}
