package com.balri;

import java.io.*;
import java.util.*;

public class HangmanService {

    private List<String> words;
    private Random random = new Random();

    public HangmanService(String wordsFile) throws IOException {
        words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(wordsFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line.trim().toLowerCase());
            }
        }
    }

    public String chooseWord() {
        return words.get(random.nextInt(words.size()));
    }

    public String revealLetters(String word, String current, char guess) {
        StringBuilder sb = new StringBuilder(current);
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) sb.setCharAt(i, guess);
        }
        return sb.toString();
    }

    public boolean isComplete(String hidden) {
        return !hidden.contains("*");
    }
}
