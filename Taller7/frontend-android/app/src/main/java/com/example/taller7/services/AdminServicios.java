package com.example.taller7.services;

import com.example.taller7.utils.Handlers;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class AdminServicios {

    public String crearEmpleado(String postData) throws IOException {

        URL url = new URL("http://10.0.2.2:8080/guardar");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        byte[] bytes = postData.getBytes(StandardCharsets.UTF_8);
        int length = bytes.length;

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Content-Length", String.valueOf(length));
        connection.setDoOutput(true);

        //Solo para POST
        OutputStream os = connection.getOutputStream();
        os.write(bytes);
        os.flush();
        os.close();

        int responseCode = connection.getResponseCode();
        System.out.println("POST Response Code :: " + responseCode);
        String response = Handlers.handleResponse(connection, responseCode);
        return response;
    }

    public String consultarEmpleado(Long id) throws IOException {

        URL url = new URL("http://10.0.2.2:8080/consultar/" + id);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        String response = Handlers.handleResponse(connection, responseCode);
        return response;
    }

    public String login(String email, String password) throws IOException {

        URL url = new URL("http://10.0.2.2:8080/login");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        String dataInputs = "{\"email\":\"" + email + "\",\"password\":\"" + password + "\"}";
        byte[] bytes = dataInputs.getBytes(StandardCharsets.UTF_8);
        int length = bytes.length;

        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Content-Length", String.valueOf(length));
        connection.setDoOutput(true);
        //Establece data en body
        OutputStream os = connection.getOutputStream();
        os.write(bytes);
        os.flush();
        os.close();

        int responseCode = connection.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        String response = Handlers.handleResponse(connection, responseCode);

        return response;
    }

}
