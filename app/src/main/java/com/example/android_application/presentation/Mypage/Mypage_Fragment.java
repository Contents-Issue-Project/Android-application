package com.example.android_application.presentation.Mypage;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.android_application.MainActivity;
import com.example.android_application.R;
import com.example.android_application.presentation.Home.OnBackPressedListener;

public class Mypage_Fragment extends Fragment implements OnBackPressedListener {

    private View view;

    public static Mypage_Fragment newInstance() {
        return new Mypage_Fragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag3, container, false);

        return view;
    }

    @Override
    public void onBack() {
        ((MainActivity)getActivity()).finish();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ((MainActivity)context).setOnBackPressedListener(this);
    }
}