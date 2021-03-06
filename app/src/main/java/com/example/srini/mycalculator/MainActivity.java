package com.example.srini.mycalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txt1 = (TextView)findViewById(R.id.textView);
        final EditText txt= (EditText)findViewById(R.id.editText);
        final Button dot= (Button)findViewById(R.id.button);
        final Button zero= (Button)findViewById(R.id.button2);
        final Button one= (Button)findViewById(R.id.button5);
        final Button two= (Button)findViewById(R.id.button6);
        final Button three= (Button)findViewById(R.id.button7);
        final Button four= (Button)findViewById(R.id.button9);
        final Button five= (Button)findViewById(R.id.button10);
        final Button six= (Button)findViewById(R.id.button11);
        final Button seven= (Button)findViewById(R.id.button13);
        final Button eight= (Button)findViewById(R.id.button14);
        final Button nine= (Button)findViewById(R.id.button15);
        final Button add= (Button)findViewById(R.id.button4);
        final Button sub= (Button)findViewById(R.id.button8);
        final Button mul= (Button)findViewById(R.id.button12);
        final Button div= (Button)findViewById(R.id.button16);
        final Button mod= (Button)findViewById(R.id.button18);
        final Button pow= (Button)findViewById(R.id.button17);
        final Button eq= (Button)findViewById(R.id.button3);
        final Button clear= (Button)findViewById(R.id.button20);
        final Button allclear= (Button)findViewById(R.id.button19);

        final String[] operator = {""};
        final float[] num1 = {0};
        final float[] num2 = {0};

        final View.OnClickListener myHandler = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                String s = b.getText().toString();
                String s1= txt.getText().toString();
                if((s.equals(".") && s1.contains(".")) || (s1.equals("Infinity") || s1.equals("NaN"))) {

                }
                else {
                    txt.append(s);
                }
            }
        };

        View.OnClickListener myOperator = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button op = (Button)v;
                if(txt.getText().toString().equals("")){}
                else {
                    if (operator[0].equals("")) {
                        num1[0] = Float.parseFloat(txt.getText().toString());

                    } else {

                        eq.performClick();
                    }
                    txt1.append(txt.getText().toString());
                    txt.setText("");
                    operator[0] = op.getText().toString();
                    txt1.append(operator[0]);
                }
            }
        };

        dot.setOnClickListener(myHandler);
        zero.setOnClickListener(myHandler);
        one.setOnClickListener(myHandler);
        two.setOnClickListener(myHandler);
        three.setOnClickListener(myHandler);
        four.setOnClickListener(myHandler);
        five.setOnClickListener(myHandler);
        six.setOnClickListener(myHandler);
        seven.setOnClickListener(myHandler);
        eight.setOnClickListener(myHandler);
        nine.setOnClickListener(myHandler);

        add.setOnClickListener(myOperator);
        sub.setOnClickListener(myOperator);
        mul.setOnClickListener(myOperator);
        div.setOnClickListener(myOperator);
        pow.setOnClickListener(myOperator);
        mod.setOnClickListener(myOperator);

        allclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText("");
                txt1.setText("");
                num1[0]=0;
                num2[0]=0;
                operator[0]="";
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t= txt.getText().toString();
                if(t.equals("") || t.equals("Infinity") || t.equals("NaN")) {

                }
                else{
                    txt.setText(t.substring(0, t.length() - 1));
                }
            }
        });

        eq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txt.getText().toString().equals("") || txt.getText().toString().equals(".")){
                    if(!txt1.getText().toString().equals("")) {
                        float f= Float.parseFloat(txt1.getText().toString());
                        txt.setText(Float.toString(f));
                    }
                    else{
                        txt.setText("0.0");
                    }
                }
                else {
                    String t=txt.getText().toString();
                    //not working
                    if(t.equals('.')){
                        t="0";
                    }
                    num2[0] = Float.parseFloat(t);
                    switch (operator[0]) {
                        case "+":
                            num1[0] += num2[0];
                            operator[0] = "";
                            break;
                        case "-":
                            num1[0] -= num2[0];
                            operator[0] = "";
                            break;
                        case "*":
                            num1[0] *= num2[0];
                            operator[0] = "";
                            break;
                        case "/":
                            num1[0] /= num2[0];
                            operator[0] = "";
                            break;
                        case "^":
                            num1[0] = (float) Math.pow(num1[0], num2[0]);
                            operator[0] = "";
                            break;
                        case "%":
                            num1[0] %= num2[0];
                            operator[0] = "";
                            break;
                        default:
                            num1[0] = num2[0];
                    }
                    txt.setText(Float.toString(num1[0]));
                    txt1.setText("");
                }
            }
        });

    }
}
