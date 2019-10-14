package com.example.oneblood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout donorslist;
    private RelativeLayout donateBlood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        donorslist = (RelativeLayout) findViewById(R.id.donatebloodID);
        donateBlood = (RelativeLayout) findViewById(R.id.donatebloodID2);

        donorslist.setOnClickListener(this);
        donateBlood.setOnClickListener(this);
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
}
