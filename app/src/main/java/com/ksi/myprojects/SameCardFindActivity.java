package com.ksi.myprojects;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class SameCardFindActivity extends AppCompatActivity implements View.OnClickListener{

    //버튼 배열
    private ImageButton[] buttons =  new ImageButton[16];

    //이미지 리스트
    private ArrayList<Integer> imageList;

    //카드 리스트
    private ArrayList<CardData> cards;

    int score = 0;
    
    TextView tvTime;

    //이전 카드 위치
    int preCardPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_same_card);
        
        tvTime = (TextView) findViewById(R.id.tvTime);

        Button startBtn = findViewById(R.id.btnStart);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score = 0;
                init();
                tvTime.setText("점수:"+ score + "점!");

            }
        });

        Button resetBtn = findViewById(R.id.btnReset);
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score = 0;
                init();
                tvTime.setText("점수:"+ score + "점!");

            }
        });


    }//onClick

    //초기화
    public void init(){

        //리스트에 데이터 등록
        imageList = new ArrayList<>();
        imageList.add(R.drawable.gibonjjangu);
        imageList.add(R.drawable.jangu);
        imageList.add(R.drawable.pajamajangu);
        imageList.add(R.drawable.runjangu);
        imageList.add(R.drawable.hipmangu);
        imageList.add(R.drawable.culsupaino);
        imageList.add(R.drawable.siro);
        imageList.add(R.drawable.jjanga);
        imageList.add(R.drawable.gibonjjangu);
        imageList.add(R.drawable.jangu);
        imageList.add(R.drawable.pajamajangu);
        imageList.add(R.drawable.runjangu);
        imageList.add(R.drawable.hipmangu);
        imageList.add(R.drawable.culsupaino);
        imageList.add(R.drawable.siro);
        imageList.add(R.drawable.jjanga);

        //순서 섞기
        Collections.shuffle(imageList);

        //카드 리스트 초기화
        cards = new ArrayList<>();

        //버튼 초기화
        for(int i = 0; i < buttons.length; i++){

            String buttonID = "imageBtn" + i;
            int resourceID = getResources().getIdentifier(buttonID, "id", getPackageName());
            buttons[i] = findViewById(resourceID);

            //각 버튼에 클릭이벤트 적용
            buttons[i].setOnClickListener(this);

            //카드 리스트에 담기
            cards.add(new CardData(imageList.get(i), false, false));
            //버튼 이미지 적용
            buttons[i].setImageResource(R.drawable.q);
            //선명도 설정
            buttons[i].setAlpha(1.0f);
        }
    }

    @Override
    public void onClick(View view) {

        int id = view.getId();

        int position = 0;

        if(id == R.id.imageBtn0){
            position = 0;

        }else if(id == R.id.imageBtn1){
            position = 1;
        }else if(id == R.id.imageBtn2){
            position = 2;
        }else if(id == R.id.imageBtn3){
            position = 3;
        }else if(id == R.id.imageBtn4){
            position = 4;
        }else if(id == R.id.imageBtn5){
            position = 5;
        }else if(id == R.id.imageBtn6){
            position = 6;
        }else if(id == R.id.imageBtn7){
            position = 7;
        }else if(id == R.id.imageBtn8){
            position = 8;
        }else if(id == R.id.imageBtn9){
            position = 9;
        }else if(id == R.id.imageBtn10){
            position = 10;
        }else if(id == R.id.imageBtn11){
            position = 11;
        }else if(id == R.id.imageBtn12){
            position = 12;
        }else if(id == R.id.imageBtn13){
            position = 13;
        }else if(id == R.id.imageBtn14){
            position = 14;
        }else if(id == R.id.imageBtn15){
            position = 15;
        }
        updateModel(position);

        updateView(position);


    }
    //데이터 변경
    private void updateModel(int position){

        CardData card = cards.get(position);

        //나중에 카드 비교 할때 뒤집고 다시 클릭하는거 방지
        if(card.isCardFB()){

            Toast.makeText(this, "이미 뒤집음!", Toast.LENGTH_SHORT).show();
            return;
        }
        //뒤집힌 카드: 이전에 뒤집힌 카드 0 또는 2개일때
        if(preCardPosition == -1){
            //카드 초기화
            restoreCard();

            //위치 저장
            preCardPosition = position;

        }else{ //이전에 뒤집힌 카드: 1개일때
            //카드 비교
            checkForMatch(preCardPosition, position);
            preCardPosition = -1;
        }

        //반대의 값을 넣는다. 앞면 -> 뒷면 , 뒷면 -> 앞면
        cards.get(position).setCardFB(!card.isCardFB());
    }

    //뷰 변경
    private void updateView(int position){

        CardData card = cards.get(position);

        //뒤집었음 랜덤 이미지로 보여준다.
        if(card.isCardFB()){
            buttons[position].setImageResource(card.getImageId());

        }else{ //기본 이미지
            buttons[position].setImageResource(R.drawable.q);
        }
    }

    private void restoreCard(){

        for(int i = 0; i < cards.size(); i++){

            //매치되지 않은거
            if(!cards.get(i).isCardMatch()){

                //이미지 앞으로
                buttons[i].setImageResource(R.drawable.q);

                //데이터 수정
                cards.get(i).setCardFB(false);
            }
        }
    }
    private void checkForMatch(int prePosition, int position){

        //처음 카드와 두번째 카드 이미지가 같다면
        if(cards.get(prePosition).getImageId() == cards.get(position).getImageId()){

                score += 10;
                tvTime.setText("점수:"+ score + "점!");





            cards.get(prePosition).setCardMatch(true);
            cards.get(position).setCardMatch(true);

            //색상변경
            buttons[prePosition].setAlpha(0.1f);
            buttons[position].setAlpha(0.1f);

            //완료 체크
            checkCompletion();
        }else{
                score -= 5;
                tvTime.setText("점수:"+ score + "점!");

        }
    }

   //완료체크
    private void checkCompletion(){

        int count = 0;

        for(int i =0; i < cards.size(); i++){

            if(cards.get(i).isCardMatch()){

                count++;
            }
        }
        //매치갯수가 카드갯수와 같다면 완료
        if(count == cards.size()){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("게임결과"); //제목
            dlg.setMessage("점수: "+ score+"점!"); // 메시지
            dlg.setPositiveButton("확인",new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            dlg.show();
            tvTime.setText("점수:"+score+"점!");
        }
    }
}