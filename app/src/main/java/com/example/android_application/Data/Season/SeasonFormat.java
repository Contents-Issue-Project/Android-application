package com.example.android_application.Data.Season;

import com.example.android_application.Data.Leaf.LeafFormat;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SeasonFormat {

    @SerializedName("content_id")
    public String content_id;
    @SerializedName("season_number")
    public int season_number;
    @SerializedName("episode_count")
    public int episode_count;
    @SerializedName("season_statistics")
    public ArrayList<SeasonFormat.Statistics_data> season_statistics;

    public class Statistics_data {
        @SerializedName("statistics_type")
        public String statistics_type;
        @SerializedName("statistics_name")
        public String statistics_name;
        @SerializedName("url")
        public String url;
    }

}
