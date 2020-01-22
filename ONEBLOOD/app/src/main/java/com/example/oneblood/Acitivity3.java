package com.example.oneblood;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.Manifest.permission;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

public class Acitivity3 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;

    ListView listView;
    ArrayList<String> blood = new ArrayList<>();
    ArrayList<String> mobile = new ArrayList<>();
    ArrayList<String> countrynames = new ArrayList<>();

    ArrayList<String> username = new ArrayList<>();
    ArrayList<String> Name = new ArrayList<>();
    ArrayList<String> email = new ArrayList<>();

    DrawerLayout drawerLayout2;
    Toolbar toolbar2;
    NavigationView navigationView2;
    ActionBarDrawerToggle toggle2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acitivity3);

        loadJsonArray();
        loadJsonUserInformation();

        // json_string = getIntent().getExtras().getString("json_data");


        listView = (ListView) findViewById(R.id.listviewID);

        CustomAdapter adapter = new CustomAdapter(this, countrynames, mobile, blood);


        listView.setAdapter(adapter);
        
        listView.startAnimation(AnimationUtils.loadAnimation(this,R.anim.bounce));
        drawerLayout2 = findViewById(R.id.drawer2);
        toolbar2 = findViewById(R.id.toolbar2);
        navigationView2 = findViewById(R.id.navigationview2);
        navigationView2.bringToFront();

        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle2 = new ActionBarDrawerToggle(this, drawerLayout2, toolbar2, R.string.draweropen, R.string.drawerclose);
        drawerLayout2.addDrawerListener(toggle2);
        toggle2.syncState();
        navigationView2.setNavigationItemSelectedListener(this);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                Toast.makeText(Acitivity3.this, mobile.get(position), Toast.LENGTH_SHORT).show();

                AlertDialog.Builder builder = new AlertDialog.Builder(Acitivity3.this);
                builder.setMessage("What do you want to do?")
                        .setCancelable(true)
                        .setPositiveButton("CALL USER", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(Intent.ACTION_CALL);
                                String s = "tel:" + mobile.get(position);
                                intent.setData(Uri.parse(s));
                                if (ActivityCompat.checkSelfPermission(Acitivity3.this,Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                                    return;
                                }
                                startActivity(intent);
                                overridePendingTransition(R.anim.fadein,R.anim.fadein);
                            }
                        })
                        .setNegativeButton("See Profile", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ArrayList<String> profiledetails = new ArrayList<>();
                                profiledetails.add(Name.get(position));
                                profiledetails.add(username.get(position));
                                profiledetails.add(mobile.get(position));
                                profiledetails.add(email.get(position));
                                profiledetails.add(countrynames.get(position));
                                profiledetails.add(blood.get(position));

                                Intent intent2 = new Intent(Acitivity3.this,profiledetails.class);
                                intent2.putExtra("profiledetails",profiledetails);
                                startActivity(intent2);
                                overridePendingTransition(R.anim.fadein,R.anim.fadein);

                            }
                        });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();






            }
        });

    }

    private void loadJsonArray(){
        jsonArray=Dbcontract.getUSER_INFO_JSONarry();
    }
    private void loadJsonUserInformation(){
        JSONObject jo=null;

        try {
            for(int i=0;i<jsonArray.length();i++){

                jo=jsonArray.getJSONObject(i);
                if(jo==null) {
                    break;

                }

                blood.add(jo.getString("blood_group"));
                mobile.add(jo.getString("phone"));
                countrynames.add(jo.getString("location"));
                username.add(jo.getString("user_name"));
                email.add(jo.getString("email"));
                Name.add(jo.getString("name"));

//                blood[i] =jo.getString("blood_group");
  //              mobile[i] =jo.getString("phone");
    //            countrynames[i] =jo.getString("location");
                System.out.println(jo.getString("blood_group"));
//                System.out.println(mobile[i]);
            }



            /*JSONObject jo=new JSONObject(json_string);

            for(int i=0;i<jo.length();i++){
                blood[i] = "A+";
                mobile[i] = "hello";
                countrynames[i] = "hello";
            }*/

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        //loadJsonUserInformation();


        int positionofuser = -1;
        String s2="";

        if(!Objects.requireNonNull(getIntent().getExtras()).isEmpty())
        {
            s2 = (String) getIntent().getExtras().get("username");
        }

        for(int i=0;i<username.size();i++)
        {
            String s3 = username.get(i);
            if(s3.equals(s2))
            {
                positionofuser = i;
                break;
            }
        }


        switch (menuItem.getItemId()){
            case R.id.profile2:
                //Toast.makeText(Acitivity3.this, "Profile Selected", Toast.LENGTH_SHORT).show();
                if(positionofuser!=-1)
                {
                    int p = positionofuser;
                    ArrayList<String>allinformation=new ArrayList<>();
                    allinformation.add(Name.get(p));
                    allinformation.add(username.get(p));
                    allinformation.add(mobile.get(p));
                    allinformation.add(email.get(p));
                    allinformation.add(countrynames.get(p));
                    allinformation.add(blood.get(p));

                    Intent intent = new Intent(this,Profile.class);
                    intent.putExtra("allinformation",allinformation);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fadein,R.anim.fadein);
                }
                System.out.println(s2 + "username");
                break;
            case R.id.contact_us2:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String sharebody = "https://github.com/Dr-thrax/SWE-250-Project";
                intent.putExtra(intent.EXTRA_TEXT,sharebody);
                startActivity(Intent.createChooser(intent,"Share Using"));
                overridePendingTransition(R.anim.fadein,R.anim.fadein);
                break;
            case R.id.about_us2:
                Intent intent2 = new Intent(this,About.class);
                startActivity(intent2);
                break;
            case R.id.logoutnow2:
                startActivity(new Intent(this,homeactivity.class));
                overridePendingTransition(R.anim.fadein,R.anim.fadein);
                Toast.makeText(Acitivity3.this, "logged out Succesfully", Toast.LENGTH_SHORT).show();
                break;
            case R.id.exit2:
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            default:
                break;
        }
        return false;
    }
}

