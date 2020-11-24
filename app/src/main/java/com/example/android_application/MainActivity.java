package com.example.android_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.android_application.presentation.Home.Bookmark.BookmarkLogoutFragment;
import com.example.android_application.presentation.Home.Bookmark.Bookmark_Fragment;
import com.example.android_application.presentation.Home.Home_Fragment;
import com.example.android_application.presentation.Home.OnBackPressedListener;
import com.example.android_application.presentation.Mypage.SignInFragment;
import com.example.android_application.presentation.Search.SearchFragment;
import com.example.android_application.presentation.Search.SearchResultFragment;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private OnBackPressedListener mBackListener;

    private BottomNavigationView bottomNavigationView; // 바텀 네비게이션 뷰
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Home_Fragment frag1;
    private SearchFragment frag2;
    private SignInFragment frag3;
    private Bookmark_Fragment frag4;
    private BookmarkLogoutFragment frag5;
    private SearchFragment searchFragment;
    private SearchResultFragment searchResultFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Marked.getInstance();
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
        frag2 = new SearchFragment();
        frag3 = new SignInFragment();
        frag4 = new Bookmark_Fragment();
        frag5 = new BookmarkLogoutFragment();

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
            case 3: // 로그아웃 상태일 때 화면 구별 필요

                GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
                if (account != null) {
                    ft.replace(R.id.main_frame, frag4);
                    ft.commit();
                } else {
                    ft.replace(R.id.main_frame, frag5);
                    ft.commit();
                }
        }

    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment).commit();      // Fragment로 사용할 MainActivity내의 layout공간을 선택
    }

    /*
    public void setResult(String str) {
        SearchResultFragment srf = (SearchResultFragment)getSupportFragmentManager()
                .findFragmentById(R.id.main_frame);
        srf.setResult(str);
    }
     */

    public void setOnBackPressedListener(OnBackPressedListener listener) {
        mBackListener = listener;
    }

    @Override
    public void onBackPressed() {
            mBackListener.onBack();
    }

}