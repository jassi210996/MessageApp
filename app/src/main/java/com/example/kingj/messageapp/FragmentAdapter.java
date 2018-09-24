package com.example.kingj.messageapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.kingj.messageapp.Fragments.Home;
import com.example.kingj.messageapp.Fragments.Recent;
import com.example.kingj.messageapp.Fragments.Search;
import com.example.kingj.messageapp.Fragments.TopRated;

public class FragmentAdapter extends FragmentPagerAdapter {
    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        if(position==0)
        {
            return new Home();
        }
        else if(position==1)
        {
            return new Search();
        }
        else if(position==2)
        {
            return new Recent();
        }
        else if(position==3)
        {
            return new TopRated();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
