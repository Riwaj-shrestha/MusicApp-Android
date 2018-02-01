package com.example.riwaj.musicapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {
MediaPlayer playerN, playerNH, playerNN,playerNNS, playerNNN;
DrawerLayout drawerLayout;
Toolbar toolbar;
FragmentTransaction ft;
NavigationView navigationView;
ActionBarDrawerToggle actionBarDrawerToggle;

RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawerlayout);
        drawerLayout = findViewById(R.id.drawerlayoutid);
        navigationView = findViewById(R.id.navid);
        toolbar=findViewById(R.id.toolbarid);

        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerView);


        actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this,drawerLayout, toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ft=getSupportFragmentManager().beginTransaction();
        ft.add(R.id.framelayout,new HomeFragment());
        ft.commit();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.drawer_home:
                        ft=getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.framelayout, new HomeFragment());
                        ft.commit();
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.drawer_aboutus:
                        ft=getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.framelayout, new AboutUsFragment());
                        ft.commit();
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.drawer_tuto:
                        Intent You = new Intent(Intent.ACTION_VIEW);
                        You.setData(Uri.parse("vnd.youtube://www.youtube.com/watch?v=egTNhyu-yFQ"));
                        startActivity(You);
                        break;

//                        ft=getSupportFragmentManager().beginTransaction();
//                        ft.replace(R.id.framelayout, new TutoFragment());
//                        ft.commit();
//                        drawerLayout.closeDrawers();
//                        break;

                }
                return false;
            }
        });




        playerN =MediaPlayer.create(MainActivity.this, R.raw.hat);
        playerNH =MediaPlayer.create(MainActivity.this, R.raw.hat);
        playerNN =MediaPlayer.create(MainActivity.this, R.raw.snr);
        playerNNS =MediaPlayer.create(MainActivity.this, R.raw.snare);
        playerNNN =MediaPlayer.create(MainActivity.this, R.raw.kick);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void hat1(View view){
        playerN.start();
    }
    public void hat2(View view){
        playerNH.start();
    }
    public void snare1(View view){
        playerNN.start();
    }
    public void snare2(View view){
        playerNNS.start();
    }
    public void kick(View view){
        playerNNN.start();
    }
}
