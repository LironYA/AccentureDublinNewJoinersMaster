package com.example.android.accenturenewjoiners.Activities.Revenue;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.accenturenewjoiners.Activities.StartingOut.GeneralFragment;

public class PageFragmentRevenue extends FragmentPagerAdapter {
    private final int PAGE_COUNT = 2;
    private String tabs[] = new String[]{"General", "Accenture's Revenue Details"};
    private Context context;

    public PageFragmentRevenue(FragmentManager fragmentManager, Context context) {
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
            return new GeneralRevenueFragment();
        }
        else {
            return new GeneralRevenueFragment();
        }
    }

    @Override
    public CharSequence getPageTitle (int position){
        // Generate title based on item position
        return tabs[position];

    }
}
