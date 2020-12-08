package com.example.android_application.Data.New;

import com.example.android_application.Data.DataFormat;
import com.example.android_application.Domain.New.NewDataSource;
import com.example.android_application.util.DataUnavailableException;
import com.example.android_application.util.WrongRequestException;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewRemote implements NewDataSource {

    @Override
    public Single<DataFormat> getNew(NewParam newParam) {
        //TODO 재사용 불가능?
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.andang.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(NewApi.class).getNew(
                newParam.result_count)
                .flatMap((response)->{
                    switch(response.code()){
                        case 200:
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
