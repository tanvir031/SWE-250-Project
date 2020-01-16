package com.example.oneblood;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Register extends Activity {
    EditText ET_Name,ET_Username,ET_Password,ET_Email,ET_Phone_No,ET_Location,ET_Blood_Group;
    String Name,Username,Password,Email,Phone_No,Location,Blood_group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ET_Name = (EditText)findViewById(R.id.name);
        ET_Username = (EditText) findViewById(R.id.username);
        ET_Password = (EditText) findViewById(R.id.Password);
        ET_Email = (EditText) findViewById(R.id.email);
        ET_Phone_No = (EditText) findViewById(R.id.phone);
        ET_Location = (EditText) findViewById(R.id.location);
        ET_Blood_Group = (EditText) findViewById(R.id.bloodGroup);



    }

    public void userReg(View view)
    {
        Name = ET_Name.getText().toString();
        Username = ET_Username.getText().toString();
        Password = ET_Password.getText().toString();
        Email = ET_Email.getText().toString();
        Phone_No = ET_Phone_No.getText().toString();
        Location = ET_Location.getText().toString();
        Blood_group = ET_Blood_Group.getText().toString();
        String method = "register";
        Database backgroundtask = new Database(this);
        backgroundtask.execute(method,Name,Username,Password,Email,Phone_No,Location,Blood_group);
        finish();
    }
}
