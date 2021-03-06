package com.nappdeveloper.juff.Adapters;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.nappdeveloper.juff.Fragments.filterFoodResultFragment;
import com.nappdeveloper.juff.Model.Model;
import com.nappdeveloper.juff.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class restaurantsImageFilterAdapter extends FirebaseRecyclerAdapter<Model, restaurantsImageFilterAdapter.Viewholder> {

    private int selected_position = 0;
    public restaurantsImageFilterAdapter(@NonNull FirebaseRecyclerOptions<Model> options) {

        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull restaurantsImageFilterAdapter.Viewholder holder, @SuppressLint("RecyclerView") int position, @NonNull Model model) {

        String name=model.getFilterName().toString();
        holder.filterNameTxt.setText(name);
        Glide.with(holder.circleImageView.getContext()).load(model.getFilterImage()).into(holder.circleImageView);

        /*
        if(selected_position==position){
            holder.filterNameTxt.setTextColor(Color.parseColor("White"));
            holder.linearLayout.setBackgroundResource(R.color.pale_pink);
        }else{
            holder.filterNameTxt.setTextColor(Color.parseColor("Black"));
            holder.linearLayout.setBackgroundResource(R.color.white);
        }
         */

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new filterFoodResultFragment();
                FragmentManager fragmentManager = ((FragmentActivity) v.getContext()).getSupportFragmentManager(); // this is basically context of the class
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                Bundle bundle = new Bundle();
                bundle.putString("name",name); //key and value
                //set Fragmentclass Arguments
                fragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.filter_food_result_layout, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


                int previousItem = selected_position;
                selected_position = position;

                notifyItemChanged(previousItem);
                notifyItemChanged(position);

            }
        });
    }

    @Override
    public void onDataChanged() {
        notifyDataSetChanged();
        super.onDataChanged();
    }

    @NonNull
    @Override
    public restaurantsImageFilterAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //the data objects are inflated into the xml file single_data_item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurants_image_filter_layout, parent, false);
        return new restaurantsImageFilterAdapter.Viewholder(view);

    }

    //we need view holder to hold each objet form recyclerview and to show it in recyclerview
    class Viewholder extends RecyclerView.ViewHolder {

        TextView filterNameTxt;
        LinearLayout linearLayout;
        CircleImageView circleImageView;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            linearLayout = (LinearLayout) itemView.findViewById(R.id.home_food_filter_layout);
            circleImageView=(CircleImageView) itemView.findViewById(R.id.food_filter_img);
            filterNameTxt = (TextView) itemView.findViewById(R.id.food_filter_txt);

        }
    }


}

