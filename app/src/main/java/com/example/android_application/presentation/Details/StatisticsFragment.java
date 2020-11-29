package com.example.android_application.presentation.Details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.android_application.R;

import io.reactivex.annotations.NonNull;

public class StatisticsFragment extends Fragment {
    ImageView imageView;
    TextView textView;

    String url;
    String stat_name;

    public StatisticsFragment(String url, String stat_name) {
        this.url = url;
        this.stat_name = stat_name;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.stat_img1, container, false);

        imageView = (ImageView) view.findViewById(R.id.statistics);
        textView = (TextView) view.findViewById(R.id.stat_name);

        Glide.with(this)
                .load(url)
                .placeholder(R.drawable.loading_img)
                .error(R.drawable.error_img)
                .into(imageView);
        textView.setText(stat_name);
        return view;
    }
}
