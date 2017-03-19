package com.abraham24.nyobaaja;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.DragEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;

import com.abraham24.nyobaaja.FromDatabase.ConfigUrl;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class DetailFromRecyclerView extends AppCompatActivity {
    private WebView wvContent;

    private CollapsingToolbarLayout collaptoolDetail;
    private String idDetailArticel, strTitleBlog, strContentBlog, strUrlBlog, idKategori;
    ArrayList<HashMap<String, String>> list_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_from_recycler_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        collaptoolDetail = (CollapsingToolbarLayout)findViewById(R.id.toolbar_layout);
      //  ivHeaderToolbar = (ImageView) findViewById(R.id.ivdetailHeader);
        wvContent = (WebView) findViewById(R.id.detailkonten);
        wvContent.getSettings().setJavaScriptEnabled(true);

        Intent reciveIntent = getIntent();
        idDetailArticel = reciveIntent.getStringExtra("id_konten");
        idKategori = reciveIntent.getStringExtra("id_kategori");
        RequestDetailServer(ConfigUrl.URL_DETAIL_ARTICEL + idDetailArticel );
    }


    private void setContent(String forTitle, String forContent, String forUrlImage) {
     //   Glide.with(getApplicationContext()).
     //           load(forUrlImage).
     //           placeholder(R.mipmap.ic_launcher).
     //           into(ivHeaderToolbar);
        collaptoolDetail.setTitle(forTitle);
        String contentwvContent = "<html><body>" + forContent + "</body></html>";
        wvContent.loadData(contentwvContent, "text/html", null);

    }

    private void RequestDetailServer(String urlRequest) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest strRequest = new StringRequest(Request.Method.GET, urlRequest, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonRespons = new JSONObject(response);
                    JSONObject dataDetailArticel = jsonRespons.getJSONObject("hasil");


                        strTitleBlog = dataDetailArticel.getString("judul_konten");
                        strContentBlog = dataDetailArticel.getString("isi_konten");
                        strUrlBlog = dataDetailArticel.getString("url_gambar");


                        setContent(strTitleBlog, strContentBlog, strUrlBlog);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Fail send request to server", Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(strRequest);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent share  = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_SUBJECT,strTitleBlog);
                share.putExtra(Intent.EXTRA_TEXT,strTitleBlog + "\n" + strContentBlog);
                 startActivity(Intent.createChooser(share,"Share with"));
            }
        });
    }
}
