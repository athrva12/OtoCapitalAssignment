package com.example.otocapitalassignment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.otocapitalassignment.Adapters.ViewPagerAdapter;
import com.example.otocapitalassignment.view.fragments.GalleryFragment;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;

    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }


}
