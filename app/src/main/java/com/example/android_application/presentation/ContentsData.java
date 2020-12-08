package com.example.android_application.presentation;

import com.example.android_application.Data.Contents.ContentsFormat;

import java.util.ArrayList;

public class ContentsData {
    public String content_id;
    public String title_kr;
    public String title_en;
    public String release_date;
    public String content_type;
    public boolean is_single;
    public String poster_url;
    public ArrayList<String> top_words;
    public ArrayList<String> sub_type;
    public Boolean is_hot;
    public ArrayList<ContentsFormat.Statistics_data> single_statistics;
    public ContentsFormat.Additional_Data type_additional_data;
    public int season_count;


    public ContentsData(String content_id, String title_kr, String title_en, String release_date, String content_type, boolean is_single, String poster_url, ArrayList<String> top_words, ArrayList<String> sub_type, Boolean is_hot, ArrayList<ContentsFormat.Statistics_data> single_statistics, ContentsFormat.Additional_Data type_additional_data, int season_count) {
        this.content_id = content_id;
        this.title_kr = title_kr;
        this.title_en = title_en;
        this.release_date = release_date;
        this.content_type = content_type;
        this.is_single = is_single;
        this.poster_url = "http://static.andang.net".concat(poster_url);
        this.top_words = top_words;
        this.sub_type = sub_type;
        this.is_hot = is_hot;
        this.single_statistics = single_statistics;
        this.type_additional_data = type_additional_data;
        this.season_count = season_count;
    }


}
