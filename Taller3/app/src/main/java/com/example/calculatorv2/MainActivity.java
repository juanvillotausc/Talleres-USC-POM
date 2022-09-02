package com.example.calculatorv2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.calculatorv2.polimorfism.Divide;
import com.example.calculatorv2.polimorfism.Multiply;
import com.example.calculatorv2.polimorfism.Operations;
import com.example.calculatorv2.polimorfism.Substract;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView labelCalc;
    private final String[] OPERATORS = {"x", "/"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        labelCalc = findViewById(R.id.textView);

        listener(findViewById(R.id.button34));       // Button 1
        listener(findViewById(R.id.button35));       // Button 2
        listener(findViewById(R.id.button36));       // Button 3
        listener(findViewById(R.id.button37));       // Button 4
        listener(findViewById(R.id.button38));       // Button 5
        listener(findViewById(R.id.button39));       // Button 6
        listener(findViewById(R.id.button12));       // Button 7
        listener(findViewById(R.id.button28));       // Button 8
        listener(findViewById(R.id.button32));       // Button 9
        listener(findViewById(R.id.button2));        // Button 0
        listener(findViewById(R.id.button4));        // Button sumar
        listener(findViewById(R.id.button9));        // Button resta
        listener(findViewById(R.id.button13));        // Button multiplicacion
        listener(findViewById(R.id.button15));        // Button division
        listener(findViewById(R.id.button0));        // Button Borrar
        listener(findViewById(R.id.button11));        // Button Realizar
        listener(findViewById(R.id.button));        // Button Realizar
        listener(findViewById(R.id.button3));        // Button Realizar


    }

    public void listener(Button btn) {
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Button btn = (Button) view;
        String stringConcated = labelCalc.getText().toString();
        if (stringConcated.length() > 12) return;


        if (stringConcated.equals("0")) {
            stringConcated = "";
            labelCalc.setText(btn.getText().toString());
        }
        //Borra operacion completa
        if (btn.getText().equals("C")) {
            labelCalc.setText("");
            return;
        }
        //Borra ultimo valor digitado
        if (btn.getText().equals("CE")) {
            for (String operator : OPERATORS) {
                if (stringConcated.contains(operator)) {
                    String[] array = stringConcated.split(operator);
                    if (array.length < 2) return;
                    StringBuilder str = new StringBuilder();
                    labelCalc.setText(str.append(array[0]) + operator + "0");
                    return;
                }
            }
            String[] array = stringConcated.split("(?<=\\d)(?=\\D)");
            String operator = Character.toString(array[1].charAt(0));
            StringBuilder str = new StringBuilder();
            labelCalc.setText(str.append(array[0]) + operator + "0");
            return;
        }
        //Hace operacion
        if (btn.getText().equals("=")) {
            int operation1, operation2, resultSumRest;
            String result;
            for (String operator : OPERATORS) {
                if (stringConcated.contains(operator)) {
                    String[] array = stringConcated.split(operator);
                    if (array.length < 2) return;
                    switch (operator) {
                        case "x":
                            Operations multiply = new Multiply();
                            operation1 = Integer.parseInt(array[0]);
                            operation2 = Integer.parseInt(array[1]);
                            try {
                                result = Integer.toString(multiply.operation(operation1, operation2));
                                labelCalc.setText(result);
                            } catch (Exception e) {
                                labelCalc.setText("ERROR");
                            }

                            break;
                        case "/":
                            Operations divide = new Divide();
                            operation1 = Integer.parseInt(array[0]);
                            operation2 = Integer.parseInt(array[1]);
                            try {
                                result = Integer.toString(divide.operation(operation1, operation2));
                                labelCalc.setText(result);
                            } catch (Exception ex) {
                                labelCalc.setText("ERROR");
                            }
                            break;
                    }
                    return;
                }
            }
            // Suma y resta
            String[] array = stringConcated.split("(?<=\\d)(?=\\D)");
            operation1 = Integer.parseInt(array[0]);
            operation2 = Integer.parseInt(array[1]);
            resultSumRest = operation1 + operation2;
            result = Integer.toString(resultSumRest);
            labelCalc.setText(result);
            return;
        }

        if (btn.getText().equals("Borrar")) {
            if (stringConcated.length() > 0) {
                stringConcated = stringConcated.substring(0, stringConcated.length() - 1);
            } else {
                stringConcated = "0";
            }
        } else {
            if (stringConcated.length() > 1 && !btn.getText().toString().equals("0")) {
                labelCalc.setText(btn.getText().toString());
            }
            if (stringConcated.equals("ERROR")) {
                stringConcated = "0";
            }

            stringConcated = stringConcated + btn.getText().toString();
        }

        labelCalc.setText(stringConcated);
    }
}