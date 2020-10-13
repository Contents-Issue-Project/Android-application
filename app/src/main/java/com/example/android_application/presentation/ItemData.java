package com.example.android_application.presentation;

import java.util.ArrayList;

import retrofit2.http.Url;

public class ItemData {
    public int contentId;
    public boolean isSingle;
    public Url poster;
    public String title;
    public String release_date;
    public String type;
    public String genre;
    public String stat_1st;
    public String stat_2nd;

    public ItemData(String title, String release_date, String type, ArrayList<String> genre, String stat_1st, String stat_2nd) {
        // this.poster = poster;
        this.title = title;
        this.release_date = release_date;
        this.type = type;
        String temp_genre = "";
        for (String i : genre) {
            temp_genre = temp_genre.concat("#"+i+" ");
        }
        this.genre = temp_genre;
        this.stat_1st = stat_1st;
        this.stat_2nd = stat_2nd;
    }

    // 입력받은 숫자의 리스트 생성
    public static ArrayList<ItemData> createContactsList(int numContacts) {
        ArrayList<ItemData> contacts = new ArrayList<ItemData>();

        //example 용 코드
        ArrayList<String> example = new ArrayList<String>();
        example.add("장르1");
        example.add("장르2");
        for (int i = 1; i <= numContacts; i++) {
            contacts.add(new ItemData("컨텐츠 제목", " (방영 날짜)", "유형 /", example, "통계 1위,", " 2위 단어"));
        }
        return contacts;
    }
}