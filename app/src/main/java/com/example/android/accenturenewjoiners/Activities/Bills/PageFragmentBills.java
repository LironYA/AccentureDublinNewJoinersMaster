package com.example.android.accenturenewjoiners.Activities.Bills;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class PageFragmentBills extends FragmentPagerAdapter {
    private final int PAGE_COUNT = 3;
    private String tabs[] = new String[]{"Electricity & Gas", "Internet & TV", "Mobile Phone Plans"};
    private Context context;
    public PageFragmentBills(FragmentManager fragmentManager, Context context) {
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
            return new ElectricityFragment();
        }
        if (position == 1) {
            return new InternetFragment();
        } else {
            return new ElectricityFragment();
        }
    }

    @Override
    public CharSequence getPageTitle ( int position){
        // Generate title based on item position
        return tabs[position];

    }
}
