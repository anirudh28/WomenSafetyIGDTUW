package com.techno.womensafety;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Nitin on 10/7/2017.
 */

public class HelpFrag extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_help,container,false);
        ((ImageView)view.findViewById(R.id.iv)).setImageResource(R.drawable.helpli);
        return view;

    }
}
