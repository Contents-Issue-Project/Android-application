package com.example.android_application.presentation;

import java.util.ArrayList;

import retrofit2.http.Url;

public class ItemData {
    public String contentId;
    public String title;
    public String release_date;
    public String type;
    public boolean isSingle;
    public String poster;
    //public String genre;
    public String top_word = "";

    public ItemData(String contentId, String title, String release_date, String type, boolean isSingle, String poster, String[] top_word) { //ArrayList<String> genre

        this.contentId = contentId;
        this.title = title;

        this.release_date = "  (".concat(release_date.substring(2).concat(")"));
        this.type = type;
        /*
        String temp_genre = "";
        for (String i : genre) {
            temp_genre = temp_genre.concat("#"+i+" ");
        }
        this.genre = temp_genre;
        */
        this.isSingle = isSingle;
        this.poster = "http://static.andang.net".concat(poster);

        // topword들을 하나의 String으로 합쳐주는 과정
        for(int i = 0; i< this.top_word.length(); i++){
            this.top_word = this.top_word.concat("#".concat(top_word[i]).concat(" "));
        }
    }

    // 입력받은 숫자의 리스트 생성
    public static ArrayList<ItemData> createContactsList(int numContacts) {
        ArrayList<ItemData> contacts = new ArrayList<ItemData>();

        //example 용 코드
        //example.add("장르1");
        //example.add("장르2");
        //ArrayList<String> example = new ArrayList<String>();

        String[] a = {"ㅋㅋㅋ", " 3시네"};
        for (int i = 1; i <= numContacts; i++) {
            contacts.add(new ItemData("id","컨텐츠 제목", " (방영 날짜)", "유형 /, ", true, "URL", a)); //example
        }
        return contacts;
    }
}