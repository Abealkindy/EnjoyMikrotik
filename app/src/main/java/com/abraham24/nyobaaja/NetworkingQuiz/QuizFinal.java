package com.abraham24.nyobaaja.NetworkingQuiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.abraham24.nyobaaja.MenuUtama;
import com.abraham24.nyobaaja.R;

public class QuizFinal extends AppCompatActivity {
    int nilai;
    TextView txtNilai;
    Button ulang,balik;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_final);

        nilai=getIntent().getIntExtra("nilai",0);
        txtNilai=(TextView)findViewById(R.id.txtsubmit);
        balik=(Button)findViewById(R.id.buttonbalik);
        ulang=(Button)findViewById(R.id.btnulang);
        //txtNilai.setText(nilai);

        balik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MenuUtama.class));
                finish();
            }
        });
        ulang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), QuizActivity.class));
            }
        });
        txtNilai.setText("Nilai Kamu : "+nilai);
        Toast.makeText(getApplicationContext(),"nilai "+nilai,Toast.LENGTH_LONG).show();
    }
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(),"Dilarang Balik! ",Toast.LENGTH_LONG).show();
        return;
    }
}
