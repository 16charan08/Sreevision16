package com.app.sreevision.sv16;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.design.widget.FloatingActionButton;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.pushbots.push.Pushbots;
import com.yalantis.guillotine.animation.GuillotineAnimation;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final int NUM_PAGES = 4;
    private int pressed = 0;
    //Toolbar toolbar;
    private FrameLayout root;
    private View contentHamburger;
    private Boolean isFabOpen = false;
    private FloatingActionButton fab, fab1, fab2;
    private Animation fab_open, fab_close, rotate_forward, rotate_backward;
    private static final long RIPPLE_DURATION = 250;
    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    TextView act_name;

    public TextView thome, tevents, tschedule, tupdates, tfavorites, tsponsors, tcontacts, tdevelopers;
    // private LinearLayout ll;
    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;
    private TextView tnavi;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        int permissionCheck = ContextCompat.checkSelfPermission(this,
                Manifest.permission.C2D_MESSAGE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        Pushbots.sharedInstance().init(this);

        Pushbots.sharedInstance().setNotificationEnabled(true);

        root = (FrameLayout) findViewById(R.id.root);
        contentHamburger = findViewById(R.id.content_hamburger);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(null);
            getSupportActionBar().setElevation((float) 1.5);
        }

        act_name = (TextView) findViewById(R.id.main_actname);
        Typeface tf1 = Typeface.createFromAsset(getAssets(),
                "JosefinSans-Regular.ttf");

        act_name.setTypeface(tf1);
        act_name.setText("SreeVision'16");

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        rotate_forward = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_foward);
        rotate_backward = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_backward);
        fab.setOnClickListener(this);
        fab1.setOnClickListener(this);
        fab2.setOnClickListener(this);

       /*micon = new ImageView(this);
        micon.setImageDrawable(getResources().getDrawable(R.drawable.ic_share_white_36dp));
        //micon = (ImageView)findViewById(R.id.mainIcon);
        actionButton = new FloatingActionButton.Builder(this)
                .setContentView(micon)
                .setBackgroundDrawable(R.drawable.button_action_red_selector)
                .build();

        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this);
// repeat many times:
        itemIcon1 = new ImageView(this);
        itemIcon1.setImageDrawable(getResources().getDrawable(R.drawable.itemicon3));
        button1 = itemBuilder.setContentView(itemIcon1).setBackgroundDrawable(getResources().getDrawable(R.drawable.button_action_blue_selector)).build();
        itemIcon2 = new ImageView(this);
        itemIcon2.setImageDrawable(getResources().getDrawable(R.drawable.itemicon2));
        button2 = itemBuilder.setContentView(itemIcon2).setBackgroundDrawable(getResources().getDrawable(R.drawable.button_action_blue_selector)).build();
        itemIcon3 = new ImageView(this);
        itemIcon3.setImageDrawable(getResources().getDrawable(R.drawable.itemicon1));
        button3 = itemBuilder.setContentView(itemIcon3).setBackgroundDrawable(getResources().getDrawable(R.drawable.button_action_blue_selector)).build();

        fabMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(itemBuilder.setContentView(button1).build())
                .addSubActionView(itemBuilder.setContentView(button2).build())
                .addSubActionView(itemBuilder.setContentView(button3).build())
                .attachTo(actionButton)
                .build();

        fabMenu.setStateChangeListener(new FloatingActionMenu.MenuStateChangeListener() {
            @Override
            public void onMenuOpened(FloatingActionMenu menu) {
                // Rotate the icon of rightLowerButton 45 degrees clockwise
                micon.setRotation(0);
                PropertyValuesHolder pvhR = PropertyValuesHolder.ofFloat(View.ROTATION, 45);
                ObjectAnimator animation = ObjectAnimator.ofPropertyValuesHolder(micon, pvhR);
                animation.start();

            }

            @Override
            public void onMenuClosed(FloatingActionMenu menu) {
                // Rotate the icon of rightLowerButton 45 degrees counter-clockwise
                micon.setRotation(45);
                PropertyValuesHolder pvhR = PropertyValuesHolder.ofFloat(View.ROTATION, 0);
                ObjectAnimator animation = ObjectAnimator.ofPropertyValuesHolder(micon, pvhR);
                animation.start();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(), "button1", Toast.LENGTH_SHORT).show();
                String url = "https://google.com";
                Intent ir = new Intent(Intent.ACTION_VIEW);
                ir.setData(Uri.parse(url));
                startActivity(ir);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(), "button2", Toast.LENGTH_SHORT).show();
                String url = "https://www.sreevision16.in";
                Intent ir = new Intent(Intent.ACTION_VIEW);
                ir.setData(Uri.parse(url));
                startActivity(ir);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(), "button3", Toast.LENGTH_SHORT).show();
                String url = "https://www.facebook.com/sreevision16";
                Intent ir = new Intent(Intent.ACTION_VIEW);
                ir.setData(Uri.parse(url));
                startActivity(ir);
            }
        });
*/
        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            //@Override
            public void onPageSelected(int position) {
                changeinactivestate(position);
                changeactivestate((position + 1) % 4);
                changeactivestate((position + 2) % 4);
                changeactivestate((position + 3) % 4);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        View guillotineMenu = LayoutInflater.from(this).inflate(R.layout.guillotine, null);
        root.addView(guillotineMenu);

        new GuillotineAnimation.GuillotineBuilder(guillotineMenu, guillotineMenu.findViewById(R.id.guillotine_hamburger), contentHamburger)
                .setStartDelay(RIPPLE_DURATION)
                .setActionBarViewForAnimation(toolbar)
                .setClosedOnStart(true)
                .build();
        //  .hideandshowfloatingButton(actionButton, button1, button2, button3, fabMenu);


        thome = (TextView) findViewById(R.id.thome);
        tevents = (TextView) findViewById(R.id.tevents);
        tschedule = (TextView) findViewById(R.id.tschedule);
        tupdates = (TextView) findViewById(R.id.tupdates);
        tsponsors = (TextView) findViewById(R.id.tsponsors);
        tfavorites = (TextView) findViewById(R.id.tfavorites);
        tcontacts = (TextView) findViewById(R.id.tcontacts);
        tdevelopers = (TextView) findViewById(R.id.tdevelopers);
        tnavi = (TextView) findViewById(R.id.tnavi);

        //resetstyle();
        thome.setTypeface(tf1);
        thome.setText("Home");
        tevents.setTypeface(tf1);
        tevents.setText("Events Log");
        tschedule.setTypeface(tf1);
        tschedule.setText("Schedule");
        tupdates.setTypeface(tf1);
        tupdates.setText("Updates");
        tsponsors.setTypeface(tf1);
        tsponsors.setText("Sponsors");
        tfavorites.setTypeface(tf1);
        tfavorites.setText("Favorites");
        tcontacts.setTypeface(tf1);
        tcontacts.setText("Contacts");
        tdevelopers.setTypeface(tf1);
        tdevelopers.setText("Developers");
        tnavi.setTypeface(tf1);
        tnavi.setText("Navigate");

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.fab:

                animateFAB();
                break;
            case R.id.fab1:
                Intent intent1 = new Intent(this,Contacts.class);
                startActivity(intent1);
                Log.d("Raj", "Fab 1");
                break;
            case R.id.fab2:
                Intent intent = new Intent(this,Favorites.class);
                startActivity(intent);
                Log.d("Going to Favorites", "Fab 2");
                break;
        }
    }

    public void animateFAB() {

        if (isFabOpen) {

            fab.startAnimation(rotate_backward);
            fab1.startAnimation(fab_close);
            fab2.startAnimation(fab_close);
            fab1.setClickable(false);
            fab2.setClickable(false);
            isFabOpen = false;
            Log.d("Raj", "close");

        } else {

            fab.startAnimation(rotate_forward);
            fab1.startAnimation(fab_open);
            fab2.startAnimation(fab_open);
            fab1.setClickable(true);
            fab2.setClickable(true);
            isFabOpen = true;
            Log.d("Raj", "open");

        }
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            if (pressed == 0) {
                Toast.makeText(MainActivity.this, "Press Again to Exit", Toast.LENGTH_SHORT).show();
                pressed = 1;
            } else if (pressed == 1) {
                pressed = 0;
                super.onBackPressed();
            }
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.app.sreevision.sv16/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.app.sreevision.sv16/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }


    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new ScreenSlideFragment1();
                case 1:
                    return new ScreenSlideFragment2();
                case 2:
                    return new ScreenSlideFragment3();
                case 3:
                    return new ScreenSlideFragment4();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }


    public void changeinactivestate(int pos) {
        switch (pos) {
            case 0:
                ImageView imageView = (ImageView) findViewById(R.id.imageView4);
                imageView.setImageResource(R.drawable.dot_selected_2x);
                break;
            case 1:
                ImageView imageView1 = (ImageView) findViewById(R.id.imageView5);
                imageView1.setImageResource(R.drawable.dot_selected_2x);
                break;
            case 2:
                ImageView imageView2 = (ImageView) findViewById(R.id.imageView6);
                imageView2.setImageResource(R.drawable.dot_selected_2x);
                break;
            case 3:
                ImageView imageView3 = (ImageView) findViewById(R.id.imageView8);
                imageView3.setImageResource(R.drawable.dot_selected_2x);
                break;
        }
    }

    public void changeactivestate(int pos) {
        switch (pos) {
            case 0:
                ImageView imageView = (ImageView) findViewById(R.id.imageView4);
                imageView.setImageResource(R.drawable.dot_2x);
                break;
            case 1:
                ImageView imageView1 = (ImageView) findViewById(R.id.imageView5);
                imageView1.setImageResource(R.drawable.dot_2x);
                break;
            case 2:
                ImageView imageView2 = (ImageView) findViewById(R.id.imageView6);
                imageView2.setImageResource(R.drawable.dot_2x);
                break;
            case 3:
                ImageView imageView3 = (ImageView) findViewById(R.id.imageView8);
                imageView3.setImageResource(R.drawable.dot_2x);
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sreevision16.in")));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void chome(View v) {
        //resetstyle();
        //thome.setTextAppearance(R.style.TextView_GuillotineItem_Selected);
        Intent i = new Intent(MainActivity.this, MainActivity.class);
        startActivity(i);
        finish();
    }

    public void cevent(View v) {
        //resetstyle();
        //tevents.setTextAppearance(R.style.TextView_GuillotineItem_Selected);
        Intent i = new Intent(MainActivity.this, Eventlog.class);
        startActivity(i);
        //finish();
    }

    public void cschedule(View v) {
        //resetstyle();
        //tschedule.setTextAppearance(R.style.TextView_GuillotineItem_Selected);
        Intent i = new Intent(MainActivity.this, Schedule.class);
        startActivity(i);
        //finish();
    }

    public void cupdates(View v) {
        //resetstyle();
        //tupdates.setTextAppearance(R.style.TextView_GuillotineItem_Selected);
        Intent i = new Intent(MainActivity.this, Updates.class);
        startActivity(i);
        //finish();
    }

    public void cfavorites(View v) {
        //resetstyle();
        //tfavorites.setTextAppearance(R.style.TextView_GuillotineItem_Selected);
        Intent i = new Intent(MainActivity.this, Favorites.class);
        startActivity(i);
        //finish();
    }

    public void csponsors(View v) {
        Intent i = new Intent(MainActivity.this, Sponsors.class);
        startActivity(i);
    }


    public void ccontact(View v) {
        //resetstyle();
        //tcontacts.setTextAppearance(R.style.TextView_GuillotineItem_Selected);
        Intent i = new Intent(MainActivity.this, Contacts.class);
        startActivity(i);
        //finish();
    }

    public void cdeveloper(View v) {
        //resetstyle();
        //tdevelopers.setTextAppearance(R.style.TextView_GuillotineItem_Selected);
        Intent i = new Intent(MainActivity.this, Developers.class);
        startActivity(i);
        //finish();
    }

    public void cnavigate(View v) {
        //resetstyle();
        //tdevelopers.setTextAppearance(R.style.TextView_GuillotineItem_Selected);
        Intent i = new Intent(MainActivity.this, Navigate.class);
        startActivity(i);
        //finish();
    }

   /* public void resetstyle(){
        thome.setTextAppearance(R.style.TextView_GuillotineItem);
        tevents.setTextAppearance(R.style.TextView_GuillotineItem);
        tschedule.setTextAppearance(R.style.TextView_GuillotineItem);
        tupdates.setTextAppearance(R.style.TextView_GuillotineItem);
        teventsnow.setTextAppearance(R.style.TextView_GuillotineItem);
        tfavorites.setTextAppearance(R.style.TextView_GuillotineItem);
        tsponsors.setTextAppearance(R.style.TextView_GuillotineItem);
        tcontacts.setTextAppearance(R.style.TextView_GuillotineItem);
        tdevelopers.setTextAppearance(R.style.TextView_GuillotineItem);

    }*/


}
