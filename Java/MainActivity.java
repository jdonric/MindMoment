package com.jiellr.mindmoment;

import android.graphics.drawable.TransitionDrawable;
import android.media.MediaDataSource;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {


    //ONCREATE
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

                //buttons
                 Button blue = (Button) findViewById(R.id.rest);
                 Button teal = (Button) findViewById(R.id.reflect);
                 Button orange = (Button) findViewById(R.id.emmerse);
                Button gold = (Button) findViewById(R.id.awaken);


                //media
                final MediaPlayer reflect1 = MediaPlayer.create(this, R.raw.reflect);
                final MediaPlayer awaken1 = MediaPlayer.create(this, R.raw.awaken);
                final MediaPlayer rest1 = MediaPlayer.create(this, R.raw.relax);
                final MediaPlayer emmerse1 = MediaPlayer.create(this, R.raw.emmerse);

                //pause and reset button
                Button p = findViewById(R.id.pause);
                Button r = findViewById(R.id.reset);



    //ONCLICKLISTENER -PLAY
        //playing relax
        blue.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                rest1.start();
            }

        });

        //playing reflect
        teal.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                reflect1.start();
            }
        });

        //playing immerse
        orange.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                emmerse1.start();
            }
        });

        //playing awaken
        gold.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                awaken1.start();
            }
        });

   //ONCLICKLISTENER - PAUSE

        p.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rest1.isPlaying()) {
                    rest1.pause();
                }
                else if (reflect1.isPlaying()) {
                    reflect1.pause();
                }
                else if(emmerse1.isPlaying()) {
                    emmerse1.pause();
                }
                else if (awaken1.isPlaying())  {
                    awaken1.pause();
                }else {
                    rest1.stop();
                    reflect1.stop();
                    emmerse1.stop();
                    awaken1.stop();

                }
            }
        });

    //ONCLICKLISTENER - RESET

        r.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                rest1.reset();
                reflect1.reset();
                emmerse1.reset();
                awaken1.reset();
            }
        });

    }





//end bracket
}





