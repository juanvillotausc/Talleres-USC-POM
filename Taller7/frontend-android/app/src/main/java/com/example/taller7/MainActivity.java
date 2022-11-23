package com.example.taller7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.taller7.services.AdminServicios;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

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
        Button btnCrear = findViewById(R.id.button2);
        Button btnConsultar = findViewById(R.id.button3);

        AdminServicios services = new AdminServicios();

        //Login button
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();
                if (email.isEmpty() || password.isEmpty()) return;
                try {
                    String response = services.login(email, password);
                    System.out.println(response);
                    Toast.makeText(MainActivity.this, "¡Login exitoso!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("data", response);
                    startActivity(intent);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    Toast.makeText(MainActivity.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                }finally{
                    inputEmail.setText("");
                    inputPassword.setText("");
                }
            }
        });

        //Create Button
        btnCrear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity3.class));
            }
        });

        //Consultar Button
        btnConsultar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity4.class));
            }
        });
    }

}