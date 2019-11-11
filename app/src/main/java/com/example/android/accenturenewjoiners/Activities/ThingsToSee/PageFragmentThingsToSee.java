package com.example.android.accenturenewjoiners.Activities.ThingsToSee;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.accenturenewjoiners.Activities.Revenue.GeneralRevenueFragment;
import com.example.android.accenturenewjoiners.Activities.Revenue.RevenueDetailsFragment;

    public class PageFragmentThingsToSee extends FragmentPagerAdapter {
        private final int PAGE_COUNT = 2;
        private String tabs[] = new String[]{"Dublin", "Outside Of Dublin"};
        private Context context;

        public PageFragmentThingsToSee(FragmentManager fragmentManager, Context context) {
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
                return new ThingsToSeeDublinFragment();
            }
            else {
                return new ThingsToSeeDublinFragment();
            }
        }

        @Override
        public CharSequence getPageTitle (int position){
            // Generate title based on item position
            return tabs[position];

        }
    }

