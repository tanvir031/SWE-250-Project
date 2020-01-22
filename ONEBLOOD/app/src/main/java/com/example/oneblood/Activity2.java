package com.example.oneblood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Activity2 extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    private RelativeLayout donorslist;
    private RelativeLayout donateBlood;
    private CardView cardView1;
    private CardView cardView2;


    String JSON_STRING="";
    String json_string="";


    DrawerLayout drawerLayout1;
    Toolbar toolbar1;
    NavigationView navigationView1;
    ActionBarDrawerToggle toggle1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        donorslist = (RelativeLayout) findViewById(R.id.donatebloodID);
        donateBlood = (RelativeLayout) findViewById(R.id.donatebloodID2);

        donorslist.setOnClickListener(this);
        donateBlood.setOnClickListener(this);

        drawerLayout1 = findViewById(R.id.drawer);
        toolbar1 = findViewById(R.id.toolbar1);
        navigationView1 = findViewById(R.id.navigationview);

        cardView1 = findViewById(R.id.cardview4);
        cardView2 = findViewById(R.id.cardview5);



        setSupportActionBar(toolbar1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toggle1 =new ActionBarDrawerToggle(this,drawerLayout1,toolbar1,R.string.draweropen,R.string.drawerclose);
        drawerLayout1.addDrawerListener(toggle1);
        toggle1.syncState();
        navigationView1.setNavigationItemSelectedListener(this);

        cardView1.startAnimation(AnimationUtils.loadAnimation(this,R.anim.top_animation));
        cardView2.startAnimation(AnimationUtils.loadAnimation(this,R.anim.bottom_animation));



    }



    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.donatebloodID){
            openActivity3();
            overridePendingTransition(R.anim.fadein,R.anim.fadein);

        }
        else if(v.getId()==R.id.donatebloodID2){

            String s1 = (String) getIntent().getExtras().get("login_name");
            //System.out.println(s1);
            if(s1.equals("guest"))
            {
                Intent intent = new Intent(this,Register.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein,R.anim.fadein);
                Toast.makeText(this,"register to be enlisted as blood donor",Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast toast = Toast.makeText(this,"You are already enlisted as blood donor",Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }

    private void openActivity3() {
        Intent intent = new Intent(this,Acitivity3.class);
        String s1 = (String) getIntent().getExtras().get("login_name");
        System.out.println(s1 + " activity2 username");
        intent.putExtra("username",s1);
        startActivity(intent);
        overridePendingTransition(R.anim.fadein,R.anim.fadein);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){

            case R.id.contact_us:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String sharebody = "https://github.com/Dr-thrax/SWE-250-Project";
                intent.putExtra(intent.EXTRA_TEXT,sharebody);
                startActivity(Intent.createChooser(intent,"Share Using"));
                overridePendingTransition(R.anim.fadein,R.anim.fadein);

                break;
            case R.id.about_us:
                Intent intent2 = new Intent(this,About.class);
                startActivity(intent2);
                break;
            case R.id.logoutnow:
                startActivity(new Intent(this,homeactivity.class));
                overridePendingTransition(R.anim.fadein,R.anim.fadein);
                Toast.makeText(Activity2.this, "logged out Succesfully", Toast.LENGTH_SHORT).show();
                break;
            case R.id.exit:
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
                break;
        }
        return false;
    }



}
