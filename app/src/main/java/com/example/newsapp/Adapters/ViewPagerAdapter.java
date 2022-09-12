package com.example.newsapp.Adapters;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.newsapp.TabFragments.EntertainmentFragment;
import com.example.newsapp.TabFragments.ForYouFragment;
import com.example.newsapp.TabFragments.HealthFragment;
import com.example.newsapp.TabFragments.ScienceFragment;
import com.example.newsapp.TabFragments.SportsFragment;
import com.example.newsapp.TabFragments.TechnologyFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    int tabcount;

    public ViewPagerAdapter( FragmentManager fm, int behavior) {
        super(fm, behavior);

        tabcount = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new ForYouFragment();
            case 1: return new SportsFragment();
            case 2: return new ScienceFragment();
            case 3: return new EntertainmentFragment();
            case 4: return new HealthFragment();
            case 5: return new TechnologyFragment();

            default: return null;
        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
