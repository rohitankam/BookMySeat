package com.bookmyseat.rohit.bookmyseat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class location extends AppCompatActivity {


    RecyclerView r1;
    String s1[];
    LocationAdapter la;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        r1=(RecyclerView)findViewById(R.id.recyclerView);
        s1=getResources().getStringArray(R.array.locations);

        la=new LocationAdapter(this,s1);
        r1.setAdapter(la);
        r1.setLayoutManager(new LinearLayoutManager(this));
    }
}
