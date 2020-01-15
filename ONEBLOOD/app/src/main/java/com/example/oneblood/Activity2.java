package com.example.oneblood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Activity2 extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    private RelativeLayout donorslist;
    private RelativeLayout donateBlood;

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


        setSupportActionBar(toolbar1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toggle1 =new ActionBarDrawerToggle(this,drawerLayout1,toolbar1,R.string.draweropen,R.string.drawerclose);
        drawerLayout1.addDrawerListener(toggle1);
        toggle1.syncState();
        navigationView1.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.donatebloodID){
            openActivity3();
        }
        else if(v.getId()==R.id.donatebloodID2){
            Toast toast = Toast.makeText(this,"Successfully added",Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    private void openActivity3() {
        Intent intent = new Intent(this,Acitivity3.class);
        startActivity(intent);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.profile:
                Toast.makeText(Activity2.this,"We will now open Profile",Toast.LENGTH_SHORT).show();
                break;
            case R.id.contact_us:
                Toast.makeText(Activity2.this,"We will now open contact window",Toast.LENGTH_SHORT).show();
                break;
            case R.id.about_us:
                Toast.makeText(Activity2.this,"about us",Toast.LENGTH_SHORT).show();
                break;
            case R.id.logoutnow:
                Toast.makeText(Activity2.this,"Logging out",Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }
}
