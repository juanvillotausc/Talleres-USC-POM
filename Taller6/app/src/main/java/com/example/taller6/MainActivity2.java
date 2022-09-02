package com.example.taller6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity2 extends AppCompatActivity {

    TextView tx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tx = findViewById(R.id.textView5);

        String data = getIntent().getStringExtra("data");

        if (data.isEmpty()) {
            tx.setText("Data is empty");
        } else {
            tx.setText(data);
        }
    }
}