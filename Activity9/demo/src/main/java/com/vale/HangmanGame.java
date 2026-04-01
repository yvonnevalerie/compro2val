import java.io.*;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class HangmanGame {

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    Gson gson = new Gson();

    class User {
        String username;
        String password;
        int score;
    }

    public static void main(String[] args) {
        new HangmanGame().startGame();
    }

    public void startGame() {

        List<String> words = loadWords();
        if (words.isEmpty()) {
            System.out.println("No words loaded. Check words.txt!");
            return;
        }

        List<User> users = loadUsers();

        User currentUser = authenticate(users);

        int score = playRound(words);

        currentUser.score += score;

        saveUsers(users);

        System.out.println("Final Score: " + currentUser.score);
    }

    public List<String> loadWords() {
        List<String> words = new ArrayList<>();

        try (InputStream is = getClass().getClassLoader()
                .getResourceAsStream("words.txt")) {

            if (is == null) {
                System.out.println("words.txt not found!");
                return words;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    words.add(line.trim().toLowerCase());
                }
            }

        } catch (Exception e) {
            System.out.println("Error loading words.");
        }

        return words;
    }

    public List<User> loadUsers() {
        try (Reader reader = new FileReader("users.json")) {

            List<User> users = gson.fromJson(reader,
                    new TypeToken<List<User>>(){}.getType());

            return users != null ? users : new ArrayList<>();

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public void saveUsers(List<User> users) {
        try (Writer writer = new FileWriter("users.json")) {
            gson.toJson(users, writer);
        } catch (Exception e) {
            System.out.println("Error saving users.");
        }
    }

    public User authenticate(List<User> users) {
        while (true) {
            System.out.println("\n1. Login");
            System.out.println("2. Sign Up");
            System.out.print("Choice: ");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                User u = login(users);
                if (u != null) return u;
            } else if (choice.equals("2")) {
                return signUp(users);
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    public User login(List<User> users) {
        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        for (User u : users) {
            if (u.username.equals(username) &&
                u.password.equals(password)) {
                System.out.println("Login successful!");
                return u;
            }
        }

        System.out.println("Invalid login.");
        return null;
    }

    public User signUp(List<User> users) {
        System.out.print("New username: ");
        String username = scanner.nextLine();

        for (User u : users) {
            if (u.username.equals(username)) {
                System.out.println("Username already exists.");
                return signUp(users);
            }
        }

        System.out.print("New password: ");
        String password = scanner.nextLine();

        User user = new User();
        user.username = username;
        user.password = password;
        user.score = 0;

        users.add(user);

        System.out.println("Account created!");
        return user;
    }

    public int playRound(List<String> words) {

        String word = words.get(random.nextInt(words.size()));
        String hidden = "*".repeat(word.length());

        int wrong = 0;
        int score = 0;

        Set<Character> guessed = new HashSet<>();

        while (wrong < 6 && hidden.contains("*")) {

            System.out.println("\nWord: " + hidden);
            System.out.print("Guess: ");

            String input = scanner.nextLine().toLowerCase();

            if (input.isEmpty()) continue;

            char guess = input.charAt(0);

            if (guessed.contains(guess)) {
                System.out.println("Already guessed!");
                continue;
            }

            guessed.add(guess);

            if (word.contains(String.valueOf(guess))) {

                StringBuilder newHidden = new StringBuilder(hidden);

                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        newHidden.setCharAt(i, guess);
                        score += 2;
                    }
                }

                hidden = newHidden.toString();

            } else {
                System.out.println("Wrong!");
                wrong++;
            }
        }

        if (!hidden.contains("*")) {
            System.out.println("You win! Word: " + word);
        } else {
            System.out.println("You lose! Word: " + word);
        }

        return Math.min(score, 20);
    }
}
