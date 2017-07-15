package com.app.sreevision.sv16;

import android.*;
import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import DBManager.DBFavs;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by Satyam Poddar on 30-Jan-16.
 */
public class Developers extends AppCompatActivity implements View.OnClickListener {
    private Toolbar toolbar;
    private TextView activityName;
    private ImageView img;


    private TextView num1;
    private LinearLayout org1;
    private TextView num2;
    private LinearLayout org2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/JosefinSans-Regular.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build()
        );
        setContentView(R.layout.developers);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        activityName = (TextView) findViewById(R.id.activity_name);


        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Typeface tf2 = Typeface.createFromAsset(getAssets(),
        //      "Arsenal-Bold.otf");

        //activityName.setTypeface(tf2);
        activityName.setText("Developers");



        num1 = (TextView) findViewById(R.id.num1);
        org1 = (LinearLayout) findViewById(R.id.organiser1);
        org1.setOnClickListener(this);
        num2 = (TextView) findViewById(R.id.number2);
        org2 = (LinearLayout) findViewById(R.id.organiser2);
        org2.setOnClickListener(this);


    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem item = menu.findItem(R.id.action_settings);
        item.setVisible(false);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


    public void onClick(View view) {

        switch (view.getId()) {


            case R.id.organiser1:
                String number1 = num1.getText().toString().trim();
                Intent callIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:+91" + number1));
                //startActivity(callIntent);
                 /* Intent callIntent2 = new Intent(Intent.ACTION_CALL);
                callIntent2.setData(Uri.parse("tel:+91" + number1));*/
                if (!hasPermission("android.permission.CALL_PHONE")) {
                    Toast.makeText(this, "Grant permission for Calling", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    startActivity(callIntent);
                }

               /* String to = eid1.getText().toString();
                String subject="Regarding " + EVENT_NAME +"!";


                Intent email1 = new Intent(Intent.ACTION_SEND);
                email1.putExtra(Intent.EXTRA_EMAIL, to);
                email1.putExtra(Intent.EXTRA_SUBJECT, subject);

                //need this to prompts email client only
                email1.setType("text/plain");

                startActivity(Intent.createChooser(email1, "Choose an Email client :"));*/
                break;

            case R.id.organiser2:
                String number2 = num2.getText().toString().trim();
                Intent callIntent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:+91" + number2));
                //startActivity(callIntent);
                 /* Intent callIntent2 = new Intent(Intent.ACTION_CALL);
                callIntent2.setData(Uri.parse("tel:+91" + number1));*/
                if (!hasPermission("android.permission.CALL_PHONE")) {
                    Toast.makeText(this, "Grant permission for Calling", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    startActivity(callIntent1);
                }

               /* String to = eid1.getText().toString();
                String subject="Regarding " + EVENT_NAME +"!";


                Intent email1 = new Intent(Intent.ACTION_SEND);
                email1.putExtra(Intent.EXTRA_EMAIL, to);
                email1.putExtra(Intent.EXTRA_SUBJECT, subject);

                //need this to prompts email client only
                email1.setType("text/plain");

                startActivity(Intent.createChooser(email1, "Choose an Email client :"));*/
                break;
        }}
            public boolean hasPermission(String permission) {
            try {
                PackageInfo info = getPackageManager().getPackageInfo(this.getPackageName(), PackageManager.GET_PERMISSIONS);
                if (info.requestedPermissions != null) {
                    for (String p : info.requestedPermissions) {
                        if (p.equals(permission)) {
                            return true;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }

}