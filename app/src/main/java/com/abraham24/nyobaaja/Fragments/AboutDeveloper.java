package com.abraham24.nyobaaja.Fragments;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.abraham24.nyobaaja.AboutActivity;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import com.abraham24.nyobaaja.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutDeveloper extends Fragment  {
    FloatingActionMenu fabpertama;
    FloatingActionButton fabnotelp1, fabke2, fabke3;


    public AboutDeveloper() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
View v = inflater.inflate(R.layout.activity_coba_scroll,container,false);
        CollapsingToolbarLayout collaptoolDetail = (CollapsingToolbarLayout)v.findViewById(R.id.toolbar_layout2);
        collaptoolDetail.setTitle("About Developer");
        fabpertama = (FloatingActionMenu) v.findViewById(R.id.fabawal);
        fabnotelp1 = (FloatingActionButton) v.findViewById(R.id.fab1);
        fabke2 = (FloatingActionButton) v.findViewById(R.id.fab2);
        fabke3 = (FloatingActionButton) v.findViewById(R.id.fab3);

       fabnotelp1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String call = "082115165102";
               Intent a = new Intent(Intent.ACTION_CALL);
               a.setData(Uri.parse("tel:" + call));
              if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                   return;
               }
startActivity(a);
           }
       });
        //TODO something when floating action menu first item clicked
        fabke2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                smsIntent.setType("vnd.android-dir/mms-sms");
                smsIntent.putExtra("address", "082115165102");
                smsIntent.putExtra("sms_body","Body of Message");
                startActivity(smsIntent);
            }
        });
        //TODO something when floating action menu second item clicked
        fabke3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Send email", "");
              String[] TO = {"abealkindy@gmail.com"};
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                try {
                    startActivity(Intent.createChooser(emailIntent, "send mail..."));

                    Log.i("Email sent...", "");
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getActivity(), "gagal bro", Toast.LENGTH_SHORT).show();
                }

            }
        });
        //TODO something when floating action menu third item clicked
//


        // Inflate the layout for this fragment
        return v;
    }

   
}
