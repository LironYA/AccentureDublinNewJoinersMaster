package com.example.android.accenturenewjoiners.Activities.Transportation;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


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
                return new ShuttelServiceFragment();
            }
            if (position == 1) {
                return new LuasFragment();
            }
            if (position == 2) {
                return new BusFragment();

            } else {
                return new BusFragment();
            }
        }

        @Override
        public CharSequence getPageTitle ( int position){
            // Generate title based on item position
            return tabs[position];

        }
    }
