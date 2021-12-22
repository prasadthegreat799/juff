package com.nappdeveloper.juff.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.nappdeveloper.juff.Adapters.homeFilterResultAdapter;
import com.nappdeveloper.juff.Adapters.restaurantsFilterResultAdapter;
import com.nappdeveloper.juff.Model.Model;
import com.nappdeveloper.juff.R;

public class restaurantsFilterFoodResultFragment extends Fragment {


    RecyclerView FilterResultRecyclerView;
    restaurantsFilterResultAdapter filterResultAdapter;
    DatabaseReference FilterResultDatabaseReference;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_restaurants_filter_food_result, container, false);


        FilterResultDatabaseReference = FirebaseDatabase.getInstance().getReference().child("filterFoodList");
        FilterResultRecyclerView = (RecyclerView) view.findViewById(R.id.restaurant_filter_food_result_recyclerView);
        FilterResultRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        FilterResultRecyclerView.getRecycledViewPool().clear();

        FirebaseRecyclerOptions<Model> Options =
                new FirebaseRecyclerOptions.Builder<Model>()
                        .setQuery(FilterResultDatabaseReference, Model.class)
                        .build();

        filterResultAdapter = new restaurantsFilterResultAdapter(Options);
        FilterResultRecyclerView.setAdapter(filterResultAdapter);

       return view;
    }


    @Override
    public void onStart() {

        filterResultAdapter.startListening();
        super.onStart();
    }

    @Override
    public void onStop() {

        filterResultAdapter.startListening();
        super.onStop();
    }
}