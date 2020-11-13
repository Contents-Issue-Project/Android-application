package com.example.android_application.presentation.Contents;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.android_application.Data.Bookmark.BookmarkParam;
import com.example.android_application.Data.Contents.ContentsFormat;
import com.example.android_application.Data.Contents.ContentsParam;
import com.example.android_application.R;
import com.example.android_application.presentation.ContentsData;
import com.example.android_application.presentation.Home.Bookmark.BookmarkAdapter;
import com.example.android_application.presentation.Home.Bookmark.BookmarkPresenter;
import com.example.android_application.util.DataUnavailableException;
import com.example.android_application.util.WrongRequestException;

import java.util.ArrayList;

public class ContentsActivity extends AppCompatActivity implements ContentsContract.View {
    private ContentsContract.Presenter contentsPresenter;
    //private ContentsAdapter contentsAdapter;
    private ContentsData contentsData;
    private Context context;
    private ImageView[] imageViews;

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

        context = getApplicationContext();
        Intent intent = getIntent();
        String contentId = intent.getExtras().getString("contentID");

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

        imageViews = new ImageView[]{statistics1, statistics2};

       //contentsAdapter = new ContentsAdapter(context, contentsData);
       //contentsPresenter = new ContentsPresenter(contentsAdapter);
        contentsPresenter = new ContentsPresenter(this);
        ContentsParam contents_param = new ContentsParam();
        contents_param.content_id = contentId;
        contentsPresenter.loadContents(contents_param);

    }

    @Override
    public void setUpContent(ContentsFormat contentsformat) {
        contentsData = new ContentsData(contentsformat.content_id, contentsformat.title_kr, contentsformat.title_en, contentsformat.release_date, contentsformat.content_type, contentsformat.is_single, contentsformat.poster_url, contentsformat.top_words, contentsformat.sub_type, contentsformat.is_hot, contentsformat.single_statistics, contentsformat.type_additional_data, contentsformat.season_count);
        System.out.println("content test : " + contentsformat.title_en + ", " + contentsformat.title_kr);

        setUp(contentsData);
    }

    @Override
    public void handleWrongRequest(WrongRequestException exception) {
        System.out.println("Wrong Request");
    }

    @Override
    public void handleDataUnavailable(DataUnavailableException exception) {
        System.out.println("Data unavailable");
    }


    public void setUp(ContentsData contentsData) {
        // poster 사진 가져오기
        Glide.with(context)
                .load(contentsData.poster_url)
                .placeholder(R.drawable.loading_img)
                .error(R.drawable.error_img)
                .into(poster);

        // Hot인 경우 포스터 왼쪽 상단에 Hot 표시하기
        if (contentsData.is_hot) {
            isHot.setImageResource(R.drawable.is_hot);
        } else {
            isHot.setVisibility(View.GONE);
        }

        // 제목, 시즌정보, 출시일
        title.setText(contentsData.title_kr);
        season.setText("시즌1 1화");
        date.setText(contentsData.release_date);

        // 감독, 등장인물
        ContentsFormat.Additional_Data additionalData = contentsData.type_additional_data;
        director.setText(additionalData.director);
        casts.setText(additionalData.casts.toString());

        // 통계 이미지
        ArrayList<ContentsFormat.Statistics_data> statisticsData = contentsData.single_statistics;
        String[] url = new String[statisticsData.size()];
        for (int i = 0; i < url.length; i++) {
            url[i] = "http://static.andang.net" + statisticsData.get(i).url;

            Glide.with(context)
                    .load(url[i])
                    .placeholder(R.drawable.loading_img)
                    .error(R.drawable.error_img)
                    .into(imageViews[i]);
        }


    }
}
