package com.example.oneblood;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Acitivity3 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ListView listView;
    private String[] blood;
    private String[] mobile;
    private String[] countrynames;

    DrawerLayout drawerLayout2;
    Toolbar toolbar2;
    NavigationView navigationView2;
    ActionBarDrawerToggle toggle2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acitivity3);

        countrynames = getResources().getStringArray(R.array.Country_Names);
        blood = getResources().getStringArray(R.array.blood);
        mobile = getResources().getStringArray(R.array.mobile);

        listView = (ListView) findViewById(R.id.listviewID);

        CustomAdapter adapter = new CustomAdapter(this,countrynames,mobile,blood);

        listView.setAdapter(adapter);


        drawerLayout2 = findViewById(R.id.drawer2);
        toolbar2 = findViewById(R.id.toolbar2);
        navigationView2 = findViewById(R.id.navigationview2);
        navigationView2.bringToFront();

        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle2 = new ActionBarDrawerToggle(this,drawerLayout2,toolbar2,R.string.draweropen,R.string.drawerclose);
        drawerLayout2.addDrawerListener(toggle2);
        toggle2.syncState();
        navigationView2.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.profile2:
                Toast.makeText(Acitivity3.this, "Profile Selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.contact_us2:
                Toast.makeText(Acitivity3.this, "Contact us Selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.about_us2:
                Toast.makeText(Acitivity3.this, "About us Selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.logoutnow2:
                Toast.makeText(Acitivity3.this, "Logout Selected", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return false;
    }
}

