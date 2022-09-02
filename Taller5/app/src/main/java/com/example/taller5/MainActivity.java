package com.example.taller5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.service.autofill.Validator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        TextView tx = findViewById(R.id.textView3);
        TextView inputEmail = (TextView) findViewById(R.id.inputEmail);
        TextView inputPassword = (TextView) findViewById(R.id.inputPassword);
        TextView tx2 = findViewById(R.id.textView4);
        TextView tx3 = findViewById(R.id.textView6);

        tx.setTextColor(Color.rgb(38, 198, 250));
        tx2.setTextColor(Color.rgb(38, 198, 250));
        tx3.setTextColor(Color.rgb(2, 218, 197));

        Button btnLogin = findViewById(R.id.button);
        Random rd = new Random();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number = rd.nextInt(500);
                if (!inputEmail.getText().toString().isEmpty() && !inputPassword.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "¡Logged In!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, MainActivity2.class));
                    return;
                }
                Toast.makeText(MainActivity.this, "¡Login Failed!", Toast.LENGTH_SHORT).show();
                btnLogin.setBackgroundColor(Color.rgb(38, 198, number));
            }
        });
    }
}