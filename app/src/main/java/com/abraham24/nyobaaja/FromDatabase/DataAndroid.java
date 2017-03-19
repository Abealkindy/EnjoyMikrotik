package com.abraham24.nyobaaja.FromDatabase;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.abraham24.nyobaaja.DetailFromRecyclerView;
import com.abraham24.nyobaaja.KelasLain;
import com.abraham24.nyobaaja.R;
import com.bumptech.glide.Glide;

import java.util.HashMap;
import java.util.List;

/**
 * Created by KOCHOR on 2/21/2017.
 */
public class DataAndroid extends RecyclerView.Adapter<ViewAndroid>{

    Context context;
    List<AndroidVersion.Children> listitemObjects;

    public DataAndroid (Context context, List<AndroidVersion.Children> listitemObjects) {
        this.context = context;
        this.listitemObjects = listitemObjects;
    }


    @Override
    public ViewAndroid onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlistlanjutan, parent, false);
        return new ViewAndroid(view);
    }

    @Override
    public void onBindViewHolder(ViewAndroid holder, int position) {
        holder.tvName.setText(listitemObjects.get(position).strtitle_blog);
       // holder.tvVersion.setText(listitemObjects.get(position).strid_blog);
        String urlImage = listitemObjects.get(position).strurl_image;
        final String idArticel = listitemObjects.get(position).strid_blog;
        final String idkategori = listitemObjects.get(position).idkategori;
        Glide.with(context).
                load(urlImage).
                placeholder(R.mipmap.ic_launcher).
                into(holder.tvApiVersion);





        holder.cardItemArticel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendToDetail = new Intent(view.getContext(), DetailFromRecyclerView.class);
                sendToDetail.putExtra("id_konten", idArticel);
                view.getContext().startActivity(sendToDetail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listitemObjects.size();
    }
}
