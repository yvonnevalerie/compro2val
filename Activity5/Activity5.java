import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Activity5 {

    static String[] subjects = new String[50];
    static double[][] grades = new double[50][3];
    static int count = 0;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("""
                [1] Add Grade for subject
                [2] Display Grades
                [3] Search for Subject
                [4] Exit
            """);

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> addGrade(sc);
                case 2 -> displayGrades();
                case 3 -> searchSubject(sc);
                case 4 -> System.out.println("Exiting program. Goodbye!");
                default -> System.out.println("Invalid choice!\n");
            }

        } while (choice != 4);

        writeData();
        sc.close();
    }

    public static void addGrade(Scanner sc) {
        System.out.print("\nEnter Subject: ");
        subjects[count] = sc.nextLine();

        System.out.print("Enter Prelim Grade: ");
        grades[count][0] = sc.nextDouble();

        System.out.print("Enter Midterm Grade: ");
        grades[count][1] = sc.nextDouble();

        System.out.print("Enter Finals Grade: ");
        grades[count][2] = sc.nextDouble();

        sc.nextLine(); // clear buffer
        count++;
        System.out.println("Grade added successfully!\n");
    }

    public static void displayGrades() {
        if (count == 0) {
            System.out.println("No grades available.\n");
            return;
        }

        System.out.println("\nAll Grades:");
        System.out.printf("%-15s %-10s %-10s %-10s\n", "Subject", "Prelim", "Midterm", "Finals");
        for (int i = 0; i < count; i++) {
            System.out.printf("%-15s %-10.2f %-10.2f %-10.2f\n", subjects[i], grades[i][0], grades[i][1], grades[i][2]);
        }
        System.out.println();
    }

    public static void searchSubject(Scanner sc) {
        System.out.print("\nEnter subject name to search: ");
        String query = sc.nextLine().trim().toLowerCase();

        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (subjects[i].toLowerCase().equals(query)) {
                System.out.printf("Found %s: Prelim %.2f, Midterm %.2f, Finals %.2f\n",
                        subjects[i], grades[i][0], grades[i][1], grades[i][2]);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Subject not found.\n");
        } else {
            System.out.println();
        }
    }

    public static void writeData() throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("Subject,Prelim,Midterm,Finals\n");

        for (int r = 0; r < count; r++) {
            sb.append(subjects[r]);
            for (int c = 0; c < grades[r].length; c++) {
                sb.append(",").append(grades[r][c]);
            }
            sb.append("\n");
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter("data.csv"));
        bw.write(sb.toString());
        bw.close();

        System.out.println("Data saved to data.csv successfully!");
    }
}
