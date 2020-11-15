package com.example.android_application.presentation.Details.Leaf;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android_application.R;

public class LeafActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contents);

        Intent intent = getIntent();
        String contentId = intent.getExtras().getString("contentID");
        int season_number = intent.getExtras().getInt("season_number");
        int episode_number = intent.getExtras().getInt("episode_number");
        System.out.println("Leaf Activity : "+contentId+", "+episode_number);
    }
}
