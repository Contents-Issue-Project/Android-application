package com.example.android_application.Domain.Contents;



import com.example.android_application.Data.Contents.ContentsFormat;
import com.example.android_application.Data.Contents.ContentsParam;

import io.reactivex.Single;

public interface ContentsService {
    public Single<ContentsFormat> getContents(ContentsParam contentsParam);
}
