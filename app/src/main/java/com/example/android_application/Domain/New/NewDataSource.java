package com.example.android_application.Domain.New;

import com.example.android_application.Data.DataFormat;
import com.example.android_application.Data.New.NewParam;

import io.reactivex.Single;

public interface NewDataSource {
    Single<DataFormat> getNew(NewParam newParam);
}
