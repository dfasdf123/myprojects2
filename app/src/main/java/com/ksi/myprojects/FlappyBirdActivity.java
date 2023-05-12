package com.ksi.myprojects;

import android.media.MediaPlayer;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FlappyBirdActivity extends AppCompatActivity {

    public static TextView tvScore, tvGamover, tvBestScore, tvScoreover;
    public static RelativeLayout rlGameover;
    public static Button btnStart;
    public GameView gv;

    public  MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        Constants.SCREEN_WIDTH = dm.widthPixels;
        Constants.SCREEN_HEIGHT = dm.heightPixels;
        setContentView(R.layout.activity_flappy_bird);

        tvScore = (TextView) findViewById(R.id.tvScore);
        tvGamover = (TextView) findViewById(R.id.tvGamever);
        tvScoreover = (TextView) findViewById(R.id.tvScoreover);
        tvBestScore = (TextView) findViewById(R.id.tvBestScore);
        rlGameover = (RelativeLayout) findViewById(R.id.rlGameover);
        btnStart = (Button) findViewById(R.id.btnStart);
        gv = findViewById(R.id.gv);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gv.setStart(true);
                tvScore.setVisibility(View.VISIBLE);
                btnStart.setVisibility(View.INVISIBLE);
            }
        });
        rlGameover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gv.setStart(true);
                btnStart.setVisibility(View.VISIBLE);
                rlGameover.setVisibility(View.INVISIBLE);
                gv.setStart(false);
                gv.reset();
            }
        });
        player = MediaPlayer.create(this,R.raw.sillychipsong);
        player.setLooping(true);
        player.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        player.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        player.pause();
    }
}