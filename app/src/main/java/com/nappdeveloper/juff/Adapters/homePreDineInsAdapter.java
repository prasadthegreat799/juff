package com.nappdeveloper.juff.Adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.nappdeveloper.juff.Model.Model;
import com.nappdeveloper.juff.R;

public class homePreDineInsAdapter extends FirebaseRecyclerAdapter<Model, homePreDineInsAdapter.Viewholder> {

    private int selected_position = 0;
    public homePreDineInsAdapter(@NonNull FirebaseRecyclerOptions<Model> options) {

        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull homePreDineInsAdapter.Viewholder holder, @SuppressLint("RecyclerView") int position, @NonNull Model model) {

        Glide.with(holder.imageView.getContext()).load(model.getFilterImage()).into(holder.imageView);

    }

    @Override
    public void onDataChanged() {
        notifyDataSetChanged();
        super.onDataChanged();
    }

    @NonNull
    @Override
    public homePreDineInsAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //the data objects are inflated into the xml file single_data_item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pre_dineins_layout, parent, false);
        return new homePreDineInsAdapter.Viewholder(view);

    }

    //we need view holder to hold each objet form recyclerview and to show it in recyclerview
    class Viewholder extends RecyclerView.ViewHolder {


        ImageView imageView;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            imageView=(ImageView) itemView.findViewById(R.id.home_pre_dinein_img);

        }
    }


}

