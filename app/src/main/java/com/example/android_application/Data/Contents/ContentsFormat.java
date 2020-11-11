package com.example.android_application.Data.Contents;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ContentsFormat {

    @SerializedName("content_id")
    public String content_id;
    @SerializedName("title_kr")
    public String title_kr;
    @SerializedName("title_en")
    public String title_en;
    @SerializedName("release_date")
    public String release_date;
    @SerializedName("content_type")
    public String content_type;
    @SerializedName("is_single")
    public Boolean is_single;
    @SerializedName("poster_url")
    public String poster_url;
    @SerializedName("top_words")
    public ArrayList<String> top_words;
    @SerializedName("sub_type")
    public ArrayList<String> sub_type;
    @SerializedName("is_hot")
    public Boolean is_hot;
    @SerializedName("single_statistics")
    public ArrayList<Statistics_data> single_statistics;
    @SerializedName("type_additional_data")
    public Additional_Data type_additional_data;
    @SerializedName("season_count")
    public int season_count;

    public class Statistics_data {

        @SerializedName("statistics_type")
        public String statistics_type;
        @SerializedName("statistics_name")
        public String statistics_name;
        @SerializedName("url")
        public String url;
    }
    public class Additional_Data {
        @SerializedName("casts")
        public ArrayList<String> casts;
        @SerializedName("director")
        public String director;
        @SerializedName("rating")
        public float rating;
    }

}
