package com.bookmyseat.rohit.bookmyseat;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ROHiT on 26-Jan-18.
 */

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.LocationHolder> {

    String t1[],t2[];
    int img[];
    Context ct;

    public LocationAdapter(Context c,String s1[],String s2[],int i1[]){
        ct=c;
        t1=s1;
        t2=s2;
        img=i1;
    }



    @Override
    public LocationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflat =LayoutInflater.from(ct);
        View myView=inflat.inflate(R.layout.location_row,parent,false);
        return new LocationHolder(myView);
    }

    @Override
    public void onBindViewHolder(LocationHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 0;
    }



    public class LocationHolder extends RecyclerView.ViewHolder {
        TextView t1,t2;
        ImageView i1;
        public LocationHolder(View itemView) {
            super(itemView);

            t1=(TextView)itemView(R.id.textView4);
            t1=(TextView)itemView(R.id.textView5);
        }
    }
}
