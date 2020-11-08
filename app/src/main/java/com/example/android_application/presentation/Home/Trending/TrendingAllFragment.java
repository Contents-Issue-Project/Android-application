package com.example.android_application.presentation.Home.Trending;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_application.Data.Bookmark.BookmarkParam;
import com.example.android_application.Data.Trending.TrendingParam;
import com.example.android_application.MainActivity;
import com.example.android_application.R;
import com.example.android_application.presentation.Home.Bookmark.BookmarkAdapter;
import com.example.android_application.presentation.Home.Bookmark.BookmarkContract;
import com.example.android_application.presentation.Home.Bookmark.BookmarkPresenter;
import com.example.android_application.presentation.Home.Home_Fragment;
import com.example.android_application.presentation.Home.New.NewAllFragment;
import com.example.android_application.presentation.Home.OnBackPressedListener;
import com.example.android_application.presentation.ItemData;

import java.util.ArrayList;

public class TrendingAllFragment extends Fragment implements OnBackPressedListener {

    private TrendingContract.Presenter trendingPresenter;
    private View view;
    private ImageButton back_button;
    private String top_title;
    private TextView textView;
    private RecyclerView recyclerView;
    private TrendingAdapter trending_adapter;
    private ArrayList<ItemData> list = new ArrayList<>();

    public static TrendingAllFragment newInstance() {
        return new TrendingAllFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag4, container, false);

        back_button = (ImageButton) view.findViewById(R.id.back_button);
        recyclerView = (RecyclerView) view.findViewById(R.id.display_recycler);
        textView = (TextView) view.findViewById(R.id.top_title);

        top_title = "Trending";
        textView.setText(top_title);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(Home_Fragment.newInstance());
            }
        });

        recyclerView.setHasFixedSize(true);
        trending_adapter = new TrendingAdapter(getActivity(), list);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        recyclerView.setAdapter(trending_adapter);

        trendingPresenter = new TrendingPresenter(trending_adapter);
        TrendingParam trending_param = new TrendingParam();
        trending_param.result_count = 30;
        trendingPresenter.loadTrending(trending_param);

        Log.e("Frag", "TrendingAllFragment");

        return view;
    }

    @Override
    public void onBack() {
        ((MainActivity)getActivity()).replaceFragment(Home_Fragment.newInstance());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ((MainActivity)context).setOnBackPressedListener(this);
    }

}
