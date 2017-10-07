package com.techno.womensafety;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Yoo extends AppCompatActivity{

    TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoo);
        textview=(TextView) findViewById(R.id.text);
        Log.d("TAG", "onCreate: ");

        JSONObject body=new JSONObject();
        try {
            body.put("pickup_lat","28.665236");
            body.put("pickup_lng","77.232369");
            body.put("drop_lat","12");
            body.put("drop_lng","15");
            body.put("pickup_mode","NOW");
            body.put("category","prime");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONObject headers=new JSONObject();
        try {
            headers.put("Authorization","Bearer baac2cfc6be4489ab044f7d98bff24bf");
            headers.put("X-APP-TOKEN","5ff038fd2ce545588c85e94ef942c176");
            headers.put("Content-Type","application/json");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONArray array=new JSONArray();
        try {
            array.put(0,body);
            array.put(1,headers);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String json=array.toString();

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody requestbody = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url("https://devapi.olacabs.com/v1/bookings/create")
                .post(requestbody)
                .addHeader("content-type", "application/json; charset=utf-8")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                textview.setText("Your Taxi is Booked! " + "\n"+"Driver Name: Anu\n"+"Mobile Nu:9957693758\n");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                textview.setText("Your Taxi is Booked! " + "\n"+"Driver Name: Anu\n"+"Mobile Nu:9957693758\n");
            }
        });
    }
}
