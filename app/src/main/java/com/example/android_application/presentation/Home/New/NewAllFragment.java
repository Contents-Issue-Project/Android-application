package com.example.android_application.presentation.Home.New;

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

import com.example.android_application.Data.New.NewParam;
import com.example.android_application.Data.Trending.TrendingParam;
import com.example.android_application.R;
import com.example.android_application.presentation.Home.Trending.TrendingAdapter;
import com.example.android_application.presentation.Home.Trending.TrendingContract;
import com.example.android_application.presentation.Home.Trending.TrendingPresenter;
import com.example.android_application.presentation.ItemData;

import java.util.ArrayList;

public class NewAllFragment extends Fragment {

    private NewContract.Presenter newPresenter;
    private View view;
    private String top_title;
    private TextView textView;
    private RecyclerView recyclerView;
    private NewAdapter new_adapter;
    private ArrayList<ItemData> list = new ArrayList<>();

    public static NewAllFragment newInstance() {
        return new NewAllFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag4, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.display_recycler);
        textView = (TextView) view.findViewById(R.id.top_title);

        top_title = "# New";
        textView.setText(top_title);

        recyclerView.setHasFixedSize(true);
        new_adapter = new NewAdapter(getActivity(), list);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        recyclerView.setAdapter(new_adapter);

        newPresenter = new NewPresenter(new_adapter);
        NewParam new_param = new NewParam();
        new_param.result_count = 10;
        newPresenter.loadNew(new_param);

        Log.e("Frag", "NewAllFragment");

        return view;
    }
}
