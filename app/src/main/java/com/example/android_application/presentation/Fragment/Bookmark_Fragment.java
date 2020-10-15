package com.example.android_application.presentation.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_application.Data.Bookmark.BookmarkParam;
import com.example.android_application.Data.New.NewParam;
import com.example.android_application.R;
import com.example.android_application.presentation.Bookmark.BookmarkAdapter;
import com.example.android_application.presentation.Bookmark.BookmarkContract;
import com.example.android_application.presentation.Bookmark.BookmarkPresenter;
import com.example.android_application.presentation.New.NewPresenter;
import com.example.android_application.presentation.Trending.TrendingAdapter;
import com.example.android_application.presentation.ItemData;
import com.example.android_application.presentation.Trending.TrendingContract;

import java.util.ArrayList;

public class Bookmark_Fragment extends Fragment {
    private BookmarkContract.Presenter bookmarkPresenter;

    private String top_title;
    private TextView textView;
    private RecyclerView recyclerView;
    private BookmarkAdapter bookmark_adapter;
    private ArrayList<ItemData> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.frag4, container, false);


        recyclerView = (RecyclerView) view.findViewById(R.id.display_recycler);
        textView = (TextView) view.findViewById(R.id.top_title);

        top_title = "#BookMark";
        textView.setText(top_title);

        //list = ItemData.createContactsList(15);
        recyclerView.setHasFixedSize(true);
        bookmark_adapter = new BookmarkAdapter(getActivity(), list);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        recyclerView.setAdapter(bookmark_adapter);

        bookmarkPresenter = new BookmarkPresenter(bookmark_adapter);
        BookmarkParam bookmark_param = new BookmarkParam();
        bookmark_param.result_count = 10;
        bookmarkPresenter.loadBookmark(bookmark_param);

        Log.e("Frag", "BookmarkFragment");
        return view;
    }
}