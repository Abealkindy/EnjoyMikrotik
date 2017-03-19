package com.abraham24.nyobaaja;

import android.content.Intent;
import android.os.Bundle;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.abraham24.nyobaaja.FromDatabase.ConfigUrl;
import com.abraham24.nyobaaja.NetworkingQuiz.FirstPageQuiz;
import com.abraham24.nyobaaja.NetworkingQuiz.QuizActivity;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MenuUtama extends AppCompatActivity {
//pengenalan recyclerview
    private RecyclerView lv;
//pengenalan requestqueque fitur library volley
    private RequestQueue requestQueue;
    //pengenalan stringrequest fitur dari library volley
    private StringRequest stringRequest;
    //pengenalan swiperefresh
    SwipeRefreshLayout swipe;
    //pengambilan arrayList
    ArrayList<HashMap<String, String>> list_data;
//pengenalan fab menu, dan fab button
    FloatingActionMenu materialDesignFAM;
    FloatingActionButton floatingActionButton1, floatingActionButton2, floatingActionButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolli);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//inisialisasi recyclerview
        lv = (RecyclerView) findViewById(R.id.listv);
        //manampilkan jumlah dari kotak yang dibuat gridlayoutmanager
        int numberOfColumns = 2;
        //membuat recyclerview menjadi gridlayout
        GridLayoutManager llm = new GridLayoutManager(MenuUtama.this, numberOfColumns);
        //setting layout menjadi gridlayoutmanager
        lv.setLayoutManager(llm);
        //inisialisasi swiperefreshlayout
        swipe = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);


//penambahan event/pemfngsian untuk swipe refresh
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //TODO something when swipe refresh swiped

                swipe.setRefreshing(false);

                proses();
            }
        });
        //inisialisasi dari fab menu dan button
        materialDesignFAM = (FloatingActionMenu) findViewById(R.id.material_design_android_floating_action_menu);
        floatingActionButton1 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item1);
        floatingActionButton2 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item2);
        floatingActionButton3 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item3);
        //  pemberian event fab
        floatingActionButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu first item clicked
                startActivity(new Intent(getApplicationContext(), ResourceActivity.class));
            }
        });
        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu second item clicked
                startActivity(new Intent(getApplicationContext(), FirstPageQuiz.class));
            }
        });
        floatingActionButton3.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        //TODO something when floating action menu third item clicked
                        startActivity(new Intent(getApplicationContext(), AboutActivity.class));
                    }
                });
//meload method proses didalam method onCreate();
proses();

    }
//method proses();
    private void proses() {
        //memasukkan directory URL untuk diproses
               String urlKategori = (ConfigUrl.URL_KATEGORI);
        //memasukkan requestqueque utk meload data volley
        requestQueue = Volley.newRequestQueue(MenuUtama.this);
        //pengenalan listdata
        list_data = new ArrayList<HashMap<String, String>>();
        //method stringrequest
        stringRequest = new StringRequest(Request.Method.GET, urlKategori, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("response ", response);
                try {
                    //pengambilan JSON object dan array memakai JSON parsing
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("hasil");

                       //  Toast.makeText(MenuUtama.this, response, Toast.LENGTH_SHORT).show();
                    //perulangan utk mengambil data
                    for (int a = 0; a < jsonArray.length(); a++) {
                        JSONObject json = jsonArray.getJSONObject(a);
                        //parameter HashMap utk menangkap variabel JSON
                        HashMap<String, String> map = new HashMap<String, String>();
//pengambilan variabel JSON
                        map.put("nama_kategori", json.getString("nama_kategori"));
                        map.put("gambar_kategori", json.getString("gambar_kategori"));
                        map.put("id_kategori", json.getString("id_kategori"));
//memasukkan data ke ArrayList memakai variabel list_data
                        list_data.add(map);
                        //membuat method baru di kelas baru utk menampung data dari recyclerview
                        CustomListAdapter adapter = new CustomListAdapter(MenuUtama.this, list_data);
                        //memasukkan data ke recyclerview dari kelas CustomListAdapter.java
                        lv.setAdapter(adapter);
                    }
                    //penangkapan error JSON
                } catch (JSONException e) {
                    //action yang akan dilakukan jika JSON gagal
                    Toast.makeText(MenuUtama.this, "Gk bisa tong", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
            //penangkapan jika volley error
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //action yanga akan keluar jika volley error
                Toast.makeText(MenuUtama.this, "Fail send request to server", Toast.LENGTH_LONG).show();

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<String, String>();
                KelasLain kelas = new KelasLain();
                //utk melempar data
                param.put("id_kategori", kelas.getIdkategori());

                return param;
            }
        };
        //memasukkan data dari stringrequest ke requestqueque
        requestQueue.add(stringRequest);
    }


}








