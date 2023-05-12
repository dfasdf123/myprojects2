package com.ksi.myprojects;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class YachtActivity extends AppCompatActivity {

    int dice1P = R.drawable.dice1;
    int dice2P = R.drawable.dice2;
    int dice3P = R.drawable.dice3;
    int dice4P = R.drawable.dice4;
    int dice5P = R.drawable.dice5;
    private ImageButton[] buttons = new ImageButton[5];

    Animation ani;

    boolean scoreCheck = true, aceCheck = true, deuceCheck = true, threesCheck = true, foursCheck = true,
    fivesCheck = true, sixesCheck = true, fourCardCheck = true, totalCheck = true;

    ImageButton dice1, dice2, dice3, dice4,dice5;

    Button btnRoll, btnSave, btnReset, btnjok;

    TextView tvChance,  tvRound;

    TextView tvChoice,tvAces, tvDeuces, tvThrees, tvFours, tvFives, tvSixes, tv4K, tvFH, tvS_st, tvB_st,
            tvYacht, tvBonus, tvTot;
    int  choice,aces, deuces, threes, fours, fives, sixes, fk, fh, sst, bst, yacht, bonus, tot;
    int chance = 3, round = 1;
    int position = 0;
    boolean chanceCheck = true;
    boolean roundCheck = true;
    boolean saveCheck = true;
    Random random = new Random();

    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yacht);

        ani = AnimationUtils.loadAnimation(this,R.anim.shake);

        tvChance = (TextView) findViewById(R.id.tvChance);
        tvRound = (TextView) findViewById(R.id.tvRound);
        tvChoice = (TextView) findViewById(R.id.tvChoice);
        tvAces = (TextView) findViewById(R.id.tvAces);
        tvDeuces = (TextView) findViewById(R.id.tvDeuces);
        tvThrees = (TextView) findViewById(R.id.tvThrees);
        tvFours = (TextView) findViewById(R.id.tvFours);
        tvFives = (TextView) findViewById(R.id.tvFives);
        tvSixes = (TextView) findViewById(R.id.tvSixes);
        tv4K = (TextView) findViewById(R.id.tv4K);
        tvFH = (TextView) findViewById(R.id.tvFH);
        tvS_st = (TextView) findViewById(R.id.tvS_st);
        tvB_st = (TextView) findViewById(R.id.tvB_st);
        tvYacht = (TextView) findViewById(R.id.tvYacht);
        tvBonus = (TextView) findViewById(R.id.tvBonus);
        tvTot = (TextView) findViewById(R.id.tvTot);

        dice1 = (ImageButton) findViewById(R.id.dice1);
        dice2 = (ImageButton) findViewById(R.id.dice2);
        dice3 = (ImageButton) findViewById(R.id.dice3);
        dice4 = (ImageButton) findViewById(R.id.dice4);
        dice5 = (ImageButton) findViewById(R.id.dice5);

        btnRoll = (Button) findViewById(R.id.btnRoll);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnReset = (Button) findViewById(R.id.btnReset);
        btnjok = (Button) findViewById(R.id.btnjok);

        player = MediaPlayer.create(YachtActivity.this,R.raw.dice);


        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                diceRoll();
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreFourCards();
                scoreAces();
                scoreDeuces();
                scoreThrees();
                scoreFours();
                scoreFives();
                scoreSixes();
                scoreFullHouse();
                scoreB_st();
                scoreS_st();
                socreYacht();
                scoreChoice();
                bonus();
                nextRound();

            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 start();

            }
        });
        btnjok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent jokbo = new Intent(YachtActivity.this,yachtjokbo.class);
                startActivity(jokbo);
            }
        });
    }

    void diceRoll() {

            // 1. 랜덤으로 숫자를 가져온다.

            int num1 = random.nextInt(6); // 0~5 까지
            int num2 = random.nextInt(6);
            int num3 = random.nextInt(6);
            int num4 = random.nextInt(6);
            int num5 = random.nextInt(6);

            player.start();
            // 2. 각각 가져온 랜덤 숫자에 맞게, 이미지를 바꿔준다.
            if (chance > 0) {
                dice1.startAnimation(ani);
                dice2.startAnimation(ani);
                dice3.startAnimation(ani);
                dice4.startAnimation(ani);
                dice5.startAnimation(ani);
                chanceCheck = true;
                if (saveCheck = true) {
                    if (num1 == 0) {
                        dice1.setImageResource(R.drawable.dice1);
                        position = 0;
                        dice1P = position;
                    } else if (num1 == 1) {
                        dice1.setImageResource(R.drawable.dice2);
                        position = 1;
                        dice1P = position;
                    } else if (num1 == 2) {
                        dice1.setImageResource(R.drawable.dice3);
                        position = 2;
                        dice1P = position;
                    } else if (num1 == 3) {
                        dice1.setImageResource(R.drawable.dice4);
                        position = 3;
                        dice1P = position;
                    } else if (num1 == 4) {
                        dice1.setImageResource(R.drawable.dice5);
                        position = 4;
                        dice1P = position;
                    } else if (num1 == 5) {
                        dice1.setImageResource(R.drawable.dice6);
                        position = 5;
                        dice1P = position;
                    }
                }else {saveCheck = false; dice1.setEnabled(false);}


                if (num2 == 0) {
                    dice2.setImageResource(R.drawable.dice1);
                    position = 0;
                    dice2P = position;
                } else if (num2 == 1) {
                    dice2.setImageResource(R.drawable.dice2);
                    position = 1;
                    dice2P = position;
                } else if (num2 == 2) {
                    dice2.setImageResource(R.drawable.dice3);
                    position = 2;
                    dice2P = position;
                } else if (num2 == 3) {
                    dice2.setImageResource(R.drawable.dice4);
                    position = 3;
                    dice2P = position;
                } else if (num2 == 4) {
                    dice2.setImageResource(R.drawable.dice5);
                    position = 4;
                    dice2P = position;
                } else if (num2 == 5) {
                    dice2.setImageResource(R.drawable.dice6);
                    position = 5;
                    dice2P = position;
                }

                if (num3 == 0) {
                    dice3.setImageResource(R.drawable.dice1);
                    position = 0;
                    dice3P = position;
                } else if (num3 == 1) {
                    dice3.setImageResource(R.drawable.dice2);
                    position = 1;
                    dice3P = position;
                } else if (num3 == 2) {
                    dice3.setImageResource(R.drawable.dice3);
                    position = 2;
                    dice3P = position;
                } else if (num3 == 3) {
                    dice3.setImageResource(R.drawable.dice4);
                    position = 3;
                    dice3P = position;
                } else if (num3 == 4) {
                    dice3.setImageResource(R.drawable.dice5);
                    position = 4;
                    dice3P = position;
                } else if (num3 == 5) {
                    dice3.setImageResource(R.drawable.dice6);
                    position = 5;
                    dice3P = position;
                }

                if (num4 == 0) {
                    dice4.setImageResource(R.drawable.dice1);
                    position = 0;
                    dice4P = position;
                } else if (num4 == 1) {
                    dice4.setImageResource(R.drawable.dice2);
                    position = 1;
                    dice4P = position;
                } else if (num4 == 2) {
                    dice4.setImageResource(R.drawable.dice3);
                    position = 2;
                    dice4P = position;
                } else if (num4 == 3) {
                    dice4.setImageResource(R.drawable.dice4);
                    position = 3;
                    dice4P = position;
                } else if (num4 == 4) {
                    dice4.setImageResource(R.drawable.dice5);
                    position = 4;
                    dice4P = position;
                } else if (num4 == 5) {
                    dice4.setImageResource(R.drawable.dice6);
                    position = 5;
                    dice4P = position;
                }

                if (num5 == 0) {
                    dice5.setImageResource(R.drawable.dice1);
                    position = 0;
                    dice5P = position;
                } else if (num5 == 1) {
                    dice5.setImageResource(R.drawable.dice2);
                    position = 1;
                    dice5P = position;
                } else if (num5 == 2) {
                    dice5.setImageResource(R.drawable.dice3);
                    position = 2;
                    dice5P = position;
                } else if (num5 == 3) {
                    dice5.setImageResource(R.drawable.dice4);
                    position = 3;
                    dice5P = position;
                } else if (num5 == 4) {
                    dice5.setImageResource(R.drawable.dice5);
                    position = 4;
                    dice5P = position;
                } else if (num5 == 5) {
                    dice5.setImageResource(R.drawable.dice6);
                    position = 5;
                    dice5P = position;
                }

                chance--;
                tvChance.setText("Chance: " + chance + "/3");
                tvRound.setText("Round: " + round + "/13");

            } else if (chance == 0) {
                chanceCheck = false;
            }
        }
        void nextRound()
        {
            if (round < 13) {
                roundCheck = true;
                saveCheck = true;
                chance = 3;
                round++;
                tvChance.setText("Chance: " + chance + "/3");
                tvRound.setText("Round: " + round + "/13");
                dice1.setEnabled(true);
                dice1.setImageResource(R.drawable.dice);
                dice2.setImageResource(R.drawable.dice);
                dice3.setImageResource(R.drawable.dice);
                dice4.setImageResource(R.drawable.dice);
                dice5.setImageResource(R.drawable.dice);
            } else if (round == 13) {
                roundCheck = false;
                AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                dlg.setTitle("게임결과"); //제목
                dlg.setMessage("총점: "+ tot + "점!"); // 메시지
                dlg.setPositiveButton("확인",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dlg.show();
            }

        }
        void start()
        {
            chance = 3;
            round = 1;
            choice = 0;
            aces = 0;
            deuces = 0;
            threes = 0;
            fours = 0;
            fives = 0;
            sixes = 0;
            fk = 0;
            fh = 0;
            sst = 0;
            bst = 0;
            yacht = 0;
            bonus = 0;
            tot = 0;

            tvChance.setText("Chance: " + chance + "/3");
            tvRound.setText("Round: " + round + "/13");
            tvChoice.setText(choice+"");
            tvAces.setText(aces+"");
            tvDeuces.setText(deuces+"");
            tvThrees.setText(threes+"");
            tvFours.setText(fours+"");
            tvFives.setText(fives+"");
            tvSixes.setText(sixes+"");
            tv4K.setText(fk+"");
            tvFH.setText(fh+"");
            tvS_st.setText(sst+"");
            tvB_st.setText(bst+"");
            tvYacht.setText(yacht+"");
            tvBonus.setText(bonus+"");
            tvTot.setText(tot+"");

            dice1.setImageResource(R.drawable.dice);
            dice2.setImageResource(R.drawable.dice);
            dice3.setImageResource(R.drawable.dice);
            dice4.setImageResource(R.drawable.dice);
            dice5.setImageResource(R.drawable.dice);
        }
        void scoreAces() {
            if (aces == 0)
            {
                aceCheck = true;
                if (dice1P == 0 && dice2P == 0 && dice3P == 0) {
                    aces += 3;
                    tot += 3;
                    tvAces.setText(aces + "");
                    tvTot.setText(tot + "");
                } else if (dice1P == 0 && dice2P == 0 && dice4P == 0) {
                    aces += 3;
                    tot += 3;
                    tvTot.setText(tot + "");
                    tvAces.setText(aces + "");
                } else if (dice1P == 0 && dice2P == 0 && dice5P == 0) {
                    aces += 3;
                    tot += 3;
                    tvTot.setText(tot + "");
                    tvAces.setText(aces + "");
                } else if (dice1P == 0 && dice3P == 0 && dice4P == 0) {
                    aces += 3;
                    tot += 3;
                    tvTot.setText(tot + "");
                    tvAces.setText(aces + "");
                } else if (dice1P == 0 && dice3P == 0 && dice5P == 0) {
                    aces += 3;
                    tot += 3;
                    tvTot.setText(tot + "");
                    tvAces.setText(aces + "");
                } else if (dice1P == 0 && dice4P == 0 && dice5P == 0) {
                    aces += 3;
                    tot += 3;
                    tvTot.setText(tot + "");
                    tvAces.setText(aces + "");
                } else if (dice2P == 0 && dice3P == 0 && dice4P == 0) {
                    aces += 3;
                    tot += 3;
                    tvTot.setText(tot + "");
                    tvAces.setText(aces + "");
                } else if (dice2P == 0 && dice3P == 0 && dice5P == 0) {
                    aces += 3;
                    tot += 3;
                    tvTot.setText(tot + "");
                    tvAces.setText(aces + "");
                } else if (dice3P == 0 && dice4P == 0 && dice5P == 0) {
                    aces += 3;
                    tot += 3;
                    tvTot.setText(tot + "");
                    tvAces.setText(aces + "");
                }
            }
            else if(aces > 0)
            {
                aceCheck = false;
            }
        }
    void scoreDeuces() {
        if (deuces == 0)
        {
            deuceCheck = true;
            if (dice1P == 1 && dice2P == 1 && dice3P == 1) {
                deuces += 6;
                tot += 6;
                tvDeuces.setText(deuces + "");
                tvTot.setText(tot + "");
            } else if (dice1P == 1 && dice2P == 1 && dice4P == 1) {
                deuces += 6;
                tot += 6;
                tvDeuces.setText(deuces + "");
                tvTot.setText(tot + "");
            }else if (dice1P == 1 && dice2P == 1 && dice5P == 1) {
                deuces += 6;
                tot += 6;
                tvDeuces.setText(deuces + "");
                tvTot.setText(tot + "");
            }else if (dice1P == 1 && dice3P == 1 && dice4P == 1) {
                deuces += 6;
                tot += 6;
                tvDeuces.setText(deuces + "");
                tvTot.setText(tot + "");
            }else if (dice1P == 1 && dice3P == 1 && dice5P == 1) {
                deuces += 6;
                tot += 6;
                tvDeuces.setText(deuces + "");
                tvTot.setText(tot + "");
            }else if (dice1P == 1 && dice4P == 1 && dice5P == 1) {
                deuces += 6;
                tot += 6;
                tvDeuces.setText(deuces + "");
                tvTot.setText(tot + "");
            }else if (dice2P == 1 && dice3P == 1 && dice4P == 1) {
                deuces += 6;
                tot += 6;
                tvDeuces.setText(deuces + "");
                tvTot.setText(tot + "");
            }else if (dice2P == 1 && dice3P == 1 && dice5P == 1) {
                deuces += 6;
                tot += 6;
                tvDeuces.setText(deuces + "");
                tvTot.setText(tot + "");
            }else if (dice3P == 1 && dice4P == 1 && dice5P == 1) {
                deuces += 6;
                tot += 6;
                tvDeuces.setText(deuces + "");
                tvTot.setText(tot + "");
            }

        }
        else if(deuces > 0)
        {
            deuceCheck = false;
        }
    }
    void scoreThrees() {
        if (threes == 0)
        {
            threesCheck = true;
            if (dice1P == 2 && dice2P == 2 && dice3P == 2) {
                threes += 9;
                tot += 9;
                tvThrees.setText(threes + "");
                tvTot.setText(tot + "");
            } else if (dice1P == 2 && dice2P == 2 && dice4P == 2) {
                threes += 9;
                tot += 9;
                tvThrees.setText(threes + "");
                tvTot.setText(tot + "");
            }else if (dice1P == 2 && dice2P == 2 && dice5P == 2) {
                threes += 9;
                tot += 9;
                tvThrees.setText(threes + "");
                tvTot.setText(tot + "");
            }else if (dice1P == 2 && dice3P == 2 && dice4P == 2) {
                threes += 9;
                tot += 9;
                tvThrees.setText(threes + "");
                tvTot.setText(tot + "");
            }else if (dice1P == 2 && dice3P == 2 && dice5P == 2) {
                threes += 9;
                tot += 9;
                tvThrees.setText(threes + "");
                tvTot.setText(tot + "");
            }else if (dice1P == 2 && dice4P == 2 && dice5P == 2) {
                threes += 9;
                tot += 9;
                tvThrees.setText(threes + "");
                tvTot.setText(tot + "");
            }else if (dice2P == 2 && dice3P == 2 && dice4P == 2) {
                threes += 9;
                tot += 9;
                tvThrees.setText(threes + "");
                tvTot.setText(tot + "");
            }else if (dice2P == 2 && dice3P == 2 && dice5P == 2) {
                threes += 9;
                tot += 9;
                tvThrees.setText(threes + "");
                tvTot.setText(tot + "");
            }else if (dice3P == 2 && dice4P == 2 && dice5P == 2) {
                threes += 9;
                tot += 9;
                tvThrees.setText(threes + "");
                tvTot.setText(tot + "");
            }

        }
        else if(threes > 0)
        {
            threesCheck = false;
        }
    }
    void scoreFours() {
        if (fours == 0)
        {
            foursCheck = true;
            if (dice1P == 3 && dice2P == 3 && dice3P == 3) {
                fours += 12;
                tot += 12;
                tvFours.setText(fours + "");
                tvTot.setText(tot + "");
            } else if (dice1P == 3 && dice2P == 3 && dice4P == 3) {
                fours += 12;
                tot += 12;
                tvFours.setText(fours + "");
                tvTot.setText(tot + "");
            }else if (dice1P == 3 && dice2P == 3 && dice5P == 3) {
                fours += 12;
                tot += 12;
                tvFours.setText(fours + "");
                tvTot.setText(tot + "");
            }else if (dice1P == 3 && dice3P == 3 && dice4P == 3) {
                fours += 12;
                tot += 12;
                tvFours.setText(fours + "");
                tvTot.setText(tot + "");
            }else if (dice1P == 3 && dice3P == 3 && dice5P == 3) {
                fours += 12;
                tot += 12;
                tvFours.setText(fours + "");
                tvTot.setText(tot + "");
            }else if (dice1P == 3 && dice4P == 3 && dice5P == 3) {
                fours += 12;
                tot += 12;
                tvFours.setText(fours + "");
                tvTot.setText(tot + "");
            }else if (dice2P == 3 && dice3P == 3 && dice4P == 3) {
                fours += 12;
                tot += 12;
                tvFours.setText(fours + "");
                tvTot.setText(tot + "");
            }else if (dice2P == 3 && dice3P == 3 && dice5P == 3) {
                fours += 12;
                tot += 12;
                tvFours.setText(fours + "");
                tvTot.setText(tot + "");
            }else if (dice3P == 3 && dice4P == 3 && dice5P == 3) {
                fours += 12;
                tot += 12;
                tvFours.setText(fours + "");
                tvTot.setText(tot + "");
            }

        }
        else if(fours > 0)
        {
            foursCheck = false;
        }
    }
    void scoreFives() {
        if (fives == 0)
        {
            fivesCheck = true;
            if (dice1P == 4 && dice2P == 4 && dice3P == 4) {
                fives += 15;
                tot += 15;
                tvFives.setText(fives + "");
                tvTot.setText(tot + "");
            } else if (dice1P == 4 && dice2P == 4 && dice4P == 4) {
                fives += 15;
                tot += 15;
                tvFives.setText(fives + "");
                tvTot.setText(tot + "");
            }else if (dice1P == 4 && dice2P == 4 && dice5P == 4) {
                fives += 15;
                tot += 15;
                tvFives.setText(fives + "");
                tvTot.setText(tot + "");
            }else if (dice1P == 4 && dice3P == 4 && dice4P == 4) {
                fives += 15;
                tot += 15;
                tvFives.setText(fives + "");
                tvTot.setText(tot + "");
            }else if (dice1P == 4 && dice3P == 4 && dice5P == 4) {
                fives += 15;
                tot += 15;
                tvFives.setText(fives + "");
                tvTot.setText(tot + "");
            }else if (dice1P == 4 && dice4P == 4 && dice5P == 4) {
                fives += 15;
                tot += 15;
                tvFives.setText(fives + "");
                tvTot.setText(tot + "");
            }else if (dice2P == 4 && dice3P == 4 && dice4P == 4) {
                fives += 15;
                tot += 15;
                tvFives.setText(fives + "");
                tvTot.setText(tot + "");
            }else if (dice2P == 4 && dice3P == 4 && dice5P == 4) {
                fives += 15;
                tot += 15;
                tvFives.setText(fives + "");
                tvTot.setText(tot + "");
            }else if (dice3P == 4 && dice4P == 4 && dice5P == 4) {
                fives += 15;
                tot += 15;
                tvFives.setText(fives + "");
                tvTot.setText(tot + "");
            }

        }
        else if(fives > 0)
        {
            fivesCheck = false;
        }
    }
    void scoreSixes() {
        if (sixes == 0)
        {
            sixesCheck = true;
            if (dice1P == 5 && dice2P == 5 && dice3P == 5) {
                sixes += 18;
                tot += 18;
                tvSixes.setText(sixes + "");
                tvTot.setText(tot + "");
            } else if (dice1P == 5 && dice2P == 5 && dice4P == 5) {
                sixes += 18;
                tot += 18;
                tvSixes.setText(sixes + "");
                tvTot.setText(tot + "");
            }else if (dice1P == 5 && dice2P == 5 && dice5P == 5) {
                sixes += 18;
                tot += 18;
                tvSixes.setText(sixes + "");
                tvTot.setText(tot + "");
            }else if (dice1P == 5 && dice3P == 5 && dice4P == 5) {
                sixes += 18;
                tot += 18;
                tvSixes.setText(sixes + "");
                tvTot.setText(tot + "");
            }else if (dice1P == 5 && dice3P == 5 && dice5P == 5) {
                sixes += 18;
                tot += 18;
                tvSixes.setText(sixes + "");
                tvTot.setText(tot + "");
            }else if (dice1P == 5 && dice4P == 5 && dice5P == 5) {
                sixes += 18;
                tot += 18;
                tvSixes.setText(sixes + "");
                tvTot.setText(tot + "");
            }else if (dice2P == 5 && dice3P == 5 && dice4P == 5) {
                sixes += 18;
                tot += 18;
                tvSixes.setText(sixes + "");
                tvTot.setText(tot + "");
            }else if (dice2P == 5 && dice3P == 5 && dice5P == 5) {
                sixes += 18;
                tot += 18;
                tvSixes.setText(sixes + "");
                tvTot.setText(tot + "");
            }else if (dice3P == 5 && dice4P == 5 && dice5P == 5) {
                sixes += 18;
                tot += 18;
                tvSixes.setText(sixes + "");
                tvTot.setText(tot + "");
            }

        }
        else if(fives > 0)
        {
            sixesCheck = false;
        }
    }
    void scoreFourCards()
    {
        if(fk == 0)
        {
            fourCardCheck = true;
            if(dice1P == dice2P && dice1P == dice3P && dice1P == dice4P)
            {
                fk += dice1P+dice2P+dice3P+dice4P+dice5P+5;
                tot += fk;
                tv4K.setText(fk+"");
                tvTot.setText(tot+"");
            }
            else if(dice1P == dice2P && dice1P == dice3P && dice1P == dice5P)
            {
                fk += dice1P+dice2P+dice3P+dice4P+dice5P+5;
                tot += fk;
                tv4K.setText(fk+"");
                tvTot.setText(tot+"");
            }
            else if(dice1P == dice2P && dice1P == dice4P && dice1P == dice5P)
            {
                fk += dice1P+dice2P+dice3P+dice4P+dice5P+5;
                tot += fk;
                tv4K.setText(fk+"");
                tvTot.setText(tot+"");
            }
            else if(dice1P == dice3P && dice1P == dice4P && dice1P == dice5P)
            {
                fk += dice1P+dice2P+dice3P+dice4P+dice5P+5;
                tot += fk;
                tv4K.setText(fk+"");
                tvTot.setText(tot+"");
            }
            else if(dice2P == dice3P && dice2P == dice4P && dice2P == dice5P)
            {
                fk += dice1P+dice2P+dice3P+dice4P+dice5P+5;
                tot += fk;
                tv4K.setText(fk+"");
                tvTot.setText(tot+"");
            }
        }
        else if(fk > 0)
        {
            fourCardCheck = false;
        }
    }
    void scoreFullHouse()
    {
        if(fh == 0)
        {
            scoreCheck = true;

            /////3개가 2 이고 2개가 1 일때//////
            if(dice1P == 1 && dice2P == 1 && dice3P == 1)
            {
                if(dice4P == 0 && dice5P == 0)
                {
                    fh += 8;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 1 && dice2P == 1 && dice4P == 1)
            {
                if(dice3P == 0 && dice5P == 0)
                {
                    fh += 8;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 1 && dice2P == 1 && dice5P == 1)
            {
                if(dice3P == 0 && dice4P == 0)
                {
                    fh += 8;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 1 && dice3P == 1 && dice4P == 1)
            {
                if(dice2P == 0 && dice5P == 0)
                {
                    fh += 8;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 1 && dice3P == 1 && dice5P == 1)
            {
                if(dice2P == 0 && dice4P == 0)
                {
                    fh += 8;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 1 && dice4P == 1 && dice4P == 1)
            {
                if(dice2P == 0 && dice5P == 0)
                {
                    fh += 8;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 1 && dice3P == 1 && dice4P == 1)
            {
                if(dice1P == 0 && dice5P == 0)
                {
                    fh += 8;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 1 && dice3P == 1 && dice5P == 1)
            {
                if(dice1P == 0 && dice4P == 0)
                {
                    fh += 8;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 1 && dice4P == 1 && dice5P == 1)
            {
                if(dice1P == 0 && dice3P == 0)
                {
                    fh += 8;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice3P == 1 && dice4P == 1 && dice5P == 1)
            {
                if(dice1P == 0 && dice2P == 0)
                {
                    fh += 8;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }




            ////3개가 3이고 2개가 1 일때/////
            if(dice1P == 2 && dice2P == 2 && dice3P == 2)
            {
                if(dice4P == 0 && dice5P == 0)
                {
                    fh += 11;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 2 && dice2P == 2 && dice4P == 2)
            {
                if(dice3P == 0 && dice5P == 0)
                {
                    fh += 11;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 2 && dice2P == 2 && dice5P == 2)
            {
                if(dice3P == 0 && dice4P == 0)
                {
                    fh += 11;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 2 && dice3P == 2 && dice4P == 2)
            {
                if(dice2P == 0 && dice5P == 0)
                {
                    fh += 11;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 2 && dice3P == 2 && dice5P == 2)
            {
                if(dice2P == 0 && dice4P == 0)
                {
                    fh += 11;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 2 && dice4P == 2 && dice4P == 2)
            {
                if(dice2P == 0 && dice5P == 0)
                {
                    fh += 11;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 2 && dice3P == 2 && dice4P == 2)
            {
                if(dice1P == 0 && dice5P == 0)
                {
                    fh += 11;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 2 && dice3P == 2 && dice5P == 2)
            {
                if(dice1P == 0 && dice4P == 0)
                {
                    fh += 11;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 2 && dice4P == 2 && dice5P == 2)
            {
                if(dice1P == 0 && dice3P == 0)
                {
                    fh += 11;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice3P == 2 && dice4P == 2 && dice5P == 2)
            {
                if(dice1P == 0 && dice2P == 0)
                {
                    fh += 11;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }



            ////3개가 4이고 2개가 1일때 //////
            if(dice1P == 3 && dice2P == 3 && dice3P == 3)
            {
                if(dice4P == 0 && dice5P == 0)
                {
                    fh += 14;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 3 && dice2P == 3 && dice4P == 3)
            {
                if(dice3P == 0 && dice5P == 0)
                {
                    fh += 14;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 3 && dice2P == 3 && dice5P == 3)
            {
                if(dice3P == 0 && dice4P == 0)
                {
                    fh += 14;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 3 && dice3P == 3 && dice4P == 3)
            {
                if(dice2P == 0 && dice5P == 0)
                {
                    fh += 14;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 3 && dice3P == 3 && dice5P == 3)
            {
                if(dice2P == 0 && dice4P == 0)
                {
                    fh += 14;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 3 && dice4P == 3 && dice4P == 3)
            {
                if(dice2P == 0 && dice5P == 0)
                {
                    fh += 14;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 3 && dice3P == 3 && dice4P == 3)
            {
                if(dice1P == 0 && dice5P == 0)
                {
                    fh += 14;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 3 && dice3P == 3 && dice5P == 3)
            {
                if(dice1P == 0 && dice4P == 0)
                {
                    fh += 14;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 3 && dice4P == 3 && dice5P == 3)
            {
                if(dice1P == 0 && dice3P == 0)
                {
                    fh += 14;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice3P == 3 && dice4P == 3 && dice5P == 3)
            {
                if(dice1P == 0 && dice2P == 0)
                {
                    fh += 14;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }


            /////3개가 5이고 2개가 1 일때///////
            if(dice1P == 4 && dice2P == 4 && dice3P == 4)
            {
                if(dice4P == 0 && dice5P == 0)
                {
                    fh += 17;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 4 && dice2P == 4 && dice4P == 4)
            {
                if(dice3P == 0 && dice5P == 0)
                {
                    fh += 17;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 4 && dice2P == 4 && dice5P == 4)
            {
                if(dice3P == 0 && dice4P == 0)
                {
                    fh += 17;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 4 && dice3P == 4 && dice4P == 4)
            {
                if(dice2P == 0 && dice5P == 0)
                {
                    fh += 17;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 4 && dice3P == 4 && dice5P == 4)
            {
                if(dice2P == 0 && dice4P == 0)
                {
                    fh += 17;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 4 && dice4P == 4 && dice4P == 4)
            {
                if(dice2P == 0 && dice5P == 0)
                {
                    fh += 17;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 4 && dice3P == 4 && dice4P == 4)
            {
                if(dice1P == 0 && dice5P == 0)
                {
                    fh += 17;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 4 && dice3P == 4 && dice5P == 4)
            {
                if(dice1P == 0 && dice4P == 0)
                {
                    fh += 17;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 4 && dice4P == 4 && dice5P == 4)
            {
                if(dice1P == 0 && dice3P == 0)
                {
                    fh += 17;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice3P == 4 && dice4P == 4 && dice5P == 4)
            {
                if(dice1P == 0 && dice2P == 0)
                {
                    fh += 17;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }



            //////3개가 6이고 2개가 1 일때///////////

            if(dice1P == 5 && dice2P == 5 && dice3P == 5)
            {
                if(dice4P == 0 && dice5P == 0)
                {
                    fh += 20;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 5 && dice2P == 5 && dice4P == 5)
            {
                if(dice3P == 0 && dice5P == 0)
                {
                    fh += 20;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 5 && dice2P == 5 && dice5P == 5)
            {
                if(dice3P == 0 && dice4P == 0)
                {
                    fh += 20;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 5 && dice3P == 5 && dice4P == 5)
            {
                if(dice2P == 0 && dice5P == 0)
                {
                    fh += 20;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 5 && dice3P == 5 && dice5P == 5)
            {
                if(dice2P == 0 && dice4P == 0)
                {
                    fh += 20;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 5 && dice4P == 5 && dice4P == 5)
            {
                if(dice2P == 0 && dice5P == 0)
                {
                    fh += 20;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 5 && dice3P == 5 && dice4P == 5)
            {
                if(dice1P == 0 && dice5P == 0)
                {
                    fh += 20;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 5 && dice3P == 5 && dice5P == 5)
            {
                if(dice1P == 0 && dice4P == 0)
                {
                    fh += 20;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 5 && dice4P == 5 && dice5P == 5)
            {
                if(dice1P == 0 && dice3P == 0)
                {
                    fh += 20;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice3P == 5 && dice4P == 5 && dice5P == 5)
            {
                if(dice1P == 0 && dice2P == 0)
                {
                    fh += 20;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }

                //3개가 1 이고 2개가 2 일때
                if(dice1P == 0 && dice2P == 0 && dice3P == 0)
                {
                    if(dice4P == 1 && dice5P == 1)
                    {
                        fh += 7;
                        tot += fh;
                        tvFH.setText(fh+"");
                        tvTot.setText(tot+"");
                    }
                }
                else if(dice1P == 0 && dice2P == 0 && dice4P == 0)
                {
                    if(dice3P == 1 && dice5P == 1)
                    {
                        fh += 7;
                        tot += fh;
                        tvFH.setText(fh+"");
                        tvTot.setText(tot+"");
                    }
                }
                else if(dice1P == 0 && dice2P == 0 && dice5P == 0)
                {
                    if(dice3P == 1 && dice4P == 1)
                    {
                        fh += 7;
                        tot += fh;
                        tvFH.setText(fh+"");
                        tvTot.setText(tot+"");
                    }
                }
                else if(dice1P == 0 && dice3P == 0 && dice4P == 0)
                {
                    if(dice2P == 1 && dice5P == 1)
                    {
                        fh += 7;
                        tot += fh;
                        tvFH.setText(fh+"");
                        tvTot.setText(tot+"");
                    }
                }
                else if(dice1P == 0 && dice3P == 0 && dice5P == 0)
                {
                    if(dice2P == 1 && dice4P == 1)
                    {
                        fh += 7;
                        tot += fh;
                        tvFH.setText(fh+"");
                        tvTot.setText(tot+"");
                    }
                }
                else if(dice1P == 0 && dice4P == 0 && dice4P == 0)
                {
                    if(dice2P == 1 && dice5P == 1)
                    {
                        fh += 7;
                        tot += fh;
                        tvFH.setText(fh+"");
                        tvTot.setText(tot+"");
                    }
                }
                else if(dice2P == 0 && dice3P == 0 && dice4P == 0)
                {
                    if(dice1P == 1 && dice5P == 1)
                    {
                        fh += 7;
                        tot += fh;
                        tvFH.setText(fh+"");
                        tvTot.setText(tot+"");
                    }
                }
                else if(dice2P == 0 && dice3P == 0 && dice5P == 0)
                {
                    if(dice1P == 1 && dice4P == 1)
                    {
                        fh += 7;
                        tot += fh;
                        tvFH.setText(fh+"");
                        tvTot.setText(tot+"");
                    }
                }
                else if(dice2P == 0 && dice4P == 0 && dice5P == 0)
                {
                    if(dice1P == 1 && dice3P == 1)
                    {
                        fh += 7;
                        tot += fh;
                        tvFH.setText(fh+"");
                        tvTot.setText(tot+"");
                    }
                }
                else if(dice3P == 0 && dice4P == 0 && dice5P == 0)
                {
                    if(dice1P == 1 && dice2P == 1)
                    {
                        fh += 7;
                        tot += fh;
                        tvFH.setText(fh+"");
                        tvTot.setText(tot+"");
                    }
                }

                /////3개가 1이고 2개가 3일때/////////////
            if(dice1P == 0 && dice2P == 0 && dice3P == 0)
            {
                if(dice4P == 2 && dice5P == 2)
                {
                    fh += 9;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 0 && dice2P == 0 && dice4P == 0)
            {
                if(dice3P == 2 && dice5P == 2)
                {
                    fh += 9;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 0 && dice2P == 0 && dice5P == 0)
            {
                if(dice3P == 2 && dice4P == 2)
                {
                    fh += 9;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 0 && dice3P == 0 && dice4P == 0)
            {
                if(dice2P == 2 && dice5P == 2)
                {
                    fh += 9;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 0 && dice3P == 0 && dice5P == 0)
            {
                if(dice2P == 2 && dice4P == 2)
                {
                    fh += 9;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 0 && dice4P == 0 && dice4P == 0)
            {
                if(dice2P == 2 && dice5P == 2)
                {
                    fh += 9;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 0 && dice3P == 0 && dice4P == 0)
            {
                if(dice1P == 2 && dice5P == 2)
                {
                    fh += 9;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 0 && dice3P == 0 && dice5P == 0)
            {
                if(dice1P == 2 && dice4P == 2)
                {
                    fh += 9;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 0 && dice4P == 0 && dice5P == 0)
            {
                if(dice1P == 2 && dice3P == 2)
                {
                    fh += 9;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice3P == 0 && dice4P == 0 && dice5P == 0)
            {
                if(dice1P == 2 && dice2P == 2)
                {
                    fh += 9;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }

           ////3개가 1이고 2개가 4일때/////
            if(dice1P == 0 && dice2P == 0 && dice3P == 0)
            {
                if(dice4P == 3 && dice5P == 3)
                {
                    fh += 11;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 0 && dice2P == 0 && dice4P == 0)
            {
                if(dice3P == 3 && dice5P == 3)
                {
                    fh += 11;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 0 && dice2P == 0 && dice5P == 0)
            {
                if(dice3P == 3 && dice4P == 3)
                {
                    fh += 11;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 0 && dice3P == 0 && dice4P == 0)
            {
                if(dice2P == 3 && dice5P == 3)
                {
                    fh += 11;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 0 && dice3P == 0 && dice5P == 0)
            {
                if(dice2P == 3 && dice4P == 3)
                {
                    fh += 11;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 0 && dice4P == 0 && dice4P == 0)
            {
                if(dice2P == 3 && dice5P == 3)
                {
                    fh += 11;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 0 && dice3P == 0 && dice4P == 0)
            {
                if(dice1P == 3 && dice5P == 3)
                {
                    fh += 11;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 0 && dice3P == 0 && dice5P == 0)
            {
                if(dice1P == 3 && dice4P == 3)
                {
                    fh += 11;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 0 && dice4P == 0 && dice5P == 0)
            {
                if(dice1P == 3 && dice3P == 3)
                {
                    fh += 11;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice3P == 0 && dice4P == 0 && dice5P == 0)
            {
                if(dice1P == 3 && dice2P == 3)
                {
                    fh += 11;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }

            ////3개가 1이고 2개가 5일때/////
            if(dice1P == 0 && dice2P == 0 && dice3P == 0)
            {
                if(dice4P == 4 && dice5P == 4)
                {
                    fh += 13;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 0 && dice2P == 0 && dice4P == 0)
            {
                if(dice3P == 4 && dice5P == 4)
                {
                    fh += 13;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 0 && dice2P == 0 && dice5P == 0)
            {
                if(dice3P == 4 && dice4P == 4)
                {
                    fh += 13;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 0 && dice3P == 0 && dice4P == 0)
            {
                if(dice2P == 4 && dice5P == 4)
                {
                    fh += 13;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 0 && dice3P == 0 && dice5P == 0)
            {
                if(dice2P == 4 && dice4P == 4)
                {
                    fh += 13;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 0 && dice4P == 0 && dice4P == 0)
            {
                if(dice2P == 4 && dice5P == 4)
                {
                    fh += 13;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 0 && dice3P == 0 && dice4P == 0)
            {
                if(dice1P == 4 && dice5P == 4)
                {
                    fh += 13;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 0 && dice3P == 0 && dice5P == 0)
            {
                if(dice1P == 4 && dice4P == 4)
                {
                    fh += 13;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 0 && dice4P == 0 && dice5P == 0)
            {
                if(dice1P == 4 && dice3P == 4)
                {
                    fh += 13;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice3P == 0 && dice4P == 0 && dice5P == 0)
            {
                if(dice1P == 4 && dice2P == 4)
                {
                    fh += 13;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }

            /////3개가 1이고 2개가 6 일때 ///////
            if(dice1P == 0 && dice2P == 0 && dice3P == 0)
            {
                if(dice4P == 5 && dice5P == 5)
                {
                    fh += 15;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 0 && dice2P == 0 && dice4P == 0)
            {
                if(dice3P == 5 && dice5P == 5)
                {
                    fh += 15;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 0 && dice2P == 0 && dice5P == 0)
            {
                if(dice3P == 5 && dice4P == 5)
                {
                    fh += 15;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 0 && dice3P == 0 && dice4P == 0)
            {
                if(dice2P == 5 && dice5P == 5)
                {
                    fh += 15;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 0 && dice3P == 0 && dice5P == 0)
            {
                if(dice2P == 5 && dice4P == 5)
                {
                    fh += 15;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 0 && dice4P == 0 && dice4P == 0)
            {
                if(dice2P == 5 && dice5P == 5)
                {
                    fh += 15;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 0 && dice3P == 0 && dice4P == 0)
            {
                if(dice1P == 5 && dice5P == 5)
                {
                    fh += 15;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 0 && dice3P == 0 && dice5P == 0)
            {
                if(dice1P == 5 && dice4P == 5)
                {
                    fh += 15;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 0 && dice4P == 0 && dice5P == 0)
            {
                if(dice1P == 5 && dice3P == 5)
                {
                    fh += 15;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice3P == 0 && dice4P == 0 && dice5P == 0)
            {
                if(dice1P == 5 && dice2P == 5)
                {
                    fh += 15;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }



            /////3개가 2이고 2개가 3일때////
            if(dice1P == 1 && dice2P == 1 && dice3P == 1)
            {
                if(dice4P == 2 && dice5P == 2)
                {
                    fh += 12;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 1 && dice2P == 1 && dice4P == 1)
            {
                if(dice3P == 2 && dice5P == 2)
                {
                    fh += 12;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 1 && dice2P == 1 && dice5P == 1)
            {
                if(dice3P == 2 && dice4P == 2)
                {
                    fh += 12;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 1 && dice3P == 1 && dice4P == 1)
            {
                if(dice2P == 2 && dice5P == 2)
                {
                    fh += 12;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 1 && dice3P == 1 && dice5P == 1)
            {
                if(dice2P == 2 && dice4P == 2)
                {
                    fh += 12;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 1 && dice4P == 1 && dice4P == 1)
            {
                if(dice2P == 2 && dice5P == 2)
                {
                    fh += 12;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 1 && dice3P == 1 && dice4P == 1)
            {
                if(dice1P == 2 && dice5P == 2)
                {
                    fh += 12;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 1 && dice3P == 1 && dice5P == 1)
            {
                if(dice1P == 2 && dice4P == 2)
                {
                    fh += 12;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 1 && dice4P == 1 && dice5P == 1)
            {
                if(dice1P == 2 && dice3P == 2)
                {
                    fh += 12;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice3P == 1 && dice4P == 1 && dice5P == 1)
            {
                if(dice1P == 2 && dice2P == 2)
                {
                    fh += 12;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }

            /////3개가 2 이고 2개가 4 일때////
            if(dice1P == 1 && dice2P == 1 && dice3P == 1)
            {
                if(dice4P == 3 && dice5P == 3)
                {
                    fh += 14;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 1 && dice2P == 1 && dice4P == 1)
            {
                if(dice3P == 3 && dice5P == 3)
                {
                    fh += 14;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 1 && dice2P == 1 && dice5P == 1)
            {
                if(dice3P == 3 && dice4P == 3)
                {
                    fh += 14;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 1 && dice3P == 1 && dice4P == 1)
            {
                if(dice2P == 3 && dice5P == 3)
                {
                    fh += 14;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 1 && dice3P == 1 && dice5P == 1)
            {
                if(dice2P == 3 && dice4P == 3)
                {
                    fh += 14;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 1 && dice4P == 1 && dice4P == 1)
            {
                if(dice2P == 3 && dice5P == 3)
                {
                    fh += 14;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 1 && dice3P == 1 && dice4P == 1)
            {
                if(dice1P == 3 && dice5P == 3)
                {
                    fh += 14;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 1 && dice3P == 1 && dice5P == 1)
            {
                if(dice1P == 3 && dice4P == 3)
                {
                    fh += 14;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 1 && dice4P == 1 && dice5P == 1)
            {
                if(dice1P == 3 && dice3P == 3)
                {
                    fh += 14;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice3P == 1 && dice4P == 1 && dice5P == 1)
            {
                if(dice1P == 3 && dice2P == 3)
                {
                    fh += 14;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }

            /////3개가 2이고 2개가 5 일때/////
            if(dice1P == 1 && dice2P == 1 && dice3P == 1)
            {
                if(dice4P == 4 && dice5P == 4)
                {
                    fh += 16;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 1 && dice2P == 1 && dice4P == 1)
            {
                if(dice3P == 4 && dice5P == 4)
                {
                    fh += 16;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 1 && dice2P == 1 && dice5P == 1)
            {
                if(dice3P == 4 && dice4P == 4)
                {
                    fh += 16;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 1 && dice3P == 1 && dice4P == 1)
            {
                if(dice2P == 4 && dice5P == 4)
                {
                    fh += 16;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 1 && dice3P == 1 && dice5P == 1)
            {
                if(dice2P == 4 && dice4P == 4)
                {
                    fh += 16;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 1 && dice4P == 1 && dice4P == 1)
            {
                if(dice2P == 4 && dice5P == 4)
                {
                    fh += 16;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 1 && dice3P == 1 && dice4P == 1)
            {
                if(dice1P == 4 && dice5P == 4)
                {
                    fh += 16;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 1 && dice3P == 1 && dice5P == 1)
            {
                if(dice1P == 4 && dice4P == 4)
                {
                    fh += 16;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 1 && dice4P == 1 && dice5P == 1)
            {
                if(dice1P == 4 && dice3P == 4)
                {
                    fh += 16;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice3P == 1 && dice4P == 1 && dice5P == 1)
            {
                if(dice1P == 4 && dice2P == 4)
                {
                    fh += 16;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }


            /////3개가 2이고 2개가 6 일때////
            if(dice1P == 1 && dice2P == 1 && dice3P == 1)
            {
                if(dice4P == 5 && dice5P == 5)
                {
                    fh += 18;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 1 && dice2P == 1 && dice4P == 1)
            {
                if(dice3P == 5 && dice5P == 5)
                {
                    fh += 18;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 1 && dice2P == 1 && dice5P == 1)
            {
                if(dice3P == 5 && dice4P == 5)
                {
                    fh += 18;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 1 && dice3P == 1 && dice4P == 1)
            {
                if(dice2P == 5 && dice5P == 5)
                {
                    fh += 18;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 1 && dice3P == 1 && dice5P == 1)
            {
                if(dice2P == 5 && dice4P == 5)
                {
                    fh += 18;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 1 && dice4P == 1 && dice4P == 1)
            {
                if(dice2P == 5 && dice5P == 5)
                {
                    fh += 18;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 1 && dice3P == 1 && dice4P == 1)
            {
                if(dice1P == 5 && dice5P == 5)
                {
                    fh += 18;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 1 && dice3P == 1 && dice5P == 1)
            {
                if(dice1P == 5 && dice4P == 5)
                {
                    fh += 18;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 1 && dice4P == 1 && dice5P == 1)
            {
                if(dice1P == 5 && dice3P == 5)
                {
                    fh += 18;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice3P == 1 && dice4P == 1 && dice5P == 1)
            {
                if(dice1P == 5 && dice2P == 5)
                {
                    fh += 18;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }

            /////3개가 3이고 2개가 2일때/////
            if(dice1P == 2 && dice2P == 2 && dice3P == 2)
            {
                if(dice4P == 1 && dice5P == 1)
                {
                    fh += 13;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 2 && dice2P == 2 && dice4P == 2)
            {
                if(dice3P == 1 && dice5P == 1)
                {
                    fh += 13;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 2 && dice2P == 2 && dice5P == 2)
            {
                if(dice3P == 1 && dice4P == 1)
                {
                    fh += 13;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 2 && dice3P == 2 && dice4P == 2)
            {
                if(dice2P == 1 && dice5P == 1)
                {
                    fh += 13;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 2 && dice3P == 2 && dice5P == 2)
            {
                if(dice2P == 1 && dice4P == 1)
                {
                    fh += 13;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 2 && dice4P == 2 && dice4P == 2)
            {
                if(dice2P == 1 && dice5P == 1)
                {
                    fh += 13;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 2 && dice3P == 2 && dice4P == 2)
            {
                if(dice1P == 1 && dice5P == 1)
                {
                    fh += 13;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 2 && dice3P == 2 && dice5P == 2)
            {
                if(dice1P == 1 && dice4P == 1)
                {
                    fh += 13;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 2 && dice4P == 2 && dice5P == 2)
            {
                if(dice1P == 1 && dice3P == 1)
                {
                    fh += 13;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice3P == 2 && dice4P == 2 && dice5P == 2)
            {
                if(dice1P == 1 && dice2P == 1)
                {
                    fh += 13;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }


            //////3개가 3이고 2개가 4일때/////
            if(dice1P == 2 && dice2P == 2 && dice3P == 2)
            {
                if(dice4P == 3 && dice5P == 3)
                {
                    fh += 17;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 2 && dice2P == 2 && dice4P == 2)
            {
                if(dice3P == 3 && dice5P == 3)
                {
                    fh += 17;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 2 && dice2P == 2 && dice5P == 2)
            {
                if(dice3P == 3 && dice4P == 3)
                {
                    fh += 17;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 2 && dice3P == 2 && dice4P == 2)
            {
                if(dice2P == 3 && dice5P == 3)
                {
                    fh += 17;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 2 && dice3P == 2 && dice5P == 2)
            {
                if(dice2P == 3 && dice4P == 3)
                {
                    fh += 17;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 2 && dice4P == 2 && dice4P == 2)
            {
                if(dice2P == 3 && dice5P == 3)
                {
                    fh += 17;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 2 && dice3P == 2 && dice4P == 2)
            {
                if(dice1P == 3 && dice5P == 3)
                {
                    fh += 17;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 2 && dice3P == 2 && dice5P == 2)
            {
                if(dice1P == 3 && dice4P == 3)
                {
                    fh += 17;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 2 && dice4P == 2 && dice5P == 2)
            {
                if(dice1P == 3 && dice3P == 3)
                {
                    fh += 17;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice3P == 2 && dice4P == 2 && dice5P == 2)
            {
                if(dice1P == 3 && dice2P == 3)
                {
                    fh += 17;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }


            //////3개가 3이고 2개가 5일때///////
            if(dice1P == 2 && dice2P == 2 && dice3P == 2)
            {
                if(dice4P == 4 && dice5P == 4)
                {
                    fh += 19;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 2 && dice2P == 2 && dice4P == 2)
            {
                if(dice3P == 4 && dice5P == 4)
                {
                    fh += 19;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 2 && dice2P == 2 && dice5P == 2)
            {
                if(dice3P == 4 && dice4P == 4)
                {
                    fh += 19;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 2 && dice3P == 2 && dice4P == 2)
            {
                if(dice2P == 4 && dice5P == 4)
                {
                    fh += 19;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 2 && dice3P == 2 && dice5P == 2)
            {
                if(dice2P == 4 && dice4P == 4)
                {
                    fh += 19;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 2 && dice4P == 2 && dice4P == 2)
            {
                if(dice2P == 4 && dice5P == 4)
                {
                    fh += 19;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 2 && dice3P == 2 && dice4P == 2)
            {
                if(dice1P == 4 && dice5P == 4)
                {
                    fh += 19;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 2 && dice3P == 2 && dice5P == 2)
            {
                if(dice1P == 4 && dice4P == 4)
                {
                    fh += 19;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 2 && dice4P == 2 && dice5P == 2)
            {
                if(dice1P == 4 && dice3P == 4)
                {
                    fh += 19;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice3P == 2 && dice4P == 2 && dice5P == 2)
            {
                if(dice1P == 4 && dice2P == 4)
                {
                    fh += 19;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }





            //////3개가 3이고 2개가 6일때///////
            if(dice1P == 2 && dice2P == 2 && dice3P == 2)
            {
                if(dice4P == 5 && dice5P == 5)
                {
                    fh += 21;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 2 && dice2P == 2 && dice4P == 2)
            {
                if(dice3P == 5 && dice5P == 5)
                {
                    fh += 21;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 2 && dice2P == 2 && dice5P == 2)
            {
                if(dice3P == 5 && dice4P == 5)
                {
                    fh += 21;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 2 && dice3P == 2 && dice4P == 2)
            {
                if(dice2P == 5 && dice5P == 5)
                {
                    fh += 21;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 2 && dice3P == 2 && dice5P == 2)
            {
                if(dice2P == 5 && dice4P == 5)
                {
                    fh += 21;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 2 && dice4P == 2 && dice4P == 2)
            {
                if(dice2P == 5 && dice5P == 5)
                {
                    fh += 21;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 2 && dice3P == 2 && dice4P == 2)
            {
                if(dice1P == 5 && dice5P == 5)
                {
                    fh += 21;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 2 && dice3P == 2 && dice5P == 2)
            {
                if(dice1P == 5 && dice4P == 5)
                {
                    fh += 21;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 2 && dice4P == 2 && dice5P == 2)
            {
                if(dice1P == 5 && dice3P == 5)
                {
                    fh += 21;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice3P == 2 && dice4P == 2 && dice5P == 2)
            {
                if(dice1P == 5 && dice2P == 5)
                {
                    fh += 21;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }




            //////3개가 4이고 2개가 2일때//////
            if(dice1P == 3 && dice2P == 3 && dice3P == 3)
            {
                if(dice4P == 1 && dice5P == 1)
                {
                    fh += 16;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 3 && dice2P == 3 && dice4P == 3)
            {
                if(dice3P == 1 && dice5P == 1)
                {
                    fh += 16;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 3 && dice2P == 3 && dice5P == 3)
            {
                if(dice3P == 1 && dice4P == 1)
                {
                    fh += 16;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 3 && dice3P == 3 && dice4P == 3)
            {
                if(dice2P == 1 && dice5P == 1)
                {
                    fh += 16;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 3 && dice3P == 3 && dice5P == 3)
            {
                if(dice2P == 1 && dice4P == 1)
                {
                    fh += 16;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 3 && dice4P == 3 && dice4P == 3)
            {
                if(dice2P == 1 && dice5P == 1)
                {
                    fh += 16;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 3 && dice3P == 3 && dice4P == 3)
            {
                if(dice1P == 1 && dice5P == 1)
                {
                    fh += 16;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 3 && dice3P == 3 && dice5P == 3)
            {
                if(dice1P == 1 && dice4P == 1)
                {
                    fh += 16;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 3 && dice4P == 3 && dice5P == 3)
            {
                if(dice1P == 1 && dice3P == 1)
                {
                    fh += 16;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice3P == 3 && dice4P == 3 && dice5P == 3)
            {
                if(dice1P == 1 && dice2P == 1)
                {
                    fh += 16;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }


            /////3개가 4이고 2개가 3일때///////
            if(dice1P == 3 && dice2P == 3 && dice3P == 3)
            {
                if(dice4P == 2 && dice5P == 2)
                {
                    fh += 18;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 3 && dice2P == 3 && dice4P == 3)
            {
                if(dice3P == 2 && dice5P == 2)
                {
                    fh += 18;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 3 && dice2P == 3 && dice5P == 3)
            {
                if(dice3P == 2 && dice4P == 2)
                {
                    fh += 18;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 3 && dice3P == 3 && dice4P == 3)
            {
                if(dice2P == 2 && dice5P == 2)
                {
                    fh += 18;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 3 && dice3P == 3 && dice5P == 3)
            {
                if(dice2P == 2 && dice4P == 2)
                {
                    fh += 18;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 3 && dice4P == 3 && dice4P == 3)
            {
                if(dice2P == 2 && dice5P == 2)
                {
                    fh += 18;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 3 && dice3P == 3 && dice4P == 3)
            {
                if(dice1P == 2 && dice5P == 2)
                {
                    fh += 18;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 3 && dice3P == 3 && dice5P == 3)
            {
                if(dice1P == 2 && dice4P == 2)
                {
                    fh += 18;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 3 && dice4P == 3 && dice5P == 3)
            {
                if(dice1P == 2 && dice3P == 2)
                {
                    fh += 18;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice3P == 3 && dice4P == 3 && dice5P == 3)
            {
                if(dice1P == 2 && dice2P == 2)
                {
                    fh += 18;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }




            //////3개가 4이고 2개가 5일때//////
            if(dice1P == 3 && dice2P == 3 && dice3P == 3)
            {
                if(dice4P == 4 && dice5P == 4)
                {
                    fh += 22;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 3 && dice2P == 3 && dice4P == 3)
            {
                if(dice3P == 4 && dice5P == 4)
                {
                    fh += 22;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 3 && dice2P == 3 && dice5P == 3)
            {
                if(dice3P == 4 && dice4P == 4)
                {
                    fh += 22;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 3 && dice3P == 3 && dice4P == 3)
            {
                if(dice2P == 4 && dice5P == 4)
                {
                    fh += 22;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 3 && dice3P == 3 && dice5P == 3)
            {
                if(dice2P == 4 && dice4P == 4)
                {
                    fh += 22;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 3 && dice4P == 3 && dice4P == 3)
            {
                if(dice2P == 4 && dice5P == 4)
                {
                    fh += 22;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 3 && dice3P == 3 && dice4P == 3)
            {
                if(dice1P == 4 && dice5P == 4)
                {
                    fh += 22;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 3 && dice3P == 3 && dice5P == 3)
            {
                if(dice1P == 4 && dice4P == 4)
                {
                    fh += 22;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 3 && dice4P == 3 && dice5P == 3)
            {
                if(dice1P == 4 && dice3P == 4)
                {
                    fh += 22;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice3P == 3 && dice4P == 3 && dice5P == 3)
            {
                if(dice1P == 4 && dice2P == 4)
                {
                    fh += 22;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }




            /////3개가 4이고 2개가 6일때///////
            if(dice1P == 3 && dice2P == 3 && dice3P == 3)
            {
                if(dice4P == 5 && dice5P == 5)
                {
                    fh += 24;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 3 && dice2P == 3 && dice4P == 3)
            {
                if(dice3P == 5 && dice5P == 5)
                {
                    fh += 24;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 3 && dice2P == 3 && dice5P == 3)
            {
                if(dice3P == 5 && dice4P == 5)
                {
                    fh += 24;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 3 && dice3P == 3 && dice4P == 3)
            {
                if(dice2P == 5 && dice5P == 5)
                {
                    fh += 24;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 3 && dice3P == 3 && dice5P == 3)
            {
                if(dice2P == 5 && dice4P == 5)
                {
                    fh += 24;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 3 && dice4P == 3 && dice4P == 3)
            {
                if(dice2P == 5 && dice5P == 5)
                {
                    fh += 24;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 3 && dice3P == 3 && dice4P == 3)
            {
                if(dice1P == 5 && dice5P == 5)
                {
                    fh += 24;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 3 && dice3P == 3 && dice5P == 3)
            {
                if(dice1P == 5 && dice4P == 5)
                {
                    fh += 24;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 3 && dice4P == 3 && dice5P == 3)
            {
                if(dice1P == 5 && dice3P == 5)
                {
                    fh += 24;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice3P == 3 && dice4P == 3 && dice5P == 3)
            {
                if(dice1P == 5 && dice2P == 5)
                {
                    fh += 24;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }


            /////3개가 5이고 2개가 2일때/////
            if(dice1P == 4 && dice2P == 4 && dice3P == 4)
            {
                if(dice4P == 1 && dice5P == 1)
                {
                    fh += 19;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 4 && dice2P == 4 && dice4P == 4)
            {
                if(dice3P == 1 && dice5P == 1)
                {
                    fh += 19;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 4 && dice2P == 4 && dice5P == 4)
            {
                if(dice3P == 1 && dice4P == 1)
                {
                    fh += 19;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 4 && dice3P == 4 && dice4P == 4)
            {
                if(dice2P == 1 && dice5P == 1)
                {
                    fh += 19;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 4 && dice3P == 4 && dice5P == 4)
            {
                if(dice2P == 1 && dice4P == 1)
                {
                    fh += 19;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 4 && dice4P == 4 && dice4P == 4)
            {
                if(dice2P == 1 && dice5P == 1)
                {
                    fh += 19;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 4 && dice3P == 4 && dice4P == 4)
            {
                if(dice1P == 1 && dice5P == 1)
                {
                    fh += 19;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 4 && dice3P == 4 && dice5P == 4)
            {
                if(dice1P == 1 && dice4P == 1)
                {
                    fh += 19;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 4 && dice4P == 4 && dice5P == 4)
            {
                if(dice1P == 1 && dice3P == 1)
                {
                    fh += 19;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice3P == 4 && dice4P == 4 && dice5P == 4)
            {
                if(dice1P == 1 && dice2P == 1)
                {
                    fh += 19;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }




            /////3개가 5이고 2개가 3일떄/////
            if(dice1P == 4 && dice2P == 4 && dice3P == 4)
            {
                if(dice4P == 2 && dice5P == 2)
                {
                    fh += 21;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 4 && dice2P == 4 && dice4P == 4)
            {
                if(dice3P == 2 && dice5P == 2)
                {
                    fh += 21;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 4 && dice2P == 4 && dice5P == 4)
            {
                if(dice3P == 2 && dice4P == 2)
                {
                    fh += 21;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 4 && dice3P == 4 && dice4P == 4)
            {
                if(dice2P == 2 && dice5P == 2)
                {
                    fh += 21;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 4 && dice3P == 4 && dice5P == 4)
            {
                if(dice2P == 2 && dice4P == 2)
                {
                    fh += 21;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 4 && dice4P == 4 && dice4P == 4)
            {
                if(dice2P == 2 && dice5P == 2)
                {
                    fh += 21;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 4 && dice3P == 4 && dice4P == 4)
            {
                if(dice1P == 2 && dice5P == 2)
                {
                    fh += 21;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 4 && dice3P == 4 && dice5P == 4)
            {
                if(dice1P == 2 && dice4P == 2)
                {
                    fh += 21;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 4 && dice4P == 4 && dice5P == 4)
            {
                if(dice1P == 2 && dice3P == 2)
                {
                    fh += 21;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice3P == 4 && dice4P == 4 && dice5P == 4)
            {
                if(dice1P == 2 && dice2P == 2)
                {
                    fh += 21;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }





            ////3개가 5이고 2개가 4일때/////
            if(dice1P == 4 && dice2P == 4 && dice3P == 4)
            {
                if(dice4P == 3 && dice5P == 3)
                {
                    fh += 23;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 4 && dice2P == 4 && dice4P == 4)
            {
                if(dice3P == 3 && dice5P == 3)
                {
                    fh += 23;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 4 && dice2P == 4 && dice5P == 4)
            {
                if(dice3P == 3 && dice4P == 3)
                {
                    fh += 23;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 4 && dice3P == 4 && dice4P == 4)
            {
                if(dice2P == 3 && dice5P == 3)
                {
                    fh += 23;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 4 && dice3P == 4 && dice5P == 4)
            {
                if(dice2P == 3 && dice4P == 3)
                {
                    fh += 23;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 4 && dice4P == 4 && dice4P == 4)
            {
                if(dice2P == 3 && dice5P == 3)
                {
                    fh += 23;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 4 && dice3P == 4 && dice4P == 4)
            {
                if(dice1P == 3 && dice5P == 3)
                {
                    fh += 23;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 4 && dice3P == 4 && dice5P == 4)
            {
                if(dice1P == 3 && dice4P == 3)
                {
                    fh += 23;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 4 && dice4P == 4 && dice5P == 4)
            {
                if(dice1P == 3 && dice3P == 3)
                {
                    fh += 23;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice3P == 4 && dice4P == 4 && dice5P == 4)
            {
                if(dice1P == 3 && dice2P == 3)
                {
                    fh += 23;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }





            /////3개가 5이고 2개가 6일때/////
            if(dice1P == 4 && dice2P == 4 && dice3P == 4)
            {
                if(dice4P == 5 && dice5P == 5)
                {
                    fh += 27;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 4 && dice2P == 4 && dice4P == 4)
            {
                if(dice3P == 5 && dice5P == 5)
                {
                    fh += 27;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 4 && dice2P == 4 && dice5P == 4)
            {
                if(dice3P == 5 && dice4P == 5)
                {
                    fh += 27;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 4 && dice3P == 4 && dice4P == 4)
            {
                if(dice2P == 5 && dice5P == 5)
                {
                    fh += 27;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 4 && dice3P == 4 && dice5P == 4)
            {
                if(dice2P == 5 && dice4P == 5)
                {
                    fh += 27;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 4 && dice4P == 4 && dice4P == 4)
            {
                if(dice2P == 5 && dice5P == 5)
                {
                    fh += 27;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 4 && dice3P == 4 && dice4P == 4)
            {
                if(dice1P == 5 && dice5P == 5)
                {
                    fh += 27;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 4 && dice3P == 4 && dice5P == 4)
            {
                if(dice1P == 5 && dice4P == 5)
                {
                    fh += 27;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 4 && dice4P == 4 && dice5P == 4)
            {
                if(dice1P == 5 && dice3P == 5)
                {
                    fh += 27;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice3P == 4 && dice4P == 4 && dice5P == 4)
            {
                if(dice1P == 5 && dice2P == 5)
                {
                    fh += 27;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }



            //////3개가 6이고 2개가 2일때////
            if(dice1P == 5 && dice2P == 5 && dice3P == 5)
            {
                if(dice4P == 1 && dice5P == 1)
                {
                    fh += 22;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 5 && dice2P == 5 && dice4P == 5)
            {
                if(dice3P == 1 && dice5P == 1)
                {
                    fh += 22;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 5 && dice2P == 5 && dice5P == 5)
            {
                if(dice3P == 1 && dice4P == 1)
                {
                    fh += 22;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 5 && dice3P == 5 && dice4P == 5)
            {
                if(dice2P == 1 && dice5P == 1)
                {
                    fh += 22;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 5 && dice3P == 5 && dice5P == 5)
            {
                if(dice2P == 1 && dice4P == 1)
                {
                    fh += 22;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 5 && dice4P == 5 && dice4P == 5)
            {
                if(dice2P == 1 && dice5P == 1)
                {
                    fh += 22;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 5 && dice3P == 5 && dice4P == 5)
            {
                if(dice1P == 1 && dice5P == 1)
                {
                    fh += 22;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 5 && dice3P == 5 && dice5P == 5)
            {
                if(dice1P == 1 && dice4P == 1)
                {
                    fh += 22;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 5 && dice4P == 5 && dice5P == 5)
            {
                if(dice1P == 1 && dice3P == 1)
                {
                    fh += 22;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice3P == 5 && dice4P == 5 && dice5P == 5)
            {
                if(dice1P == 1 && dice2P == 1)
                {
                    fh += 22;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }



            /////3개가 6이고 2개가 3일때/////
            if(dice1P == 5 && dice2P == 5 && dice3P == 5)
            {
                if(dice4P == 2 && dice5P == 2)
                {
                    fh += 24;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 5 && dice2P == 5 && dice4P == 5)
            {
                if(dice3P == 2 && dice5P == 2)
                {
                    fh += 24;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 5 && dice2P == 5 && dice5P == 5)
            {
                if(dice3P == 2 && dice4P == 2)
                {
                    fh += 24;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 5 && dice3P == 5 && dice4P == 5)
            {
                if(dice2P == 2 && dice5P == 2)
                {
                    fh += 24;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 5 && dice3P == 5 && dice5P == 5)
            {
                if(dice2P == 2 && dice4P == 2)
                {
                    fh += 24;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 5 && dice4P == 5 && dice4P == 5)
            {
                if(dice2P == 2 && dice5P == 2)
                {
                    fh += 24;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 5 && dice3P == 5 && dice4P == 5)
            {
                if(dice1P == 2 && dice5P == 2)
                {
                    fh += 24;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 5 && dice3P == 5 && dice5P == 5)
            {
                if(dice1P == 2 && dice4P == 2)
                {
                    fh += 24;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 5 && dice4P == 5 && dice5P == 5)
            {
                if(dice1P == 2 && dice3P == 2)
                {
                    fh += 24;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice3P == 5 && dice4P == 5 && dice5P == 5)
            {
                if(dice1P == 2 && dice2P == 2)
                {
                    fh += 24;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }


            /////3개가 6이고 2개가 4일때/////
            if(dice1P == 5 && dice2P == 5 && dice3P == 5)
            {
                if(dice4P == 3 && dice5P == 3)
                {
                    fh += 26;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 5 && dice2P == 5 && dice4P == 5)
            {
                if(dice3P == 3 && dice5P == 3)
                {
                    fh += 26;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 5 && dice2P == 5 && dice5P == 5)
            {
                if(dice3P == 3 && dice4P == 3)
                {
                    fh += 26;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 5 && dice3P == 5 && dice4P == 5)
            {
                if(dice2P == 3 && dice5P == 3)
                {
                    fh += 26;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 5 && dice3P == 5 && dice5P == 5)
            {
                if(dice2P == 3 && dice4P == 3)
                {
                    fh += 26;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 5 && dice4P == 5 && dice4P == 5)
            {
                if(dice2P == 3 && dice5P == 3)
                {
                    fh += 26;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 5 && dice3P == 5 && dice4P == 5)
            {
                if(dice1P == 3 && dice5P == 3)
                {
                    fh += 26;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 5 && dice3P == 5 && dice5P == 5)
            {
                if(dice1P == 3 && dice4P == 3)
                {
                    fh += 26;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 5 && dice4P == 5 && dice5P == 5)
            {
                if(dice1P == 3 && dice3P == 3)
                {
                    fh += 26;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice3P == 5 && dice4P == 5 && dice5P == 5)
            {
                if(dice1P == 3 && dice2P == 3)
                {
                    fh += 26;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }

            ////3개가 6이고 2개가 5일때//////
            if(dice1P == 5 && dice2P == 5 && dice3P == 5)
            {
                if(dice4P == 4 && dice5P == 4)
                {
                    fh += 28;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 5 && dice2P == 5 && dice4P == 5)
            {
                if(dice3P == 4 && dice5P == 4)
                {
                    fh += 28;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 5 && dice2P == 5 && dice5P == 5)
            {
                if(dice3P == 4 && dice4P == 4)
                {
                    fh += 28;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 5 && dice3P == 5 && dice4P == 5)
            {
                if(dice2P == 4 && dice5P == 4)
                {
                    fh += 28;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 5 && dice3P == 5 && dice5P == 5)
            {
                if(dice2P == 4 && dice4P == 4)
                {
                    fh += 28;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice1P == 5 && dice4P == 5 && dice4P == 5)
            {
                if(dice2P == 4 && dice5P == 4)
                {
                    fh += 28;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 5 && dice3P == 5 && dice4P == 5)
            {
                if(dice1P == 4 && dice5P == 4)
                {
                    fh += 28;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 5 && dice3P == 5 && dice5P == 5)
            {
                if(dice1P == 4 && dice4P == 4)
                {
                    fh += 28;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice2P == 5 && dice4P == 5 && dice5P == 5)
            {
                if(dice1P == 4 && dice3P == 4)
                {
                    fh += 28;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
            else if(dice3P == 5 && dice4P == 5 && dice5P == 5)
            {
                if(dice1P == 4 && dice2P == 4)
                {
                    fh += 28;
                    tot += fh;
                    tvFH.setText(fh+"");
                    tvTot.setText(tot+"");
                }
            }
        }
        else if(fh > 0)
        {
            scoreCheck = false;
        }
    }
    void scoreS_st()
    {

        if(sst == 0)
        {
            scoreCheck = true;
            if(dice1P != dice2P && dice1P != dice3P &&dice1P != dice4P )
            {
                if(dice2P != dice3P && dice2P != dice4P )
                {
                    if(dice3P != dice4P)
                    {

                            if(dice1P+dice2P+dice3P+dice4P+dice5P <= 16)
                            {
                                sst += 15;
                                tot += sst;
                                tvS_st.setText(bst+"");
                                tvTot.setText(tot+"");

                            }
                    }

                }
            }
            else if(dice1P != dice2P && dice1P != dice3P && dice1P != dice5P)
            {
                if(dice2P != dice3P &&  dice2P != dice5P)
                {
                    if( dice3P != dice5P)
                    {

                            if(dice1P+dice2P+dice3P+dice4P+dice5P <= 20)
                            {
                                sst += 15;
                                tot += sst;
                                tvS_st.setText(sst+"");
                                tvTot.setText(tot+"");

                            }

                    }
                }
            }
            else if(dice1P != dice2P  &&dice1P != dice4P && dice1P != dice5P)
            {
                if( dice2P != dice4P && dice2P != dice5P)
                {
                    if(dice3P != dice4P && dice3P != dice5P)
                    {

                            if(dice1P+dice2P+dice3P+dice4P+dice5P <= 24)
                            {
                                sst += 15;
                                tot += sst;
                                tvS_st.setText(sst+"");
                                tvTot.setText(tot+"");

                            }

                    }
                }
            }


        }
        else if(sst > 0)
        {
            scoreCheck = false;
        }
    }
    void scoreB_st()
    {
     if(bst == 0)
     {
         scoreCheck = true;
         if(dice1P != dice2P && dice1P != dice3P &&dice1P != dice4P && dice1P != dice5P)
         {
             if(dice2P != dice3P && dice2P != dice4P && dice2P != dice5P)
             {
                 if(dice3P != dice4P && dice3P != dice5P)
                 {
                     if(dice4P != dice5P)
                     {
                         if(dice1P+dice2P+dice3P+dice4P+dice5P == 20)
                         {
                             bst += 30;
                             tot += bst;
                             tvB_st.setText(bst+"");
                             tvTot.setText(tot+"");
                         }
                     }
                 }
             }
         }
         if(dice1P != dice2P && dice1P != dice3P &&dice1P != dice4P && dice1P != dice5P)
         {
             if(dice2P != dice3P && dice2P != dice4P && dice2P != dice5P)
             {
                 if(dice3P != dice4P && dice3P != dice5P)
                 {
                     if(dice4P != dice5P)
                     {
                         if(dice1P+dice2P+dice3P+dice4P+dice5P == 15)
                         {
                             bst += 30;
                             tot += bst;
                             tvB_st.setText(bst+"");
                             tvTot.setText(tot+"");
                         }
                     }
                 }
             }
         }

     }
     else if(bst > 0)
     {
         scoreCheck = false;
     }
    }
    void bonus()
    {
        int bonusResult;
        bonusResult = aces+deuces+threes+fours+fives+sixes;
        if(bonusResult >= 63)
        {
            bonus += 35;
            tot += bonus;
            tvBonus.setText(bonus+"");
            tvTot.setText(tot+"");
        }
    }

    void socreYacht()
    {
        if (dice1P == 0 && dice2P == 0 && dice3P == 0 && dice4P == 0 && dice5P == 0)
        {
            yacht += 50;
            tot += yacht;
            tvYacht.setText(yacht+"");
            tvTot.setText(tot+"");
        }
        else if (dice1P == 1 && dice2P == 1 && dice3P == 1 && dice4P == 1 && dice5P == 1)
        {
            yacht += 50;
            tot += yacht;
            tvYacht.setText(yacht+"");
            tvTot.setText(tot+"");
        }
        else if (dice1P == 2 && dice2P == 2 && dice3P == 2 && dice4P == 2 && dice5P == 2)
        {
            yacht += 50;
            tot += yacht;
            tvYacht.setText(yacht+"");
            tvTot.setText(tot+"");
        }
        else if (dice1P == 3 && dice2P == 3 && dice3P == 3 && dice4P == 3 && dice5P == 3)
        {
            yacht += 50;
            tot += yacht;
            tvYacht.setText(yacht+"");
            tvTot.setText(tot+"");
        }
        else if (dice1P == 4 && dice2P == 4 && dice3P == 4 && dice4P == 4 && dice5P == 4)
        {
            yacht += 50;
            tot += yacht;
            tvYacht.setText(yacht+"");
            tvTot.setText(tot+"");
        }
        else if (dice1P == 5 && dice2P == 5 && dice3P == 5 && dice4P == 5 && dice5P == 5)
        {
            yacht += 50;
            tot += yacht;
            tvYacht.setText(yacht+"");
            tvTot.setText(tot+"");
        }
    }
    void scoreChoice()
    {
        if(choice == 0)
        {
            scoreCheck = true;
            if(dice1P >= 0 && dice2P >= 0 && dice3P >= 0 && dice4P >= 0 && dice5P >= 0)
            {
                choice += dice1P+dice2P+dice3P+dice4P+dice5P;
                tot += choice;
                tvChoice.setText(choice+"");
                tvTot.setText(tot+"");
            }
        }
        else if(choice > 0)
        {
            scoreCheck = false;
        }
    }



}



