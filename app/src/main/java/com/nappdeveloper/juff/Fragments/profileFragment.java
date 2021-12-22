package com.nappdeveloper.juff.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.nappdeveloper.juff.Activity.profileManageAddressActivity;
import com.nappdeveloper.juff.Activity.profileMyWalletActivity;
import com.nappdeveloper.juff.Activity.profileOrdersActivity;
import com.nappdeveloper.juff.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class profileFragment extends Fragment {

    CircleImageView profileImg;
    TextView shareAppTxt,supportTxt,ordersTxt,manageAddressTxt,logOutTxt;
    LinearLayout myWalletTxt;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_profile, container, false);


        profileImg=(CircleImageView) view.findViewById(R.id.profileImg);
        shareAppTxt=(TextView) view.findViewById(R.id.shareAppTxt);
        supportTxt=(TextView) view.findViewById(R.id.supportTxt);
        ordersTxt=(TextView) view.findViewById(R.id.myOrdersTxt);
        manageAddressTxt=(TextView) view.findViewById(R.id.mangeAddressTxt);
        logOutTxt=(TextView) view.findViewById(R.id.logOutTxt);
        myWalletTxt=(LinearLayout) view.findViewById(R.id.myWalletTxt);



        ordersTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ordersIntent=new Intent(getContext(), profileOrdersActivity.class);
                startActivity(ordersIntent);

            }
        });

        manageAddressTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent manageAddressIntent=new Intent(getContext(), profileManageAddressActivity.class);
                startActivity(manageAddressIntent);
            }
        });

        myWalletTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent walletIntent=new Intent(getContext(), profileMyWalletActivity.class);
                startActivity(walletIntent);
            }
        });

        supportTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"prasadthegreat799@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Your subject here...");
                intent.putExtra(Intent.EXTRA_TEXT,"Your message here...");
                startActivity(intent);

            }
        });


        shareAppTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Here is the share content body";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));

            }
        });


        logOutTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getContext(),"This feature is under progress",Toast.LENGTH_SHORT).show();

            }
        });

        Glide.with(getContext()).load("https://www.finns.com.au/wp-content/uploads/2020/05/Nathan-Phu-circular-profile.png").into(profileImg);

        return view;
    }
}