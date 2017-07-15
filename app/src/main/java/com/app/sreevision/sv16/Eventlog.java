package com.app.sreevision.sv16;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class Eventlog extends AppCompatActivity{

    private Toolbar toolbar;

    RecyclerView formalRecycler, informalRecycler, onlineRecycler, signatureRecycler;
    CardAdapter formalAdapter, informalAdapter, onlineAdapter, signatureAdapter;
    List<Event> infoEdge, olympus, nonTech, roboVeda;


    TextView act_name;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/JosefinSans-Regular.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build()
        );
        setContentView(R.layout.eventlog);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        act_name = (TextView)findViewById(R.id.activity_name);
        Typeface tf1 = Typeface.createFromAsset(getAssets(),
                "JosefinSans-Regular.ttf");

        act_name.setTypeface(tf1);
        act_name.setText("Events Log");




        formalRecycler = (RecyclerView) findViewById(R.id.formalEventList);
        informalRecycler = (RecyclerView) findViewById(R.id.informalEventList);
        onlineRecycler = (RecyclerView) findViewById(R.id.onlineEventList);
        signatureRecycler = (RecyclerView) findViewById(R.id.signatureEventList);


        LinearLayoutManager ll0 = new LinearLayoutManager(this);
        ll0.setOrientation(LinearLayoutManager.HORIZONTAL);

        LinearLayoutManager ll1 = new LinearLayoutManager(this);
        ll1.setOrientation(LinearLayoutManager.HORIZONTAL);

        LinearLayoutManager ll2 = new LinearLayoutManager(this);
        ll2.setOrientation(LinearLayoutManager.HORIZONTAL);

        LinearLayoutManager ll3 = new LinearLayoutManager(this);
        ll3.setOrientation(LinearLayoutManager.HORIZONTAL);

        signatureRecycler.setLayoutManager(ll0);
        formalRecycler.setLayoutManager(ll1);
        informalRecycler.setLayoutManager(ll2);
        onlineRecycler.setLayoutManager(ll3);

        initializeroboVeda();
        signatureAdapter = new CardAdapter(roboVeda);
        signatureRecycler.setAdapter(signatureAdapter);
        signatureRecycler.addOnItemTouchListener(
                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        //Toast.makeText(getApplicationContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
                        switch (position) {
                            case 0:
                                Intent i0 = new Intent(Eventlog.this, Eventlist_Ranaveera.class);
                                i0.putExtra("INTENT","com.app.sreevision.sv16.RAN");
                                startActivity(i0);
                                break;
                            case 1:
                                Intent i1= new Intent(Eventlog.this, Eventlist_Gati.class);
                                i1.putExtra("INTENT","com.app.sreevision.sv16.GAT");
                                startActivity(i1);
                                break;
                            case 2:
                                Intent i2= new Intent(Eventlog.this, Eventlist_Golaa.class);
                                i2.putExtra("INTENT","com.app.sreevision.sv16.GOL");
                                startActivity(i2);
                                break;
                            case 3:
                                Intent i3= new Intent(Eventlog.this, Eventlist_Sarvagami.class);
                                i3.putExtra("INTENT","com.app.sreevision.sv16.SAR");
                                startActivity(i3);
                                break;
                            case 4:
                                Intent i4= new Intent(Eventlog.this, Eventlist_Yodha.class);
                                i4.putExtra("INTENT","com.app.sreevision.sv16.YOD");
                                startActivity(i4);
                                break;
                            case 5:
                                Intent i5= new Intent(Eventlog.this, Eventlist_LakshmanaRekha.class);
                                i5.putExtra("INTENT","com.app.sreevision.sv16.LAK");
                                startActivity(i5);
                                break;
                            case 6:
                                Intent i6= new Intent(Eventlog.this, Eventlist_Vistaar.class);
                                i6.putExtra("INTENT","com.app.sreevision.sv16.VIS");
                                startActivity(i6);
                                break;
                            case 7:
                                Intent i7= new Intent(Eventlog.this, Eventlist_Samvidhitha.class);
                                i7.putExtra("INTENT","com.app.sreevision.sv16.SAM");
                                startActivity(i7);
                                break;
                            case 8:
                                Intent i8= new Intent(Eventlog.this, Eventlist_Niyantrana.class);
                                i8.putExtra("INTENT","com.app.sreevision.sv16.NIY");
                                startActivity(i8);
                                break;
                            case 9:
                                Intent i9= new Intent(Eventlog.this, Eventlist_Vidhyuteen.class);
                                i9.putExtra("INTENT","com.app.sreevision.sv16.VID");
                                startActivity(i9);
                                break;
                            case 10:
                                Intent i10= new Intent(Eventlog.this, Eventlist_Jaladhmaatra.class);
                                i10.putExtra("INTENT","com.app.sreevision.sv16.JAL");
                                startActivity(i10);
                                break;
                            case 11:
                                Intent i11= new Intent(Eventlog.this, Eventlist_Drishti.class);
                                i11.putExtra("INTENT","com.app.sreevision.sv16.DRI");
                                startActivity(i11);
                                break;

                            }
                    }
                })
        );

        initializeinfoEdge();
        formalAdapter = new CardAdapter(infoEdge);
        formalRecycler.setAdapter(formalAdapter);
        formalRecycler.addOnItemTouchListener(
                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                       // Toast.makeText(getApplicationContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
                        switch (position){
                            case 0:
                                Intent i0 = new Intent(Eventlog.this, Eventlist_PaperPresentation.class);
                                i0.putExtra("INTENT","com.app.sreevision.sv16.PAP");
                                startActivity(i0);
                                break;
                            case 1:
                                Intent i1 = new Intent(Eventlog.this, Eventlist_PosterPresentation.class);
                                i1.putExtra("INTENT","com.app.sreevision.sv16.POP");
                                startActivity( i1);
                                break;
                            case 2:
                                Intent i2 = new Intent(Eventlog.this, Eventlist_ProjectExpo.class);
                                i2.putExtra("INTENT","com.app.sreevision.sv16.PEX");
                                startActivity( i2);
                                break;
                            case 3:
                                Intent i3 = new Intent(Eventlog.this, Eventlist_BioMania.class);
                                i3.putExtra("INTENT","com.app.sreevision.sv16.BIO");
                                startActivity( i3);
                                break;
                            case 4:
                                Intent i4 = new Intent(Eventlog.this, Eventlist_CodeZeal.class);
                                i4.putExtra("INTENT","com.app.sreevision.sv16.CDZ");
                                startActivity( i4);
                                break;
                            case 5:
                                Intent i5 = new Intent(Eventlog.this, Eventlist_EQuiz.class);
                                i5.putExtra("INTENT","com.app.sreevision.sv16.EQZ");
                                startActivity( i5);
                                break;
                            case 6:
                                Intent i6 = new Intent(Eventlog.this, Eventlist_AutomobileQuiz.class);
                                i6.putExtra("INTENT","com.app.sreevision.sv16.AUT");
                                startActivity( i6);
                                break;
                            case 7:
                                Intent i7 = new Intent(Eventlog.this, Eventlist_DesignerDen.class);
                                i7.putExtra("INTENT","com.app.sreevision.sv16.DGD");
                                startActivity( i7);
                                break;
                            case 8:
                                Intent i8 = new Intent(Eventlog.this, Eventlist_Hackathon.class);
                                i8.putExtra("INTENT","com.app.sreevision.sv16.HAC");
                                startActivity( i8);
                                break;

                        }
                    }
                })
        );

        initializeolympus();
        informalAdapter = new CardAdapter(olympus);
        informalRecycler.setAdapter(informalAdapter);
        informalRecycler.addOnItemTouchListener(
                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        //Toast.makeText(getApplicationContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
                        switch(position){
                            case 0:
                                Intent i0 = new Intent(Eventlog.this, Eventlist_FootBall.class);
                                i0.putExtra("INTENT","com.app.sreevision.sv16.FOT");
                                startActivity(i0);
                                break;
                            case 1:
                                Intent i1 = new Intent(Eventlog.this, Eventlist_VolleyBall.class);
                                i1.putExtra("INTENT","com.app.sreevision.sv16.VOL");
                                startActivity(i1);
                                break;
                            case 2:
                                Intent i2 = new Intent(Eventlog.this, Eventlist_BasketBall.class);
                                i2.putExtra("INTENT","com.app.sreevision.sv16.BSK");
                                startActivity(i2);
                                break;
                            case 3:
                                Intent i3 = new Intent(Eventlog.this, Eventlist_Chess.class);
                                i3.putExtra("INTENT","com.app.sreevision.sv16.CHE");
                                startActivity(i3);
                                break;
                            case 4:
                                Intent i4 = new Intent(Eventlog.this, Eventlist_Carroms.class);
                                i4.putExtra("INTENT","com.app.sreevision.sv16.CAR");
                                startActivity(i4);
                                break;
                            case 5:
                                Intent i5 = new Intent(Eventlog.this, Eventlist_TableTennis.class);
                                i5.putExtra("INTENT","com.app.sreevision.sv16.TAT");
                                startActivity(i5);
                                break;
                            case 6:
                                Intent i6 = new Intent(Eventlog.this, Eventlist_ThrowBall.class);
                                i6.putExtra("INTENT","com.app.sreevision.sv16.TRB");
                                startActivity(i6);
                                break;

                            }
                    }
                })
        );

        initializenonTech();
        onlineAdapter = new CardAdapter(nonTech);
        onlineRecycler.setAdapter(onlineAdapter);
        onlineRecycler.addOnItemTouchListener(
                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        //Toast.makeText(getApplicationContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
                        switch(position){
                            case 0:
                                Intent i0 = new Intent(Eventlog.this, Eventlist_LoggerHeads.class);
                                i0.putExtra("INTENT","com.app.sreevision.sv16.LGH");
                                startActivity(i0);
                                break;
                            case 1:
                                Intent i1 = new Intent(Eventlog.this, Eventlist_FeetOMania.class);
                                i1.putExtra("INTENT","com.app.sreevision.sv16.FOM");
                                startActivity(i1);
                                break;
                            case 2:
                                Intent i2 = new Intent(Eventlog.this, Eventlist_SpeakUp.class);
                                i2.putExtra("INTENT","com.app.sreevision.sv16.SPU");
                                startActivity(i2);
                                break;


                            case 3:
                                Intent i6 = new Intent(Eventlog.this, Eventlist_PictureInterpretation.class);
                                i6.putExtra("INTENT","com.app.sreevision.sv16.PIP");
                                startActivity(i6);
                                break;

                        }
                    }
                })
        );


//        final ImageView imageView = (ImageView) findViewById(R.id.imageAnimation);

 /*       final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            int i=0;
            public void run() {
                imageView.setImageResource(imageArray[i]);
                i++;
                if(i>imageArray.length-1)
                {
                    i=0;
                }
                handler.postDelayed(this, 2500);  //for interval...
            }
        };
        handler.postDelayed(runnable, 2000); //for initial delay..

   */


    }



    private void initializeroboVeda() {
        roboVeda = new ArrayList<>();
        roboVeda.add(new Event("RanaVeera", R.drawable.ranaveera));
        roboVeda.add(new Event("Gati", R.drawable.gati));
        roboVeda.add(new Event("Goalaa", R.drawable.goalaa));
        roboVeda.add(new Event("Sarvaagami", R.drawable.sarvaagami));
        roboVeda.add(new Event("Yoddha", R.drawable.yoddha));
        roboVeda.add(new Event("Lakshmana Re..", R.drawable.lakshmanarekha));
        roboVeda.add(new Event("Vistaar", R.drawable.vistaar));
        roboVeda.add(new Event("Samviditha", R.drawable.samviditha));
        roboVeda.add(new Event("Niyantrana", R.drawable.niyantrana));
        roboVeda.add(new Event("Vidhyuteenu", R.drawable.vidhyuteen));
        roboVeda.add(new Event("Jaladhmaatra", R.drawable.jaladhmaatra));
        roboVeda.add(new Event("Drishti", R.drawable.drishti));

    }






    private void initializeinfoEdge() {
        infoEdge = new ArrayList<>();
        infoEdge.add(new Event("Paper Presen..", R.drawable.paper));
        infoEdge.add(new Event("Poster Presen..", R.drawable.poster1));
        infoEdge.add(new Event("Project Expo", R.drawable.pexpo));
        infoEdge.add(new Event("Bio Mania", R.drawable.bm));
        infoEdge.add(new Event("Code Zeal", R.drawable.codezeal));
        infoEdge.add(new Event("E-Quiz", R.drawable.eq));
        infoEdge.add(new Event("Automobile Quiz", R.drawable.autoq));
        infoEdge.add(new Event("Designer Den", R.drawable.dd));
        infoEdge.add(new Event("Hackathon", R.drawable.hackthon));
    }


    private void initializeolympus() {
        olympus = new ArrayList<>();
        olympus.add(new Event("Foot Ball", R.drawable.football));
        olympus.add(new Event("Volley Ball", R.drawable.volleyball));
        olympus.add(new Event("Basket Ball", R.drawable.basket));
        olympus.add(new Event("Chess", R.drawable.chess));
        olympus.add(new Event("Carroms", R.drawable.carroms));
        olympus.add(new Event("Table Tennis", R.drawable.tt));
        olympus.add(new Event("Throw Ball", R.drawable.tball));
         }

    private void initializenonTech() {
        nonTech = new ArrayList<>();
        nonTech.add(new Event("Logger Heads", R.drawable.lq));
        nonTech.add(new Event("Feet-O-Mania", R.drawable.feetomania));
        nonTech.add(new Event("Speak UP", R.drawable.speakup));
        nonTech.add(new Event("Picture Interpretation", R.drawable.pictureuntr));

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
        if (id == android.R.id.home) {
            finish();
        }
        if (id == R.id.action_settings) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + "com.app.sreevision.sv16")));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}


