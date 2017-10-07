package com.techno.womensafety;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Nitin on 10/7/2017.
 */

public class FragmentSOSData extends Fragment {

    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_sos_data,container,false);
        final EditText etName = (EditText)view.findViewById(R.id.etnamee);
        final EditText etPhone = (EditText)view.findViewById(R.id.etPhone);
        view.findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Data.name = etName.getText().toString();
               Data.PhoneNo = etPhone.getText().toString();
                Toast.makeText(getContext(), "Added!", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
