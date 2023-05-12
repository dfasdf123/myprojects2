package com.ksi.myprojects;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class IntroActivity extends AppCompatActivity {

    Animation ani;

    ImageView intro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        intro = (ImageView) findViewById(R.id.intro);
        ani = AnimationUtils.loadAnimation(this,R.anim.alpha);

        intro.startAnimation(ani);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run()
            {
                Intent intent = new Intent(IntroActivity.this,MainActivity.class);
                startActivity(intent);
            }
        },3700);
    }
}