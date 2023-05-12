package com.ksi.myprojects;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class RockScissorsPaperActivity extends AppCompatActivity {

    Random random = new Random();

    ImageView ivRSP;

    int[] imageResources = {R.drawable.rock, R.drawable.scissors, R.drawable.paper};

    int rsp, position, score;

    TextView tvScore;

    Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_scissors_paper);

        ivRSP = (ImageView) findViewById(R.id.ivRSP);
        tvScore = (TextView) findViewById(R.id.tvScore);
        findViewById(R.id.ivRock).setOnClickListener(mClickListener);
        findViewById(R.id.ivScissors).setOnClickListener(mClickListener);
        findViewById(R.id.ivPaper).setOnClickListener(mClickListener);
        findViewById(R.id.ivRestart).setOnClickListener(mClickListener);
        start();


    }

    View.OnClickListener mClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ivRock:
                    stop();
                    Roll();
                    if(rsp == 0){
                        tvScore.setText("현재 "+score+"연승중!");
                    }
                    if(rsp == 1){
                        score++;
                        tvScore.setText("현재 "+score+"연승중!");

                    }
                    if(rsp == 2){
                        score = 0;
                        tvScore.setText("현재 "+score+"연승중!");
                    }
                    break;
                case R.id.ivScissors:
                    stop();
                    Roll();
                    if(rsp == 0){
                        score = 0;
                        tvScore.setText("현재 "+score+"연승중!");

                    }
                    if(rsp == 1){
                        tvScore.setText("현재 "+score+"연승중!");

                    }
                    if(rsp == 2){
                        score++;
                        tvScore.setText("현재 "+score+"연승중!");
                    }
                    break;
                case R.id.ivPaper:
                    stop();
                    Roll();
                    if(rsp == 0){
                        score++;
                        tvScore.setText("현재 "+score+"연승중!");

                    }
                    if(rsp == 1){
                        score = 0;
                        tvScore.setText("현재 "+score+"연승중!");

                    }
                    if(rsp == 2){
                        tvScore.setText("현재 "+score+"연승중!");
                    }
                    break;
                case R.id.ivRestart:
                    start();
                    break;

            }
        }
    };
    void stop()
    {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }
    void start()
    {
        // 일정 시간마다 이미지 변경
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int index = random.nextInt(imageResources.length);
                        int imageRes = imageResources[index];
                        ivRSP.setImageResource(imageRes);
                    }
                });
            }
        }, 0, 50);
    }

    void Roll() {
        int num1 = random.nextInt(3);

        if (num1 == 0) {
            ivRSP.setImageResource(R.drawable.rock);
            position = 0;
            rsp = position;

        } else if (num1 == 1) {
            ivRSP.setImageResource(R.drawable.scissors);
            position = 1;
            rsp = position;

        } else if (num1 == 2) {
            ivRSP.setImageResource(R.drawable.paper);
            position = 2;
            rsp = position;
        }
    }


}