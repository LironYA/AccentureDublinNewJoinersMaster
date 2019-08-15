package com.example.android.accenturenewjoiners.Activities.Transportation;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PageFragmentTransportation extends FragmentPagerAdapter {
    private final int PAGE_COUNT = 4;
    private String tabs[] = new String[]{"Shuttel", "Luas", "Dart", "Bus"};
    private Context context;

    public PageFragmentTransportation(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
        this.context = context;
    }
        @Override
        public int getCount () {
            return PAGE_COUNT;
        }

        @Override
        public Fragment getItem ( int position){
            if (position == 0) {
                return new ShuttelFragment();
            }
            if (position == 1) {
                return new ShuttelFragment();
            }
            if (position == 2) {
                return new ShuttelFragment();

            } else {
                return new ShuttelFragment();
            }
        }

        @Override
        public CharSequence getPageTitle ( int position){
            // Generate title based on item position
            return tabs[position];

        }
    }
