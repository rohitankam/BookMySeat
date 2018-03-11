package com.bookmyseat.rohit.bookmyseat.Theater_adapter;

/**
 * Created by ROHiT on 09-Mar-18.
 */

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bookmyseat.rohit.bookmyseat.R;

import java.util.ArrayList;


class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView name;
    public ImageView img;
    public ItemViewHolder(View itemView) {
        super(itemView);
        name=(TextView)itemView.findViewById(R.id.th_text);
        img=(ImageView)itemView.findViewById(R.id.th_img);
        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

    }

}

public class TheaterAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private int View_Item=0,View_Load=1;
    TheaterLoadMore loadmore;
    boolean isLoading;
    Activity activity;
    int visiblethresold=0,lastvisible,totalitem;

    String[] theater_name;



    public TheaterAdapter(RecyclerView recyclerView,Activity activity) {
        this.activity=activity;
        final LinearLayoutManager linearLayoutManager=(LinearLayoutManager)recyclerView.getLayoutManager();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                totalitem=linearLayoutManager.getItemCount();
                lastvisible=linearLayoutManager.findLastVisibleItemPosition();
                if(!isLoading && totalitem<=(lastvisible+visiblethresold))
                {
                    if(loadmore!=null){
                        loadmore.LoadMore();
                    }
                    isLoading=true;
                }
            }
        });
    }



    public void setLoadmore(TheaterLoadMore loadmore) {
        this.loadmore = loadmore;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==View_Item)
        {
            View v= LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.theater_card,parent,false);
            return new ItemViewHolder(v);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ItemViewHolder)holder).name.setText(TheaterData.name[position]);
        ((ItemViewHolder)holder).img.setImageResource(TheaterData.img[position]);
    }

    @Override
    public int getItemCount() {
        return TheaterData.name.length;
    }


    public void setLoaded() {
        isLoading = false;
    }
}
