package com.techno.womensafety;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Toast;

import com.github.tbouron.shakedetector.library.ShakeDetector;

public class StartActivity extends AppCompatActivity implements onImageClickFragmentChange{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ShakeDetector.create(this, new ShakeDetector.OnShakeListener() {
            @Override
            public void OnShake() {

                if (ContextCompat.checkSelfPermission(StartActivity.this,
                        Manifest.permission.SEND_SMS)
                        != PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(StartActivity.this,
                            Manifest.permission.SEND_SMS)) {
                    } else {
                        ActivityCompat.requestPermissions(StartActivity.this,
                                new String[]{Manifest.permission.SEND_SMS},
                                0);
                        //MY_PERMISSIONS_REQUEST_SEND_SMS);
                    }
                }
                if(ContextCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.SEND_SMS)
                        == PackageManager.PERMISSION_GRANTED) {
                    if(Data.PhoneNo == "") Toast.makeText(getApplicationContext(), "First Save a Number", Toast.LENGTH_SHORT).show();
                    else {
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(Data.PhoneNo, null, "Emergency HELPPPPPPPPPPPPPPPPPPPPPPPPPP", null, null);
                        Toast.makeText(getApplicationContext(), "Message Successfully Sent", Toast.LENGTH_SHORT).show();
                    }
                }

                //Toast.makeText(getApplicationContext(), "Device shaken!", Toast.LENGTH_SHORT).show();


            }
        });

        getSupportFragmentManager().beginTransaction().add(R.id.options_container,new FragmentOptions()).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,new FragmentSOS()).commit();
    }



    @Override
    public void imageClickFragChange(int id) {
        switch (id){
            case R.id.ivSOS:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new FragmentSOS()).commit();
                break;
            case R.id.ivTaxi:
                startActivity(new Intent(this,Yoo2.class));
                break;
            case R.id.ivMap:
                startActivity(new Intent(this,Web_View.class));
                break;
            case R.id.ivHelplineNos:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HelpFrag()).commit();
                break;
            case R.id.ivSelfDefense:
                break;
            case R.id.ivAbout:
                break;
            case R.id.ivContactUs:
                break;
        }
    }
}
