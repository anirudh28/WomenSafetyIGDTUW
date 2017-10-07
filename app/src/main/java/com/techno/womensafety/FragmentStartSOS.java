package com.techno.womensafety;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by Nitin on 10/7/2017.
 */

public class FragmentStartSOS extends Fragment {

    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_sos_main,container,false);
        view.findViewById(R.id.startSOS).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(getContext(),
                        Manifest.permission.SEND_SMS)
                        != PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                            Manifest.permission.SEND_SMS)) {
                    } else {
                        ActivityCompat.requestPermissions(getActivity(),
                                new String[]{Manifest.permission.SEND_SMS},
                                0);
                                //MY_PERMISSIONS_REQUEST_SEND_SMS);
                    }
                }
                if(ContextCompat.checkSelfPermission(getContext(),
                        Manifest.permission.SEND_SMS)
                        == PackageManager.PERMISSION_GRANTED) {
                    if(Data.PhoneNo == "") Toast.makeText(getContext(), "First Save a Number", Toast.LENGTH_SHORT).show();
                    else {
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(Data.PhoneNo, null, "Emergency HELPPPPPPPPPPPPPPPPPPPPPPPPPP", null, null);
                        Toast.makeText(getContext(), "Message Successfully Sent", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        return view;
    }
}
