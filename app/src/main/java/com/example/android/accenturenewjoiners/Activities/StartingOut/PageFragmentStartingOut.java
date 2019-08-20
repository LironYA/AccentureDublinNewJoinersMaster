package com.example.android.accenturenewjoiners.Activities.StartingOut;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PageFragmentStartingOut extends FragmentPagerAdapter {
    private final int PAGE_COUNT = 3;
    private String tabs[] = new String[]{"General", "Dublin's Map", "Top Tips"};
    private Context context;

    public PageFragmentStartingOut(FragmentManager fragmentManager, Context context) {
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
            return new GeneralFragment();
        }
        if (position == 1) {
            return new GeneralFragment();
        }
         else {
            return new GeneralFragment();
        }
    }

    @Override
    public CharSequence getPageTitle (int position){
        // Generate title based on item position
        return tabs[position];

    }
}

