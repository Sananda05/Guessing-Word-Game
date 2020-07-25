package com.sananda.guessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class FirstQuestion extends AppCompatActivity {
    int count=3;
    int Score=20;

    public void Display(String string) {
        Toast.makeText(FirstQuestion.this, string, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_question);


        final EditText type = (EditText) findViewById(R.id.type);
        final Button answer1 = (Button) findViewById(R.id.firstAnswer);
        final Button tryagain = findViewById(R.id.TryAgain);
        final Button gonext = findViewById(R.id.goQues2);
        final TextView score =(TextView)findViewById(R.id.point);
         score.setText(String.valueOf(Score));

            answer1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String answer =type.getText().toString();

                    if (answer.equals("Teacher" )||(answer.equals("teacher"))){
                        Display("Right");
                        gonext.setVisibility(View.VISIBLE);
                    }
                     else  {
                        Display("Wrong");
                        count--;
                        Toast.makeText(FirstQuestion.this,count+"chance left!",Toast.LENGTH_SHORT).show();
                        Score=Score-5;
                        score.setText(String.valueOf(Score));

                        if(count==0)
                        {
                            Score=0;
                            score.setText(String.valueOf(Score));
                            type.setEnabled(false);
                            Toast.makeText(FirstQuestion.this,"Try Again !",Toast.LENGTH_SHORT).show();

                    }
                }
                    }
            });

            tryagain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Score=20;
                    score.setText(String.valueOf(Score));
                    count=3;
                    type.setEnabled(true);
                }
            });

            gonext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(FirstQuestion.this,secondQuestion.class);
                    Bundle bundle=new Bundle();
                    i.putExtra("FinalScore",Score);
                    startActivity(i);

                }
            });

        }

    public void hint1(View view) {

        Score=Score-5;
        Toast.makeText(FirstQuestion.this,"Ends with er !",Toast.LENGTH_SHORT).show();

    }

    public void hint2(View view) {
        Score=Score-5;
        Toast.makeText(FirstQuestion.this,"Related to your study!",Toast.LENGTH_SHORT).show();

    }

    public void hint3(View view) {
        Score=Score-5;
        Toast.makeText(FirstQuestion.this,"Gives you too much pain!",Toast.LENGTH_SHORT).show();
    }

}
