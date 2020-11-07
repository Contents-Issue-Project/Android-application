package com.example.android_application.presentation.Search;


import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
<<<<<<< HEAD
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
=======
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
>>>>>>> e590bb74802fa162c1a360c0469315e7dee7d196

import com.example.android_application.Data.Search.SearchParam.SearchParam;
import com.example.android_application.MainActivity;
import com.example.android_application.R;
import com.example.android_application.presentation.Home.OnBackPressedListener;
import com.example.android_application.presentation.Home.Trending.TrendingAllFragment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchFragment extends Fragment implements OnBackPressedListener, Serializable{

    private View view;

    private EditText search;
    private Button searchButton;
    private String search_word;
    private String type = "all";
    private ArrayList<String> genre= new ArrayList<String>();
    private String start_date = "0000-00-00";
    private String end_date = "0000-00-00";

    private Button type_movie;
    private Button type_drama;
    private Button genre_action;
    private Button genre_comedy;
    private Button genre_fantasy;
    private Button genre_animation;
    private Button genre_adventure;
    private Button genre_drama;
    private Button genre_crime;
    private Button genre_war;
    private Button genre_family;
    private Button genre_mystery;
    private Button genre_documentary;
    private Button genre_science;
    private Button genre_western;
    private LinearLayout movie_option1;
    private LinearLayout movie_option2;
    private Button genre_history;
    private Button genre_horror;
    private Button genre_music;
    private Button genre_romance;
    private Button genre_thriller;
    private Button genre_tv;

    private Boolean[] clicked = new Boolean[19];
    private Boolean type_movie_clicked=false;
    private Boolean type_drama_clicked=false;

    private Spinner start_year;
    private Spinner end_year;
    private Spinner start_month;
    private Spinner end_month;
    private String startYearString="0000";
    private int startPosition;
    private String startMonthString="00";
    private String endYearString="0000";
    private int endPosition;
    private String endMonthString="00";
    private int endMonthInt;


    void genre_click (Button genre_button,  int num, String temp_genre) {
        genre_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clicked[num]) {
                    genre_button.getBackground().setColorFilter(ContextCompat.getColor(getActivity(),R.color.buttonUnClicked),
                            PorterDuff.Mode.SRC_ATOP);
                    clicked[num] =false;
                    genre.remove(temp_genre);
                } else {
                    genre_button.getBackground().setColorFilter(ContextCompat.getColor(getActivity(), R.color.buttonClicked),
                            PorterDuff.Mode.SRC_ATOP);
                    clicked[num]=true;
                    genre.add(temp_genre);
                }
            }
        });
    }

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag2, container, false);

        search = (EditText) view.findViewById(R.id.searchView);
        searchButton = (Button) view.findViewById(R.id.searchButton);
        type_movie = (Button) view.findViewById(R.id.type_movie_button);
        type_drama = (Button) view.findViewById(R.id.type_drama_button);
        genre_action = (Button) view.findViewById(R.id.genre_action_button);
        genre_comedy = (Button) view.findViewById(R.id.genre_comedy_button);
        genre_fantasy = (Button) view.findViewById(R.id.genre_fantasy_button);
        genre_animation= (Button) view.findViewById(R.id.genre_animation_button);
        genre_adventure = (Button) view.findViewById(R.id.genre_adventure_button);
        genre_drama = (Button) view.findViewById(R.id.genre_drama_button);
        genre_crime = (Button) view.findViewById(R.id.genre_crime_button);
        genre_war = (Button) view.findViewById(R.id.genre_war_button);
        genre_family = (Button) view.findViewById(R.id.genre_family_button);
        genre_mystery = (Button) view.findViewById(R.id.genre_mystery_button);
        genre_documentary = (Button) view.findViewById(R.id.genre_documentary_button);
        genre_science = (Button) view.findViewById(R.id.genre_science_button);
        genre_western = (Button) view.findViewById(R.id.genre_western_button);
        genre_history = (Button) view.findViewById(R.id.genre_history_button);
        genre_horror = (Button) view.findViewById(R.id.genre_horror_button);
        genre_music = (Button) view.findViewById(R.id.genre_music_button);
        genre_romance = (Button) view.findViewById(R.id.genre_romance_button);
        genre_thriller = (Button) view.findViewById(R.id.genre_thriller_button);
        genre_tv = (Button) view.findViewById(R.id.genre_tv_button);
        movie_option1 = (LinearLayout) view.findViewById(R.id.movie_option1);
        movie_option2 = (LinearLayout) view.findViewById(R.id.movie_option2);
        start_year = (Spinner) view.findViewById(R.id.start_year);
        start_month = (Spinner) view.findViewById(R.id.start_month);
        end_year = (Spinner) view.findViewById(R.id.end_year);
        end_month = (Spinner) view.findViewById(R.id.end_month);

        Arrays.fill(clicked, false);

        search.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                switch(actionId) {
                    case EditorInfo.IME_ACTION_SEARCH:
                        searchButton.callOnClick();
                }
                return false;
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search_word = search.getText().toString();
                if (type != "movie") {
                    genre.remove("history");
                    genre.remove("horror");
                    genre.remove("music");
                    genre.remove("romance");
                    genre.remove("thriller");
                    genre.remove("tv");
                    genre_history.getBackground().setColorFilter(ContextCompat.getColor(getActivity(), R.color.buttonUnClicked),
                            PorterDuff.Mode.SRC_ATOP);
                    genre_horror.getBackground().setColorFilter(ContextCompat.getColor(getActivity(), R.color.buttonUnClicked),
                            PorterDuff.Mode.SRC_ATOP);
                    genre_music.getBackground().setColorFilter(ContextCompat.getColor(getActivity(), R.color.buttonUnClicked),
                            PorterDuff.Mode.SRC_ATOP);
                    genre_romance.getBackground().setColorFilter(ContextCompat.getColor(getActivity(), R.color.buttonUnClicked),
                            PorterDuff.Mode.SRC_ATOP);
                    genre_thriller.getBackground().setColorFilter(ContextCompat.getColor(getActivity(), R.color.buttonUnClicked),
                            PorterDuff.Mode.SRC_ATOP);
                    genre_tv.getBackground().setColorFilter(ContextCompat.getColor(getActivity(), R.color.buttonUnClicked),
                            PorterDuff.Mode.SRC_ATOP);
                    for (int i = 13; i <= 18; i++) {
                        clicked[i] = false;
                    }
                }
                if (startYearString.equals("00")) {
                    start_date = null;
                } else if (startMonthString.equals("00")) {
                    start_date = start_date +"-01-01";
                } else {
                    start_date = startYearString+"-"+startMonthString+"-01";
                }
                if (endYearString.equals("00")) {
                    end_date = null;
                } else {
                    switch (endMonthInt) {
                        case 0:
                            end_date = endYearString + "-12-31";
                            break;
                        case 2:
                            end_date = endYearString + "-" + endMonthString + "-28";
                            break;
                        case 4:
                        case 6:
                        case 9:
                        case 11:
                            end_date = endYearString + "-" + endMonthString + "-30";
                            break;
                        case 1:
                        case 3:
                        case 5:
                        case 7:
                        case 8:
                        case 10:
                        case 12:
                            end_date = endYearString + "-" + endMonthString + "-31";
                            break;
                    }
                }
                ArrayList<String> date_range = new ArrayList<String> ();
                date_range.add(start_date);
                date_range.add(end_date);
<<<<<<< HEAD

                Bundle bundle = new Bundle(5);

                SearchData search_condition = new SearchData(type, search_word, genre, start_date, end_date);
                bundle.putSerializable("search_condition", search_condition);

                bundle.putString("type", type);

                SearchResultFragment fragment = new SearchResultFragment();
                fragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.main_frame, fragment).commit();
                //((MainActivity)getActivity()).replaceFragment(SearchResultFragment.newInstance());
=======
                SearchParam searchParam = new SearchParam(type, search_word, genre, date_range );

                SearchResultFragment fragment = new SearchResultFragment();
                Bundle bundle = new Bundle();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                bundle.putString("type", type);
                bundle.putString("searchWord", search_word);
                //bundle.putSerializable("genre", genre);
                bundle.putString("startDate", start_date);
                bundle.putString("endDate", end_date);
                fragment.setArguments(bundle);
                transaction.replace(R.id.main_frame, fragment);
                transaction.commit();
>>>>>>> e590bb74802fa162c1a360c0469315e7dee7d196
            }
        });

        type_movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (type_movie_clicked) {
                    type_movie.getBackground().setColorFilter(ContextCompat.getColor(getActivity(), R.color.buttonUnClicked),
                            PorterDuff.Mode.SRC_ATOP);
                    type="all";
                    type_movie_clicked = false;
                    movie_option1.setVisibility(View.INVISIBLE);
                    movie_option2.setVisibility(View.GONE);
                } else {
                    type = "movie";
                    type_movie.getBackground().setColorFilter(ContextCompat.getColor(getActivity(), R.color.buttonClicked),
                            PorterDuff.Mode.SRC_ATOP);
                    type_movie_clicked=true;
                    movie_option1.setVisibility(View.VISIBLE);
                    movie_option2.setVisibility(View.VISIBLE);
                }
                if (type_drama_clicked) {
                    type_drama.getBackground().setColorFilter(ContextCompat.getColor(getActivity(), R.color.buttonUnClicked),
                            PorterDuff.Mode.SRC_ATOP);
                    type_drama_clicked = false;
                }
            }
        });

        type_drama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (type_drama_clicked) {
                    type_drama.getBackground().setColorFilter(ContextCompat.getColor(getActivity(), R.color.buttonUnClicked),
                            PorterDuff.Mode.SRC_ATOP);
                    type="all";
                    type_drama_clicked = false;
                } else {
                    type = "drama";
                    type_drama.getBackground().setColorFilter(ContextCompat.getColor(getActivity(), R.color.buttonClicked),
                            PorterDuff.Mode.SRC_ATOP);
                    type_drama_clicked=true;
                }
                if (type_movie_clicked) {
                    type_movie.getBackground().setColorFilter(ContextCompat.getColor(getActivity(), R.color.buttonUnClicked),
                            PorterDuff.Mode.SRC_ATOP);
                    type_movie_clicked = false;
                    movie_option1.setVisibility(View.INVISIBLE);
                    movie_option2.setVisibility(View.GONE);
                }
            }
        });

        genre_click(genre_action, 0, "action");
        genre_click(genre_comedy, 1, "comedy");
        genre_click(genre_fantasy, 2, "fantasy");
        genre_click(genre_animation, 3, "animation");
        genre_click(genre_adventure, 4, "adventure");
        genre_click(genre_drama, 5,"drama");
        genre_click(genre_crime, 6, "crime");
        genre_click(genre_war, 7, "war");
        genre_click(genre_family, 8, "family");
        genre_click(genre_mystery, 9, "mystery");
        genre_click(genre_documentary, 10, "documentary");
        genre_click(genre_science, 11, "sci-fi");
        genre_click(genre_western, 12, "western");
        genre_click(genre_history, 13, "history");
        genre_click(genre_horror, 14, "horror");
        genre_click(genre_music, 15, "music");
        genre_click(genre_romance, 16, "romance");
        genre_click(genre_thriller, 17, "thriller");
        genre_click(genre_tv, 18, "tv");


        start_year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    startYearString = (String)parent.getItemAtPosition(position);
                } else {
                    startYearString = "0000";
                    start_month.setSelection(0);
                    startMonthString="00";
                }
                startPosition = position;
                if (endPosition<position) {
                    end_year.setSelection(0);
                    end_month.setSelection(0);
                    endYearString = "0000";
                    endMonthString = "00";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        start_month.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (startYearString.equals("0000")) {
                    start_month.setSelection(0);
                    startMonthString = "00";
                } else {
                    if (position != 0) {
                        startMonthString = (String)parent.getItemAtPosition(position);
                    } else {
                        startMonthString = "00";
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        end_year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position < startPosition) {
                    Toast.makeText(getActivity(), "시작년도가 더 빨라야 합니다.", Toast.LENGTH_SHORT).show();
                    end_year.setSelection(0);
                    endYearString = "0000";
                } else {
                    endYearString = (String)parent.getItemAtPosition(position);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        end_month.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (endYearString.equals("0000")) {
                    end_month.setSelection(0);
                    endMonthString = "00";
                } else {
                    if (position != 0) {
                        endMonthString = (String)parent.getItemAtPosition(position);
                    } else {
                        endMonthString = "00";
                    }
                }
                endMonthInt = Integer.parseInt(endMonthString);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

    @Override
    public void onBack() {
        ((MainActivity)getActivity()).finish();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ((MainActivity)context).setOnBackPressedListener(this);
    }
}