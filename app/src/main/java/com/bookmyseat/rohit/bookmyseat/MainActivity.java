package com.bookmyseat.rohit.bookmyseat;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private  boolean backclick=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void signup(View view) {
        Intent i=new Intent(this,SignUPActivity.class);
        startActivity(i);
    }

    public void login(View view) {
        Intent i=new Intent(this,Main2Activity.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        if(!backclick){
            Toast.makeText(this,"Press back again to exit",Toast.LENGTH_SHORT).show();
            backclick=true;
        }
        else {
            super.onBackPressed();
        }

        new CountDownTimer(3000,1000){

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                backclick=false;
            }
        }.start();
    }
}
