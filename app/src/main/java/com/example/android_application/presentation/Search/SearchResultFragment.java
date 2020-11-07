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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_application.Data.Search.SearchParam.SearchParam;
import com.example.android_application.MainActivity;
import com.example.android_application.R;
import com.example.android_application.presentation.Home.OnBackPressedListener;
import com.example.android_application.presentation.ItemData;

import java.io.Serializable;
import java.util.ArrayList;

public class SearchResultFragment extends Fragment implements OnBackPressedListener, Serializable{

    private SearchContract.Presenter searchPresenter;
    private View view;
    private ImageButton back_button;
    private String top_title;
    private TextView textView;
    private RecyclerView recyclerView;
    private SearchAdapter search_adapter;
    private ArrayList<ItemData> list = new ArrayList<>();

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
        // ----------------------------------------------------------------------------------
        top_title = "검색 내용 기입";
        // ----------------------------------------------------------------------------------
        textView.setText(top_title);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(SearchFragment.newInstance());
            }
        });

        recyclerView.setHasFixedSize(true);
        search_adapter = new SearchAdapter(getActivity(), list);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        recyclerView.setAdapter(search_adapter);

        searchPresenter = new SearchPresenter(search_adapter);

        Bundle bundle = this.getArguments();
        System.out.println("type 값 : " + bundle.getString("type"));
        SearchData condition  = (SearchData) bundle.getSerializable("search_condition");

        ArrayList<String> date_ex = new ArrayList<String>();
        date_ex.add(condition.start_date);
        date_ex.add(condition.end_date);
        SearchParam search_param = new SearchParam(condition.content_type, condition.search_word, condition.sub_type, null); //date_ex);

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
