package com.example.android_application.presentation.trending.Fragment.Home;

import java.util.ArrayList;

import retrofit2.http.Url;

public class ItemData {
    // public Url poster;
    public String title;
    public String release_date;
    public String type;
    public String genre;
    public String statistics;

    // 화면에 표시될 문자열 초기화
    public ItemData(String title, String release_date, String type, String genre, String statistics) {
        // this.poster = poster;
        this.title = title;
        this.release_date = release_date;
        this.type = type;
        this.genre = genre;
        this.statistics = statistics;
    }

    // 입력받은 숫자의 리스트 생성
    public static ArrayList<ItemData> createContactsList(int numContacts) {
        ArrayList<ItemData> contacts = new ArrayList<ItemData>();

        for (int i=1; i<=numContacts ; i++) {
            contacts.add(new ItemData("컨텐츠 제목", " (방영 날짜)", "유형 /", " 장르1, 장르2", "통계 1위, 2위 단어"));
        }
        return contacts;
    }
}