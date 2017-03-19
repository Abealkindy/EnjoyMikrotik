package com.abraham24.nyobaaja;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResourceActivity extends AppCompatActivity {

    TextView wikimikrotik, mikrotikindo, mikrotik, mikrotikid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource);
    wikimikrotik = (TextView)findViewById(R.id.textwikimikrotik);
    mikrotikindo = (TextView)findViewById(R.id.textmikrotikindo);
    mikrotik = (TextView)findViewById(R.id.textmikrotik);
    mikrotikid = (TextView)findViewById(R.id.textmikrotikid);

        wikimikrotik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent text1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://wiki.mikrotik.com"));
                startActivity(text1);
            }
        });

        mikrotikindo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent text2 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.mikrotikindo.blogspot.com"));
                startActivity(text2);
            }
        });

        mikrotik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent text3 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.mikrotik.com"));
                startActivity(text3);
            }
        });

        mikrotikid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent text4 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.mikrotik.co.id"));
                startActivity(text4);
            }
        });
    }
}
