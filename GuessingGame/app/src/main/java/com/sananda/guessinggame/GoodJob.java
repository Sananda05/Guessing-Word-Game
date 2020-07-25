package com.sananda.guessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GoodJob extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_job);

        Bundle extras=getIntent().getExtras();
        int j=extras.getInt("FinalScore");

        final TextView score = findViewById(R.id.Fscore);
        final Button Try = findViewById(R.id.Try);
        final Button play = findViewById(R.id.play);
        final Button pause = findViewById(R.id.pause);


        score.setText(String.valueOf(j));

        mediaPlayer=MediaPlayer.create(GoodJob.this,R.raw.song);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
            }
        });

    }
}
