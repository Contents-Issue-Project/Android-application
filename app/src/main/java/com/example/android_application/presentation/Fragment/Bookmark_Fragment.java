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

import com.example.android_application.R;
import com.example.android_application.presentation.trending.TrendingAdapter;
import com.example.android_application.presentation.ItemData;

import java.util.ArrayList;

public class Bookmark_Fragment extends Fragment {

    private String top_title;
    private TextView textView;
    private RecyclerView recyclerView;
    private TrendingAdapter adapter;
    private ArrayList<ItemData> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.frag4, container, false);


        recyclerView = (RecyclerView) view.findViewById(R.id.display_recycler);
        textView = (TextView) view.findViewById(R.id.top_title);

        top_title = "#BookmMark";
        textView.setText(top_title);

        list = ItemData.createContactsList(15);
        recyclerView.setHasFixedSize(true);
        adapter = new TrendingAdapter(getActivity(), list);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        recyclerView.setAdapter(adapter);

        Log.e("Frag", "BookmarkFragment");
        return view;
    }
}