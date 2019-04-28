package com.example.otocapitalassignment.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.otocapitalassignment.view.fragments.FragmentDetails;
import com.example.otocapitalassignment.view.fragments.FragmentMovieList;
import com.example.otocapitalassignment.view.fragments.FragmentSpinner;
import com.example.otocapitalassignment.view.fragments.GalleryFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0)
        {
            fragment = new GalleryFragment();
        }
        else if (position == 1)
        {
            fragment = new FragmentSpinner();
        }
        else if (position == 2)
        {
            fragment = new FragmentMovieList();
        }

        else if(position==3)
        {
          fragment= new FragmentDetails();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0)
        {
            title = "Gallery";
        }
        else if (position == 1)
        {
            title = "Spinner";
        }
        else if (position == 2)
        {
            title = "MovieList";
        }
        else if (position==3)
        {
            title="Description";
        }
        return title;
    }
}