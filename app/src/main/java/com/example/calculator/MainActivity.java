package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button7, button8, button9, button1, button2, button3, button4, button5, button6, button0;
    Button btnC, btnPlusMinus, btnDel;
    Button btnPlus, btnEqual, btnMinus, btnX, btnOver;
    TextView tvSan, tvZapis;
    String operation, birinshiSan, ekinshiSan, zapisText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        Sandar();
        PlusMinus();
        Func();
        operations();

//        View.OnClickListener doubleNums = new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        }

    }

    public void Sandar(){

        View.OnClickListener buttonSandar = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String aldingiSan = tvSan.getText().toString();
                String basilganSan = "";
                String songiRes = "";

                switch (view.getId()){
                    case R.id.btn7:
                        basilganSan = "7";
                        break;

                    case R.id.btn0:
                        basilganSan = "0";
                        break;

                    case R.id.btn9:
                        basilganSan = "9";
                        break;

                    case R.id.btn8:
                        basilganSan = "8";
                        break;

                    case R.id.btn6:
                        basilganSan = "6";
                        break;

                    case R.id.btn5:
                        basilganSan = "5";
                        break;

                    case R.id.btn4:
                        basilganSan = "4";
                        break;

                    case R.id.btn3:
                        basilganSan = "3";
                        break;

                    case R.id.btn2:
                        basilganSan = "2";
                        break;

                    case R.id.btn1:
                        basilganSan = "1";
                        break;
                }

                if(!aldingiSan.equals("0")) songiRes = aldingiSan + basilganSan;
                else songiRes = basilganSan;

                tvSan.setText(songiRes);


            }
        };
        button8.setOnClickListener(buttonSandar);
        button7.setOnClickListener(buttonSandar);
        button6.setOnClickListener(buttonSandar);
        button5.setOnClickListener(buttonSandar);
        button4.setOnClickListener(buttonSandar);
        button3.setOnClickListener(buttonSandar);
        button2.setOnClickListener(buttonSandar);
        button1.setOnClickListener(buttonSandar);
        button0.setOnClickListener(buttonSandar);
        button9.setOnClickListener(buttonSandar);
    }
    public void PlusMinus(){
        View.OnClickListener buttonCandPlusMinusDel = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.btnC:
                        tvSan.setText("0");
                        break;

                    case R.id.btn_plusminus:
                        String sanText = tvSan.getText().toString();
                        int san = Integer.parseInt(sanText);
                        if (san > 0) tvSan.setText("-" + sanText);
                        else {
                            san = san * (-1);
                            tvSan.setText(sanText);
                        }
                        break;

                    case R.id.btn_del:
                        String last = tvSan.getText().toString();
                        int lastsan = Integer.parseInt(last);
                        lastsan = lastsan / 10;
                        tvSan.setText(""+lastsan);
                }
            }
        };

        btnC.setOnClickListener(buttonCandPlusMinusDel);
        btnPlusMinus.setOnClickListener(buttonCandPlusMinusDel);
        btnDel.setOnClickListener(buttonCandPlusMinusDel);

    }
    public void Func(){
        View.OnClickListener btnFunctions = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                birinshiSan = tvSan.getText().toString();

                switch (view.getId()){
                    case R.id.btnPlus:
                        operation = "+";
                        break;

                    case R.id.btn_minus:
                        operation = "-";
                        break;
                    case R.id.btn_multiply:
                        operation = "*";
                        break;
                    case R.id.btn_over:
                        operation = "/";
                        break;
                }

                zapisText = birinshiSan + operation;
                tvZapis.setText(zapisText);
                tvSan.setText("0");
            }
        };

        btnPlus.setOnClickListener(btnFunctions);
        btnMinus.setOnClickListener(btnFunctions);
        btnOver.setOnClickListener(btnFunctions);
        btnX.setOnClickListener(btnFunctions);
    }
    public void operations(){
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ekinshiSan = tvSan.getText().toString();//11+15=1115
                int san1 = Integer.parseInt(birinshiSan);
                int san2 = Integer.parseInt(ekinshiSan);
                int res = 0;
                if (operation.equals("+")) {
                    res = san1 + san2;
                } else if (operation.equals("-")) {
                    res = san1 - san2;
                } else if (operation.equals("*")) {
                    res = san1 * san2;
                } else if (operation.equals("/")) {
                    res = san1 / san2;
                }


                zapisText = birinshiSan + operation + ekinshiSan + " = " + res;
                tvZapis.setText(zapisText);
                tvSan.setText(""+res);
            }
        });
    }
    public void init(){
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.btn3);
        button4 = findViewById(R.id.btn4);
        button5 = findViewById(R.id.btn5);
        button6 = findViewById(R.id.btn6);
        button7 = findViewById(R.id.btn7);
        button8 = findViewById(R.id.btn8);
        button9 = findViewById(R.id.btn9);
        button0 = findViewById(R.id.btn0);
        btnC = findViewById(R.id.btnC);
        btnPlusMinus = findViewById(R.id.btn_plusminus);
        btnDel = findViewById(R.id.btn_del);


        btnPlus = findViewById(R.id.btnPlus);
        btnEqual = findViewById(R.id.btnEqual);
        btnMinus = findViewById(R.id.btn_minus);
        btnX = findViewById(R.id.btn_multiply);
        btnOver = findViewById(R.id.btn_over);

        tvSan = findViewById(R.id.tv_san);
        tvZapis = findViewById(R.id.tv_zapis);
    }
}