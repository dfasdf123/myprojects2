package com.ksi.myprojects;

import android.media.MediaPlayer;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class holjackActivity extends AppCompatActivity {

    ImageView img1, img2;

    int dice1P;
    int dice2P;
    int wow=0;

    int right=0,wrong=0;
    TextView tvResult, tvMyChoice, tvRight, tvWrong, tv;
    MediaPlayer player;
    int position;

    Button btnHol, btnJack;

    Random random = new Random();

    Animation ani;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holjack);

        img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);
        tvResult = (TextView) findViewById(R.id.tvResult);
        tvMyChoice = (TextView) findViewById(R.id.tvMyChoice);
        tvRight = (TextView) findViewById(R.id.tvO);
        tvWrong = (TextView) findViewById(R.id.tvX);
        tv = (TextView) findViewById(R.id.tv);
        ani = AnimationUtils.loadAnimation(this,R.anim.shake);
        btnHol = (Button) findViewById(R.id.btnHol);
        btnJack = (Button) findViewById(R.id.btnJack);

        player = MediaPlayer.create(holjackActivity.this,R.raw.dice);






        btnHol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tvMyChoice.setText(" 홀!");
                Roll();
                inputHol();

            }
        });

        btnJack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tvMyChoice.setText(" 짝!");
                Roll();
                inputJack();


            }
        });
    }

    void Roll()
    {
        int num1 = random.nextInt(6);
        int num2 = random.nextInt(6);
        img1.startAnimation(ani);
        img2.startAnimation(ani);
        player.start();

        if (num1 == 0) {
            img1.setImageResource(R.drawable.dice1);
            position = 1;
            dice1P = position;
        } else if (num1 == 1) {
            img1.setImageResource(R.drawable.dice2);
            position = 2;
            dice1P = position;
        } else if (num1 == 2) {
            img1.setImageResource(R.drawable.dice3);
            position = 3;
            dice1P = position;
        } else if (num1 == 3) {
            img1.setImageResource(R.drawable.dice4);
            position = 4;
            dice1P = position;
        } else if (num1 == 4) {
            img1.setImageResource(R.drawable.dice5);
            position = 5;
            dice1P = position;
        } else if (num1 == 5) {
            img1.setImageResource(R.drawable.dice6);
            position = 6;
            dice1P = position;
        }

        if (num2 == 0) {
            img2.setImageResource(R.drawable.dice1);
            position = 1;
            dice2P = position;
        } else if (num2 == 1) {
            img2.setImageResource(R.drawable.dice2);
            position = 2;
            dice2P = position;
        } else if (num2 == 2) {
            img2.setImageResource(R.drawable.dice3);
            position = 3;
            dice2P = position;
        } else if (num2 == 3) {
            img2.setImageResource(R.drawable.dice4);
            position = 4;
            dice2P = position;
        } else if (num2 == 4) {
            img2.setImageResource(R.drawable.dice5);
            position = 5;
            dice2P = position;
        } else if (num2 == 5) {
            img2.setImageResource(R.drawable.dice6);
            position = 6;
            dice2P = position;
        }
        Hol();
        Jack();

    }
    void Hol()
    {
        if(dice1P+dice2P == 3)
        {
            tvResult.setText(" 홀!");
        }
        else if(dice1P+dice2P == 5)
        {
            tvResult.setText(" 홀!");
        }
        else if(dice1P+dice2P == 7)
        {
            tvResult.setText(" 홀!");
        }
        else if(dice1P+dice2P == 9)
        {
            tvResult.setText(" 홀!");
        }
        else if(dice1P+dice2P == 11)
        {
            tvResult.setText(" 홀!");
        }
    }
    void Jack()
    {
        if(dice1P+dice2P == 2)
        {
            tvResult.setText(" 짝!");
        }
        else if(dice1P+dice2P == 4)
        {
            tvResult.setText(" 짝!");
        }
        if(dice1P+dice2P == 6)
        {
            tvResult.setText(" 짝!");
        }
        if(dice1P+dice2P == 8)
        {
            tvResult.setText(" 짝!");
        }
        if(dice1P+dice2P == 10)
        {
            tvResult.setText(" 짝!");
        }
        if(dice1P+dice2P == 12)
        {
            tvResult.setText(" 짝!");
        }
    }
    void inputHol()
    {
        if(dice1P+dice2P == 3)
        {
            right++;
            wow++;
            tv.setText(" "+wow+"번 연속성공!");
            tvRight.setText(" "+right+"번 성공!");
        } else if(dice1P+dice2P == 5)
        {
            right++;
            wow++;
            tv.setText(" "+wow+"번 연속성공!");
            tvRight.setText(" "+right+"번 성공!");
        }else if(dice1P+dice2P == 7)
        {
            right++;
            wow++;
            tv.setText(" "+wow+"번 연속성공!");
            tvRight.setText(" "+right+"번 성공!");
        }else if(dice1P+dice2P == 9)
        {
            right++;
            wow++;
            tv.setText(" "+wow+"번 연속성공!");
            tvRight.setText(" "+right+"번 성공!");
        }else if(dice1P+dice2P == 11)
        {
            right++;
            wow++;
            tv.setText(" "+wow+"번 연속성공!");
            tvRight.setText(" "+right+"번 성공!");
        }
        else
        {
            wrong++;
            wow = 0;
            tv.setText(" "+wow+"번 연속성공!");
            tvWrong.setText(" "+wrong+"번 실패!");
        }
    }
    void inputJack()
    {
        if(dice1P+dice2P == 2)
        {
            right++;
            wow++;
            tv.setText(" "+wow+"번 연속성공!");
            tvRight.setText(" "+right+"번 성공!");
        } else if(dice1P+dice2P == 4)
        {
            right++;
            wow++;
            tv.setText(" "+wow+"번 연속성공!");
            tvRight.setText(" "+right+"번 성공!");
        }else if(dice1P+dice2P == 6)
        {
            right++;
            wow++;
            tv.setText(" "+wow+"번 연속성공!");
            tvRight.setText(" "+right+"번 성공!");
        }else if(dice1P+dice2P == 8)
        {
            right++;
            wow++;
            tv.setText(" "+wow+"번 연속성공!");
            tvRight.setText(" "+right+"번 성공!");
        }else if(dice1P+dice2P == 10)
        {
            right++;
            wow++;
            tv.setText(" "+wow+"번 연속성공!");
            tvRight.setText(" "+right+"번 성공!");
        }else if(dice1P+dice2P == 12)
        {
            right++;
            wow++;
            tv.setText(" "+wow+"번 연속성공!");
            tvRight.setText(" "+right+"번 성공!");
        }
        else
        {
            wrong++;
            wow = 0;
            tv.setText(" "+wow+"번 연속성공!");
            tvWrong.setText(" "+wrong+"번 실패!");
        }
    }
}
