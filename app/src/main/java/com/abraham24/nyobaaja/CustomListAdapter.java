package com.abraham24.nyobaaja;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.abraham24.nyobaaja.FromDatabase.ConfigUrl;
import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by KOCHOR on 2/3/2017.
 */
public class CustomListAdapter extends RecyclerView.Adapter<CustomListAdapter.ViewHolder> {
    Context context;
    ArrayList<HashMap<String, String>> list_data;

    public CustomListAdapter(MenuUtama utama, ArrayList<HashMap<String, String>> list_data) {
        this.context = utama;
        this.list_data = list_data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(context)
                .load(ConfigUrl.URL_GAMBAR + list_data.get(position).get("gambar_kategori"))
                .crossFade()
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.imghape);

        holder.txthape.setText(list_data.get(position).get("nama_kategori"));

        holder.cardv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(v.getContext(),ListLanjutan.class);
                a.putExtra("id_kategori",list_data.get(position).get("id_kategori"));
                v.getContext().startActivity(a);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txthape;
        ImageView imghape;
        CardView cardv;
        public ViewHolder(View itemView) {
            super(itemView);
            cardv = (CardView)itemView.findViewById(R.id.cardviewkategori);
            txthape = (TextView) itemView.findViewById(R.id.textcontent);
            imghape = (ImageView) itemView.findViewById(R.id.imgcontent);
        }
    }
    }

