package com.example.taller7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.taller7.services.AdminServicios;

import org.json.JSONObject;

public class MainActivity4 extends AppCompatActivity {

    Button buttonBuscar;
    EditText inputID;
    TextView labelNombre, labelEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        inputID = findViewById(R.id.inputId);
        labelNombre = findViewById(R.id.textView14);
        labelEmail = findViewById(R.id.textView15);
        buttonBuscar = findViewById(R.id.buttonBuscar);

        AdminServicios services = new AdminServicios();

        buttonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = inputID.getText().toString();
                if (id.isEmpty()) return;
                try {
                    String response = services.consultarEmpleado(Long.parseLong(id));
                    System.out.println(response);
                    if (!response.equals("null")) {
                        JSONObject jsonObject = new JSONObject(response);
                        labelNombre.setText(jsonObject.get("nombre").toString());
                        labelEmail.setText(jsonObject.get("email").toString());
                        Toast.makeText(MainActivity4.this, "¡Empleado encontrado!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity4.this, "¡Empleado no encontrado!", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    Toast.makeText(MainActivity4.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                } finally {
                    inputID.setText("");
                }
            }
        });

    }
}