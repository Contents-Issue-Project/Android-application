package com.example.android_application.presentation;


import com.example.android_application.Data.Season.SeasonFormat;

import java.util.ArrayList;

public class SeasonData {

    public String content_id;
    public int season_number;
    public int episode_count;
    public ArrayList<SeasonFormat.Statistics_data> season_statistics;

    public SeasonData(String content_id, int season_number, int episode_count, ArrayList<SeasonFormat.Statistics_data> season_statistics) {
        this.content_id = content_id;
        this.season_number = season_number;
        this.episode_count = episode_count;
        this.season_statistics = season_statistics;
    }

}
