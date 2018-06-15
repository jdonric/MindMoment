package com.jiellr.mindmoment;

import android.app.Fragment;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.drawable.TransitionDrawable;
import android.media.MediaDataSource;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.transition.Transition;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Variable for Nav Bar Toggle
    private DrawerLayout mainLayout;
    private ActionBarDrawerToggle hamburger;



            //Variable for page intent
    Intent tipPage;
    Intent homePage;




    //ONCREATE
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //NAV MENU NAV MENU NAV MENU !!!!
        mainLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
          hamburger = new ActionBarDrawerToggle(this, mainLayout, R.string.open, R.string.close);

          mainLayout.addDrawerListener(hamburger);
          hamburger.syncState();

          getSupportActionBar().setDisplayHomeAsUpEnabled(true);

          //page linking
          NavigationView nv = findViewById(R.id.menu_reference);
          nv.setNavigationItemSelectedListener(this);



        //MUSIC PLAY MUSIC PLAY MUSIC PLAY BELOW!!!!!!

                //buttons
                 Button awakenButton = (Button) findViewById(R.id.awaken_1);
                 Button concentrateButton = (Button) findViewById(R.id.concentrate_1);
                 Button relaxButton = (Button) findViewById(R.id.relax_1);
                Button reflectButton = (Button) findViewById(R.id.reflect_1);
                Button relieveButton = (Button) findViewById(R.id.relieve_1);

                //media
                final MediaPlayer awakenMP = MediaPlayer.create(this, R.raw.awaken_m);
                final MediaPlayer concentrateMP = MediaPlayer.create(this, R.raw.concentrate_m);
                final MediaPlayer relaxMP = MediaPlayer.create(this, R.raw.relax_m);
                final MediaPlayer reflectMP = MediaPlayer.create(this, R.raw.reflect_m);
                final MediaPlayer relieveMP = MediaPlayer.create(this, R.raw.relieve_m);

                //pause and reset button
                Button p = findViewById(R.id.pause);
                Button r = findViewById(R.id.reset);



    //Onclicklistener -PLAY
        //playing relax
        relieveButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                relieveMP.start();
                Toast toast1 = Toast.makeText(getApplicationContext(), "Relieve - 10:14" ,Toast.LENGTH_SHORT);
                toast1.show();
            }

        });

        //playing reflect
        reflectButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                reflectMP.start();
                Toast toast1 = Toast.makeText(getApplicationContext(), "Reflect - 4:48" ,Toast.LENGTH_SHORT);
                toast1.show();
            }
        });

        //playing immerse
        relaxButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                relaxMP.start();
                Toast toast1 = Toast.makeText(getApplicationContext(), "Relax - 15:08" ,Toast.LENGTH_SHORT);
                toast1.show();
            }
        });

        //playing awaken
        concentrateButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                concentrateMP.start();
                Toast toast1 = Toast.makeText(getApplicationContext(), "Concentrate - 8:04" ,Toast.LENGTH_SHORT);
                toast1.show();
            }
        });

        //play focus
        awakenButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                awakenMP.start();
                Toast toast1 = Toast.makeText(getApplicationContext(), "Awaken - 15:11" ,Toast.LENGTH_SHORT);
                toast1.show();
            }
        });

   //Onclicklistener - PAUSE

        p.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(relieveMP.isPlaying()) {
                    relieveMP.pause();
                }
                else if (reflectMP.isPlaying()) {
                    reflectMP.pause();
                }
                else if(relaxMP.isPlaying()) {
                    relaxMP.pause();
                }
                else if (concentrateMP.isPlaying())  {
                    concentrateMP.pause();
                }
                else if(awakenMP.isPlaying()) {
                    awakenMP.pause();
                }else
                 {
                    relieveMP.stop();
                    reflectMP.stop();
                    concentrateMP.stop();
                    relaxMP.stop();
                    awakenMP.stop();

                }
            }
        });

    //Onclicklistener - RESET

        r.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                relaxMP.reset();
                reflectMP.reset();
                concentrateMP.reset();
                relaxMP.reset();
                awakenMP.reset();
            }
        });

    }


    // NAV BAR NAV BAR NAV BAR CONT'D !!!
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (hamburger.onOptionsItemSelected(item)) {
            return true;

        }
          return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        tipPage = new Intent (this, TipActivity.class);
        homePage = new Intent (this, MainActivity.class);

        if(id == R.id.nav_tip) {
            startActivity(tipPage);
        }

        if(id == R.id.nav_home) {
            startActivity(homePage);
        }

        return true;
    }



//end bracket
}

       





