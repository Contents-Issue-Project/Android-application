package com.example.android_application.Data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataFormat {
    @SerializedName("results")
    public List<Item> data = null;

    public class Item {
        @SerializedName("content_id")
        public String contentId;
        @SerializedName("title_kr")
        public String title_kr;
        @SerializedName("title_en")
        public String title_en;
        @SerializedName("release_date")
        public String date;
        @SerializedName("content_type")
        public String type;
        @SerializedName("is_single")
        public boolean is_single;
        @SerializedName("poster_url")
        public String poster;
        @SerializedName("top_words")
        public String[] top_word;
    }
}
