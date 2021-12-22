package com.nappdeveloper.juff.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.nappdeveloper.juff.Model.Model;
import com.nappdeveloper.juff.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class snapsPostAdapter extends FirebaseRecyclerAdapter<Model, snapsPostAdapter.Viewholder> {


    public snapsPostAdapter(@NonNull FirebaseRecyclerOptions<Model> options) {

        super(options);

    }

    @Override
    protected void onBindViewHolder(@NonNull snapsPostAdapter.Viewholder holder, int position, @NonNull Model model) {

        Glide.with(holder.foodImage.getContext()).load(model.getFilterImage()).into(holder.foodImage);
        Glide.with(holder.circleImageView.getContext()).load(model.getFilterImage()).into(holder.circleImageView);
    }

    @Override
    public void onDataChanged() {
        notifyDataSetChanged();
        super.onDataChanged();
    }

    @NonNull
    @Override
    public snapsPostAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //the data objects are inflated into the xml file single_data_item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.snaps_post_layout, parent, false);
        return new snapsPostAdapter.Viewholder(view);

    }

    //we need view holder to hold each objet form recyclerview and to show it in recyclerview
    class Viewholder extends RecyclerView.ViewHolder {

        ImageView foodImage;
        CircleImageView circleImageView;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            foodImage = (ImageView) itemView.findViewById(R.id.snaps_post_image);
            circleImageView=(CircleImageView) itemView.findViewById(R.id.snaps_user_profile);

        }
    }


}

