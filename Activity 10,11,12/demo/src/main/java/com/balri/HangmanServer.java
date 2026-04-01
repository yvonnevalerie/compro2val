package com.balri;

import java.net.*;
import java.io.*;
import java.util.*;

public class HangmanServer {

    private static final int PORT = 12345;
    private static Map<String, User> users = new HashMap<>();

    public static void main(String[] args) {
        try {
            HangmanService service = new HangmanService("words.txt");

            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Hangman server running on port " + PORT);

            while (true) {
                Socket client = server.accept();
                new Thread(() -> handleClient(client, service)).start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket client, HangmanService service) {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true)
        ) {
            out.println("Enter username:");
            String username = in.readLine();

            out.println("Enter password:");
            String password = in.readLine();

            if (username == null || password == null) return;

            User user = users.getOrDefault(username, new User());
            user.username = username;
            user.password = password;
            users.put(username, user);

            String word = service.chooseWord();
            String hidden = "*".repeat(word.length());
            int wrong = 0;

            while (wrong < 6 && !service.isComplete(hidden)) {
                out.println("Word: " + hidden + " | Guess a letter:");

                String input = in.readLine();
                if (input == null || input.isEmpty()) continue;

                char guess = input.charAt(0);

                if (word.contains(String.valueOf(guess))) {
                    hidden = service.revealLetters(word, hidden, guess);
                    user.score += 2;
                } else {
                    wrong++;
                    out.println("Wrong! Attempts left: " + (6 - wrong));
                }
            }

            if (service.isComplete(hidden)) {
                out.println("You win! Word: " + word);
            } else {
                out.println("You lose! Word: " + word);
            }

            client.close();

        } catch (IOException e) {
            System.out.println("Client disconnected.");
        }
    }
}