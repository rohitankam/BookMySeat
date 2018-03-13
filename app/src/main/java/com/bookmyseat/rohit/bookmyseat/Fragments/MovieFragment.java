package com.bookmyseat.rohit.bookmyseat.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bookmyseat.rohit.bookmyseat.Movie_adapter.MovieAdapter;
import com.bookmyseat.rohit.bookmyseat.R;

/**
 * A simple {@link Fragment} subclass.
 */
public  class MovieFragment extends android.support.v4.app.Fragment {
    Context c;

    public MovieFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_movie, container, false);
        RecyclerView recycle= view.findViewById(R.id.movie_recycle);


        recycle.setLayoutManager(new LinearLayoutManager(getActivity()));
        MovieAdapter adapter=new MovieAdapter(c,recycle,getActivity());
        recycle.setAdapter(adapter);


        return  view;
    }



}

