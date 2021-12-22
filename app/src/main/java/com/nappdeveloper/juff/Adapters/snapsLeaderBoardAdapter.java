package com.nappdeveloper.juff.Adapters;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

public class snapsLeaderBoardAdapter extends FirebaseRecyclerAdapter<Model, snapsLeaderBoardAdapter.Viewholder> {

    private int selected_position = 0;
    public snapsLeaderBoardAdapter(@NonNull FirebaseRecyclerOptions<Model> options) {

        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull snapsLeaderBoardAdapter.Viewholder holder, @SuppressLint("RecyclerView") int position, @NonNull Model model) {

        String name=model.getLeaderName();
        holder.NameTxt.setText(name);

        Glide.with(holder.imageView.getContext()).load(model.getLeaderImage()).into(holder.imageView);


    }

    @Override
    public void onDataChanged() {
        notifyDataSetChanged();
        super.onDataChanged();
    }

    @NonNull
    @Override
    public snapsLeaderBoardAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //the data objects are inflated into the xml file single_data_item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.leader_board_layout, parent, false);
        return new snapsLeaderBoardAdapter.Viewholder(view);

    }

    //we need view holder to hold each objet form recyclerview and to show it in recyclerview
    class Viewholder extends RecyclerView.ViewHolder {

        TextView NameTxt;
        LinearLayout linearLayout;
        ImageView imageView;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            linearLayout = (LinearLayout) itemView.findViewById(R.id.leaderboard_layout);
            imageView=(ImageView) itemView.findViewById(R.id.leaderboard_person_image);
            NameTxt = (TextView) itemView.findViewById(R.id.leaderboard_person_name);

        }
    }


}

