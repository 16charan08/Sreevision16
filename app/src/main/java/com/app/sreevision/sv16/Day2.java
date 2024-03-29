package com.app.sreevision.sv16;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;

import java.util.ArrayList;
import java.util.HashMap;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by Satyam Poddar on 30-Jan-16.
 */
public class Day2 extends AppCompatActivity{
    private Toolbar toolbar;
    private SwipeMenuListView mList;
    String[] events_1;
    int[] images;
    String[] timing;
    String[] intents;
    TextView eventName,act_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/JosefinSans-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
        setContentView(R.layout.eventsnow);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        act_name = (TextView)findViewById(R.id.activity_name);
        Typeface tf1 = Typeface.createFromAsset(getAssets(),
                "JosefinSans-Regular.ttf");

        act_name.setTypeface(tf1);
        act_name.setText("28-Sep-16");

        mList = (SwipeMenuListView) findViewById(R.id.listView);
        // step 1. create a MenuCreator
        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // create "open" item
                SwipeMenuItem openItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                openItem.setBackground(new ColorDrawable(Color.rgb(0x52, 0xb3,
                        0xd9)));
                // set item width
                openItem.setWidth(dp2px(90));
                // set item title
                openItem.setTitle("Open");
                // set item title fontsize
                openItem.setTitleSize(18);
                // set item title font color
                openItem.setTitleColor(Color.WHITE);
                // add to menu
                menu.addMenuItem(openItem);

                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xff,
                        0x00, 0x00)));
                // set item width
                deleteItem.setWidth(dp2px(90));
                // set a icon
                deleteItem.setIcon(R.drawable.ic_settings);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };
        // set creator
        mList.setMenuCreator(creator);
        mList.setOpenInterpolator(new BounceInterpolator());
        mList.setCloseInterpolator(new BounceInterpolator());



        //Add events in this array
        events_1 = new String[] {"Paper Presentation","Poster Presentation","Project Expo",
                "Ranaveera","Gati", "Goalaa", "Sarvaagami",
                "Yoddha", "Lakshmana Rekha", "Vistaar","Samviditha","Niyantrana","Vidhyuteen",
                "Jaladhmaatra","Drishti","Spell Bee","Picture Interpretation","What Do You See?","Debate",
                "Idea PItching","Case Studies",
                "FootBall","Volley Ball","Basket Ball","Throw Ball",
               };

        images = new int[] {R.drawable.paper,R.drawable.poster1,R.drawable.pexpo,R.drawable.ranaveera,
                R.drawable.gati,R.drawable.goalaa,R.drawable.sarvaagami,
                R.drawable.yoddha,R.drawable.lakshmanarekha,R.drawable.vistaar,R.drawable.samviditha,
                R.drawable.niyantrana,R.drawable.vidhyuteen,R.drawable.jaladhmaatra,R.drawable.drishti,
                R.drawable.logo2,R.drawable.logo2,R.drawable.logo2,R.drawable.logo2,R.drawable.logo2,R.drawable.logo2,
                R.drawable.football,R.drawable.volleyball,R.drawable.basket,R.drawable.tball,
                };

        timing = new String[] {"9.30 AM, Block 1,2","10.30 AM, Block 1,2","10.30 AM, Ground",
                "10.30 AM, Opp.Central Library",
                "10.30 AM, Vaughn Block","10.30 AM, Vaughn Block",
                "10.30 AM, Vaughn Block","10.30 AM, Vaughn Block","10.30 AM, Vaughn Block",
                "10.30 AM, Vaughn Block","10.30 AM, Vaughn Block","10.30 AM, Vaughn Block",
                "10.30 AM, Vaughn Block","10.30 AM, Vaughn Block","10.30 AM, Vaughn Block",
                "10.30 AM, Admin Block","10.30 AM, Admin Block","10.30 AM, Admin Block",
                "10.30 AM, Admin Block","10.30 AM, Admin Block","10.30 AM, Admin Block",
                "11.00 AM, Foot Ball Ground,SNIST","11.30 AM, Volley Ball Ground,SNIST",
                "11.00 AM, Basket Ball Ground,SNIST","11.00 AM, Throw Ball Ground,SNIST",
                };

        intents = new String[]{"PAP","POP","PEX","RAN", "GAT", "GOL", "SAR", "YOD", "LAK",
                "VIS","SAM","NIY","VID","JAL","DRI","MAIN1","MAIN1","MAIN1","MAIN1","MAIN1","MAIN1",
                "FOT","VOL","BSK","TRB", };

        initList(events_1, images, timing, intents);


        Toast.makeText(this,
                "Swipe From Right on each Event To Get More Options ", Toast.LENGTH_LONG).show();
        Toast.makeText(this,
                "Swipe From Right on each Event To Get More Options ", Toast.LENGTH_LONG).show();


    }


    public void initList(String[] eventsArray, int[] imagesList, String[] timingList, String[] intentsList) {
        if(eventsArray.length != 0) {

            ArrayList<HashMap<String, String>> eventList = new ArrayList<HashMap<String, String>>();

            for(int i = 0; i <eventsArray.length ; i++) {
                HashMap<String, String> candy = new HashMap<String, String>();
                candy.put("event", eventsArray[i]);
                candy.put("image", Integer.toString(imagesList[i]));
                candy.put("time", timingList[i]);
                candy.put("intent", "com.app.sreevision.sv16."+intentsList[i].trim());
                eventList.add(candy);
            }

            ListAdapter adapter = new SimpleAdapter(
                    Day2.this ,
                    eventList,
                    R.layout.list_item,
                    new String[] { "event", "image", "time", "intent" },
                    new int[] { R.id.event_name, R.id.eventImg, R.id.eventTime, R.id.intent }) {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);
                    TextView item_name = (TextView)view.findViewById(R.id.event_name);

                    return view;
                }
            };

            mList.setAdapter(adapter);
        }

        mList.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0:
                        // open

                        String intentToOpen = "com.app.sreevision.sv16." + intents[position];

                        Intent i = new Intent(intentToOpen);
                        i.putExtra("INTENT", intentToOpen);
                        startActivity(i);

                        break;
                    case 1:
                        Intent it = new Intent("com.app.sreevision.sv16.SN");
                        it.putExtra("event", events_1[position]);
                        it.putExtra("address","com.app.sreevision.sv16."+ intents[position]);
                        startActivity(it);
                        break;
                }
                return false;
            }
        });

    }
    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
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
}