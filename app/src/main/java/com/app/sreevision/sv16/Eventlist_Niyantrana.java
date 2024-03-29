package com.app.sreevision.sv16;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import DBManager.DBFavs;

/**
 * Created by Satyam Poddar on 16-Feb-16.
 */
public class Eventlist_Niyantrana extends AppCompatActivity implements View.OnClickListener{
    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbar;
    private LinearLayout desc,rules,prize,org;

    private ImageView bdesc,brules,bprize,borg,bfav;

    private SharedPreferences sharedpreferences;
    private String PREF_FILE_NAME = "APRO";
    private String FAVSTATUS = "vfl";
    private String intentNaam;
    final static private String EVENT_NAME = "Niyantrana";

    private TextView num1;
    private LinearLayout org1;
    private TextView num2;
    private LinearLayout org2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_niyantrana);
        toolbar = (Toolbar) findViewById(R.id.anim_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("Niyantrana");

        desc = (LinearLayout)findViewById(R.id.desc);
        rules = (LinearLayout)findViewById(R.id.rules);
        prize = (LinearLayout)findViewById(R.id.prize);
        org = (LinearLayout)findViewById(R.id.org);

        desc.setVisibility(View.VISIBLE);

        bdesc = (ImageView)findViewById(R.id.bdesc);
        brules = (ImageView)findViewById(R.id.brules);
        bprize = (ImageView)findViewById(R.id.bprize);
        borg = (ImageView)findViewById(R.id.borg);
        bfav = (ImageView)findViewById(R.id.bfav);

        bdesc.setOnClickListener(this);
        brules.setOnClickListener(this);
        bprize.setOnClickListener(this);
        borg.setOnClickListener(this);
        bfav.setOnClickListener(this);

        num1 = (TextView) findViewById(R.id.num1);
        org1 = (LinearLayout) findViewById(R.id.organiser1);
        org1.setOnClickListener(this);
        num2 = (TextView) findViewById(R.id.number2);
        org2 = (LinearLayout) findViewById(R.id.organiser2);
        org2.setOnClickListener(this);
        // Animation in = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        // Animation out = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);

        Button Button1,button2,button4,Button3;


        Button1 = (Button)findViewById(R.id.register);

        Button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLScTBBJoix0Vd99OAA6zhiB1_ZZ6lzfoBXqRGKVQWB3ug8ARbw/viewform?c=0&w=1"));
                startActivity(intent);
            }
        });

        Button3 = (Button)findViewById(R.id.register1);

        Button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLScTBBJoix0Vd99OAA6zhiB1_ZZ6lzfoBXqRGKVQWB3ug8ARbw/viewform?c=0&w=1"));
                startActivity(intent);
            }
        });


        //RuleBook
        button2 = (Button)findViewById(R.id.rule);

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.sreevision16.in/docs/Niyantrana.pdf"));
                startActivity(intent);
            }
        });

        button4 = (Button)findViewById(R.id.rule1);

        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.sreevision16.in/docs/Niyantrana.pdf"));
                startActivity(intent);
            }
        });


        Toast.makeText(this,
                "Click on the above 4 icons to get more info about the event ", Toast.LENGTH_LONG).show();
        Toast.makeText(this,
                "Click on the above 4 icons to get more info about the event ", Toast.LENGTH_LONG).show();


        Intent intent = getIntent();
        intentNaam = intent.getStringExtra("INTENT");
        // String name = intent.getStringExtra("name");

        if (getFav().equals("1")) {
            //fav is set

            bfav.setImageResource(R.drawable.book2);

        } else {
            //fav is not set

            bfav.setImageResource(R.drawable.book1);

        }

    }

    public void setFav(String fav) {
        sharedpreferences = getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(FAVSTATUS, fav);
        editor.commit();
    }

    public String getFav() {
        sharedpreferences = getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        if (sharedpreferences.contains(FAVSTATUS)) {

            return sharedpreferences.getString(FAVSTATUS, "");

        }
        return "";

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
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.bdesc :
                desc.setVisibility(View.VISIBLE);
                rules.setVisibility(View.INVISIBLE);
                prize.setVisibility(View.INVISIBLE);
                org.setVisibility(View.INVISIBLE);
                break;
            case R.id.brules :
                desc.setVisibility(View.INVISIBLE);
                rules.setVisibility(View.VISIBLE);
                prize.setVisibility(View.INVISIBLE);
                org.setVisibility(View.INVISIBLE);
                break;
            case R.id.bprize :
                desc.setVisibility(View.INVISIBLE);
                rules.setVisibility(View.INVISIBLE);
                prize.setVisibility(View.VISIBLE);
                org.setVisibility(View.INVISIBLE);
                break;
            case R.id.borg :
                desc.setVisibility(View.INVISIBLE);
                rules.setVisibility(View.INVISIBLE);
                prize.setVisibility(View.INVISIBLE);
                org.setVisibility(View.VISIBLE);
                Toast.makeText(this,
                        "You can directly contact the Organizer by clicking on call ", Toast.LENGTH_LONG).show();

                break;
            case R.id.bfav :
                if(getFav().equals("1")) {
                    //fav is set
                    setFav("0");
                    DBFavs entryDel = new DBFavs(this);
                    entryDel.openandwrite();
                    entryDel.deleteTitleGivenName(EVENT_NAME);
                    entryDel.close();
                    bfav.setImageResource(R.drawable.book1);
                    Toast.makeText(this, "Removed from Favorites", Toast.LENGTH_SHORT).show();
                    //delete db entry
                }
                else {
                    //fav is not set
                    setFav("1");
                    bfav.setImageResource(R.drawable.book2);
                    DBFavs entry = new DBFavs(this);
                    entry.openandwrite();
                    entry.createEntry(EVENT_NAME, intentNaam);
                    entry.close();
                    Toast.makeText(this, "Added to Favorites", Toast.LENGTH_SHORT).show();
                    //create db entry
                }

                break;

            case R.id.organiser1:
                String number1 = num1.getText().toString().trim();
                Intent callIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:+91"+number1));
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
                Intent callIntent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:+91"+number2));
               /* startActivity(callIntent);
                Intent callIntent22 = new Intent(Intent.ACTION_CALL);
                callIntent22.setData(Uri.parse("tel:+91" + number2));*/
                if (!hasPermission("android.permission.CALL_PHONE")) {
                    Toast.makeText(this, "Grant permission for Calling", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    startActivity(callIntent2);
                }
                break;
        }

    }
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
    // new addition
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        try {
            return super.dispatchTouchEvent(ev);
        } catch (Exception e) {
            return false;
        }
    }
    //end


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
