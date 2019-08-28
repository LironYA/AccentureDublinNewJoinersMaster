package com.example.android.accenturenewjoiners.Activities.Accenture;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.example.android.accenturenewjoiners.Activities.Revenue.GeneralRevenueFragment;

public class PageFragmentAccenture extends FragmentPagerAdapter {
    private final int PAGE_COUNT = 3;
    private String tabs[] = new String[]{"Information", "Mail" ,"About Accenture"};
    private Context context;

    public PageFragmentAccenture(FragmentManager fragmentManager, Context context) {
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
            return new InformationFragment();
        }
        if (position == 1) {
            return new InformationFragment();
        }
        else {
            return new InformationFragment();
        }
    }

    @Override
    public CharSequence getPageTitle (int position){
        // Generate title based on item position
        return tabs[position];

    }
}
