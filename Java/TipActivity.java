package com.jiellr.mindmoment;

import android.app.Fragment;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class TipActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    // intent
    Intent tipPage;
    Intent homePage;

    // the side menu
    private DrawerLayout mainLayout;
    private ActionBarDrawerToggle hamburger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip);

        //NAV MENU NAV MENU NAV MENU !!!!
        mainLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        hamburger = new ActionBarDrawerToggle(this, mainLayout, R.string.open, R.string.close);

        mainLayout.addDrawerListener(hamburger);
        hamburger.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //page linking
        NavigationView nv = findViewById(R.id.menu_reference);
        nv.setNavigationItemSelectedListener(this);

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


}
