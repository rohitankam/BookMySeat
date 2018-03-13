package com.bookmyseat.rohit.bookmyseat.Movie_adapter;

/**
 * Created by ROHiT on 09-Mar-18.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bookmyseat.rohit.bookmyseat.DateTime;
import com.bookmyseat.rohit.bookmyseat.R;





public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ItemViewHolder> {
    private int View_Item = 0, View_Load = 1;
    MovieLoadMore loadmore;
    boolean isLoading;
    Activity activity;
    int visiblethresold = 0, lastvisible, totalitem;
    RecyclerView recyc;
    Context c;


    public MovieAdapter(Context ct, RecyclerView rec, Activity activity) {
        this.activity = activity;
        this.c = ct;
        this.recyc = rec;
        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyc.getLayoutManager();
        recyc.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                totalitem = linearLayoutManager.getItemCount();
                lastvisible = linearLayoutManager.findLastVisibleItemPosition();
                if (!isLoading && totalitem <= (lastvisible + visiblethresold)) {
                    if (loadmore != null) {
                        loadmore.LoadMore();
                    }
                    isLoading = true;
                }
            }
        });
    }


    public void setLoadmore(MovieLoadMore loadmore) {
        this.loadmore = loadmore;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_card, parent, false);
        ItemViewHolder holder = new ItemViewHolder(v);
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("faf", "faf");
                parent.getContext().startActivity(new Intent(parent.getContext(), DateTime.class));
            }

        });
        return holder;
    }

    @Override
    public void onBindViewHolder(final MovieAdapter.ItemViewHolder holder, final int position) {
        holder.name.setText(MovieData.name[position]);
        holder.img.setImageResource(MovieData.img[position]);


    }


    @Override
    public int getItemCount() {
        return MovieData.name.length;
    }


    public void setLoaded() {
        isLoading = false;
    }




    public class ItemViewHolder extends RecyclerView.ViewHolder  {

        public TextView name;
        public ImageView img;
        public Context ct;
        public CardView card;

        public ItemViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.th_text);
            img = (ImageView) itemView.findViewById(R.id.th_img);
            card = (CardView) itemView.findViewById(R.id.movie_card);
        }





    }
}




