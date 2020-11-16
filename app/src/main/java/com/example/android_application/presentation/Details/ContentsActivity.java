package com.example.android_application.presentation.Details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.android_application.Data.Contents.ContentsFormat;
import com.example.android_application.Data.Contents.ContentsParam;
import com.example.android_application.Data.Leaf.LeafFormat;
import com.example.android_application.Data.Leaf.LeafParam;
import com.example.android_application.Data.Season.SeasonFormat;
import com.example.android_application.Data.Season.SeasonParam;
import com.example.android_application.R;
import com.example.android_application.presentation.ContentsData;
import com.example.android_application.presentation.Details.Contents.ContentsContract;
import com.example.android_application.presentation.Details.Contents.ContentsPresenter;
import com.example.android_application.presentation.Details.Leaf.LeafActivity;
import com.example.android_application.presentation.Details.Leaf.LeafContract;
import com.example.android_application.presentation.Details.Leaf.LeafPresenter;
import com.example.android_application.presentation.Details.Season.SeasonContract;
import com.example.android_application.presentation.Details.Season.SeasonPresenter;
import com.example.android_application.presentation.LeafData;
import com.example.android_application.presentation.SeasonData;
import com.example.android_application.util.DataUnavailableException;
import com.example.android_application.util.WrongRequestException;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class ContentsActivity extends FragmentActivity implements ContentsContract.View, SeasonContract.View {
    private ContentsContract.Presenter contentsPresenter;
    private SeasonContract.Presenter seasonPresenter;
    private LeafContract.Presenter leafPresenter;

    FragmentPagerAdapter adapterViewPager;
    private ContentsData contentsData;
    private SeasonData seasonData;
    private LeafData leafData;

    private Context context;
    private ViewPager pager;
    private int pageSize;
    private int spinner_position = 1;
    private Spinner spinner;
    List<String> spinnerArray = new ArrayList<String>();
    private CircleIndicator indicator;

    private ImageButton back_button;
    private ImageView poster;
    private ImageView isHot;
    private TextView title;
    private TextView season;
    private ImageView bookmark;
    private TextView date;
    private TextView director;
    private TextView casts;

    Button[] episode;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contents);

        context = getApplicationContext();
        Intent intent = getIntent();
        String contentId = intent.getExtras().getString("contentID");

        episode = new Button[]{(Button) findViewById(R.id.episode1)
                , (Button) findViewById(R.id.episode2), (Button) findViewById(R.id.episode3)
                , (Button) findViewById(R.id.episode4), (Button) findViewById(R.id.episode5)
                , (Button) findViewById(R.id.episode6), (Button) findViewById(R.id.episode7)
                , (Button) findViewById(R.id.episode8), (Button) findViewById(R.id.episode9)
                , (Button) findViewById(R.id.episode10), (Button) findViewById(R.id.episode11)
                , (Button) findViewById(R.id.episode12), (Button) findViewById(R.id.episode13)
                , (Button) findViewById(R.id.episode14), (Button) findViewById(R.id.episode15)
                , (Button) findViewById(R.id.episode16) };

        back_button = (ImageButton)findViewById(R.id.content_backButton);
        poster = (ImageView)findViewById(R.id.poster_img);
        isHot = (ImageView)findViewById(R.id.isHot);
        title = (TextView)findViewById(R.id.title_text);
        season = (TextView)findViewById(R.id.season_text);
        bookmark = (ImageView)findViewById(R.id.bookmark_img);
        date = (TextView)findViewById(R.id.date_text);
        director = (TextView)findViewById(R.id.director_text);
        casts = (TextView)findViewById(R.id.casts_text);
        spinner = (Spinner)findViewById(R.id.season_spinner);
        indicator = (CircleIndicator)findViewById(R.id.indicator);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        for(int i = 0; i<16; i++) {
            episode_click(episode[i], contentId, i+1);
        }

        // Content
        contentsPresenter = new ContentsPresenter(this);
        ContentsParam contents_param = new ContentsParam();
        contents_param.content_id = contentId;

        // Season
        seasonPresenter = new SeasonPresenter(this);
        SeasonParam season_param = new SeasonParam();
        season_param.content_id = contentId;
        season_param.season_number = 1;

        contentsPresenter.loadContents(contents_param);
    }

    public void episode_click(Button episode, String contentId, int episode_number){
        episode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContentsActivity.this, LeafActivity.class);
                intent.putExtra("contentID", contentId);
                intent.putExtra("season_number", spinner_position);
                intent.putExtra("episode_number", episode_number);
                startActivity(intent);
            }
        });
    }

    @Override
    public void setUpContent(ContentsFormat contentsformat) {
        contentsData = new ContentsData(contentsformat.content_id, contentsformat.title_kr, contentsformat.title_en, contentsformat.release_date, contentsformat.content_type, contentsformat.is_single, contentsformat.poster_url, contentsformat.top_words, contentsformat.sub_type, contentsformat.is_hot, contentsformat.single_statistics, contentsformat.type_additional_data, contentsformat.season_count);
        if(contentsData.is_single == false){
            SeasonParam season_param = new SeasonParam();
            season_param.content_id = contentsData.content_id;
            season_param.season_number = 1;
            seasonPresenter.loadSeason(season_param);
        }

        setUp(contentsData);
        if(contentsData.is_single == true) {
            pageSetUp(contentsData);
        }
    }

    @Override
    public void setUpContent(SeasonFormat seasonformat) {
        seasonData = new SeasonData(seasonformat.content_id, seasonformat.season_number, seasonformat.episode_count, seasonformat.season_statistics);
        setUp(seasonData);
        pageSetUp(seasonData);
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
        if(!contentsData.is_single) {
            spinner.setVisibility(View.VISIBLE);
            season.setText("시즌1");

            for(int i=0 ; i<contentsData.season_count ; i++) {
                String seasonString = "시즌"+Integer.toString(i+1);
                spinnerArray.add(seasonString);
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    this, android.R.layout.simple_spinner_item, spinnerArray);

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    spinner_position = position+1;
                    SeasonParam season_param = new SeasonParam();
                    season_param.content_id = contentsData.content_id;
                    season_param.season_number = spinner_position;
                    seasonPresenter.loadSeason(season_param);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        } else {
            season.setVisibility(View.GONE);
        }
        date.setText(contentsData.release_date);

        // 감독, 등장인물
        ContentsFormat.Additional_Data additionalData = contentsData.type_additional_data;
        director.setText(additionalData.director);
        casts.setText(additionalData.casts.toString());
    }

    public void setUp(SeasonData seasonData) {
        int div = seasonData.episode_count / 4;
        int pos = seasonData.episode_count % 4;
        for(int i = 0; i<seasonData.episode_count; i++){
            episode[i].setVisibility(View.VISIBLE);
        }
        for(int i = seasonData.episode_count; i< (div+1)*4; i++) {
            episode[i].setVisibility(View.INVISIBLE);
        }
        for(int i = (div+1) * 4; i < 16; i++) {
            episode[i].setVisibility(View.GONE);
        }



    }

    // 단일 content일 때의 pageSetup
    public void pageSetUp(ContentsData contentsData) {
        ArrayList<ContentsFormat.Statistics_data> statisticsData = contentsData.single_statistics;
        pageSize = statisticsData.size();
        String[] url = new String[statisticsData.size()];
        for (int i = 0; i < url.length; i++) {
            url[i] = "http://static.andang.net" + statisticsData.get(i).url;
        }

        pager = findViewById(R.id.pager);
        pager.setOffscreenPageLimit(pageSize);

        MainPagerAdapter adapter = new MainPagerAdapter(getSupportFragmentManager(), 1);

        if (url.length >= 1) {
            StatisticsFragment statisticsFragment1 = new StatisticsFragment(url[0]);
            adapter.addItem(statisticsFragment1);
        }
        if (url.length>=2) {
            StatisticsFragment statisticsFragment2 = new StatisticsFragment(url[1]);
            adapter.addItem(statisticsFragment2);
        }
        if (url.length>=3) {
            StatisticsFragment statisticsFragment3 = new StatisticsFragment(url[2]);
            adapter.addItem(statisticsFragment3);
        }
        pager.setAdapter(adapter);
        indicator.setViewPager(pager);
    }

    // Season 일 경우의 pageSetup
    public void pageSetUp(SeasonData seasonData) {
        ArrayList<SeasonFormat.Statistics_data> statisticsData = seasonData.season_statistics;
        pageSize = statisticsData.size();
        String[] url = new String[statisticsData.size()];
        for (int i = 0; i < url.length; i++) {
            url[i] = "http://static.andang.net" + statisticsData.get(i).url;
        }

        pager = findViewById(R.id.pager);
        pager.setOffscreenPageLimit(pageSize);

        MainPagerAdapter adapter = new MainPagerAdapter(getSupportFragmentManager(), 1);

        if (url.length >= 1) {
            StatisticsFragment statisticsFragment1 = new StatisticsFragment(url[0]);
            adapter.addItem(statisticsFragment1);
        }
        if (url.length>=2) {
            StatisticsFragment statisticsFragment2 = new StatisticsFragment(url[1]);
            adapter.addItem(statisticsFragment2);
        }
        if (url.length>=3) {
            StatisticsFragment statisticsFragment3 = new StatisticsFragment(url[2]);
            adapter.addItem(statisticsFragment3);
        }
        pager.setAdapter(adapter);
        indicator.setViewPager(pager);
    }
}
