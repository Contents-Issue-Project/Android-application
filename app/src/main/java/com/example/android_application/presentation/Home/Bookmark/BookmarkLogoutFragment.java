package com.example.android_application.presentation.Home.Bookmark;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_application.MainActivity;
import com.example.android_application.R;
import com.example.android_application.presentation.Home.OnBackPressedListener;
import com.example.android_application.presentation.ItemData;
import com.example.android_application.presentation.Mypage.SignInFragment;

import java.util.ArrayList;

public class BookmarkLogoutFragment extends Fragment implements OnBackPressedListener {
    private TextView top_title;
    private Button login_button;

    public static BookmarkLogoutFragment newInstance() {
        return new BookmarkLogoutFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.logout, container, false);

        top_title = (TextView) view.findViewById(R.id.top_title);
        login_button = (Button) view.findViewById(R.id.login_button);

        top_title.setText("# BookMark");

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(SignInFragment.newInstance());
            }
        });


        return view;
    }

    @Override
    public void onBack() {
        ((MainActivity)getActivity()).finish();
    }
}
