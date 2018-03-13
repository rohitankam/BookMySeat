package com.bookmyseat.rohit.bookmyseat.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bookmyseat.rohit.bookmyseat.R;
import com.bookmyseat.rohit.bookmyseat.Theater_adapter.TheaterAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class TheaterFragment extends Fragment {


    public TheaterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_theater, container, false);

        RecyclerView recycle=(RecyclerView) view.findViewById(R.id.theater_recycle);


        recycle.setLayoutManager(new LinearLayoutManager(getActivity()));
        TheaterAdapter adapter=new TheaterAdapter(recycle,getActivity());
        recycle.setAdapter(adapter);

//        adapter.setLoadmore(new MovieLoadMore() {
//            @Override
//            public void MovieLoadMore() {
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
