package com.example.oneblood;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Acitivity3 extends AppCompatActivity {

    private ListView listView;
    private String[] blood;
    private String[] mobile;
    private String[] countrynames;

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


    }

}

