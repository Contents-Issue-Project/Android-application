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

import com.example.android_application.Data.Trending.TrendingParam;
import com.example.android_application.R;
import com.example.android_application.presentation.trending.TrendingContract;
import com.example.android_application.presentation.trending.TrendingAdapter;
import com.example.android_application.presentation.ItemData;
import com.example.android_application.presentation.trending.TrendingPresenter;

import java.util.ArrayList;

public class Home_Fragment extends Fragment {
    private TrendingContract.Presenter trendingPresenter;

    // private View view;
    private RecyclerView trending_recyclerView;
    private RecyclerView new_recyclerView;
    private TrendingAdapter trending_adapter;
    private TrendingAdapter new_adapter;
    private ArrayList<ItemData> trending_list = new ArrayList<>();
    private ArrayList<ItemData> new_list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup)inflater.inflate(R.layout.frag1, container, false);

        trending_recyclerView = (RecyclerView) view.findViewById(R.id.Trending_recycler);
        new_recyclerView = (RecyclerView) view.findViewById(R.id.New_recycler);

        trendingPresenter = new TrendingPresenter(trending_adapter);
        TrendingParam param = new TrendingParam();
        // 요청값 count 수
        param.result_count = 10;
        trendingPresenter.loadTrending(param);

        trending_list = ItemData.createContactsList(10);
        trending_recyclerView.setHasFixedSize(true);
        trending_adapter = new TrendingAdapter(getActivity(), trending_list);
        trending_recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        trending_recyclerView.setAdapter(trending_adapter);

        new_list = ItemData.createContactsList(10);
        new_recyclerView.setHasFixedSize(true);
        new_adapter = new TrendingAdapter(getActivity(), new_list);
        new_recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        new_recyclerView.setAdapter(new_adapter);

        Log.e("Frag", "HomeFragment");

        return view;
    }

}
