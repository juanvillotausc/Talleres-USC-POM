package com.example.taller7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.taller7.services.AdminServicios;

public class MainActivity3 extends AppCompatActivity {

    Button buttonAgregar;
    EditText inputNombre, inputCreateEmail, inputCreatePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        buttonAgregar = findViewById(R.id.buttonBuscar);
        inputNombre = findViewById(R.id.inputId);
        inputCreateEmail = findViewById(R.id.inputCreateEmail);
        inputCreatePassword = findViewById(R.id.inputCreatePassword);

        AdminServicios services = new AdminServicios();

        buttonAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = inputNombre.getText().toString();
                String email = inputCreateEmail.getText().toString();
                String password = inputCreatePassword.getText().toString();
                String postData = "{\"nombre\":\"" + nombre + "\",\"email\":\"" + email + "\",\"password\":\"" + password + "\"}";
                if (email.isEmpty() || password.isEmpty() || nombre.isEmpty()) return;
                try {
                    String response = services.crearEmpleado(postData);
                    System.out.println(response);
                    Toast.makeText(MainActivity3.this, "¡Empleado agregado!", Toast.LENGTH_SHORT).show();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    Toast.makeText(MainActivity3.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                } finally {
                    inputNombre.setText("");
                    inputCreateEmail.setText("");
                    inputCreatePassword.setText("");
                }
            }
        });

    }
}