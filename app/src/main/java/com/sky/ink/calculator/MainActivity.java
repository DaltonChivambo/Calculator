package com.sky.ink.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;


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

        initComponents();
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

        assignId(buttonAc,R.id.button_ac);
        assignId(buttonDot,R.id.button_dot);

        assignId(button_number[0],R.id.button_0);
        assignId(button_number[1],R.id.button_1);
        assignId(button_number[2],R.id.button_2);
        assignId(button_number[3],R.id.button_3);
        assignId(button_number[4],R.id.button_4);
        assignId(button_number[5],R.id.button_5);
        assignId(button_number[6],R.id.button_6);
        assignId(button_number[7],R.id.button_7);
        assignId(button_number[8],R.id.button_8);
        assignId(button_number[9],R.id.button_9);
    }

    private void assignId(Button button,int id){
        button = findViewById(id);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Button button = (Button) view;
        String buttonText = button.getText().toString();

        String dataToCalculate = textViewSolution.getText().toString();

        if (buttonText.equals("AC")){
            textViewSolution.setText("");
            textViewResult.setText("0");
            return;
        }

        if (buttonText.equals("=")){
            textViewSolution.setText(textViewResult.getText());
            return;
        }


        if (buttonText.equals("C")){
            byte var0 = 0;
            int var1 = dataToCalculate.length()-1;
            dataToCalculate = dataToCalculate.substring(var0,var1);
        }else {
            dataToCalculate = dataToCalculate + buttonText;
        }

        textViewSolution.setText(dataToCalculate);

        String finalResult = getResult(dataToCalculate);

        if (!finalResult.equals("Err")){
            textViewResult.setText(finalResult);
        }

    }


    private String getResult(String data){
        try {
            Context context = Context.enter();
            context.setOptimizationLevel(-1);

            Scriptable scriptable = context.initStandardObjects();
            String finalResult = context.evaluateString(scriptable,data,"Javascript",1,null).toString();
            if (finalResult.endsWith(".0")){
                finalResult = finalResult.replace(".0","");
            }

            return finalResult;
        }catch (Exception e){
            return "Err";
        }catch (UnknownError unknownError){
            return "Err";
        }
    }
}