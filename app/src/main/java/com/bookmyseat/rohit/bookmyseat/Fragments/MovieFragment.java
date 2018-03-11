package com.bookmyseat.rohit.bookmyseat.Fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bookmyseat.rohit.bookmyseat.R;

/**
 * A simple {@link Fragment} subclass.
 */
public  class MovieFragment extends android.support.v4.app.Fragment{


    public MovieFragment() {
        // Required empty public constructor
    }

//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_movie);
//
//        FragmentManager fm=getSupportFragmentManager();
//        android.support.v4.app.Fragment frag=fm.findFragmentById(R.id.movie_fragment);
//
//        if(frag==null){
//            frag=createfragment();
//            fm.beginTransaction()
//                    .add(R.id.movie_fragment,frag)
//                    .commit();
//
//        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

}

