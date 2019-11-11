package com.example.android.accenturenewjoiners.Activities.Welfare;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class PageFragmentWelfare extends FragmentPagerAdapter {
    private final int PAGE_COUNT = 2;
        private String tabs[] = new String[]{"Welfare Services", "How to Apply"};
    private Context context;

    public PageFragmentWelfare(FragmentManager fragmentManager, Context context) {
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
            return new GeneralWelfareFragment();
        }
        else {
            return new WelfareHowToApplyFragment();
        }
    }

    @Override
    public CharSequence getPageTitle (int position){
        // Generate title based on item position
        return tabs[position];

    }

}
