package com.abraham24.nyobaaja.FromDatabase;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.abraham24.nyobaaja.R;

/**
 * Created by KOCHOR on 2/21/2017.
 */
public class ViewAndroid extends RecyclerView.ViewHolder{
    public TextView tvName, tvVersion;
    public ImageView tvApiVersion;
    public CardView cardItemArticel;

    public ViewAndroid(View itemView) {
        super(itemView);
        tvName = (TextView) itemView.findViewById(R.id.textcontentlistlanjutan);
        tvApiVersion = (ImageView) itemView.findViewById(R.id.imagelistitem);
      //  tvVersion = (TextView) itemView.findViewById(R.id.textkedualanjutan);
        cardItemArticel = (CardView)itemView.findViewById(R.id.cardviewlanjutan);
    }
}
