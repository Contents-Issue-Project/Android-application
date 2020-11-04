package com.example.android_application.Data.Search.SearchParam;

import java.util.ArrayList;

public class SearchParam {
    public String content_type;
    public String search_word;
    public ArrayList<String> sub_type;
    public Object date_range;
    // public Object additional;

    public SearchParam() {

    }

    public SearchParam(String content_type,String search_word, ArrayList<String> sub_type,Object date_range) {
        this.content_type = content_type;
        this.search_word = search_word;
        this.sub_type = sub_type;
        this.date_range = date_range;
    }
}
