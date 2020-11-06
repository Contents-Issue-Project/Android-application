package com.example.android_application.presentation.Search;

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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_application.Data.Search.SearchParam.SearchParam;
import com.example.android_application.MainActivity;
import com.example.android_application.R;
import com.example.android_application.presentation.Home.OnBackPressedListener;
import com.example.android_application.presentation.ItemData;

import java.util.ArrayList;

public class SearchResultFragment extends Fragment implements OnBackPressedListener {

    private SearchContract.Presenter searchPresenter;
    private View view;
    private ImageButton back_button;
    private String top_title;
    private TextView textView;
    private RecyclerView recyclerView;
    private SearchAdapter search_adapter;
    private ArrayList<ItemData> list = new ArrayList<>();

    private String type;
    private String search_word;
    private ArrayList<String> genre = new ArrayList<String>();
    private ArrayList<String> date_range = new ArrayList<String>();
    private String start_date;
    private String end_date;

    public static SearchResultFragment newInstance() {
        return new SearchResultFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.frag4, container, false);

        back_button = (ImageButton) view.findViewById(R.id.back_button);
        recyclerView = (RecyclerView) view.findViewById(R.id.display_recycler);
        textView = (TextView) view.findViewById(R.id.top_title);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(SearchFragment.newInstance());
            }
        });

        if (getArguments() != null) {
            type = getArguments().getString("type");
            search_word = getArguments().getString("searchWord");
            start_date = getArguments().getString("startDate");
            end_date = getArguments().getString("endDate");
            System.out.println("type : " + type);
            System.out.println("searchWord : " + search_word);
            System.out.println("genre : " + genre);
            System.out.println("startDate : " + start_date);
            System.out.println("endDate : " + end_date);
        }

        top_title = search_word+" 검색 결과";		// search_word 들어가야 함
        textView.setText(top_title);

        date_range.add(start_date);
        date_range.add(end_date);

        recyclerView.setHasFixedSize(true);
        search_adapter = new SearchAdapter(getActivity(), list);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        recyclerView.setAdapter(search_adapter);

        searchPresenter = new SearchPresenter(search_adapter);

        ArrayList<String> genre_ex = new ArrayList<String>();
        genre_ex.add("action");
        genre_ex.add("fantasy");
        ArrayList<String> date_ex = new ArrayList<String>();
        date_ex.add("2000-01-01");
        date_ex.add("2020-10-18");

        //SearchParam search_param = new SearchParam(type, search_word, genre_ex, date_range );
        SearchParam search_param = new SearchParam("movie", "avengers", genre_ex, date_ex);
        searchPresenter.loadSearch(search_param);

        Log.e("Frag", "SearchResultFragment");

        return view;
    }


    @Override
    public void onBack() {
        ((MainActivity)getActivity()).replaceFragment(SearchFragment.newInstance());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ((MainActivity)context).setOnBackPressedListener(this);
    }

}
