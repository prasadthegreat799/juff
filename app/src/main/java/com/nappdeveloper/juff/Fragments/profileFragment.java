package com.nappdeveloper.juff.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.nappdeveloper.juff.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class profileFragment extends Fragment {

    CircleImageView profileImg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_profile, container, false);


        profileImg=(CircleImageView) view.findViewById(R.id.profileImg);

        Glide.with(getContext()).load("https://www.finns.com.au/wp-content/uploads/2020/05/Nathan-Phu-circular-profile.png").into(profileImg);

        return view;
    }
}