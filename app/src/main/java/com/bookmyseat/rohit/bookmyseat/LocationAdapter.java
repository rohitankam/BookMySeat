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

    String t1[];
    Context ct;

    public LocationAdapter(Context c,String s1[]){
        ct=c;
        t1=s1;
    }


    @Override
    public LocationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflate=LayoutInflater.from(ct);
        View v=inflate.inflate(R.layout.location_list,parent,false);
        return new LocationHolder(v);
    }

    @Override
    public void onBindViewHolder(LocationHolder holder, int position) {
        holder.txt1.setText(t1[position]);
    }


    @Override
    public int getItemCount() {
        return t1.length;
    }



    public class LocationHolder extends RecyclerView.ViewHolder {
        TextView txt1;
        public LocationHolder(View itemView) {
            super(itemView);
            txt1=(TextView)itemView.findViewById(R.id.loc_txt);

        }
    }


}
