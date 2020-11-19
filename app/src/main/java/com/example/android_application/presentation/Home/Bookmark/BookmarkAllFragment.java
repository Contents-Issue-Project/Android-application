package com.example.android_application.presentation.Home.Bookmark;

import android.content.Context;
import android.media.Image;
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
import com.example.android_application.MainActivity;
import com.example.android_application.R;
import com.example.android_application.presentation.Home.Home_Fragment;
import com.example.android_application.presentation.Home.OnBackPressedListener;
import com.example.android_application.presentation.ItemData;

import java.util.ArrayList;

public class BookmarkAllFragment extends Fragment implements OnBackPressedListener {
    private BookmarkContract.Presenter bookmarkPresenter;

    private ImageButton back_button;
    private String top_title;
    private TextView textView;
    private RecyclerView recyclerView;
    private BookmarkAdapter bookmark_adapter;
    private ArrayList<ItemData> list = new ArrayList<>();

    public static BookmarkAllFragment newInstance() {
        return new BookmarkAllFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.frag4, container, false);

        back_button = (ImageButton) view.findViewById(R.id.back_button);
        recyclerView = (RecyclerView) view.findViewById(R.id.display_recycler);
        textView = (TextView) view.findViewById(R.id.top_title);

        top_title = "BookMark";
        textView.setText(top_title);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(Home_Fragment.newInstance());
            }
        });

        recyclerView.setHasFixedSize(true);
        bookmark_adapter = new BookmarkAdapter(getActivity(), list);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        recyclerView.setAdapter(bookmark_adapter);

        bookmarkPresenter = new BookmarkPresenter(bookmark_adapter);
        BookmarkParam bookmark_param = new BookmarkParam();
        bookmark_param.Authentication = "abcd";
        bookmark_param.result_number = 0;
        bookmarkPresenter.loadBookmark(bookmark_param);

        Log.e("Frag", "BookmarkFragment");
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