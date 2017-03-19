package com.abraham24.nyobaaja.NetworkingQuiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.abraham24.nyobaaja.R;

public class QuizActivity6 extends AppCompatActivity {
    int nilai;
    RadioButton radio,radio1,radio2,radio3;
    Button btn2;
    int tampungNilai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz6);
        btn2=(Button)findViewById(R.id.buttonnext6);
        radio = (RadioButton)findViewById(R.id.jawabansatu6);
        radio1=(RadioButton)findViewById(R.id.jawabandua6);
        radio2=(RadioButton)findViewById(R.id.jawabantiga6);
        radio3=(RadioButton)findViewById(R.id.jawabanempat6);
        tampungNilai = getIntent().getIntExtra("nilai",0);

        radio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nilai = 0;
            }
        });
        radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nilai = 10;
            }
        });
        radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nilai= 0;
            }
        });
        radio3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nilai = 0;
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i =new Intent(getApplicationContext(),QuizActivity7.class);
                i.putExtra("nilai",nilai + tampungNilai);
                startActivity(i);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(),"Dilarang Balik! ",Toast.LENGTH_LONG).show();
        return;
    }
    }

