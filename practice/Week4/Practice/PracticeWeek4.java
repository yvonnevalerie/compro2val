import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileWriter;

public class PracticeWeek4 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        try (Scanner sc = new Scanner(System.in)) {
            sb.append("First Name:");
            System.out.println("First Name:");
            sb.append(sc.nextLine()).append("\nLast Name :");
            System.out.println("Last Name:");
            sb.append(sc.nextLine()).append("\nAge       :");
            System.out.println("Age:");
            sb.append(sc.nextLine()).append("\nEmail     :");
            System.out.println("Email:");
            sb.append(sc.nextLine()).append("\nPhone     :");
            System.out.print("Phone:");

            sb.append(sc.nextLine());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }

        // try-with-resource
        try (FileWriter fw = new FileWriter("data.txt")) {
            fw.write(sb.toString());
            System.out.println("Data is saved...");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
