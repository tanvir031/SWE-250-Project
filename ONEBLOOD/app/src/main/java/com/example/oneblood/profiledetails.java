package com.example.oneblood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class profiledetails extends AppCompatActivity {

    TextView t1,t2,t3,t4,t5,t6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profiledetails);

        t1 = (TextView) findViewById(R.id.af1);
        t2 = (TextView) findViewById(R.id.af2);
        t3 = (TextView) findViewById(R.id.af3);
        t4 = (TextView) findViewById(R.id.af4);
        t5 = (TextView) findViewById(R.id.af5);
        t6 = (TextView) findViewById(R.id.af6);

        ArrayList<String> profiledetails = (ArrayList<String>) getIntent().getExtras().get("profiledetails");

        if (!profiledetails.isEmpty()) {
            t1.setText("Name: " + profiledetails.get(0));
            t2.setText("Username: " + profiledetails.get(1));
            t3.setText("Mobile: " + profiledetails.get(2));
            t4.setText("Email: " + profiledetails.get(3));
            t5.setText("Location: " + profiledetails.get(4));
            t6.setText("Blood: " + profiledetails.get(5));
        } else {
            t1.setText("Name: ");
            t2.setText("Username: ");
            t3.setText("Mobile: ");
            t4.setText("Email: ");
            t5.setText("Location: ");
            t6.setText("Blood: ");
        }

    }
}
