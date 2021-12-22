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
import com.nappdeveloper.juff.Adapters.homeFilterFoodAdapter;
import com.nappdeveloper.juff.Adapters.snapsPostAdapter;
import com.nappdeveloper.juff.Model.Model;
import com.nappdeveloper.juff.R;

public class snapsFragment extends Fragment {

    RecyclerView RecyclerView;
    homeFilterFoodAdapter Adapter;
    DatabaseReference DatabaseReference;

    RecyclerView snapsRecyclerView;
    snapsPostAdapter snapsAdapter;
    DatabaseReference snapsDatabaseReference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_snaps, container, false);


        //RecyclerView Code For Food Filters
        DatabaseReference = FirebaseDatabase.getInstance().getReference().child("filterFoodList");
        RecyclerView = (RecyclerView) view.findViewById(R.id.snaps_leader_board_recyclerview);
        RecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        RecyclerView.getRecycledViewPool().clear();


        //RecyclerView Code For Food Filters
        snapsDatabaseReference = FirebaseDatabase.getInstance().getReference().child("filterFoodList");
        snapsRecyclerView = (RecyclerView) view.findViewById(R.id.snaps_post_recyclerview);
        snapsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        snapsRecyclerView.getRecycledViewPool().clear();


        //Firebase Recycler Options for food filters
        FirebaseRecyclerOptions<Model> options =
                new FirebaseRecyclerOptions.Builder<Model>()
                        .setQuery(DatabaseReference, Model.class)
                        .build();
        Adapter = new homeFilterFoodAdapter(options);
        RecyclerView.setAdapter(Adapter);


        //Firebase Recycler Options for food filters
        FirebaseRecyclerOptions<Model> snapsOptions =
                new FirebaseRecyclerOptions.Builder<Model>()
                        .setQuery(snapsDatabaseReference, Model.class)
                        .build();
        snapsAdapter = new snapsPostAdapter(snapsOptions);
        snapsRecyclerView.setAdapter(snapsAdapter);

        return view;
    }

    @Override
    public void onStart() {

        Adapter.startListening();
        snapsAdapter.startListening();
        super.onStart();
    }

    @Override
    public void onStop() {

        Adapter.stopListening();
        snapsAdapter.stopListening();
        super.onStop();
    }
}