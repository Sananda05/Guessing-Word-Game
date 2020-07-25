package com.sananda.guessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Scoreshowing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreshowing);

        Bundle extras=getIntent().getExtras();
        int j=extras.getInt("FinalScore");

        final TextView score = findViewById(R.id.Fscore);
        final Button Try = findViewById(R.id.Try);

        score.setText(String.valueOf(j));

        Try.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Scoreshowing.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
