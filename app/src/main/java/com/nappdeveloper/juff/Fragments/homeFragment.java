package com.nappdeveloper.juff.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.nappdeveloper.juff.Activity.foodPlannerActivity;
import com.nappdeveloper.juff.Adapters.homeFilterFoodAdapter;
import com.nappdeveloper.juff.Adapters.homePreDineInsAdapter;
import com.nappdeveloper.juff.Adapters.homeTopOffersAdapter;
import com.nappdeveloper.juff.Model.Model;
import com.nappdeveloper.juff.R;

public class homeFragment extends Fragment {


    RecyclerView filterRecyclerView;
    homeFilterFoodAdapter filterAdapter;
    DatabaseReference filterDatabaseReference;


    RecyclerView topOffersRecyclerView;
    homeTopOffersAdapter topOffersAdapter;
    DatabaseReference topOffersDatabaseRef;


    RecyclerView dineInRecyclerView;
    homePreDineInsAdapter dineInsAdapter;
    DatabaseReference dineInDatabaseRef;


    CardView foodPlannerCard;
    TextView foodPlannerTxt;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_home, container, false);


       foodPlannerCard=(CardView) view.findViewById(R.id.food_planner_card);
       foodPlannerTxt=(TextView) view.findViewById(R.id.food_planner_txt);

       foodPlannerTxt.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               foodPlanner(v);
           }
       });

       foodPlannerCard.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               foodPlanner(v);
           }
       });


        //RecyclerView Code For Food Filters
        filterDatabaseReference = FirebaseDatabase.getInstance().getReference().child("filterFoodList");
        filterRecyclerView = (RecyclerView) view.findViewById(R.id.filter_food_recyclerView);
        filterRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        filterRecyclerView.getRecycledViewPool().clear();


        //Fragment to show the results of food filters
        Fragment fragment = new filterFoodResultFragment();
        FragmentManager fragmentManager = ((FragmentActivity) view.getContext()).getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.filter_food_result_layout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();



        //RecyclerView to show the top offers
        topOffersDatabaseRef = FirebaseDatabase.getInstance().getReference().child("topOffers");
        topOffersRecyclerView = (RecyclerView) view.findViewById(R.id.top_offers_recyclerView);
        topOffersRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        topOffersRecyclerView.getRecycledViewPool().clear();


        //RecyclerView to show the Dine in
        dineInDatabaseRef = FirebaseDatabase.getInstance().getReference().child("filterFoodList");
        dineInRecyclerView = (RecyclerView) view.findViewById(R.id.home_pre_dinein_recyclerView);
        dineInRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        dineInRecyclerView.getRecycledViewPool().clear();


        //Firebase Recycler Options for food filters
        FirebaseRecyclerOptions<Model> options =
                new FirebaseRecyclerOptions.Builder<Model>()
                        .setQuery(filterDatabaseReference, Model.class)
                        .build();
        filterAdapter = new homeFilterFoodAdapter(options);
        filterRecyclerView.setAdapter(filterAdapter);


        //Firebase Recycler Options for top offers
        FirebaseRecyclerOptions<Model> topOffers =
                new FirebaseRecyclerOptions.Builder<Model>()
                        .setQuery(topOffersDatabaseRef, Model.class)
                        .build();
        topOffersAdapter = new homeTopOffersAdapter(topOffers);
        topOffersRecyclerView.setAdapter(topOffersAdapter);


        //Firebase Recycler Options for dineins
        FirebaseRecyclerOptions<Model> dineIns =
                new FirebaseRecyclerOptions.Builder<Model>()
                        .setQuery(dineInDatabaseRef, Model.class)
                        .build();
        dineInsAdapter = new homePreDineInsAdapter(dineIns);
        dineInRecyclerView.setAdapter(dineInsAdapter);

       return view;
    }

    public  void foodPlanner(View view){
        Intent intent=new Intent(getContext(), foodPlannerActivity.class);
        getActivity().startActivity(intent);
    }


    @Override
    public void onStart() {

        filterAdapter.startListening();
        topOffersAdapter.startListening();
        dineInsAdapter.startListening();
        super.onStart();
    }

    @Override
    public void onStop() {

        filterAdapter.stopListening();
        topOffersAdapter.stopListening();
        dineInsAdapter.stopListening();
        super.onStop();
    }
}