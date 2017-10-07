package com.techno.womensafety;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class Web_View extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web__view);
        WebView webView;
        webView=new WebView(this);
        getSupportActionBar().hide();
        webView.getSettings().setJavaScriptEnabled(true); // enable javascript

        final Activity activity = this;

        webView.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }
        });

//        webView .loadUrl("https://gmaps009.neocities.org");
        webView .loadUrl("https://www.google.com/maps/d/u/0/embed?mid=1cUKeGWNDdUj0YWg7zV9Bd-VEp5s&z=10&ll=28.70741201636743%2C77.1695563805664");
        setContentView(webView );

    }
}
