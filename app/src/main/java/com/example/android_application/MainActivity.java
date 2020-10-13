package com.example.android_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.android_application.presentation.Fragment.Bookmark_Fragment;
import com.example.android_application.presentation.Fragment.Home_Fragment;
import com.example.android_application.presentation.Fragment.Mypage_Fragment;
import com.example.android_application.presentation.Fragment.Search_Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView; // 바텀 네비게이션 뷰
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Home_Fragment frag1;
    private Search_Fragment frag2;
    private Mypage_Fragment frag3;
    private Bookmark_Fragment frag4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()) {
                    case R.id.menu1:
                        setFrag(0);
                        break;
                    case R.id.menu2:
                        setFrag(1);
                        break;
                    case R.id.menu3:
                        setFrag(2);
                        break;
                    case R.id.menu4:
                        setFrag(3);
                        break;
                }
                return true;
            }
        });
        frag1 = new Home_Fragment();
        frag2 = new Search_Fragment();
        frag3 = new Mypage_Fragment();
        frag4 = new Bookmark_Fragment();

        setFrag(0); // 첫 프래그먼트 화면 지정
    }

    // 프래그먼트 교체가 일어나는 실행문.
    private void setFrag(int n) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch(n) {
            case 0:
                ft.replace(R.id.main_frame, frag1);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.main_frame, frag2);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.main_frame, frag3);
                ft.commit();
                break;
            case 3:
                ft.replace(R.id.main_frame, frag4);
                ft.commit();
                break;
        }

    }

}