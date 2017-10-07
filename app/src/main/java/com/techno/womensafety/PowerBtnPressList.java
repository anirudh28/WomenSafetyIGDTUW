package com.techno.womensafety;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class PowerBtnPressList extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d("RRR", "yooo");
        Intent i = new Intent(context, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
        Toast.makeText(context, "Yoo", Toast.LENGTH_LONG).show();
    }
}
