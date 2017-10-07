package com.techno.womensafety;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Nitin on 10/7/2017.
 */

public class FragmentSOS extends Fragment{
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_sos,container,false);
        ViewPager viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(new AdapterSOS(getFragmentManager()));
        ((TabLayout)view.findViewById(R.id.tabView)).setupWithViewPager(viewPager);
        return view;
    }
}
