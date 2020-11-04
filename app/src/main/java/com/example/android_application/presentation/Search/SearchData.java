package com.example.android_application.presentation.Search;

import java.util.ArrayList;

public class SearchData {
    public String content_type;
    public String search_word;
    public ArrayList<String> sub_type;
    public String start_date;
    public String end_date;

    public SearchData(String content_type, String search_word, ArrayList<String> genre, String start_date, String end_date) {
        this.content_type = content_type;
        this.search_word = search_word;
        this.sub_type = genre;
        this.start_date = start_date;
        this.end_date = end_date;
    }
}
