package com.example.android_application.presentation.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_application.Data.New.NewParam;
import com.example.android_application.Data.Trending.TrendingParam;
import com.example.android_application.R;
import com.example.android_application.presentation.New.NewAdapter;
import com.example.android_application.presentation.New.NewContract;
import com.example.android_application.presentation.New.NewPresenter;
import com.example.android_application.presentation.Trending.TrendingContract;
import com.example.android_application.presentation.Trending.TrendingAdapter;
import com.example.android_application.presentation.ItemData;
import com.example.android_application.presentation.Trending.TrendingPresenter;

import java.util.ArrayList;

public class Home_Fragment extends Fragment {
    private TrendingContract.Presenter trendingPresenter;
    private NewContract.Presenter newPresenter;

    // private View view;

    private RecyclerView trending_recyclerView;
    private RecyclerView new_recyclerView;
    private TrendingAdapter trending_adapter;
    private NewAdapter new_adapter;
    private ArrayList<ItemData> trending_list = new ArrayList<>();
    private ArrayList<ItemData> new_list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup)inflater.inflate(R.layout.frag1, container, false);

        trending_recyclerView = (RecyclerView) view.findViewById(R.id.Trending_recycler);
        new_recyclerView = (RecyclerView) view.findViewById(R.id.New_recycler);



        //trending_list = ItemData.createContactsList(10);
        trending_recyclerView.setHasFixedSize(true);
        trending_adapter = new TrendingAdapter(getActivity(), trending_list);
        trending_recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        trending_recyclerView.setAdapter(trending_adapter);

        trendingPresenter = new TrendingPresenter(trending_adapter);
        TrendingParam trending_param = new TrendingParam();
        trending_param.result_count = 10;
        trendingPresenter.loadTrending(trending_param);


        //new_list = ItemData.createContactsList(10);
        new_recyclerView.setHasFixedSize(true);
        new_adapter = new NewAdapter(getActivity(), new_list);
        new_recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        new_recyclerView.setAdapter(new_adapter);

        newPresenter = new NewPresenter(new_adapter);
        NewParam new_param = new NewParam();
        new_param.result_count = 10;
        newPresenter.loadNew(new_param);

/*      bookmark_recyclerView.setHasFixedSize(true);
        bookmark_adapter = new BookmarkAdapter(getActivity(), bookmark_list);
        bookmark_recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        bookmark_recyclerView.setAdapter(bookmark_adapter);

        bookmarkPresenter = new BookmarkPresenter(bookmark_adapter);
        BookmarkParam bookmark_param = new BookmarkParam();
        bookmark_param.result_count = 10;
        bookmarkPresenter.loadBookmark(bookmark_param);*/


        Log.e("Frag", "HomeFragment");

        return view;
    }

}
