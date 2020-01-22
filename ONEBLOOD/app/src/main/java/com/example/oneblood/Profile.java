package com.example.oneblood;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

public class Profile extends AppCompatActivity {

    TextView t1,t2,t3,t4,t5,t6;

    /*@Override
    public void onBackPressed() {

        Intent intent = new Intent(this,Acitivity3.class);
        startActivity(intent);
    }*/

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        t1 = (TextView) findViewById(R.id.pf1);
        t2= (TextView)findViewById(R.id.pf2);
        t3= (TextView)findViewById(R.id.pf3);
        t4= (TextView)findViewById(R.id.pf4);
        t5= (TextView)findViewById(R.id.pf5);
        t6= (TextView)findViewById(R.id.pf6);

        ArrayList<String> allinformation = new ArrayList<>();
        if(!Objects.requireNonNull(getIntent().getExtras()).isEmpty())
        {
            allinformation = (ArrayList<String>) getIntent().getExtras().get("allinformation");
        }

        if(!Objects.requireNonNull(allinformation).isEmpty())
        {
            t1.setText("Name: " + allinformation.get(0));
            t2.setText("Username: " + allinformation.get(1));
            t3.setText("Mobile: " + allinformation.get(2));
            t4.setText("Email: " + allinformation.get(3));
            t5.setText("Location: " + allinformation.get(4));
            t6.setText("Blood: " + allinformation.get(5));
        }




    }
}
