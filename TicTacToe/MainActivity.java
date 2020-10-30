package com.example.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
TextView info;
Button newgame;

//we have two players
    int player_0 = 0;
    int player_x = 1;

//  active player

    int active_player = player_0;  // initially it is player_0

    int[] posfill = {-1, -1, -1, -1 ,-1, -1, -1, -1, -1};

    boolean isgameactive = true;  // just for checking either game is active or not and initially it will be active


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        info = findViewById(R.id.infoLabel);
        info.setText("Player 0's turn");

        btn1 = findViewById(R.id.square1);
        btn2 = findViewById(R.id.square2);
        btn3 = findViewById(R.id.square3);
        btn4 = findViewById(R.id.square4);
        btn5 = findViewById(R.id.square5);
        btn6 = findViewById(R.id.square6);
        btn7 = findViewById(R.id.square7);
        btn8 = findViewById(R.id.square8);
        btn9 = findViewById(R.id.square9);

        newgame = findViewById(R.id.newgame_id);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

        newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newgame();
            }
        });

    }

    private void newgame() {
        active_player = player_0;
        info.setText("Player 0's turn");
        posfill = new int[]{-1, -1, -1, -1 ,-1, -1, -1, -1, -1};
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");

        isgameactive = true;

    }

    @Override
    public void onClick(View v) {

        if(!isgameactive)
            return;

//        detecting the current clicked button by using the id from the view object
        Button clickedBtn = findViewById(v.getId());

        int clickedTag = Integer.parseInt(v.getTag().toString());

        if(posfill[clickedTag] != -1)
        {
            return;
        }

        posfill[clickedTag] = active_player;

        if(active_player == player_0)
        {
            clickedBtn.setText("0");
            active_player = player_x;
            info.setText("Player X's turn");
        }
        else
        {
            clickedBtn.setText("X");
            active_player = player_0;
            info.setText("Player 0's turn");
        }

        findwinnigPlayer();
    }

    private void findwinnigPlayer() {
//        lets store the winning pos in the array
        int[][] winningpos = {{0,1,2}, {3,4,5},{6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};


        for(int i=0;i<8;i++)
        {
            int val0 = winningpos[i][0];
            int val1 = winningpos[i][1];
            int val2 = winningpos[i][2];

            if(posfill[val0] == posfill[val1] && posfill[val1] == posfill[val2])
            {
                if(posfill[val0] != -1)
                {
//                    now winner is declare
                    isgameactive = false;

                    if(posfill[val0] == player_0)
                    {
                        info.setText("0 is winner");
                    }
                    else
                    {
                        info.setText("X is winner");
                    }
                }
//                else
//                {
//                    info.setText("No One is Winner..play fast")
//                }
            }
        }
    }
}
