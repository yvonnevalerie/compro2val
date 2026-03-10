package com.valeria;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int choice;

    loadData(); 

    do {

        System.out.println("\nMenu:");
        System.out.println("[1] Add Grade for Subject");
        System.out.println("[2] Display Grades");
        System.out.println("[3] Exit");

        System.out.print("Enter Choice: ");
        choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {

            case 1:
                addGrade(sc);
                break;

            case 2:
                displayGrades();
                break;

            case 3:
                System.out.println("Saving data and exiting...");
                break;

            default:
                System.out.println("Invalid choice!");
        }

    } while (choice != 3);

    try {
        saveData(); // save to JSON file
    } catch (IOException e) {
        System.out.println("Error saving file.");
    }

    sc.close();
}

}