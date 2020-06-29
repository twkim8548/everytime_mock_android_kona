package com.softsquared.template.src.main;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.softsquared.template.R;
import com.softsquared.template.src.BaseActivity;
import com.softsquared.template.src.main.alarm.AlarmFragment;
import com.softsquared.template.src.main.campuspick.CampuspickFragment;
import com.softsquared.template.src.main.community.CommunityFragment;
import com.softsquared.template.src.main.home.HomeFragment;
import com.softsquared.template.src.main.interfaces.MainActivityView;
import com.softsquared.template.src.main.timetable.TimetableFragment;

public class MainActivity extends BaseActivity implements MainActivityView {

    BottomNavigationView bottomNavigationView;
    FragmentManager fragmentManager =getSupportFragmentManager();
    HomeFragment homeFragment;
    CommunityFragment communityFragment;
    TimetableFragment timetableFragment;
    CampuspickFragment campuspickFragment;
    AlarmFragment alarmFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomNavigationView();


    }

    public void mBottomNavigationView()
    {
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        homeFragment = new HomeFragment();
        communityFragment = new CommunityFragment();
        timetableFragment = new TimetableFragment();
        campuspickFragment = new CampuspickFragment();
        alarmFragment = new AlarmFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.main_frameLayout, homeFragment).commitAllowingStateLoss();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.bottom_navi_home:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frameLayout, homeFragment).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.bottom_navi_community:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frameLayout, communityFragment).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.bottom_navi_timetable:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frameLayout, timetableFragment).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.bottom_navi_alarm:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frameLayout, alarmFragment).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.bottom_navi_campuspick:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frameLayout, campuspickFragment).commitAllowingStateLoss();
                        break;
                    }

                }
                return true;
            }
        });
    }


    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }
}
