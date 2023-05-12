package com.ksi.myprojects;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TicTacToeActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView pOneScore, pTwoScore, pStatus;
    private Button[] buttons = new Button[9];
    private Button resetGame;

    private int pOneScoreCount, pTwoScoreCount, roundCount;

    //활성화 플레이어
    boolean activityPlayer; //true: p1, false: p2

    //클릭 한 버튼위치 들어갈 배열
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    //승리 위치
    int[][] winningPosition = {
            {0,1,2}, {3,4,5}, {6,7,8}, //가로 한 줄
            {0,3,6}, {1,4,7}, {2,5,8}, //세로 한 줄
            {0,4,8}, {2,4,6} //대각선 한 줄
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);

        //컴포넌트 초기화
        pOneScore = findViewById(R.id.playerOneScore);
        pTwoScore = findViewById(R.id.playerTwoScore);
        pStatus = findViewById(R.id.playerStatus);
        resetGame = findViewById(R.id.resetGame);

        //버튼 초기화
        for(int i = 0; i < buttons.length; i++){

            String buttonID = "btn_" + i;
            int resourceID = getResources().getIdentifier(buttonID, "id", getPackageName());
            buttons[i] = findViewById(resourceID);
            buttons[i].setOnClickListener(this);
        }

        //변수 초기화
        roundCount = 0; //클릭 횟수
        pOneScoreCount = 0; //플레이어1 승수
        pTwoScoreCount = 0; //플레이어2 승수
        activityPlayer = true; //플레이어 차례

        //게임 전체 초기화
        resetGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerAgain(); //게임 초기화
                pOneScoreCount = 0;
                pTwoScoreCount = 0;
                pStatus.setText("");
                updatePlayerScore(); // 점수 초기화
            }
        });
    }//onCreate
    public boolean checkWinner(){

        boolean winnerResult = false;

        for(int [] winningPosition : winningPosition){

            if(gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                    gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                    gameState[winningPosition[0]] != 2){

                winnerResult = true;
            }
        }
        return winnerResult;
    }
    public void updatePlayerScore() {

        pOneScore.setText(Integer.toString(pOneScoreCount));
        pTwoScore.setText(Integer.toString(pTwoScoreCount));
    }
    public void playerAgain() {

        roundCount = 0; //클릭 횟수
        activityPlayer = true; //플레이어 차례

        //버튼 초기화
        for(int i = 0; i < buttons.length; i++){
            gameState[i] = 2;
            buttons[i].setText("");
        }
    }
    @Override
    public void onClick(View view) {

        //버튼값이 비워있지 않으면 리턴
        if(!((Button)view).getText().toString().equals("")){
            return;
        }

        //버튼 ID 변수에 담기(예: btn_2 )
        String buttonID = view.getResources().getResourceEntryName(view.getId());

        //버튼 ID에서 숫자만 변수에 담기 (예:2)
        int gameStatePointer = Integer.parseInt(buttonID.substring(buttonID.length()-1, buttonID.length()));

        //사용자 순서 true: player1, false: player2
        if(activityPlayer){

            //버튼 텍스트 설정
            ((Button)view).setText("X");

            //버튼 텍스트 색상 설정
            ((Button)view).setTextColor(Color.parseColor("#00D8FF"));

            //해당 위치에 0을 넣는다.
            gameState[gameStatePointer] = 0;

        }else{
            //버튼 텍스트 설정
            ((Button)view).setText("O");

            //버튼 텍스트 색상 설정
            ((Button)view).setTextColor(Color.parseColor("#ABF200"));

            //해당 위치에 1을 넣는다.
            gameState[gameStatePointer] = 1;
        }

        roundCount++; //버튼 클릭 갯수 올리기

        //승리 체크
        if(checkWinner()){
            if(activityPlayer){
                pOneScoreCount++; //승수 올리기
                updatePlayerScore(); //승수 업데이트
                AlertDialog.Builder dlg = new AlertDialog.Builder(TicTacToeActivity.this);
                dlg.setTitle("게임결과"); //제목
                dlg.setMessage("player1 승리!"); // 메시지
                dlg.setPositiveButton("확인",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dlg.show();
                playerAgain();//게임 초기화
            }else{
                pTwoScoreCount++; //승수 올리기
                updatePlayerScore(); //승수 업데이트
                AlertDialog.Builder dlg = new AlertDialog.Builder(TicTacToeActivity.this);
                dlg.setTitle("게임결과"); //제목
                dlg.setMessage("player2 승리!"); // 메시지
                dlg.setPositiveButton("확인",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dlg.show();
                playerAgain();//게임 초기화

            }
        }else if(roundCount == 9){ //9개가 다 채워졌는데 승부가 안났다면
            playerAgain();
            AlertDialog.Builder dlg = new AlertDialog.Builder(TicTacToeActivity.this);
            dlg.setTitle("게임결과"); //제목
            dlg.setMessage("무승무!"); // 메시지
            dlg.setPositiveButton("확인",new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            dlg.show();

        }else{ //상대방 차례로 변경
            activityPlayer = !activityPlayer;
        }
    }
}