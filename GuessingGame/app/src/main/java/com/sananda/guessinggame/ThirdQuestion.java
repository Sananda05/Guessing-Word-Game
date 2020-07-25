package com.sananda.guessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdQuestion extends AppCompatActivity {

    int count=3;
    int Score=20;
    public void Display(String string) {
        Toast.makeText(ThirdQuestion.this, string, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_question);

        Bundle extras=getIntent().getExtras();
        int j=extras.getInt("FinalScore");

        Score=Score+j;

        final EditText type = (EditText) findViewById(R.id.type);
        final Button answer1 = (Button) findViewById(R.id.firstAnswer);
        final Button tryagain = findViewById(R.id.TryAgain);
        final Button Next = findViewById(R.id.goQues2);
        final TextView score=findViewById(R.id.score);
        score.setText(String.valueOf(Score));

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String answer =type.getText().toString();

                if (answer.equals("Chocolate")||(answer.equals("chocolate"))){
                    Display("Right");
                    Next.setVisibility(View.VISIBLE);
                }
                else  {
                    Display("Wrong");
                    count--;
                    Score=Score-5;
                    score.setText(String.valueOf(Score));

                }
                if(count==0)

                {
                    Score=0;
                    score.setText(String.valueOf(Score));
                    type.setEnabled(false);
                    Toast.makeText(ThirdQuestion.this,"Try Again !",Toast.LENGTH_SHORT).show();
                }
            }
        });

        tryagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Score=20;
                count=3;
                type.setEnabled(true);
            }
        });

        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Score<45) {
                    Intent i = new Intent(ThirdQuestion.this, Scoreshowing.class);
                    Bundle bundle = new Bundle();
                    i.putExtra("FinalScore", Score);
                    startActivity(i);
                }
                else
                {
                    Intent i = new Intent(ThirdQuestion.this, GoodJob.class);
                    Bundle bundle = new Bundle();
                    i.putExtra("FinalScore", Score);
                    startActivity(i);

                }
            }
        });

    }

    public void hint1(View view) {

        Score=Score-5;
        Toast.makeText(ThirdQuestion.this,"Ends with ate!",Toast.LENGTH_SHORT).show();

    }

    public void hint2(View view) {
        Score=Score-5;
        Toast.makeText(ThirdQuestion.this,"It can be dark also !",Toast.LENGTH_SHORT).show();
    }

    public void hint3(View view) {
        Score=Score-5;
        Toast.makeText(ThirdQuestion.this,"Everyone likes to eat this!",Toast.LENGTH_SHORT).show();

    }
}
