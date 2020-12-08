package com.example.android_application.presentation;

import com.example.android_application.Data.Leaf.LeafFormat;

import java.util.ArrayList;

public class LeafData {
    public String content_id;
    public int season_number;
    public int episode_number;
    public ArrayList<LeafFormat.Statistics_data> episode_statistics;

    public LeafData(String content_id, int season_number, int episode_number, ArrayList<LeafFormat.Statistics_data> episode_statistics) {
        this.content_id = content_id;
        this.season_number = season_number;
        this.episode_number = episode_number;
        this.episode_statistics = episode_statistics;
    }

}
