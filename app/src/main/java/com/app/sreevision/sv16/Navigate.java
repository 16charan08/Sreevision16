package com.app.sreevision.sv16;


import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class Navigate extends Activity {

    private WebView mWebview ;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigate);
        mWebview  = new WebView(this);

        mWebview.getSettings().setJavaScriptEnabled(true); // enable javascript

        final Activity activity = this;

        Toast.makeText(this,
                "Check Your InterNet Connection", Toast.LENGTH_LONG).show();

        Toast.makeText(this,
                "A Slow InterNet Connection is Detected, Please Be patient While we load", Toast.LENGTH_LONG).show();

        Toast.makeText(this,
                "A Slow InterNet Connection is Detected, Please Be patient While we load", Toast.LENGTH_SHORT).show();

        mWebview.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, description, Toast.LENGTH_LONG).show();
            }
        });

        mWebview .loadUrl("https://www.google.co.in/maps/place/Sreenidhi+Institute+of+Science+%26+Technology/@17.4552577,78.6668677,19z/data=!4m5!3m4!1s0x0:0x9ea4b426b7e3699!8m2!3d17.4556159!4d78.666535");
        setContentView(mWebview );

    }

}