package com.example.calculatorv2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Button> buttons = new ArrayList<>();
        buttons.add(findViewById(R.id.button34));       // Button 1
        buttons.add(findViewById(R.id.button35));       // Button 2
        buttons.add(findViewById(R.id.button36));       // Button 3
        buttons.add(findViewById(R.id.button37));      // Button 4
        buttons.add(findViewById(R.id.button38));       // Button 5
        buttons.add(findViewById(R.id.button39));       // Button 6
        buttons.add(findViewById(R.id.button12));       // Button 7
        buttons.add(findViewById(R.id.button28));       // Button 8
        buttons.add(findViewById(R.id.button32));       // Button 9
        buttons.add(findViewById(R.id.button2));        // Button 0
        buttons.add(findViewById(R.id.button0));        // Button Borrar
        buttons.add(findViewById(R.id.button4));        // Button sumar
        buttons.add(findViewById(R.id.button9));        // Button resta
        buttons.add(findViewById(R.id.button13));        // Button multiplicacion
        buttons.add(findViewById(R.id.button15));        // Button division
        buttons.add(findViewById(R.id.button11));

        Operations op = new Add();
        int result = op.operation(1,3);
        System.out.println(result);
    }
}