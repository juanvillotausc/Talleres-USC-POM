package com.example.taller5.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class Handlers {

    public static String handleResponse(HttpURLConnection connection, int responseCode) throws IOException {
        BufferedReader in;
        if (responseCode == HttpURLConnection.HTTP_OK) { //success
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        }

        in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        throw new IOException(String.valueOf(response));
    }

}
