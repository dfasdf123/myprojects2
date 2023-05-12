package com.ksi.myprojects;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;

public class DrawingLotsActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnReset;
    private ImageView[] buttons =  new ImageView[4];

    private ArrayList<Integer> imageList;

    private ArrayList<LotsData> lots;
    Animation ani;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing_lots);
        ani = AnimationUtils.loadAnimation(this,R.anim.alpha);
        btnReset = (Button) findViewById(R.id.btnReset);

        init();

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               init();


            }
        });


    }
    void init()
    {
        imageList = new ArrayList<>();
        imageList.add(R.drawable.boom);
        imageList.add(R.drawable.bomb);
        imageList.add(R.drawable.bomb);
        imageList.add(R.drawable.bomb);



        //순서 섞기
        Collections.shuffle(imageList);

        lots = new ArrayList<>();

        //버튼 초기화
        for(int i = 0; i < buttons.length; i++){

            String buttonID = "iv" + i;
            int resourceID = getResources().getIdentifier(buttonID, "id", getPackageName());
            buttons[i] = findViewById(resourceID);

            //각 버튼에 클릭이벤트 적용
            buttons[i].setOnClickListener(this);

            //카드 리스트에 담기
            lots.add(new LotsData(imageList.get(i),false));
            //버튼 이미지 적용
            buttons[i].setImageResource(R.drawable.bomb);



        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        int position = 0;

        if(id == R.id.iv0)
        {
            position = 0;
        }else if(id == R.id.iv1)
        {
            position = 1;
        }else if(id == R.id.iv2)
        {
            position = 2;
        }else if(id == R.id.iv3)
        {
            position = 3;
        }
        updateModel(position);
        updateView(position);
    }
    //데이터 변경
    private void updateModel(int position){

        LotsData lot = lots.get(position);



        //반대의 값을 넣는다. 앞면 -> 뒷면 , 뒷면 -> 앞면
        lots.get(position).setLotsFB(!lot.isLotsFB());
    }
    private void updateView(int position){

        LotsData lot = lots.get(position);

        //뒤집었음 랜덤 이미지로 보여준다.
        if(lot.isLotsFB()){
            buttons[position].setImageResource(lot.getImageId());

        }else{ //기본 이미지
            buttons[position].setImageResource(R.drawable.bomb);
        }
    }


    ;
}