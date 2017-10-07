package com.techno.womensafety;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Nitin on 10/7/2017.
 */

public class AdapterSOS extends FragmentPagerAdapter {
    public AdapterSOS(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new FragmentStartSOS();
                break;
            case 1:
                fragment = new FragmentSOSData();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:return "Main";
            case 1:return "Data";
        }
        return super.getPageTitle(position);
    }
}
