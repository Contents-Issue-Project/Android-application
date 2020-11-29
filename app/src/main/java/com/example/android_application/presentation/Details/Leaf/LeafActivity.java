package com.example.android_application.presentation.Details.Leaf;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.android_application.Data.Contents.ContentsFormat;
import com.example.android_application.Data.Contents.ContentsParam;
import com.example.android_application.Data.Leaf.LeafFormat;
import com.example.android_application.Data.Leaf.LeafParam;

import com.example.android_application.R;
import com.example.android_application.presentation.ContentsData;
import com.example.android_application.presentation.Details.Contents.ContentsContract;
import com.example.android_application.presentation.Details.Contents.ContentsPresenter;

import com.example.android_application.presentation.Details.MainPagerAdapter;

import com.example.android_application.presentation.Details.StatisticsFragment;
import com.example.android_application.presentation.LeafData;
import com.example.android_application.presentation.SeasonData;
import com.example.android_application.util.DataUnavailableException;
import com.example.android_application.util.WrongRequestException;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class LeafActivity extends AppCompatActivity implements LeafContract.View, ContentsContract.View{

    private ContentsContract.Presenter contentsPresenter;
    private LeafContract.Presenter leafPresenter;


    private ContentsData contentsData;
    private SeasonData seasonData;
    private LeafData leafData;

    private Context context;
    private ViewPager pager;
    private int pageSize;
    private CircleIndicator indicator;
    private int rating_round;

    private ImageButton back_button;
    private ImageView poster;
    private ImageView isHot;
    private TextView title;
    private TextView season;
    private ImageView bookmark;
    private ImageView rating;
    private TextView date;
    private TextView director;
    private TextView casts;
    private String casts_txt = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contents);

        context = getApplicationContext();

        Intent intent = getIntent();
        String contentId = intent.getExtras().getString("contentID");
        int season_number = intent.getExtras().getInt("season_number");
        int episode_number = intent.getExtras().getInt("episode_number");
        System.out.println("Leaf Activity : "+contentId+", "+episode_number);


        back_button = (ImageButton)findViewById(R.id.content_backButton);
        poster = (ImageView)findViewById(R.id.poster_img);
        isHot = (ImageView)findViewById(R.id.isHot);
        title = (TextView)findViewById(R.id.title_text);
        season = (TextView)findViewById(R.id.season_text);
        bookmark = (ImageView)findViewById(R.id.bookmark_img);
        rating = (ImageView)findViewById(R.id.rating_img);
        date = (TextView)findViewById(R.id.date_text);
        director = (TextView)findViewById(R.id.director_text);
        casts = (TextView)findViewById(R.id.casts_text);
        indicator = (CircleIndicator)findViewById(R.id.indicator);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // Content
        contentsPresenter = new ContentsPresenter(this);
        /* ContentsParam contents_param = new ContentsParam();
        contents_param.content_id = contentId;*/

        // Leaf
        leafPresenter = new LeafPresenter(this);
        LeafParam leaf_param = new LeafParam();
        leaf_param.content_id = contentId;
        leaf_param.season_number = season_number;
        leaf_param.episode_number = episode_number;

        //시즌 text 설정
        String seasonText = "시즌" + Integer.toString(season_number) + " " + Integer.toString(episode_number) + "화";
        season.setText(seasonText);

        System.out.println("contentId : " + contentId + ", 시즌 : " + season_number + ", 화 : " + episode_number);

        leafPresenter.loadLeaf(leaf_param);


    }


    @Override
    public void setUpContent(ContentsFormat contentsformat) {
        contentsData = new ContentsData(contentsformat.content_id, contentsformat.title_kr, contentsformat.title_en, contentsformat.release_date, contentsformat.content_type, contentsformat.is_single, contentsformat.poster_url, contentsformat.top_words, contentsformat.sub_type, contentsformat.is_hot, contentsformat.single_statistics, contentsformat.type_additional_data, contentsformat.season_count);
        rating_round = Math.round(contentsformat.type_additional_data.rating);
        setUp(contentsData);
    }

    @Override
    public void setUpContent(LeafFormat leafformat) {
        leafData = new LeafData(leafformat.content_id, leafformat.season_number, leafformat.episode_number, leafformat.episode_statistics);

        ContentsParam contents_param = new ContentsParam();
        contents_param.content_id = leafData.content_id;
        contentsPresenter.loadContents(contents_param);

        pageSetUp(leafData);

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
        date.setText(contentsData.release_date);

        // 감독, 등장인물
        ContentsFormat.Additional_Data additionalData = contentsData.type_additional_data;
        director.setText(additionalData.director);
        int i = 0;
        int size = additionalData.casts.size();
        while(i < size) {

            casts_txt += additionalData.casts.get(i);
            if(i == 2){
                break;
            }
            if( i < size -1) {
                casts_txt += ", ";
            }
            i++;
        }

        //casts.setText(additionalData.casts.toString());
        casts.setText(casts_txt);

        switch(rating_round) {
            case 0:
                rating.setImageResource(R.drawable.rating00);
                break;
            case 1:
                rating.setImageResource(R.drawable.rating01);
                break;
            case 2:
                rating.setImageResource(R.drawable.rating02);
                break;
            case 3:
                rating.setImageResource(R.drawable.rating03);
                break;
            case 4:
                rating.setImageResource(R.drawable.rating04);
                break;
            case 5:
                rating.setImageResource(R.drawable.rating05);
                break;
            case 6:
                rating.setImageResource(R.drawable.rating06);
                break;
            case 7:
                rating.setImageResource(R.drawable.rating07);
                break;
            case 8:
                rating.setImageResource(R.drawable.rating08);
                break;
            case 9:
                rating.setImageResource(R.drawable.rating09);
                break;
            case 10:
                rating.setImageResource(R.drawable.rating10);
                break;
        }
    }


    // Leaf 일 경우의 pageSetup
    public void pageSetUp(LeafData leafData) {
        ArrayList<LeafFormat.Statistics_data> statisticsData = leafData.episode_statistics;
        pageSize = statisticsData.size();
        String[] url = new String[statisticsData.size()];
        String[] statistics_name = new String[statisticsData.size()];

        for (int i = 0; i < url.length; i++) {
            url[i] = "http://static.andang.net" + statisticsData.get(i).url;
            statistics_name[i] = statisticsData.get(i).statistics_name;
        }

        pager = findViewById(R.id.pager);
        pager.setOffscreenPageLimit(pageSize);

        MainPagerAdapter adapter = new MainPagerAdapter(getSupportFragmentManager(), 1);

        if (url.length >= 1) {
            StatisticsFragment statisticsFragment1 = new StatisticsFragment(url[0],"< " + statistics_name[0] + " >");
            adapter.addItem(statisticsFragment1);
        }
        if (url.length>=2) {
            StatisticsFragment statisticsFragment2 = new StatisticsFragment(url[1], "< " + statistics_name[1] + " >");
            adapter.addItem(statisticsFragment2);
        }
        if (url.length>=3) {
            StatisticsFragment statisticsFragment3 = new StatisticsFragment(url[2], "< " + statistics_name[2] + " >");
            adapter.addItem(statisticsFragment3);
        }
        pager.setAdapter(adapter);
        indicator.setViewPager(pager);
    }
}