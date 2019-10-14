package com.example.oneblood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText userName,Password;
    private TextView login;
    private RelativeLayout loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = (RelativeLayout) findViewById(R.id.cd1);
        userName = (EditText) findViewById(R.id.userID);
        Password = (EditText) findViewById(R.id.passID);
        login = (TextView) findViewById(R.id.loginID);

        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.cd1 && userName.getText().toString().equals("admin") && Password.getText().toString().equals("admin")){
                Toast toast = Toast.makeText(MainActivity.this,"Login Attempt Succesful",Toast.LENGTH_SHORT);
                toast.show();

                openActivity2();
        }

        else if(v.getId()==R.id.cd1){
            Toast toast2 = Toast.makeText(MainActivity.this,"Login Attemp Failed",Toast.LENGTH_SHORT);
            toast2.show();
        }
    }

    public void openActivity2(){
        Intent intent = new Intent(this,Activity2.class);
        startActivity(intent);
    }

}
