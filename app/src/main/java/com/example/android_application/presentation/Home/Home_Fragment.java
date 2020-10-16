package com.example.android_application.presentation.Home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_application.Data.New.NewParam;
import com.example.android_application.Data.Trending.TrendingParam;
import com.example.android_application.MainActivity;
import com.example.android_application.R;
import com.example.android_application.presentation.Home.Bookmark.Bookmark_Fragment;
import com.example.android_application.presentation.Home.New.NewAdapter;
import com.example.android_application.presentation.Home.New.NewAllFragment;
import com.example.android_application.presentation.Home.New.NewContract;
import com.example.android_application.presentation.Home.New.NewPresenter;
import com.example.android_application.presentation.Home.Trending.TrendingAllFragment;
import com.example.android_application.presentation.Home.Trending.TrendingContract;
import com.example.android_application.presentation.Home.Trending.TrendingAdapter;
import com.example.android_application.presentation.ItemData;
import com.example.android_application.presentation.Home.Trending.TrendingPresenter;

import java.util.ArrayList;

public class Home_Fragment extends Fragment{
    private TrendingContract.Presenter trendingPresenter;
    private NewContract.Presenter newPresenter;

    // private View view;

    private RecyclerView trending_recyclerView;
    private RecyclerView new_recyclerView;
    private TrendingAdapter trending_adapter;
    private NewAdapter new_adapter;
    private ArrayList<ItemData> trending_list = new ArrayList<>();
    private ArrayList<ItemData> new_list = new ArrayList<>();
    private Button trending_button;
    private Button new_button;
    private Button bookmark_button;

    public static Home_Fragment newInstance() {
        return new Home_Fragment();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup)inflater.inflate(R.layout.frag1, container, false);

        trending_recyclerView = (RecyclerView) view.findViewById(R.id.Trending_recycler);
        new_recyclerView = (RecyclerView) view.findViewById(R.id.New_recycler);
        trending_button = (Button) view.findViewById(R.id.trending_button);
        new_button = (Button) view.findViewById(R.id.new_button);
        bookmark_button = (Button) view.findViewById(R.id.bookmark_button);

        trending_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).replaceFragment(TrendingAllFragment.newInstance());    // 새로 불러올 Fragment의 Instance를 Main으로 전달
            }
        });

        new_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(NewAllFragment.newInstance());
            }
        });

        bookmark_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(Bookmark_Fragment.newInstance());
            }
        });

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
