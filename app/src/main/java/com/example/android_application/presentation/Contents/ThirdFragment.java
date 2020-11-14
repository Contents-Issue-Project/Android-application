package com.example.android_application.presentation.Contents;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.android_application.R;

import io.reactivex.annotations.NonNull;

public class ThirdFragment extends Fragment {
    ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.stat_img3, container, false);

        imageView = (ImageView) view.findViewById(R.id.statistics3);
        Glide.with(this)
                .load("http://static.andang.net/test/statistics/wordCloud.png")
                .placeholder(R.drawable.loading_img)
                .error(R.drawable.error_img)
                .into(imageView);

        return view;
    }
}