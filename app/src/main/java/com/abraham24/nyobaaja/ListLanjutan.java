package com.abraham24.nyobaaja;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.abraham24.nyobaaja.FromDatabase.AndroidVersion;
import com.abraham24.nyobaaja.FromDatabase.ConfigUrl;
import com.abraham24.nyobaaja.FromDatabase.DataAndroid;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.HashMap;

public class ListLanjutan extends AppCompatActivity {
    String materi;
    RecyclerView recycleviewlanjutan;
    private AndroidVersion itemObject;
    private DataAndroid mainAdapterItem;
    private LinearLayoutManager linearLayoutManager;
    SwipeRefreshLayout sswipe2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_lanjutan);

        recycleviewlanjutan = (RecyclerView) findViewById(R.id.recyclerViewkonten);
        sswipe2 = (SwipeRefreshLayout)findViewById(R.id.refresh);
        linearLayoutManager = new LinearLayoutManager(this);
        recycleviewlanjutan.setLayoutManager(linearLayoutManager);
        sswipe2.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                sswipe2.setRefreshing(false);
                RequestDataServer();
            }
        });

RequestDataServer();

    }

    private void RequestDataServer() {


        String id = getIntent().getStringExtra("id_kategori");
        String url = (ConfigUrl.URL_LIST_ARTICEL+id);
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest strRequest = new StringRequest(Request.Method.GET, url/*url server here*/, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();



                itemObject = gson.fromJson(response, AndroidVersion.class);
                mainAdapterItem = new DataAndroid(getApplicationContext(), itemObject.listAndroid);
                recycleviewlanjutan.setAdapter(mainAdapterItem);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Fail send request to server", Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(strRequest);
    }
}
