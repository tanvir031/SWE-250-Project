package com.example.oneblood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class About extends AppCompatActivity {

    ImageView imageView1,imageView2;
    TextView textView1,textView2,textView3,textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        imageView1 = findViewById(R.id.imageview1);
        imageView2 = findViewById(R.id.imageView2);

        textView1 = findViewById(R.id.textview1);
        textView2 = findViewById(R.id.textview2);
        textView3 = findViewById(R.id.textview3);
        textView4 = findViewById(R.id.textview4);

        imageView1.startAnimation(AnimationUtils.loadAnimation(this,R.anim.fadein));
        imageView2.startAnimation(AnimationUtils.loadAnimation(this,R.anim.fadein));

        textView1.startAnimation(AnimationUtils.loadAnimation(this,R.anim.bounce));
        textView2.startAnimation(AnimationUtils.loadAnimation(this,R.anim.bounce));
        textView3.startAnimation(AnimationUtils.loadAnimation(this,R.anim.bounce));
        textView4.startAnimation(AnimationUtils.loadAnimation(this,R.anim.bounce));
    }
}
