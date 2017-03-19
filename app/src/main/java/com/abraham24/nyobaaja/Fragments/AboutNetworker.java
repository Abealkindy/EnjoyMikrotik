package com.abraham24.nyobaaja.Fragments;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import com.abraham24.nyobaaja.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutNetworker extends Fragment {
    FloatingActionMenu fabsatu;
    FloatingActionButton fabkesatu, fabkedua, fabketiga;

    public AboutNetworker() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_scrolling,container,false);

//
        CollapsingToolbarLayout collaptoolDetail = (CollapsingToolbarLayout)v.findViewById(R.id.toolbar_layout1);
        collaptoolDetail.setTitle("About Networker");

        fabsatu = (FloatingActionMenu)v.findViewById(R.id.fabpalingawal);
        fabkesatu = (FloatingActionButton)v.findViewById(R.id.fabpaling1);
        fabkedua = (FloatingActionButton)v.findViewById(R.id.fabpaling2);
        fabketiga = (FloatingActionButton)v.findViewById(R.id.fabpaling3);

        fabsatu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        fabkesatu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String call2 = "085776665554";
                Intent a1 = new Intent(Intent.ACTION_CALL);
                a1.setData(Uri.parse("tel:" + call2));
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    return;
                }
                startActivity(a1);
            }
        });
        fabkedua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Send SMS", "");
                Intent smsIntent2 = new Intent(Intent.ACTION_VIEW);
                smsIntent2.setData(Uri.parse("smsto:"));
                smsIntent2.setType("vnd.android-dir/mms-sms");
                smsIntent2.putExtra("address" , new String("085776665554"));
                smsIntent2.putExtra("sms_body" , "Test SMS to Angilla");
                try {
                    startActivity(smsIntent2);
                    Log.i("Finished sending SMS...", "");
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getActivity(),
                            "SMS faild, please try again later.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        fabketiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Send email", "");
                String[] TO1 = {"tbazhar9@gmail.com"};
                Intent emailIntent1 = new Intent(Intent.ACTION_SEND);
                emailIntent1.setData(Uri.parse("mailto:"));
                emailIntent1.setType("text/plain");
                emailIntent1.putExtra(Intent.EXTRA_EMAIL, TO1);
                startActivity(Intent.createChooser(emailIntent1, "Send mail..."));
                try {
                    startActivity(Intent.createChooser(emailIntent1, "send mail..."));

                    Log.i("Email sent...", "");
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getActivity(), "gagal bro", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Inflate the layout for this fragment
        return v;
    }


}
