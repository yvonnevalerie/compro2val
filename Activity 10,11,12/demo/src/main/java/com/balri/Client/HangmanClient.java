package com.balri.Client;

import java.io.*;
import java.net.*;

public class HangmanClient {

    public static void main(String[] args) throws Exception {
        try (Socket socket = new Socket("localhost", 12345);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);

                if (line.contains("Guess") || line.contains("username") || line.contains("password")) {
                    String input = userInput.readLine();
                    out.println(input);
                }
            }
        }
    }
}