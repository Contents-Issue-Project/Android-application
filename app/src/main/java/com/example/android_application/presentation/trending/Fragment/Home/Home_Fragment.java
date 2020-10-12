package com.example.android_application.presentation.trending.Fragment.Home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_application.R;
import com.example.android_application.presentation.trending.Fragment.ViewAdapter;

import java.util.ArrayList;

public class Home_Fragment extends Fragment {

    // private View view;
    private RecyclerView trending_recyclerView;
    private RecyclerView new_recyclerView;
    private ViewAdapter trending_adapter;
    private ViewAdapter new_adapter;
    private ArrayList<ItemData> trending_list = new ArrayList<>();
    private ArrayList<ItemData> new_list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup)inflater.inflate(R.layout.frag1, container, false);

        trending_recyclerView = (RecyclerView) view.findViewById(R.id.Trending_recycler);
        new_recyclerView = (RecyclerView) view.findViewById(R.id.New_recycler);

        trending_list = ItemData.createContactsList(10);
        trending_recyclerView.setHasFixedSize(true);
        trending_adapter = new ViewAdapter(getActivity(), trending_list);
        trending_recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        trending_recyclerView.setAdapter(trending_adapter);

        new_list = ItemData.createContactsList(10);
        new_recyclerView.setHasFixedSize(true);
        new_adapter = new ViewAdapter(getActivity(), new_list);
        new_recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        new_recyclerView.setAdapter(new_adapter);

        Log.e("Frag", "HomeFragment");

        return view;
    }

}
