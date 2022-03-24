package com.ehyeon.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text1, text2;
    Switch switchAgree;
    RadioGroup rGroup1;
    RadioButton radioArray[] = new RadioButton[3];
    ImageView imgPet;
    Button btnQuit, btnReturn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("안드로이드 사진 보기");

        text1 = (TextView) findViewById(R.id.text1);
        switchAgree = (Switch) findViewById(R.id.switchAgree);
        text2 = (TextView) findViewById(R.id.text2);
        rGroup1 = (RadioGroup) findViewById(R.id.rdoGroup1);
        radioArray[0] = (RadioButton) findViewById(R.id.rdoQ);
        radioArray[1] = (RadioButton) findViewById(R.id.rdoR);
        radioArray[2] = (RadioButton) findViewById(R.id.rdoS);
        imgPet = (ImageView) findViewById(R.id.imgPet);
        btnQuit = (Button) findViewById(R.id.btnQuit);
        btnReturn = (Button) findViewById(R.id.btnReturn);

        switchAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
                if (switchAgree.isChecked() == true) {
                    text2.setVisibility(android.view.View.VISIBLE);
                    rGroup1.setVisibility(android.view.View.VISIBLE);
                    imgPet.setVisibility(android.view.View.VISIBLE);
                    btnQuit.setVisibility(android.view.View.VISIBLE);
                    btnReturn.setVisibility(android.view.View.VISIBLE);
                } else {
                    text2.setVisibility(android.view.View.INVISIBLE);
                    rGroup1.setVisibility(android.view.View.INVISIBLE);
                    imgPet.setVisibility(android.view.View.INVISIBLE);
                    btnQuit.setVisibility(android.view.View.INVISIBLE);
                    btnReturn.setVisibility(android.view.View.INVISIBLE);
                }
            }
        });

        final int draw[] = { R.drawable.q10,
                R.drawable.r11, R.drawable.s12};

        for (int i = 0; i < radioArray.length; i++) {
            final int index;
            index = i;
            radioArray[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imgPet.setImageResource(draw[index]);
                }
            });
        }

        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
            }
        });

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                text2.setVisibility(android.view.View.INVISIBLE);
                rGroup1.setVisibility(android.view.View.INVISIBLE);
                imgPet.setVisibility(android.view.View.INVISIBLE);
                btnQuit.setVisibility(android.view.View.INVISIBLE);
                btnReturn.setVisibility(android.view.View.INVISIBLE);

                rGroup1.clearCheck();
                switchAgree.setChecked(false);
            }
        });
    }
}
