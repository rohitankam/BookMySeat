package com.bookmyseat.rohit.bookmyseat.theater_adapters;

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
import java.util.List;


class ItemViewHolder extends RecyclerView.ViewHolder{

    public TextView name;
    public ImageView img;
    public ItemViewHolder(View itemView) {
        super(itemView);
        name=(TextView)itemView.findViewById(R.id.th_text);
        img=(ImageView)itemView.findViewById(R.id.th_img);

    }
}
public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private int View_Item=0,View_Load=1;
    LoadMore loadmore;
    boolean isLoading;
    Activity activity;
    ArrayList<Cards> items=new ArrayList<Cards>();
    int visiblethresold=0,lastvisible,totalitem;

    public Adapter(RecyclerView recyclerView,Activity activity, ArrayList<Cards> items) {
        this.activity = activity;
        this.items = items;
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

    @Override
    public int getItemViewType(int position) {
        return items.get(position)==null?View_Load:View_Item;
    }

    public void setLoadmore(LoadMore loadmore) {
        this.loadmore = loadmore;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==View_Item)
        {
            View v= LayoutInflater.from(activity)
                    .inflate(R.layout.theater_card,parent,false);
            return new ItemViewHolder(v);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ItemViewHolder){
            Cards c=items.get(position);
            ItemViewHolder itemviewholder=(ItemViewHolder)holder;
            itemviewholder.name.setText(items.get(position).getName());
            itemviewholder.img.setImageResource(items.get(position).getImg());
        }


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setLoaded() {
        isLoading = false;
    }
}
