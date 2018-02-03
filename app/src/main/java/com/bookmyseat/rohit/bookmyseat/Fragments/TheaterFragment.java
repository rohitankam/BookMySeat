package com.bookmyseat.rohit.bookmyseat.Fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bookmyseat.rohit.bookmyseat.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TheaterFragment extends android.support.v4.app.Fragment {


    public TheaterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_theater, container, false);
    }

}
