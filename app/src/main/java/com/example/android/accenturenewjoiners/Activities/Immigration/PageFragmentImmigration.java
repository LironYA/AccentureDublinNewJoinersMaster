package com.example.android.accenturenewjoiners.Activities.Immigration;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PageFragmentImmigration extends FragmentPagerAdapter {
    private final int PAGE_COUNT = 2;
    private String tabs[] = new String[]{"EU Citizen", "Non-EU Citizen"};
    private Context context;

    public PageFragmentImmigration(FragmentManager fragmentManager, Context context) {
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
            return new EUFragment();
        }
        else {
            return new EUFragment();
        }
    }

    @Override
    public CharSequence getPageTitle (int position){
        // Generate title based on item position
        return tabs[position];

    }
}
