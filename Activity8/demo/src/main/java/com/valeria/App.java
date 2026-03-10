package com.valeria;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {

    static String[] subjects = new String[50];
    static double[][] grades = new double[50][3];
    static int count = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {

            System.out.println("""
                    -----------------------------
                                MENU
                    -----------------------------
                    [1] Add Grade for Subject
                    [2] View All Grades
                    [3] Save to JSON
                    [4] Exit
                    """);

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addGrade(sc);
                    break;

                case 2:
                    viewGrades();
                    break;

                case 3:
                    writeJSON();
                    break;

                case 4:
                    System.out.println("Goodbye!");
                    writeJSON();
                    break;

                default:
                    System.out.println("Invalid choice.\n");
            }

        } while (choice != 4);

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

        sc.nextLine();

        count++;
        System.out.println("Subject added!\n");
    }

    public static void viewGrades() {

        if (count == 0) {
            System.out.println("\nNo records found.\n");
            return;
        }

        System.out.println("\n--------------------------------------");
        System.out.printf("%-15s %-8s %-8s %-8s\n", "Subject", "Prelim", "Midterm", "Finals");
        System.out.println("--------------------------------------");

        for (int i = 0; i < count; i++) {

            System.out.printf("%-15s %-8.2f %-8.2f %-8.2f\n",
                    subjects[i],
                    grades[i][0],
                    grades[i][1],
                    grades[i][2]);
        }

        System.out.println();
    }

    public static void writeJSON() {

        StringBuilder json = new StringBuilder();

        json.append("[\n");

        for (int i = 0; i < count; i++) {

            json.append("  {\n");
            json.append("    \"subject\": \"").append(subjects[i]).append("\",\n");
            json.append("    \"prelim\": ").append(grades[i][0]).append(",\n");
            json.append("    \"midterm\": ").append(grades[i][1]).append(",\n");
            json.append("    \"finals\": ").append(grades[i][2]).append("\n");
            json.append("  }");

            if (i < count - 1)
                json.append(",");

            json.append("\n");
        }

        json.append("]");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("grades.json"))) {

            bw.write(json.toString());

            System.out.println("\nData saved to grades.json\n");

        } catch (IOException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }
}