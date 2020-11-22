package com.example.android_application;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Marked{
    private Marked(){}

    private static Marked instance = new Marked();
    public ArrayList<String> marked_content_id;


    public static synchronized Marked getInstance(){ return instance; }

    public ArrayList<String> getData() {return instance.marked_content_id;}
    public void setData(ArrayList marked_content_id) {instance.marked_content_id = marked_content_id;}
    public void emptyData() {
        ArrayList<String> empty = new ArrayList<String>();
        empty.add("Empty");
        instance.marked_content_id = empty;
    }


}
