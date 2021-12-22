package com.nappdeveloper.juff.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.nappdeveloper.juff.Adapters.homeFilterFoodAdapter;
import com.nappdeveloper.juff.Adapters.restaurantsImageFilterAdapter;
import com.nappdeveloper.juff.Adapters.restaurantsTextFilterAdapter;
import com.nappdeveloper.juff.Model.Model;
import com.nappdeveloper.juff.R;

public class restaurantsFragment extends Fragment {

    RecyclerView imgFilterRecyclerView;
    restaurantsImageFilterAdapter imgFilterAdapter;
    DatabaseReference imgFilterDatabaseReference;


    RecyclerView txtFilterRecyclerView;
    restaurantsTextFilterAdapter txtFilterAdapter;
    DatabaseReference txtFilterDatabaseReference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_restaurants, container, false);


        //RecyclerView Code For Food image Filters
        imgFilterDatabaseReference = FirebaseDatabase.getInstance().getReference().child("filterFoodList");
        imgFilterRecyclerView = (RecyclerView) view.findViewById(R.id.restaurants_Image_filter_recyclerView);
        imgFilterRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        imgFilterRecyclerView.getRecycledViewPool().clear();


        //RecyclerView Code For Food text Filters
        txtFilterDatabaseReference = FirebaseDatabase.getInstance().getReference().child("filterFoodList");
        txtFilterRecyclerView = (RecyclerView) view.findViewById(R.id.restaurants_text_filter_recyclerView);
        txtFilterRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        txtFilterRecyclerView.getRecycledViewPool().clear();


        //Fragment to show the results of food filters
        Fragment fragment = new restaurantsFilterFoodResultFragment();
        FragmentManager fragmentManager = ((FragmentActivity) view.getContext()).getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.restaurant_filter_food_result_layout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


        //Firebase Recycler Options for food filters
        FirebaseRecyclerOptions<Model> options =
                new FirebaseRecyclerOptions.Builder<Model>()
                        .setQuery(imgFilterDatabaseReference, Model.class)
                        .build();
        imgFilterAdapter = new restaurantsImageFilterAdapter(options);
        imgFilterRecyclerView.setAdapter(imgFilterAdapter);


        //Firebase Recycler Options for food filters
        FirebaseRecyclerOptions<Model> txtOptions =
                new FirebaseRecyclerOptions.Builder<Model>()
                        .setQuery(txtFilterDatabaseReference, Model.class)
                        .build();
        txtFilterAdapter = new restaurantsTextFilterAdapter(txtOptions);
        txtFilterRecyclerView.setAdapter(txtFilterAdapter);

        return view;
    }

    @Override
    public void onStart() {

        imgFilterAdapter.startListening();
        txtFilterAdapter.startListening();
        super.onStart();
    }

    @Override
    public void onStop() {

        imgFilterAdapter.startListening();
        txtFilterAdapter.stopListening();
        super.onStop();
    }
}