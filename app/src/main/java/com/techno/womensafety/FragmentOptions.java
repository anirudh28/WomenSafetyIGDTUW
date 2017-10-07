package com.techno.womensafety;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Nitin on 10/7/2017.
 */

public class FragmentOptions extends Fragment implements View.OnClickListener {

    onImageClickFragmentChange interf;
    View view;
    ImageView sos,taxi,map,helpline,defense,about,contact;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_options,container,false);
        getIds();
        interf = (onImageClickFragmentChange) getActivity();
        sos.setOnClickListener(this);
        taxi.setOnClickListener(this);
        map.setOnClickListener(this);
        helpline.setOnClickListener(this);
        defense.setOnClickListener(this);
        about.setOnClickListener(this);
        contact.setOnClickListener(this);
        return view;
    }

    void getIds(){
        sos = (ImageView)view.findViewById(R.id.ivSOS);
        taxi = (ImageView)view.findViewById(R.id.ivTaxi);
        map = (ImageView)view.findViewById(R.id.ivMap);
        helpline = (ImageView)view.findViewById(R.id.ivHelplineNos);
        defense = (ImageView)view.findViewById(R.id.ivSelfDefense);
        about = (ImageView)view.findViewById(R.id.ivAbout);
        contact = (ImageView)view.findViewById(R.id.ivContactUs);

    }

    @Override
    public void onClick(View view) {
        //Toast.makeText(getContext(), "ffffff", Toast.LENGTH_SHORT).show();
        interf.imageClickFragChange(view.getId());

        /*switch (view.getId()){
            case R.id.ivSOS:

                break;
            case R.id.ivTaxi:
                break;
            case R.id.ivMap:
                break;
            case R.id.ivHelplineNos:
                break;
            case R.id.ivSelfDefense:
                break;
            case R.id.ivAbout:
                break;
            case R.id.ivContactUs:
                break;
        }*/
    }
}
