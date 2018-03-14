package com.bookmyseat.rohit.bookmyseat;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Calendar;

public class DateTime extends AppCompatActivity {
    EditText edt;
    int d,m,y;
    RadioGroup rgrp;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);
        Calendar calend=Calendar.getInstance();

        d= calend.get(Calendar.DAY_OF_MONTH);
        m=calend.get(Calendar.MONTH);
        y=calend.get(Calendar.YEAR);
        edt=(EditText)findViewById(R.id.datetext);
        edt.setShowSoftInputOnFocus(false);

        rgrp=(RadioGroup)findViewById(R.id.timegrp);
        rgrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.r1:
                        Toast.makeText(DateTime.this,"1 clicked",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        fab=(FloatingActionButton)findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DateTime.this,"1 clicked",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(DateTime.this, SeatLayout.class));
                finish();
            }
        });
    }

    public void date(View view) {
        DatePickerDialog pickerdialog=new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        i1++;
                        edt.setText(""+i2+"/"+i1+"/"+i);
                    }
                }, d, m, y);
        pickerdialog.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();//this method does the back task
        Toast.makeText(DateTime.this,"back clicked",Toast.LENGTH_SHORT).show();
    }
}
