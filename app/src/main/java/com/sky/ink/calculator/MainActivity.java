package com.sky.ink.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView textViewResult, textViewSolution;
    private Button buttonC, buttonBrackOpen, buttonBrackClose;
    private Button buttonDivide, buttonMultiply, buttonPlus, buttonMinus, buttonEquals;
    private Button [] button_number = new Button[10];
    private Button buttonAc, buttonDot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void initComponents(){
        textViewResult = findViewById(R.id.tv_result);
        textViewSolution = findViewById(R.id.tv_solution);

        assignId(buttonC,R.id.button_c);
        assignId(buttonBrackOpen,R.id.button_open_bracket);
        assignId(buttonBrackClose,R.id.button_close_bracket);
        assignId(buttonDivide,R.id.button_divide);
        assignId(buttonMultiply,R.id.button_multiply);
        assignId(buttonPlus,R.id.button_plus);
        assignId(buttonMinus,R.id.button_minus);
        assignId(buttonEquals,R.id.button_equals);





        buttonEquals = findViewById(R.id.button_equals);

        buttonAc = findViewById(R.id.button_ac);
        buttonDot = findViewById(R.id.button_dot);

        button_number [0] = findViewById(R.id.button_0);
        button_number [1] = findViewById(R.id.button_1);
        button_number [2] = findViewById(R.id.button_2);
        button_number [3] = findViewById(R.id.button_3);
        button_number [4] = findViewById(R.id.button_4);
        button_number [5] = findViewById(R.id.button_5);
        button_number [6] = findViewById(R.id.button_6);
        button_number [7] = findViewById(R.id.button_7);
        button_number [8] = findViewById(R.id.button_8);
        button_number [9] = findViewById(R.id.button_9);


    }

    private void assignId(Button button,int id){
        button = findViewById(id);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}