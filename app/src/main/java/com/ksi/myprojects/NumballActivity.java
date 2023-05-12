package com.ksi.myprojects;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Random;

public class NumballActivity extends AppCompatActivity {

    EditText requestText;

    TextView responseText, resultText, lifeCountText;

    Button startBtn, answerBtn, resetBtn;
    MediaPlayer player;

    String num = "";

    //랜덤한 숫자 들어갈 배열
    int[] com = new int[4];

    //사용자가 입력한 숫자 들어갈 배열
    int[] user = new int[4];

    int strike = 0; //스트라이크 갯수
    int ball = 0; //볼 갯수

    int lifeCount = 10; //기회 횟수

    String result = ""; //답변

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numball);

        requestText = findViewById(R.id.request_text);

        responseText = findViewById(R.id.response_text);

        lifeCountText = findViewById(R.id.life_count_text);

        resultText = findViewById(R.id.result_text);

        answerBtn = findViewById(R.id.answer_btn);

        startBtn = findViewById(R.id.start_btn);

        resetBtn = findViewById(R.id.reset_btn);

        findViewById(R.id.btn1).setOnClickListener(mClickListener);
        findViewById(R.id.btn2).setOnClickListener(mClickListener);
        findViewById(R.id.btn3).setOnClickListener(mClickListener);
        findViewById(R.id.btn4).setOnClickListener(mClickListener);
        findViewById(R.id.btn5).setOnClickListener(mClickListener);
        findViewById(R.id.btn6).setOnClickListener(mClickListener);
        findViewById(R.id.btn7).setOnClickListener(mClickListener);
        findViewById(R.id.btn8).setOnClickListener(mClickListener);
        findViewById(R.id.btn9).setOnClickListener(mClickListener);

        player = MediaPlayer.create(this,R.raw.baseballgame);

        //쉬는중
        viewMode("end");

        //시작버튼 클릭 이벤트
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                player.start();

                //랜덤한 수 생성
                randomNumber();

                //게임중
                viewMode("start");

                Toast.makeText(NumballActivity.this, "게임이 시작되었습니다.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        //리셋버튼 이벤트
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(NumballActivity.this, "초기화되었습니다.",
                        Toast.LENGTH_SHORT).show();

                viewMode("end");

                //초기화로직
                reset();
            }
        });

        //정답제출버튼 이벤트
        answerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //비교로직
                numberCheck();
                num = "";
            }
        });

    }//onCreate();


    public void randomNumber(){

        int count = 0;

        Random random = new Random();

        HashSet set = new HashSet();

        //랜덤숫자 4개 생성
        while(set.size() < 4){

            int randomNumber = random.nextInt(9)+1; // 1 ~ 9

            set.add(randomNumber);
        }

        //배열에 숫자 담기
        for(Object number : set){

            Integer tempNumber = (Integer) number;

            Log.d("Main", "tempNumber: " + tempNumber);

            com[count] = tempNumber;
            count++;
        }
    }


    public void numberCheck(){

        //기회횟수 감소
        --lifeCount;

        lifeCountText.setText("기회: " + lifeCount + "번");

        //입력값
        String inputNumber = requestText.getText().toString();

        if(inputNumber.length() == 4){ //숫자 3개여야 비교함

            //사용자가 입력한 숫자 배열에 넣기
            user[0] = Integer.parseInt(inputNumber.substring(0,1));
            user[1] = Integer.parseInt(inputNumber.substring(1,2));
            user[2] = Integer.parseInt(inputNumber.substring(2,3));
            user[3] = Integer.parseInt(inputNumber.substring(3,4));

            //비교
            for(int i = 0; i < 4; i++){

                for(int j = 0; j < 4; j++){

                    //랜덤숫자와 입력숫자가 같다면
                    if(com[i] == user[j]){

                        if(i == j){//위치까지 맞다면
                            //strike
                            strike++;
                        }else{//존재여부만 맞다면
                            //ball
                            ball++;
                        }
                    }
                }
            }

            //1.숫자 다 맞음
            if(strike == 4){

                AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                dlg.setTitle("게임결과"); //제목
                dlg.setMessage("성공!"); // 메시지
                dlg.setPositiveButton("확인",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dlg.show();

                //답변
                responseText.setText("정답: " + com[0] + " " + com[1] + " " + com[2] +" "+ com[3]);

            }
            else if(lifeCount == 0){ //기회횟수 없음

                AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                dlg.setTitle("게임결과"); //제목
                dlg.setMessage("실패..."); // 메시지
                dlg.setPositiveButton("확인",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dlg.show();

                //답변
                responseText.setText("정답: " + com[0] + " " + com[1] + " " + com[2]+" "+ com[3]);
            }

            else{ //계속 진행

                //답변
                responseText.setText("strike: " + strike + " ball: " + ball);

                //목록
                showResult(inputNumber);
            }

            //초기화
            requestText.setText("");
            result  ="";
            strike = 0;
            ball = 0;

        }else{
            Toast.makeText(this, "숫자 4개를 입력해주세요.", Toast.LENGTH_SHORT).show();
        }
    }


    public void viewMode(String mode){

        if(mode.equals("start")){ //게임중

            startBtn.setEnabled(false);
            answerBtn.setEnabled(true);
            resetBtn.setEnabled(true);
            requestText.setEnabled(true);

        }else if(mode.equals("end")){//쉬는중

            startBtn.setEnabled(true);
            answerBtn.setEnabled(false);
            resetBtn.setEnabled(false);
            requestText.setEnabled(false);
        }
    }


    public void reset(){

        lifeCount = 10;
        lifeCountText.setText("기회: " + lifeCount + "번");
        responseText.setText("");//답변 텍스트뷰
        resultText.setText("");//결과목록 텍스트뷰
    }

    public void showResult(String inputNumber){

        result = result + "Strike: " + strike + " Ball: " + ball;
        resultText.append(inputNumber + ": " + result + "\n");
    }
    ImageView.OnClickListener mClickListener = new ImageView.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn1:
                    num += "1";
                    requestText.setText(num);
                    break;
                case R.id.btn2:
                    num += "2";
                    requestText.setText(num);
                    break;
                case R.id.btn3:
                    num += "3";
                    requestText.setText(num);
                    break;
                case R.id.btn4:
                    num += "4";
                    requestText.setText(num);
                    break;
                case R.id.btn5:
                    num += "5";
                    requestText.setText(num);
                    break;
                case R.id.btn6:
                    num += "6";
                    requestText.setText(num);
                    break;
                case R.id.btn7:
                    num += "7";
                    requestText.setText(num);
                    break;
                case R.id.btn8:
                    num += "8";
                    requestText.setText(num);
                    break;
                case R.id.btn9:
                    num += "9";
                    requestText.setText(num);
                    break;
            }
        }
    };

}