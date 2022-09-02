package com.example.taller6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tx;
    EditText input1;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tx = findViewById(R.id.textView2);
        input1 = findViewById(R.id.input1);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(v -> {
            String data = input1.getText().toString();
            if (data.isEmpty()) return;
            Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("data", data);
            startActivity(intent);
        });
    }
}