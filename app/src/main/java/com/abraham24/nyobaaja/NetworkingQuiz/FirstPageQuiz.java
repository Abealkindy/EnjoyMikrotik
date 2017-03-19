package com.abraham24.nyobaaja.NetworkingQuiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.abraham24.nyobaaja.R;

public class FirstPageQuiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page_quiz);
        Button buttonstart = (Button)findViewById(R.id.buttonmulai);
        buttonstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),QuizActivity.class));
            }
        });
    }
}
