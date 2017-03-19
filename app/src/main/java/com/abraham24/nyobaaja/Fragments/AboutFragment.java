package com.abraham24.nyobaaja.Fragments;


import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.abraham24.nyobaaja.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {


    public AboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
View v = inflater.inflate(R.layout.activity_about_app, container, false);
        CollapsingToolbarLayout collaptoolDetail = (CollapsingToolbarLayout)v.findViewById(R.id.toolbar_layout3);
        collaptoolDetail.setTitle("Enjoy Mikrotik");
        // Inflate the layout for this fragment
        return v ;
    }

}
