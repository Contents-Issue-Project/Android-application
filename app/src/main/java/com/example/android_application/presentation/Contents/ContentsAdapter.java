/*
package com.example.android_application.presentation.Contents;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.android_application.Data.Contents.ContentsFormat;
import com.example.android_application.Data.DataFormat;
import com.example.android_application.R;
import com.example.android_application.presentation.ContentsData;
import com.example.android_application.presentation.Home.Bookmark.BookmarkContract;
import com.example.android_application.presentation.ItemData;
import com.example.android_application.util.DataUnavailableException;
import com.example.android_application.util.WrongRequestException;

import java.util.ArrayList;
import java.util.List;

public class ContentsAdapter implements ContentsContract.View {

    private Context context;
    private ContentsData contentsData = null;

    public ContentsAdapter(Context context, ContentsData contentsData) {
        this.context = context;
        this.contentsData = contentsData;
    }

    public void addItem(ContentsData item) {
        contentsData = item;
    }

    @Override
    public void setUpContent(ContentsFormat contentsformat) {
        contentsData = new ContentsData(contentsformat.content_id, contentsformat.title_kr, contentsformat.title_en, contentsformat.release_date, contentsformat.content_type, contentsformat.is_single, contentsformat.poster_url, contentsformat.top_words, contentsformat.sub_type, contentsformat.is_hot, contentsformat.single_statistics, contentsformat.type_additional_data, contentsformat.season_count);
        System.out.println("content test : " + contentsformat.title_en + ", " + contentsformat.title_kr);
    }

    @Override
    public void handleWrongRequest(WrongRequestException exception) {
        System.out.println("Wrong Request");
    }

    @Override
    public void handleDataUnavailable(DataUnavailableException exception) {
        System.out.println("Data unavailable");
    }


}

 */