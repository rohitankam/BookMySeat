package com.bookmyseat.rohit.bookmyseat;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.bookmyseat.rohit.bookmyseat.Fragments.AboutFragment;
import com.bookmyseat.rohit.bookmyseat.Fragments.MovieFragment;
import com.bookmyseat.rohit.bookmyseat.Fragments.TheaterFragment;
import com.bookmyseat.rohit.bookmyseat.location_adapter.location;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener , AHBottomNavigation.OnTabSelectedListener {

    RecyclerView r1;
    AHBottomNavigation bottomnavigation;
    CardView card;

//    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            FragmentTransaction trans=getSupportFragmentManager().beginTransaction();
//            switch (item.getItemId()) {
//                case R.id.movies:
//                    trans.replace(R.id.frame,new MovieFragment()).commit();
//                    return true;
//                case R.id.theaters:
//                    trans.replace(R.id.frame,new TheaterFragment()).commit();
//                    return true;
//                case R.id.about:
//                    trans.replace(R.id.frame,new AboutFragment()).commit();
//                    return true;
//            }
//            return false;
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        bottomnavigation = (AHBottomNavigation) findViewById(R.id.navigation);
        this.bottomicons();
        bottomnavigation.setOnTabSelectedListener(this);


        FragmentTransaction trans=getSupportFragmentManager().beginTransaction();
        trans.replace(R.id.frame,new MovieFragment()).commit();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }


    public void input(View view) {
        startActivity(new Intent(this,DateTime.class));
    }

    @Override
    public void onTabSelected(int position, boolean wasSelected) {
        if(position==0){
            MovieFragment movie=new MovieFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.frame,movie).commit();
        }else  if(position==1){
            TheaterFragment theater=new TheaterFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.frame,theater).commit();
        }else  if(position==2){
            AboutFragment about=new AboutFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.frame,about).commit();
        }
    }


    public void bottomicons(){
        AHBottomNavigationItem movie=new AHBottomNavigationItem("movie",R.drawable.movies);
        AHBottomNavigationItem theater=new AHBottomNavigationItem("theater",R.drawable.theaters);
        AHBottomNavigationItem about=new AHBottomNavigationItem("about",R.drawable.about);

        bottomnavigation.addItem(movie);
        bottomnavigation.addItem(theater);
        bottomnavigation.addItem(about);

        bottomnavigation.setCurrentItem(0);
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.location) {
            Intent i =new Intent(Main2Activity.this,location.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}
