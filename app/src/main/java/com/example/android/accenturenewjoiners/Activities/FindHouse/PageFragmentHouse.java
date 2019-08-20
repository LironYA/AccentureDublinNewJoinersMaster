package com.example.android.accenturenewjoiners.Activities.FindHouse;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PageFragmentHouse extends FragmentPagerAdapter {
    private final int PAGE_COUNT = 3;
    private String tabs[] = new String[]{"Websites", "Facebook Groups", "Other Services"};
    private Context context;

    public PageFragmentHouse(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
        this.context = context;
    }
    @Override
    public int getCount () {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem (int position){
        if (position == 0) {
            return new HouseWebsitesFragments();
        }
        if (position == 1) {
            return new HouseWebsitesFragments();
        } else {
            return new HouseWebsitesFragments();
        }
    }

    @Override
    public CharSequence getPageTitle ( int position){
        // Generate title based on item position
        return tabs[position];

    }
}
