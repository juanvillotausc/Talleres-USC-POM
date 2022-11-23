package com.example.taller7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView tx = findViewById(R.id.textView);

        Objects.requireNonNull(getSupportActionBar()).setTitle(tx.getText().toString());

        String data = getIntent().getStringExtra("data");

        if (data.isEmpty()) {
            tx.setText("Data is empty");
        } else {
            JSONObject jsonData = null;
            try {
                jsonData = new JSONObject(data);
                tx.setText((CharSequence) jsonData.get("email"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }
}