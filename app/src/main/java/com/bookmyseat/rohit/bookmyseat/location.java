package com.bookmyseat.rohit.bookmyseat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class location extends AppCompatActivity {


    //asdfghjkl;
    RecyclerView r1;
    String s1[],s2[];
    int image[]={R.drawable.bahubali,R.drawable.tiger,R.drawable.conjuring};
    LocationAdapter la;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);



        r1=(RecyclerView)findViewById(R.id.recyclerView);
        s1=getResources().getStringArray(R.array.movie_name);
        s2=getResources().getStringArray(R.array.movie_descp);

        la=new LocationAdapter(this,s1,s2,image);
    }
}
