package com.bookmyseat.rohit.bookmyseat.location_adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bookmyseat.rohit.bookmyseat.Main2Activity;
import com.bookmyseat.rohit.bookmyseat.R;

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
        return new LocationHolder(v,ct);
    }

    @Override
    public void onBindViewHolder(LocationHolder holder, int position) {
        holder.txt1.setText(t1[position]);
    }


    @Override
    public int getItemCount() {
        return t1.length;
    }



    public class LocationHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final Context ct;
        TextView txt1;
        public LocationHolder(View itemView,Context ctx) {

            super(itemView);
            itemView.setOnClickListener(this);
            this.ct=ctx;
            txt1=(TextView)itemView.findViewById(R.id.loc_txt);

        }

        @Override
        public void onClick(View view) {
            Intent i=new Intent(ct,Main2Activity.class);
            this.ct.startActivity(i);
        }
    }


}
