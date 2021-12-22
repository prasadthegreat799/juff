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
import com.nappdeveloper.juff.Adapters.homeFilterResultAdapter;
import com.nappdeveloper.juff.Model.Model;
import com.nappdeveloper.juff.R;

public class filterFoodResultFragment extends Fragment {


    RecyclerView homeFilterResultRecyclerView;
    homeFilterResultAdapter filterResultAdapter;
    DatabaseReference homeFilterResultDatabaseReference;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_filter_food_result, container, false);


        homeFilterResultDatabaseReference = FirebaseDatabase.getInstance().getReference().child("filterFoodList");
        homeFilterResultRecyclerView = (RecyclerView) view.findViewById(R.id.filter_food_result_recyclerView);
        homeFilterResultRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        homeFilterResultRecyclerView.getRecycledViewPool().clear();

        FirebaseRecyclerOptions<Model> Options =
                new FirebaseRecyclerOptions.Builder<Model>()
                        .setQuery(homeFilterResultDatabaseReference, Model.class)
                        .build();

        filterResultAdapter = new homeFilterResultAdapter(Options);
        homeFilterResultRecyclerView.setAdapter(filterResultAdapter);

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