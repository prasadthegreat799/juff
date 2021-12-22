package com.nappdeveloper.juff.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.nappdeveloper.juff.Model.Model;
import com.nappdeveloper.juff.R;

public class homeFilterResultAdapter extends FirebaseRecyclerAdapter<Model, homeFilterResultAdapter.Viewholder> {


    public homeFilterResultAdapter(@NonNull FirebaseRecyclerOptions<Model> options) {

        super(options);

    }

    @Override
    protected void onBindViewHolder(@NonNull homeFilterResultAdapter.Viewholder holder, int position, @NonNull Model model) {

        Glide.with(holder.foodImage.getContext()).load(model.getFilterImage()).into(holder.foodImage);


    }

    @Override
    public void onDataChanged() {
        notifyDataSetChanged();
        super.onDataChanged();
    }

    @NonNull
    @Override
    public homeFilterResultAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //the data objects are inflated into the xml file single_data_item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.filter_food_result_layout, parent, false);
        return new homeFilterResultAdapter.Viewholder(view);

    }

    //we need view holder to hold each objet form recyclerview and to show it in recyclerview
    class Viewholder extends RecyclerView.ViewHolder {

        ImageView foodImage;
        CardView foodCard;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            foodCard = (CardView) itemView.findViewById(R.id.filterFoodResultCard);
            foodImage = (ImageView) itemView.findViewById(R.id.food_result_img);

        }
    }


}
