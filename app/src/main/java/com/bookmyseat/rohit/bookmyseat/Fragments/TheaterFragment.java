package com.bookmyseat.rohit.bookmyseat.Fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.bookmyseat.rohit.bookmyseat.R;
import com.bookmyseat.rohit.bookmyseat.theater_adapters.Cards;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TheaterFragment extends android.support.v4.app.Fragment {


    ArrayList<Cards> arrayList=new ArrayList<Cards>();

    String[] name;

    public TheaterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_theater, container, false);

        RecyclerView recycle=(RecyclerView) view.findViewById(R.id.recycle);

        recycle.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerView.Adapter adapter = null;
        recycle.setAdapter(adapter);

//        adapter.setLoadmore(new LoadMore() {
//            @Override
//            public void LoadMore() {
//                if(arrayList.size()<=10){
//                    arrayList.add(null);
//                    adapter.notifyItemInserted(arrayList.size()-1);
//                    new Handler().postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            arrayList.remove(arrayList.size()-1);
//                            adapter.notifyItemRemoved(arrayList.size());
//
//                            int index=arrayList.size();
//                            int end=index+10;
//                            for(int i=index;i<end;i++){
//                                randomdata();
//                            }
//                            adapter.notifyDataSetChanged();
//                            adapter.setLoaded();
//                        }
//                    },5000);
//                }
//                else {
//                    Toast.makeText(Formula.this, "Load data completed. ", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        return view;
    }

}
