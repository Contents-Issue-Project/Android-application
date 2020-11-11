package com.example.android_application.presentation.Contents;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android_application.Data.Bookmark.BookmarkParam;
import com.example.android_application.Data.Contents.ContentsParam;
import com.example.android_application.R;
import com.example.android_application.presentation.ContentsData;
import com.example.android_application.presentation.Home.Bookmark.BookmarkAdapter;
import com.example.android_application.presentation.Home.Bookmark.BookmarkPresenter;

public class ContentsActivity extends AppCompatActivity {
    private ContentsContract.Presenter contentsPresenter;
    private ContentsAdapter contentsAdapter;
    private ContentsData contentsData;

    private ImageButton back_button;
    private ImageView poster;
    private ImageView isHot;
    private ImageView mood;
    private TextView title;
    private TextView season;
    private ImageView bookmark;
    private TextView date;
    private TextView director;
    private TextView casts;
    private ImageView statistics1;
    private ImageView statistics2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contents);

        Context mContext;
        mContext = getApplicationContext();

        back_button = (ImageButton)findViewById(R.id.content_backButton);
        poster = (ImageView)findViewById(R.id.poster_img);
        isHot = (ImageView)findViewById(R.id.isHot);
        mood = (ImageView)findViewById(R.id.mood_img);
        title = (TextView)findViewById(R.id.title_text);
        season = (TextView)findViewById(R.id.season_text);
        bookmark = (ImageView)findViewById(R.id.bookmark_img);
        date = (TextView)findViewById(R.id.date_text);
        director = (TextView)findViewById(R.id.director_text);
        casts = (TextView)findViewById(R.id.casts_text);
        statistics1 = (ImageView)findViewById(R.id.statistics1);
        statistics2 = (ImageView)findViewById(R.id.statistics2);

        System.out.println("111111");
        contentsAdapter = new ContentsAdapter(mContext, contentsData);
        System.out.println("222222");
        contentsPresenter = new ContentsPresenter(contentsAdapter);
        System.out.println("33333");
        ContentsParam contents_param = new ContentsParam();
        System.out.println("44444");
        contents_param.content_id = "a234";
        contentsPresenter.loadContents(contents_param);
        System.out.println("555555");

    }
}
