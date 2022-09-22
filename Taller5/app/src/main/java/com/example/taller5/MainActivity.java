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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
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
        String email=inputEmail.getText().toString();
        String password=inputPassword.getText().toString();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number = rd.nextInt(500);
                createUserDB(email,password);
//                if (!inputEmail.getText().toString().isEmpty() && !inputPassword.getText().toString().isEmpty()) {
//                    Toast.makeText(MainActivity.this, "¡Logged In!", Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(MainActivity.this, MainActivity2.class));
//                    return;
//                }
                Toast.makeText(MainActivity.this, "¡Login Failed!", Toast.LENGTH_SHORT).show();
                btnLogin.setBackgroundColor(Color.rgb(38, 198, number));
            }
        });
    }

    public void createUserDB(String email, String password) {
        try {

            URL obj = new URL("http://localhost:8080/guardar");
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");

            // For POST only - START
            con.setDoOutput(true);
            OutputStream os = con.getOutputStream();
            os.write(email.getBytes());
            os.write(password.getBytes());
            os.flush();
            os.close();
            // For POST only - END

            int responseCode = con.getResponseCode();
            System.out.println("POST Response Code :: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) { //success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // print result
                System.out.println(response.toString());
            } else {
                System.out.println("POST request not worked");
            }
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}