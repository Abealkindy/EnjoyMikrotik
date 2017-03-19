package com.abraham24.nyobaaja.NetworkingQuiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.abraham24.nyobaaja.R;

public class QuizActivity extends AppCompatActivity {
    RadioButton radio,radio1,radio2,radio3;
    Button btn1;
    int nilai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        radio = (RadioButton)findViewById(R.id.jawabansatu1);
        radio1=(RadioButton)findViewById(R.id.jawabandua1);
        radio2=(RadioButton)findViewById(R.id.jawabantiga1);
        radio3=(RadioButton)findViewById(R.id.jawabanempat1);
        btn1=(Button)findViewById(R.id.buttonnext1);


        radio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nilai = 0;
            }
        });
        radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nilai = 0;
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
                nilai = 10;
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i =new Intent(getApplicationContext(),QuizActivity2.class);
                i.putExtra("nilai",nilai);
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

