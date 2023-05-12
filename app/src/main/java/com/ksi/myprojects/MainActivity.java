package com.ksi.myprojects;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.ivNumball).setOnClickListener(mClickListener);
        findViewById(R.id.ivSamecard).setOnClickListener(mClickListener);
        findViewById(R.id.ivTictactoe).setOnClickListener(mClickListener);
        findViewById(R.id.ivHol).setOnClickListener(mClickListener);
        findViewById(R.id.ivYacht).setOnClickListener(mClickListener);
        findViewById(R.id.ivFlappy).setOnClickListener(mClickListener);
        findViewById(R.id.ivRSP).setOnClickListener(mClickListener);
        findViewById(R.id.ivLots).setOnClickListener(mClickListener);


    }
    View.OnClickListener mClickListener = new View.OnClickListener() {
        public void onClick(View v)
        {
            switch (v.getId()) {
                case R.id.ivNumball:
                    Intent numball = new Intent(MainActivity.this,NumballActivity.class);
                    startActivity(numball);
                    break;
                case R.id.ivSamecard:
                    Intent samecard = new Intent(MainActivity.this,SameCardFindActivity.class);
                    startActivity(samecard);
                    break;
                case R.id.ivTictactoe:
                    Intent tictactoe = new Intent(MainActivity.this,TicTacToeActivity.class);
                    startActivity(tictactoe);
                    break;
                case R.id.ivHol:
                    Intent hol = new Intent(MainActivity.this,holjackActivity.class);
                    startActivity(hol);
                    break;
                case R.id.ivYacht:
                    Intent yacht = new Intent(MainActivity.this,YachtActivity.class);
                    startActivity(yacht);
                    break;
                case R.id.ivFlappy:
                    Intent flappy = new Intent(MainActivity.this,FlappyBirdActivity.class);
                    startActivity(flappy);
                    break;
                case R.id.ivRSP:
                    Intent rsp = new Intent(MainActivity.this,RockScissorsPaperActivity.class);
                    startActivity(rsp);
                    break;
                case R.id.ivLots:
                    Intent Lots = new Intent(MainActivity.this,DrawingLotsActivity.class);
                    startActivity(Lots);
                    break;
            }
        }
    };
}