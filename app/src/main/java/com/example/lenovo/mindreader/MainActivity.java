package com.example.lenovo.mindreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private Button buttonYes,buttonLow,buttonHigh,buttonOk;

    private int left=1,right=1000,tries=0,mid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);
        buttonYes = (Button) findViewById(R.id.btnYes);
        buttonHigh = (Button) findViewById(R.id.btnHigh);
        buttonLow = (Button) findViewById(R.id.btnLow);
        buttonOk = (Button) findViewById(R.id.btnOk);

        buttonYes.setVisibility(View.INVISIBLE);
        buttonHigh.setVisibility(View.INVISIBLE);
        buttonLow.setVisibility(View.INVISIBLE);

        tv.setText("Think of a number between 1 and 1000 and I will guess it under 10 moves!");

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonYes.setVisibility(View.VISIBLE);
                buttonHigh.setVisibility(View.VISIBLE);
                buttonLow.setVisibility(View.VISIBLE);
                buttonOk.setVisibility(View.INVISIBLE);
                guess();


            }
        });

        buttonHigh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                left = mid + 1;
                guess();

            }
        });


        buttonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("Wow! i guessed right in " + tries + " chances");
                buttonYes.setVisibility(View.INVISIBLE);
                buttonHigh.setVisibility(View.INVISIBLE);
                buttonLow.setVisibility(View.INVISIBLE);
                buttonOk.setVisibility(View.VISIBLE);

                buttonOk.setText("New Game");
                tries = 0;
                left = 1;
                right = 1000;


            }
        });

        buttonLow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                right=mid-1;
                guess();

            }
        });
    }
        private void guess()
    {
            mid=(left+right)/2;
            tries++;
            tv.setText("My guess is "+mid);
        }

    }

